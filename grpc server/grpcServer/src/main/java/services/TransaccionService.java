package services;

import grpc.Transaccion;
import grpc.TransaccionServiceGrpc.*;
import io.grpc.stub.StreamObserver;

public class TransaccionService extends TransaccionServiceImplBase {


    @Override
    public void addTransaccion(Transaccion.TransaccionDTO request, StreamObserver<Transaccion.ResTransaccionDTO> responseObserver) {
        super.addTransaccion(request, responseObserver);
    }

    @Override
    public void getAllComprasByUsuarioIdRequest(Transaccion.GetTransaccionesRequest request, StreamObserver<Transaccion.LisTransaccionDTO> responseObserver) {
        super.getAllComprasByUsuarioIdRequest(request, responseObserver);
    }

    @Override
    public void getAllVentasByUsuarioIdRequest(Transaccion.GetTransaccionesRequest request, StreamObserver<Transaccion.LisTransaccionDTO> responseObserver) {
        super.getAllVentasByUsuarioIdRequest(request, responseObserver);
    }
}
