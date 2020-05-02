package homework6.server;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    static boolean isClientConnected = false; //Флаг проверки подключения клиента

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(87);
        System.out.println("Server started");
        Scanner scannedMessage = new Scanner(System.in);

    while (true){
        Socket con = server.accept();
        isClientConnected = true;
        System.out.println("Connected " + con.getInetAddress());
        DataInputStream in = new DataInputStream(con.getInputStream());
        DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.writeUTF("Connected to server");
        out.flush();


        Thread inputService = new Thread(() -> {
            while (isClientConnected) {
                String messageToClient = scannedMessage.nextLine();

                try {
                    out.writeUTF(messageToClient);
                    out.flush();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        inputService.start();

        Thread outputService = new Thread(() -> {
                while (isClientConnected) {
                    try {
                        String messageFromClient = in.readUTF();
                        switch (messageFromClient) {
                            case ("quit"):{
                                System.out.println("Client disconnected");
                                isClientConnected = false;
                                break;
                                }
                            default: {System.out.println(messageFromClient);
                                break;
                                }
                        }
                    } catch (IOException e) {
                        System.out.println("Connection to client is lost. Check connection.");
                        e.printStackTrace();
                        isClientConnected = false;
                    }
                }
        });
        outputService.start();

        }
    }
}