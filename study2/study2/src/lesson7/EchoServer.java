package lesson7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) {
        Socket socket = null;
        try(ServerSocket serverSocket = new ServerSocket(8189)){
            System.out.println("Server started, waiting for connect");
            socket = serverSocket.accept();
            System.out.println("Client has connected");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            while (true){
                String str = in.readUTF();
                if (str.equals("/end")){
                    break;
                }
                out.writeUTF("ECHO: "+str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
