package test;

import dao.UsuarioDAO;

public class TestUsuarioDAO {
	public static void main(String[] args) {
		UsuarioDAO dao = new UsuarioDAO();

		System.out.println("----------------------------------");
		System.out.println("Test getUsuarioById");
		try {
			System.out.println(dao.getById(1));
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\n\n----------------------------------");
		System.out.println("Test getUsuarioByUsuario");
		try {
			System.out.println(dao.getByNombreUsuario("maru"));
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}


	}
}