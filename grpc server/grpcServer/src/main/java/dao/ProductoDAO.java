package dao;

import model.Categoria;
import model.FotoProducto;
import model.Producto;
import model.Usuario;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductoDAO {

    private static ProductoDAO instancia;

    public static ProductoDAO getInstance() {
        if(instancia == null) {
            instancia = new ProductoDAO();
        }
        return instancia;
    }

    public Producto getById(int id) throws Exception{
        Producto producto = null;

        EntityManager em = JPAUtil.getEMF().createEntityManager();
        try {
            producto = em.find(Producto.class, id);
        } catch (Exception e) {
            String msg = "CategoriaDAO(getById) - Error de persistencia: " + e.getMessage();
            System.out.println(msg);
            throw new Exception(msg);
        } finally {
            em.close();
        }

        return producto;
    }

    public List<Producto> getAll() throws Exception{
        List<Producto> productos = new ArrayList<Producto>();

        EntityManager em = JPAUtil.getEMF().createEntityManager();
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Producto> query = criteriaBuilder.createQuery(Producto.class);
        Root<Producto> root = query.from(Producto.class);
        Predicate enStock = criteriaBuilder.greaterThan(root.get("cantidad"), 0);
        query.select(root).where(enStock);

        try {
            productos = em.createQuery(query).getResultList();
        } catch (Exception e) {
            String msg = "Error de persistencia - Método GetAllProducto: " + e.getMessage();
            System.out.println(msg);
            throw new Exception(msg);
        } finally {
            em.close();
        }
        return productos;
    }

    public List<Producto> getByUsuario(Usuario usuario) throws Exception{
        List<Producto> productos = new ArrayList<Producto>();

        EntityManager em = JPAUtil.getEMF().createEntityManager();
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Producto> query = criteriaBuilder.createQuery(Producto.class);
        Root<Producto> root = query.from(Producto.class);
        Predicate byUsuario = criteriaBuilder.equal(root.get("usuario"), usuario);
        query.select(root).where(byUsuario);

        try {
            productos = em.createQuery(query).getResultList();
        } catch (Exception e) {
            String msg = "Error de persistencia - Método GetAllProductoByUser: " + e.getMessage();
            System.out.println(msg);
            throw new Exception(msg);
        } finally {
            em.close();
        }
        return productos;
    }

    public List<Producto> getByFilter(Categoria categoria, String nombreLike, double precioDesde, double precioHasta, Date fechaDesde, Date fechaHasta) throws Exception{
        List<Producto> productos = new ArrayList<Producto>();

        EntityManager em = JPAUtil.getEMF().createEntityManager();
        try {
            CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
            CriteriaQuery<Producto> query=criteriaBuilder.createQuery(Producto.class);
            Root<Producto> root = query.from(Producto.class);

            List<Predicate> predicates = new ArrayList<>();
            if(categoria != null) {
                predicates.add(criteriaBuilder.equal(root.get("categoria"),categoria));
            }
            if(!nombreLike.isEmpty()) {
                predicates.add(criteriaBuilder.like(root.get("nombre") , "%"+nombreLike+"%"));
            }
            if(precioDesde != 0 && precioHasta != 0){
                predicates.add(criteriaBuilder.between(root.get("precio"), precioDesde, precioHasta));
            }
            if(fechaDesde != null && fechaHasta != null){
                predicates.add(criteriaBuilder.between(root.get("fechaFabricacion"), fechaDesde, fechaHasta));
            }

            //siempre debe retornar productos de los cuales haya al menos 1 disponible
            predicates.add(criteriaBuilder.ge(root.get("cantidad"), 1));

            Predicate and = criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            query.select(root).where(and);

            productos = em.createQuery(query).getResultList();
        } catch (Exception e) {
            String msg = "Error de persistencia - Método GetAllProducto: " + e.getMessage();
            System.out.println(msg);
            throw new Exception(msg);
        } finally {
            em.close();
        }
        return productos;
    }

    public Producto saveOrUpdateProducto (Producto producto) throws Exception {
        EntityManager em = JPAUtil.getEMF().createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        Producto entity = null;
        try {
            transaction.begin();
            entity = em.merge(producto);
            transaction.commit();
        } catch (Exception e){
            String msg = "Error de persistencia - Método saveOrUpdateProducto: " + e.getMessage();
            System.out.println(msg);
            throw new Exception(msg);
        } finally {
            em.close();
        }

        return entity;
    }

    public void saveOrUpdateFotoProducto (FotoProducto foto) throws Exception {
        EntityManager em = JPAUtil.getEMF().createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        //FotoProducto entity = null;
        try {
            transaction.begin();
            em.merge(foto);
            transaction.commit();
        } catch (Exception e){
            String msg = "Error de persistencia - Método saveOrUpdateFoto: " + e.getMessage();
            System.out.println(msg);
            throw new Exception(msg);
        } finally {
            em.close();
        }
    }
}
