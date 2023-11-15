package defaultPackage;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import user.UserService;

import java.io.IOException;
import java.util.Scanner;

public class GRPCServer {
    private static Scanner scanner;

    public static void main(String[] args) throws IOException, InterruptedException {
        int port = 9090; // Puerto en el que escucha el servidor
        scanner = new Scanner(System.in);
        String ipAddress = scanner.nextLine();// IPV4 en win, la privada

        Server server = ServerBuilder.forPort(port)
                .addService(new UserService())
                .build();

        server.start();

        System.out.println("Server started at " + ipAddress + ":" + port);

        server.awaitTermination();
        scanner.close();
    }
}