package bo;

import grpc.Product.*;
import grpc.Transaccion;

public class VentaBO {

    public static VentaBO instancia;

    public static VentaBO getInstance() {
        if(instancia == null) {
            instancia = new VentaBO();
        }
        return instancia;
    }

    //Retorna el dto prorque sino tendria que retornar el comprador y el producto para la cantidad y saldo restante en capa service
    public Transaccion.ResTransaccionDTO.Builder venderProducto(int idProducto, int idComprador, int idCantidad){

        /*
        * TODO
        * 1) traer producto y usuario comprador
        * 2) Update saldo comprador (usuarioBO - updateUsuarioCompraProducto)
        * 3) Crear venta (Crear dao)
        * 4) Update cantidad Producto (ProductoBO - vender)
        * 5) rezar que no se rompa ninguna transacción
        * 6) Si rompe hacer un rollback a mano
        * */
        return null;
    }

}
