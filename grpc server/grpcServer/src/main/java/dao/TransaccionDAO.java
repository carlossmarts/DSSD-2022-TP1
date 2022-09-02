package dao;

import model.Transaccion;
import model.Categoria;
import model.Producto;
import model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransaccionDAO {

    private static TransaccionDAO instancia;

    public static TransaccionDAO getInstance() {
        if(instancia == null) {
            instancia = new TransaccionDAO ();
        }
        return instancia;
    }

    public Transaccion saveOrUpdate (Transaccion transaccion) throws Exception {
        EntityManager em = JPAUtil.getEMF().createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        Transaccion entity = null;
        try {
            transaction.begin();
            entity = em.merge(transaccion);
            transaction.commit();
        } catch (Exception e){
            String msg = "Error de persistencia - Método saveOrUpdateTransaccion: " + e.getMessage();
            System.out.println(msg);
            throw new Exception(msg);
        } finally {
            em.close();
        }
        return entity;
    }

    public List<Transaccion> getByIdUsuario(int idUsuario, String tipoUsuario) throws Exception{
        List<Transaccion> transacciones = new ArrayList<Transaccion>();

        EntityManager em = JPAUtil.getEMF().createEntityManager();
        try {
            String query = "SELECT t FROM Transaccion t " +
                    "join fetch t.comprador c " +
                    "join fetch t.vendedor v " +
                    "join fetch t.producto p ";
            query += tipoUsuario.equals("vendedor") ? "WHERE v.idUsuario = :idUsuario" : "WHERE c.idUsuario = :idUsuario";

            TypedQuery<Transaccion> tq = em.createQuery(query, Transaccion.class);
            tq.setParameter("idUsuario", idUsuario);

            transacciones = tq.getResultList();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            throw new Exception("error de persistencia en método getByIdComprador");
        } finally {
            em.close();
        }
        return transacciones;
    }

}
