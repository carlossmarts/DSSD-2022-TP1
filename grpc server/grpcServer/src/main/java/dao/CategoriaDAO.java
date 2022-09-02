package dao;

import model.Categoria;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {
    private static CategoriaDAO instancia;

    public static CategoriaDAO getInstance() {
        if(instancia == null) {
            instancia = new CategoriaDAO();
        }
        return instancia;
    }

    public List<Categoria> getAll() throws Exception{
        List<Categoria> categorias = new ArrayList<Categoria>();

        EntityManager em = JPAUtil.getEMF().createEntityManager();
        try {
            CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
            CriteriaQuery<Categoria> query = criteriaBuilder.createQuery(Categoria.class);
            Root<Categoria> root = query.from(Categoria.class);
            categorias = em.createQuery(query).getResultList();
        } catch (Exception e) {
            String msg = "CategoriaDAO(getAll) - Error de persistencia: " + e.getMessage();
            System.out.println(msg);
            throw new Exception(msg);
        } finally {
            em.close();
        }

        return categorias;
    }

    public Categoria getById(int id) throws Exception{
        Categoria categoria = null;

        EntityManager em = JPAUtil.getEMF().createEntityManager();
        try {
            categoria = em.find(Categoria.class, id);
        } catch (Exception e) {
            String msg = "CategoriaDAO(getById) - Error de persistencia: " + e.getMessage();
            System.out.println(msg);
            throw new Exception(msg);
        } finally {
            em.close();
        }

        return categoria;
    }
}
