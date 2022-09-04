package services;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class GRPCServerUNLa {
	public static void main(String[] args) throws IOException, InterruptedException{

		System.out.println("Iniciando servidor grpc");
		Server server = ServerBuilder.forPort(9002)
						.addService(new ProductoService())
						.build();
		server.start();

		System.out.println("Servidor escuchando en puerto " + server.getPort());

		server.awaitTermination();

	}
}