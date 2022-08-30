package dao;

import model.Categoria;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
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

        String query = "SELECT c FROM Categoria c";
        TypedQuery<Categoria> tq = em.createQuery(query, Categoria.class);
        try {
            categorias = tq.getResultList();
        } catch (Exception e) {
            String msg = "Error de persistencia - Método GetAllTipoMedicamento: " + e.getMessage();
            System.out.println(msg);
            throw new Exception(msg);
        } finally {
            em.close();
        }

        return categorias;
    }
}
