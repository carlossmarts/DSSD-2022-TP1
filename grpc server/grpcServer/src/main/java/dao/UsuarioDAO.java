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
	
	// METODO addUsuario
	public boolean addUsuario(Usuario u) throws Exception {

		boolean retorno = false;
		
		EntityManager em = JPAUtil.getEMF().createEntityManager();

		EntityTransaction et = null;

		try {
			et = em.getTransaction();
			et.begin();
			em.persist(u);
			et.commit();
			retorno = true;
		} // end_try
		catch (Exception ex) {
			if (et != null) {
				et.rollback();
			} // end_if
			System.out.println("Error: " + ex.getMessage());
			throw new Exception("error de persistencia en método addMedicamento");
		} // end_catch
		finally {
			em.close();
		} // end_finally
		return retorno;
	} // end_addUsuario
	
	// METODO getUsuarioById
	public Usuario getUsuarioById(int idUsuario) throws Exception{
		
		Usuario usuario = null;
		EntityManager em = JPAUtil.getEMF().createEntityManager();

		String query = "SELECT u FROM Usuario u WHERE u.idUsuario";
		
		TypedQuery<Usuario> tq = em.createQuery(query, Usuario.class);
		
		try {
			usuario = tq.getSingleResult();
		} // end_try
		catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			throw new Exception("ATENCION: Error de persistencia en método getUsuarioById");
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

		String query = "SELECT u FROM Usuario u WHERE u.usuario";
		
		TypedQuery<Usuario> tq = em.createQuery(query, Usuario.class);
		
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

		String query = "SELECT u FROM Usuario u";
		
		TypedQuery<Usuario> tq = em.createQuery(query, Usuario.class);
		
		try {
			usuario = tq.getSingleResult();
		} // end_try
		catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			throw new Exception("ATENCION: Error de persistencia en método getUsuarioByUsuario");
		} // end_catch
		finally {
			em.close();
		} // end_finally

		return usuario;
	} // end_getUsuarioByUsuarioYClave
	
	// METODO updateUsuarioSaldo
	public boolean updateUsuarioSaldo(int idUsuario, double nuevoSaldo) throws Exception{
		
		boolean actualizado = false;
		
		EntityManager em = JPAUtil.getEMF().createEntityManager();

		String query = "UPDATE Usuario u SET u.saldoBilletera=:saldo WHERE u.idUsuario=:idUsuario";
		TypedQuery<Usuario> tq = em.createQuery(query, Usuario.class);
		tq.setParameter("saldo", nuevoSaldo);
		tq.setParameter("idUsuario", idUsuario);
		
		try {
			tq.executeUpdate();
			actualizado = true;
		} // end_try
		catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			throw new Exception("ATENCION: Error de persistencia en método updateUsuarioCargaSaldo");
		} // end_catch
		finally {
			em.close();
		} // end_finally

		return actualizado;
		
	} // end_updateUsuarioSaldo
	
} // end_class_UsuarioDAO