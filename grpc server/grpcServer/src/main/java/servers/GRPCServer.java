package servers;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import services.ProductoService;
import services.TransaccionService;
import services.UsuarioService;

public class GRPCServer {
    public static void main(String[] args) throws IOException, InterruptedException{

        System.out.println("Iniciando servidor grpc");

        Server server = ServerBuilder.forPort(9001)
                .addService(new ProductoService())
                .addService(new UsuarioService())
                .addService(new TransaccionService())
                .build();
        server.start();

        System.out.println("Servidor escuchando en puerto " + server.getPort());

        server.awaitTermination();
    }
}
