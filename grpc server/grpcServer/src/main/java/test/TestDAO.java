package test;

import dao.CategoriaDAO;
import model.Categoria;

import java.util.List;

public class TestDAO {
    public static void main(String[] args) {
        CategoriaDAO categoriaDAO = CategoriaDAO.getInstance();

        try {
            List<Categoria> categorias = categoriaDAO.getAll();
            for(Categoria cat : categorias){
                System.out.println(cat.toString());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
