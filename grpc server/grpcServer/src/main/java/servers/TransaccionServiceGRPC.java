package servers;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import services.ProductoService;

import java.io.IOException;

public class TransaccionServiceGRPC {
    public static void main(String[] args) throws IOException, InterruptedException{

        System.out.println("Iniciando servidor grpc TransaccionService");

        Server server = ServerBuilder.forPort(9003)
                .addService(new ProductoService())
                .build();
        server.start();

        System.out.println("Servidor escuchando en puerto " + server.getPort());

        server.awaitTermination();
    }
}
