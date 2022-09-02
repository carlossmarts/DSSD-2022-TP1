package test;

import dao.CategoriaDAO;
import dao.ProductoDAO;
import model.Categoria;
import model.Producto;

import java.util.List;

public class TestDAO {
    public static void main(String[] args) {
        CategoriaDAO categoriaDAO = CategoriaDAO.getInstance();
        ProductoDAO productoDAO = ProductoDAO.getInstance();

//        try {
//            List<Categoria> categorias = categoriaDAO.getAll();
//            for(Categoria cat : categorias){
//                System.out.println(cat.toString());
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }

        try {
            System.out.println(categoriaDAO.getById(1));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
