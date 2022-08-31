package test;

import dao.UsuarioDAO;

public class TestUsuarioDAO {
	public static void main(String[] args) {
		UsuarioDAO dao = new UsuarioDAO();

		System.out.println("----------------------------------");
		System.out.println("Test getUsuarioByUsuario");
		try {
			System.out.println(dao.getUsuarioByUsuario("maru"));
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}