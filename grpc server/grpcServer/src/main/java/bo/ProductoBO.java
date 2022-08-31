package bo;

import dao.CategoriaDAO;
import dao.ProductoDAO;
import model.Categoria;
import model.Producto;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ProductoBO {

    private static ProductoDAO instancia;

    public static ProductoDAO getInstance() {
        if(instancia == null) {
            instancia = new ProductoDAO();
        }
        return instancia;
    }

    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    ProductoDAO productoDAO = ProductoDAO.getInstance();
    CategoriaDAO categoriaDAO = CategoriaDAO.getInstance();

    public List<Producto> getAll() throws Exception{
        return ProductoDAO.getInstance().getAll();
    }

    public List<Producto> getByFilter(String idCategoria, String nombreLike, String precioDesde, String precioHasta, String fechaDesde, String fechaHasta) throws Exception{
        //conversion de los parametros
        Categoria categoria = idCategoria.isEmpty() ? null : categoriaDAO.getById(Long.parseLong(idCategoria));
        double pDesde = precioDesde.isEmpty() ? 0 :Double.parseDouble(precioDesde);
        double pHasta = precioHasta.isEmpty() ? 0 : Double.parseDouble(precioHasta);
        Date fDesde = fechaDesde.isEmpty() ? null : sdf.parse(fechaDesde);
        Date fHasta = fechaHasta.isEmpty() ? null : sdf.parse(fechaHasta);

        return productoDAO.getByFilter(categoria, nombreLike, pDesde, pHasta, fDesde, fHasta);
    }

    public Producto vender(String idProducto) throws Exception{
        Producto producto = productoDAO.getById(Long.parseLong(idProducto));
        producto.setCantidad(producto.getCantidad()-1);
        Producto newOrModif = productoDAO.saveOrUpdateProducto(producto);
        return newOrModif;
    }
    //TODO generar dto a partir de los proto files

//    public Producto agregarProducto(MedicamentoDTO medicamentoDTO){
//
//    }
}
