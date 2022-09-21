package services;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class ProductoServiceGRPCServer {
	public static void main(String[] args) throws IOException, InterruptedException{

		System.out.println("Iniciando servidor grpc ProductoService");
		Server server = ServerBuilder.forPort(9001)
						.addService(new ProductoService())
						.addService(new TransaccionService())
						.addService(new UsuarioService())
						.build();
		server.start();

		System.out.println("Servidor escuchando en puerto " + server.getPort());

		server.awaitTermination();

	}

}
