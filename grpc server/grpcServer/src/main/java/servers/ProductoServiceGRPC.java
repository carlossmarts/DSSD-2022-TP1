package servers;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import services.ProductoService;


import java.io.IOException;

public class ProductoServiceGRPC {
    public static void main(String[] args) throws IOException, InterruptedException{

        System.out.println("Iniciando servidor grpc ProductoService");

        Server server = ServerBuilder.forPort(9002)
                .addService(new ProductoService())
                .build();
        server.start();

        System.out.println("Servidor escuchando en puerto " + server.getPort());

        server.awaitTermination();
    }
}
