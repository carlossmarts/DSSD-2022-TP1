package bo;


import dao.CategoriaDAO;
import dao.JPAUtil;
import model.Categoria;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
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
