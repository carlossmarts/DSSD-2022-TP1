package services;

import bo.UsuarioBO;
// LLAMADOS
// FIN LLAMADOS
import grpc.UsuarioGrpc.*;
import grpc.UsuarioOuterClass.*;
import io.grpc.stub.StreamObserver;
import model.Usuario;

public class UsuarioService extends UsuarioImplBase {
	
	// METODO addUsuario
	@Override
	public void addUsuario(UsuarioDTO request, StreamObserver<ServerResponse> responseObserver){
		
		ServerResponse.Builder serverResponse = ServerResponse.newBuilder();
		Usuario u = null;
		
		try{
			u = mapDTOToUsuario(request);
		} // end_try
		catch (Exception e) {
			serverResponse.setCode(500);
			serverResponse.setMsg(e.getMessage());
		} // end_catach
		
		System.out.println("Llamada a método addUsuario con objeto: " + u.toString());
		
		try{
			UsuarioBO.getInstance().addUsuario(u);
			serverResponse.setCode(200);
			serverResponse.setMsg("Usuario agregado");
		} // end_try
		catch (Exception e) {
			serverResponse.setCode(500);
			serverResponse.setMsg(e.getMessage());
		} // end_catch
		
		responseObserver.onNext(serverResponse.build());
		responseObserver.onCompleted();
	} // end_addUsuario
	
	@Override
	public void getByUsuarioYClaveRequest(GetByUsuarioYClaveRequest request, StreamObserver<UsuarioObjDTO> responseObserver) {
		
		String nombreUsuario = request.getUsuario();
		String clave = request.getClave();
		
		System.out.println("Llamada al servicio getUsuarioByUsuario con nombre de usuario: "+ nombreUsuario + " y clave " + clave);
		Usuario usuario = null;
		ServerResponse.Builder serverResponse = ServerResponse.newBuilder();
		UsuarioObjDTO.Builder response = UsuarioObjDTO.newBuilder();

		try{
			usuario = UsuarioBO.getInstance().getUsuarioByUsuarioYClave(nombreUsuario, clave);
		} // end_try
		catch(Exception e){
			serverResponse.setCode(500);
			serverResponse.setMsg(e.getMessage());
		} // end_catch
		
		response.setResponse(serverResponse);
		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
		
	} // end_getByUsuarioYClaveRequest
	
	// METODO updateUsuarioCargaSaldo
	@Override
	public void updateUsuarioCargaSaldoRequest(UpdateUsuarioCargaSaldoRequest request, StreamObserver<UsuarioObjDTO> responseObserver) {
		
		int idUsuario = request.getIdUsuario();
		double saldo = request.getSaldo();
		
		System.out.println("Llamada al servicio updateUsuarioCargaSaldoRequest con idUsuario: "+ idUsuario + " y saldo " + saldo);
		
		Usuario usuario = null;
		
		ServerResponse.Builder serverResponse = ServerResponse.newBuilder();
		UsuarioObjDTO.Builder response = UsuarioObjDTO.newBuilder();

		try {
			usuario = UsuarioBO.getInstance().updateUsuarioCargaSaldo(idUsuario, saldo);
		} // end_try
		catch (Exception e) {
			serverResponse.setCode(500);
			serverResponse.setMsg(e.getMessage());
		} // end_catch
		
		response.setResponse(serverResponse);
		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
		
	} // end_updateUsuarioCargaSaldoRequest
	
	// METODO updateUsuarioCompraProductoRequest
//	@Override
//	public void updateUsuarioCompraProductoRequest(UpdateUsuarioCompraProductoRequest request, StreamObserver<UsuarioObjDTO> responseObserver) {
//
//		int idUsuario = request.getIdUsuario();
//		int idProducto = request.getIdProducto();
//
//		System.out.println("Llamada al servicio updateUsuarioCompraProductoRequest con idUsuario: "+ idUsuario + " y idProducto " + idProducto);
//		Usuario usuario = null;
//		ServerResponse.Builder serverResponse = ServerResponse.newBuilder();
//		UsuarioObjDTO.Builder response = UsuarioObjDTO.newBuilder();
//
//		try {
//			usuario = UsuarioBO.getInstance().updateUsuarioCompraProducto(idUsuario, idProducto);
//		} // end_try
//		catch (Exception e) {
//			serverResponse.setCode(500);
//			serverResponse.setMsg(e.getMessage());
//		} // end_catch
//
//		response.setResponse(serverResponse);
//		responseObserver.onNext(response.build());
//		responseObserver.onCompleted();
//
//	} // updateUsuarioCompraProductoRequest
	
	// MAPEOS

	public UsuarioDTO.Builder mapUsuarioToDTO (Usuario u){
		UsuarioDTO.Builder dto = UsuarioDTO.newBuilder();
		dto.setIdUsuario((int)u.getIdUsuario());
		dto.setNombre(u.getNombre());
		dto.setApellido(u.getApellido());
		dto.setDni(u.getDni());
		dto.setEmail(u.getEmail());
		dto.setUsuario(u.getUsuario());
		dto.setClave(u.getClave());
		dto.setSaldoBilletera(u.getSaldoBilletera());

		return dto;
	} // end_mapUsuarioToDTO
	
	public Usuario mapDTOToUsuario (UsuarioDTO dto) throws Exception{		
		Usuario u = new Usuario();
		u.setIdUsuario(dto.getIdUsuario());
		u.setNombre(dto.getNombre());
		u.setApellido(dto.getApellido());
		u.setDni(dto.getDni());
		u.setEmail(dto.getEmail());
		u.setUsuario(dto.getUsuario());
		u.setClave(dto.getClave());
		u.setSaldoBilletera(dto.getSaldoBilletera());
		
		return u;
	} // end_mapDTOToUsuario
	
} // end_UsuarioService
