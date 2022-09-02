package bo;

import dao.TransaccionDAO;
import model.Producto;
import model.Transaccion;
import grpc.Transaccion.*;
import model.Usuario;

import java.util.List;

public class TransaccionBO {

    public static TransaccionBO instancia;

    public static TransaccionBO getInstance() {
        if(instancia == null) {
            instancia = new TransaccionBO();
        }
        return instancia;
    }

    public ProductoBO productoBO = ProductoBO.getInstance();
    public UsuarioBO usuarioBO = UsuarioBO.getInstance();
    public TransaccionDAO transaccionDAO = TransaccionDAO.getInstance();

    public LisTransaccionDTO.Builder getTransacciones(int idUsuario, String tipoUsuario) throws Exception{
        List<Transaccion> transacciones = transaccionDAO.getByIdUsuario(idUsuario, tipoUsuario);
        LisTransaccionDTO.Builder transaccionesDTO = LisTransaccionDTO.newBuilder();
        for(Transaccion t : transacciones){
            transaccionesDTO.addTransacciones(mapTransaccionToDTO(t));
        }
        return transaccionesDTO;
    }


    //Retorna el dto prorque sino tendria que retornar el comprador y el producto para la cantidad y saldo restante en capa service
    public ResTransaccionDTO.Builder venderProducto(TransaccionDTO dto) throws Exception{

        Transaccion entity = mapTransaccionToEntity(dto);
        Usuario usModif = null;
        Producto prModif = null;

        Transaccion persisted = transaccionDAO.saveOrUpdate(entity);
        if(persisted != null){
            usModif = usuarioBO.updateUsuarioCompraProducto(entity.getComprador(), entity.getProducto());
            prModif = productoBO.vender(entity.getProducto(), entity.getCantidad());
        }
        /*TODO
        * Si rompe alguna de las transacciones anteriores deberia hacerse un rollback manual
        * */

        ResTransaccionDTO.Builder res = ResTransaccionDTO.newBuilder();
        res.setIdProducto(prModif.getIdProducto());
        res.setIdComprador(usModif.getIdUsuario());
        res.setSaldoRestante(usModif.getSaldoBilletera());
        res.setCantidadRestante(prModif.getCantidad());

        return res;
    }

    private Transaccion mapTransaccionToEntity(TransaccionDTO dto) throws Exception{
        Transaccion tx = new Transaccion();
        tx.setIdTransaccion(dto.getIdTransaccion());
        tx.setProducto(productoBO.getById(dto.getIdProducto()));
        tx.setComprador(usuarioBO.getById(dto.getIdComprador()));
        tx.setVendedor(usuarioBO.getById(dto.getIdVendedor()));
        tx.setNombre(dto.getNombre());
        tx.setCantidad(dto.getCantidad());
        tx.setPrecio(dto.getPrecio());
        return tx;
    }

    private TransaccionDTO.Builder mapTransaccionToDTO(Transaccion tx) throws Exception{
        TransaccionDTO.Builder dto = TransaccionDTO.newBuilder();
        dto.setIdTransaccion(tx.getIdTransaccion());
        dto.setIdProducto(tx.getProducto().getIdProducto());
        dto.setIdComprador(tx.getComprador().getIdUsuario());
        dto.setIdVendedor(tx.getVendedor().getIdUsuario());
        dto.setNombre(tx.getNombre());
        dto.setCantidad(tx.getCantidad());
        dto.setPrecio(tx.getPrecio());
        return dto;
    }
}
