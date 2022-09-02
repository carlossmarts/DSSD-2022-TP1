package services;

import bo.CategoriaBO;
import bo.ProductoBO;
import java.util.Base64;

import dao.CategoriaDAO;
import grpc.Producto.*;
import grpc.ProductoServiceGrpc.*;
import io.grpc.stub.StreamObserver;
import model.Categoria;
import model.FotoProducto;
import model.Producto;

import java.util.ArrayList;
import java.util.List;

public class ProductoService extends ProductoServiceImplBase {

    public ProductoBO productoBO = ProductoBO.getInstance();
    public CategoriaBO categoriaBO = CategoriaBO.getInstance();

    @Override
    public void addProducto(ProductoDTO request, StreamObserver<ResProductoDTO> responseObserver) {
        ResProductoDTO.Builder response = ResProductoDTO.newBuilder();
        ProductoServerResponse.Builder serverResponse = ProductoServerResponse.newBuilder();
        try {
            Producto producto = productoBO.agregarProducto(request);
            response.setProducto(mapProductoToDTO(producto));
            serverResponse.setCod(200);
            serverResponse.setMsg("Usuario guardado");
        } catch (Exception e) {
            serverResponse.setCod(500);
            serverResponse.setMsg(e.getMessage());
        }
        response.setServerResponse(serverResponse);
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void getAllProductos(Empty request, StreamObserver<ProductosDTO> responseObserver) {
        ProductosDTO.Builder response = ProductosDTO.newBuilder();
        ProductoServerResponse.Builder serverResponse = ProductoServerResponse.newBuilder();
        try {
            List<Producto> productos = productoBO.getAll();
            for(Producto p : productos){
                response.addProductos(mapProductoToDTO(p));
            }
            serverResponse.setCod(200);
            serverResponse.setMsg("");
        } catch (Exception e) {
            serverResponse.setCod(500);
            serverResponse.setMsg(e.getMessage());
        }
        response.setServerResponse(serverResponse);
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void getByFilter(ProductoFilterDTO request, StreamObserver<ProductosDTO> responseObserver) {
        ProductosDTO.Builder response = ProductosDTO.newBuilder();
        ProductoServerResponse.Builder serverResponse = ProductoServerResponse.newBuilder();
        try {
            List<Producto> productos = productoBO.getByFilter(
                    request.getCategoria(),
                    request.getNombreLike(),
                    request.getPrecioDesde(),
                    request.getPrecioHasta(),
                    request.getFechaDesde(),
                    request.getFechaHasta()
            );
            for(Producto p : productos){
                response.addProductos(mapProductoToDTO(p));
            }
            serverResponse.setCod(200);
            serverResponse.setMsg("");
        } catch (Exception e) {
            serverResponse.setCod(500);
            serverResponse.setMsg(e.getMessage());
        }
        response.setServerResponse(serverResponse);
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void getAllCategorias(Empty request, StreamObserver<CategoriasDTO> responseObserver) {
        CategoriasDTO.Builder categoriasDTO = CategoriasDTO.newBuilder();
        ProductoServerResponse.Builder serverResponse = ProductoServerResponse.newBuilder();
        try {
            List<Categoria> categorias = categoriaBO.getAll();
            for (Categoria c : categorias) {
                categoriasDTO.addCategorias(mapCategoriaToDTO(c));
            }
            categoriasDTO.setServerResponse(serverResponse);
        } catch (Exception e) {
            serverResponse.setCod(500);
            serverResponse.setMsg(e.getMessage());
        }
        responseObserver.onNext(categoriasDTO.build());
        responseObserver.onCompleted();
    }

    private ProductoDTO.Builder mapProductoToDTO (Producto p) throws Exception{
        ProductoDTO.Builder dto = ProductoDTO.newBuilder();
        dto.setIdProducto(p.getIdProducto());
        dto.setNombre(p.getNombre());
        dto.setDescripcion(p.getDescripcion());
        dto.setPrecio(p.getPrecio());
        dto.setCantidadDisponible(p.getCantidad());
        dto.setFechaFabricacion(ProductoBO.sdf.format(p.getFechaFabricacion()));
        dto.setIdCategoria(p.getCategoria().getIdCategoria());
        dto.setIdUsuario(p.getUsuario().getIdUsuario());
        for(FotoProducto foto: p.getFotosProducto()){
            FotoDTO.Builder tempFotoDTO = FotoDTO.newBuilder();
            tempFotoDTO.setIdFoto(foto.getIdFoto());
            tempFotoDTO.setNombre(foto.getNombre());
            tempFotoDTO.setFile(Base64.getEncoder().encodeToString(foto.getArchivo()));
            dto.addFotos(tempFotoDTO);
        }
        return dto;
    }

    private CategoriaDTO.Builder mapCategoriaToDTO(Categoria c) throws Exception{
        CategoriaDTO.Builder catDTO = CategoriaDTO.newBuilder();
        catDTO.setIdCategoria(c.getIdCategoria());
        catDTO.setCategoria(c.getCategoria());
        return catDTO;
    }
}
