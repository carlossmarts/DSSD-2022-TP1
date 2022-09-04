package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import model.Usuario;

public class UsuarioDAO {
	private static UsuarioDAO instancia;

	public static UsuarioDAO getInstance() {
		if(instancia == null) {
			instancia = new UsuarioDAO();
		}
		return instancia;
	}
	
	// METODO agregarUsuario
	public Usuario agregarUsuario(Usuario usuario) throws Exception {

        EntityManager em = JPAUtil.getEMF().createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        Usuario entity = null;

		try {
            transaction.begin();
            entity = em.merge(usuario);
            transaction.commit();
		} // end_try
	    catch (Exception e){
	        String msg = "Error de persistencia - Método addUsuario: " + e.getMessage();
	        System.out.println(msg);
	        throw new Exception(msg);
	    }
		finally {
	        em.close();
	    }

		return entity;
	} // end_addUsuario
	
	// METODO getById
	public Usuario getById(int idUsuario) throws Exception{
		
		Usuario usuario = null;
		EntityManager em = JPAUtil.getEMF().createEntityManager();

		String query = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario";
		TypedQuery<Usuario> tq = em.createQuery(query, Usuario.class);
		tq.setParameter("idUsuario", idUsuario);
		
		try {
			usuario = tq.getSingleResult();
		} // end_try
		catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			throw new Exception("ATENCION: Error de persistencia en método getById");
		} // end_catch
		finally {
			em.close();
		} // end_finally

		return usuario;
	} // getUsuarioById
	
	// METODO getByNombreUsuario
	public Usuario getByNombreUsuario(String nombreUsuario) throws Exception{
		
		Usuario usuario = null;
		EntityManager em = JPAUtil.getEMF().createEntityManager();

		String query = "SELECT u FROM Usuario u WHERE u.usuario = :nombreUsuario";
		TypedQuery<Usuario> tq = em.createQuery(query, Usuario.class);
		tq.setParameter("nombreUsuario", nombreUsuario);
		try {
			usuario = tq.getSingleResult();
		} // end_try
		catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			throw new Exception("ATENCION: Error de persistencia en método getByNombreUsuario");
		} // end_catch
		finally {
			em.close();
		} // end_finally

		return usuario;
	} // end_getByNombreUsuario

	// METODO getUsuarioByUsuarioYClave
	public Usuario getUsuarioByUsuarioYClave(String nombreUsuario, String clave) throws Exception{
		
		Usuario usuario = null;
		
		EntityManager em = JPAUtil.getEMF().createEntityManager();

		String query = "SELECT u FROM Usuario u WHERE u.usuario=:nombreUsuario AND u.clave=:clave";
		
		TypedQuery<Usuario> tq = em.createQuery(query, Usuario.class);
		tq.setParameter("nombreUsuario", nombreUsuario);
		tq.setParameter("clave", clave);
		
        /*EntityManager em = JPAUtil.getEMF().createEntityManager();
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Usuario> query = criteriaBuilder.createQuery(Usuario.class);
        Root<Usuario> root = query.from(Usuario.class);
        Predicate nombreUsuarioSQL = criteriaBuilder.like(root.get("usuario"), nombreUsuario);
        Predicate claveSQL = criteriaBuilder.like(root.get("clave"), clave);
        query.select(root).where(nombreUsuarioSQL);
        query.select(root).where(claveSQL);*/
		
		try {
			usuario = tq.getSingleResult();
			//usuario = em.createQuery(query).getSingleResult();
		} // end_try
		catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			throw new Exception("ATENCION: Error de persistencia en método getUsuarioByUsuarioYClave");
		} // end_catch
		finally {
			em.close();
		} // end_finally

		return usuario;
	} // end_getUsuarioByUsuarioYClave
	
	// METODO updateUsuarioSaldo
	public Usuario updateUsuarioSaldo(Usuario usuario) throws Exception{
			
        EntityManager em = JPAUtil.getEMF().createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        Usuario entity = null;
        try {
            transaction.begin();
            entity = em.merge(usuario);
            transaction.commit();
        }
		catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			throw new Exception("ATENCION: Error de persistencia en método updateUsuarioCargaSaldo");
		} // end_catch
		finally {
			em.close();
		} // end_finally

		return entity;
		
	} // end_updateUsuarioSaldo
	
} // end_class_UsuarioDAO