package bo;

import dao.CategoriaDAO;
import model.Categoria;

import java.util.List;

public class CategoriaBO {

    private static CategoriaBO instancia;

    public static CategoriaBO getInstance() {
        if(instancia == null) {
            instancia = new CategoriaBO();
        }
        return instancia;
    }

    public List<Categoria> getAll() throws Exception{
        return CategoriaDAO.getInstance().getAll();
    }
}
