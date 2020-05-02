package homework6.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private static boolean isRun = true;

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 87);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        Scanner scannedMessage = new Scanner(System.in);

        Thread inputService = new Thread(() -> {
            while (isRun) {
                String messageFromServer;
                try {
                    messageFromServer = in.readUTF();
                    System.out.println(messageFromServer);
                } catch (IOException e) {
                    System.out.println("Input connection to the server is lost. Check connection.");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                }

            }

        });
        inputService.start();

        Thread outputService = new Thread(() -> {
            while (isRun){
                String messageToServer = scannedMessage.nextLine();

                try {
                    out.writeUTF(messageToServer);
                    out.flush();
                } catch (IOException e) {
                    System.out.println("Output connection to the server is lost. Check connection.");
                }

                if (messageToServer.equals("quit")) {
                    System.out.println("Close client");
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    isRun = false;
                }

            }
        });
        outputService.start();
    }
}