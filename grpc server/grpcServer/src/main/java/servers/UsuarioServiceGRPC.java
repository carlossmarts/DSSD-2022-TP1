package servers;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import services.UsuarioService;

import java.io.IOException;

public class UsuarioServiceGRPC {
    public static void main(String[] args) throws IOException, InterruptedException{

        System.out.println("Iniciando servidor grpc UsuarioService");

        Server server = ServerBuilder.forPort(9001)
                .addService(new UsuarioService())
                .build();
        server.start();

        System.out.println("Servidor escuchando en puerto " + server.getPort());

        server.awaitTermination();
    }
}
