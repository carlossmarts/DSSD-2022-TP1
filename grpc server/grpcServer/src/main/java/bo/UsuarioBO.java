package bo;

import dao.UsuarioDAO;
import dao.ProductoDAO;
import grpc.Usuario.UsuarioDTO;
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
	
    UsuarioDAO usuarioDAO = UsuarioDAO.getInstance();
    ProductoDAO productoDAO = ProductoDAO.getInstance();

	// METODO agregarUsuario
    public Usuario agregarUsuario(UsuarioDTO usuarioDTO) throws Exception {
        Usuario toPersist = mapUsuarioToEntity(usuarioDTO);
        Usuario persisted = usuarioDAO.agregarUsuario(toPersist);
        return persisted;
    }
    
    // METODO getById
	public Usuario getById (int idUsuario) throws Exception{
		return usuarioDAO.getById(idUsuario);
	}

	// METODO getUsuarioByUsuarioYClave
	public Usuario getUsuarioByUsuarioYClave(String nombreUsuario, String clave) throws Exception{
		Usuario usuario = null;
		try{
			usuario = usuarioDAO.getUsuarioByUsuarioYClave(nombreUsuario, clave);
			return usuario;		
		} // end_try
		catch (Exception e){
			System.out.println(e.getMessage());
			throw new Exception ("ATENCION: Error, no se pudo recuperar el usuario por nombre de usuario y clave");
		} // end_catch
	} // end_getUsuarioByUsuarioYClave
	
	// METODO updateUsuarioCargaSaldo
	public Usuario updateUsuarioCargaSaldo(int idUsuario, double saldo) throws Exception{
		
		Usuario usuario = null;
		double nuevoSaldo = 0;
		
		try{
			usuario = usuarioDAO.getById(idUsuario);
			nuevoSaldo = usuario.getSaldoBilletera() + saldo;
			usuario.setSaldoBilletera(nuevoSaldo);
			usuario = usuarioDAO.updateUsuarioSaldo(usuario);
		} // end_try
		catch(Exception e){
			System.out.println(e.getMessage());
			throw new Exception ("ATENCION: Error, no se pudo actualizar el saldo");
		} // end_catch
		
		return usuario;
			
	} // end_updateUsuarioCargaSaldo
	
	// METODO updateUsuarioCompraProducto
	public Usuario updateUsuarioCompraProducto(int idUsuario, int idProducto) throws Exception{
		
		Usuario usuario = null;
		Producto producto = null;
		double nuevoSaldo = 0;
		
		try{
			usuario = usuarioDAO.getById(idUsuario);
			producto = productoDAO.getById(idProducto);
			nuevoSaldo = usuario.getSaldoBilletera() - producto.getPrecio();
			usuario.setSaldoBilletera(nuevoSaldo);
			usuario = usuarioDAO.updateUsuarioSaldo(usuario);
		} // end_try
		catch(Exception e){
			System.out.println(e.getMessage());
			throw new Exception ("ATENCION: Error, no se pudo actualizar el saldo");
		} // end_catch
		
		return usuario;
	} // updateUsuarioCompraProducto
	
    private Usuario mapUsuarioToEntity (UsuarioDTO dto) throws Exception{
        Usuario u = new Usuario();
        u.setIdUsuario(dto.getIdUsuario());
        u.setNombre(dto.getNombre());
        u.setApellido(dto.getApellido());
        u.setDni(dto.getDni());
        u.setEmail(dto.getEmail());
        u.setUsuario(dto.getUsuario());
        u.setClave(dto.getClave());
        u.setSaldoBilletera(dto.getSaldoBilletera());
        u.setIdTipoUsuario(dto.getIdTipoUsuario());
        return u;
    }
	
} // end_UsuarioBO