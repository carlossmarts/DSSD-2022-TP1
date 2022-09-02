package bo;

import dao.ProductoDAO;
import dao.UsuarioDAO;
import model.Producto;
import model.Usuario;

public class UsuarioBO {

	private static UsuarioBO instancia;

	public static UsuarioBO getInstance() {
		if(instancia == null) {
			instancia = new UsuarioBO();
		} // end_if
		return instancia;
	} // end_UsuarioBO
	
	// METODO addUsuario
	public boolean addUsuario(Usuario u) throws Exception {
		Usuario usuario = null;
		boolean retorno = false;
		try{
			usuario = UsuarioDAO.getInstance().getByNombreUsuario(u.getUsuario());			
		} // end_try
		catch(Exception e){
			System.out.println(e.getMessage());
		} // end_catch

		if(usuario != null){
			retorno = UsuarioDAO.getInstance().addUsuario(u);
		} // end_if

		return retorno;
	} // end_addUsuario

	public Usuario getById (int idUsuario) throws Exception{
		return UsuarioDAO.getInstance().getUsuarioById(idUsuario);
	}

	// METODO getUsuarioByUsuarioYClave
	public Usuario getUsuarioByUsuarioYClave(String nombreUsuario, String clave) throws Exception{
		try{
			return UsuarioDAO.getInstance().getUsuarioByUsuarioYClave(nombreUsuario, clave);
		} // end_try
		catch (Exception e){
			System.out.println(e.getMessage());
			throw new Exception ("ATENCION: Error, no se pudo recuperar el usuario por nombre de usuario y clave");
		} // end_catch
	} // end_getUsuarioByUsuarioYClave
	
	// METODO updateUsuarioCargaSaldo
	public Usuario updateUsuarioCargaSaldo(int idUsuario, double saldo) throws Exception{
		boolean actualizado = false;
		double nuevoSaldo = 0;
		Usuario usuario = null;
		try{
			usuario = UsuarioDAO.getInstance().getUsuarioById(idUsuario);
			nuevoSaldo = usuario.getSaldoBilletera() + saldo;
			actualizado = UsuarioDAO.getInstance().updateUsuarioSaldo(idUsuario, nuevoSaldo);
			if(actualizado) {
				return UsuarioDAO.getInstance().getUsuarioById(idUsuario); // DEVUELVE USUARIO
			} // end_if
			else{
				return null;
			} // end_else
		} // end_try
		catch(Exception e){
			System.out.println(e.getMessage());
			throw new Exception ("ATENCION: Error, no se pudo actualizar el saldo");
		} // end_catch
	} // end_updateUsuarioCargaSaldo
	
	// METODO updateUsuarioCompraProducto
	public Usuario updateUsuarioCompraProducto(int idUsuario, int idProducto) throws Exception{
		boolean actualizado = false;
		double nuevoSaldo = 0;
		Usuario usuario = null;
		Producto producto = null;  // ASUMIMOS QUE SE LLAMA ASI
		try{
			usuario = UsuarioDAO.getInstance().getUsuarioById(idUsuario);
			producto = ProductoDAO.getInstance().getById(idProducto);
			nuevoSaldo = usuario.getSaldoBilletera() - producto.getPrecio();
			actualizado = UsuarioDAO.getInstance().updateUsuarioSaldo(idUsuario, nuevoSaldo);
			if(actualizado) {
				return UsuarioDAO.getInstance().getUsuarioById(idUsuario); // DEVUELVE USUARIO
			} // end_if
			else{
				return null;
			} // end_else
		} // end_try
		catch(Exception e){
			System.out.println(e.getMessage());
			throw new Exception ("ATENCION: Error, no se pudo actualizar el saldo");
		} // end_catch
	} // updateUsuarioCompraProducto
	
} // end_UsuarioBO