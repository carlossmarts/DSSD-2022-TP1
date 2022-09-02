package bo;
import dao.CategoriaDAO;
import dao.ProductoDAO;
import grpc.Producto.*;
import model.Categoria;
import model.FotoProducto;
import model.Producto;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

public class ProductoBO {

    private static ProductoBO instancia;

    public static ProductoBO getInstance() {
        if(instancia == null) {
            instancia = new ProductoBO();
        }
        return instancia;
    }

    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    ProductoDAO productoDAO = ProductoDAO.getInstance();
    CategoriaDAO categoriaDAO = CategoriaDAO.getInstance();
    UsuarioBO usuarioBO = UsuarioBO.getInstance();

    public List<Producto> getAll() throws Exception{
        return ProductoDAO.getInstance().getAll();
    }

    public List<Producto> getByFilter(int idCategoria, String nombreLike, double precioDesde, double precioHasta, String fechaDesde, String fechaHasta) throws Exception{
        //conversion de los parametros
        Categoria categoria = idCategoria == 0 ? null : categoriaDAO.getById(idCategoria);
        Date fDesde = fechaDesde.isEmpty() ? null : sdf.parse(fechaDesde);
        Date fHasta = fechaHasta.isEmpty() ? null : sdf.parse(fechaHasta);

        return productoDAO.getByFilter(categoria, nombreLike, precioDesde, precioHasta, fDesde, fHasta);
    }


    public Producto agregarProducto(ProductoDTO productoDTO) throws Exception {
        Producto toPersist = mapProductoToEntity(productoDTO);
        List<FotoProducto> fotos = toPersist.getFotosProducto();
        toPersist.setFotosProducto(new ArrayList<>());

        Producto persisted = productoDAO.saveOrUpdateProducto(toPersist);
        for(FotoProducto foto : fotos ){
            foto.setProducto(persisted);
            productoDAO.saveOrUpdateFotoProducto(foto);
        }
        persisted.setFotosProducto(fotos);
        return persisted;
//        return productoDAO.saveOrUpdateProducto(mapProductoToEntity(productoDTO));

    }

    private Producto mapProductoToEntity (ProductoDTO dto) throws Exception{
        Producto p = new Producto();
        p.setIdProducto(dto.getIdProducto());
        p.setNombre(dto.getNombre());
        p.setDescripcion(dto.getDescripcion());
        p.setPrecio(dto.getPrecio());
        p.setCantidad(dto.getCantidadDisponible());
        p.setFechaFabricacion(sdf.parse(dto.getFechaFabricacion()));
        p.setCategoria(categoriaDAO.getById(dto.getIdCategoria()));
        p.setUsuario(usuarioBO.getById(dto.getIdUsuario()));
        List<FotoProducto> fotos = new ArrayList<>();
        for(FotoDTO fotoDTO : dto.getFotosList()){
            FotoProducto tempFoto = new FotoProducto();
            tempFoto.setIdFoto(fotoDTO.getIdFoto());
            tempFoto.setNombre(fotoDTO.getNombre());
            tempFoto.setArchivo(Base64.getDecoder().decode(fotoDTO.getFile()));
            fotos.add(tempFoto);
        }
        p.setFotosProducto(fotos);
        return p;
    }


}
