package dao;

import model.Categoria;
import model.Producto;


import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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

    public Producto getById(long id) throws Exception{
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
                predicates.add(criteriaBuilder.like(root.get("nombre") , nombreLike));
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
        Producto entity = null;
        try {
            entity = em.merge(producto);
        } catch (Exception e){
            String msg = "Error de persistencia - Método saveOrUpdateProducto: " + e.getMessage();
            System.out.println(msg);
            throw new Exception(msg);
        } finally {
            em.close();
        }

        return entity;
    }
}
