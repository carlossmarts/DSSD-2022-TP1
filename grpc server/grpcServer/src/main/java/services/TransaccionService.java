package services;

import bo.TransaccionBO;
import grpc.Transaccion.*;
import grpc.TransaccionServiceGrpc.*;
import io.grpc.stub.StreamObserver;

public class TransaccionService extends TransaccionServiceImplBase {

    public TransaccionBO transaccionBO = TransaccionBO.getInstance();

    @Override
    public void addTransaccion(TransaccionDTO request, StreamObserver<ResTransaccionDTO> responseObserver) {
        ResTransaccionDTO.Builder response = null;
        TransaccionServerResponse.Builder serverResponse = TransaccionServerResponse.newBuilder();
        try {
            response = transaccionBO.venderProducto(request);
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
    public void getComprasOVentasByUsuarioRequest(GetTransaccionesRequest request, StreamObserver<LisTransaccionDTO> responseObserver) {
        LisTransaccionDTO.Builder response = null;
        TransaccionServerResponse.Builder serverResponse = TransaccionServerResponse.newBuilder();
        try {
            response = transaccionBO.getTransacciones(request.getIdUsuario(), request.getTipoUsuario());
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

}
