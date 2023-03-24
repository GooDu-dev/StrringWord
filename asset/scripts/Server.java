package asset.scripts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.rmi.UnexpectedException;

public class Server {
    private static final int PORT = 1234;

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private BufferedReader request;
    private PrintWriter response;
    private Thread thread;
    public Server(ServerSocket serverSocket){
        this.serverSocket = serverSocket;
    }
    public void start(){
        try{
            clientSocket = serverSocket.accept();
            request = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            response = new PrintWriter(clientSocket.getOutputStream());
            User user = new User(clientSocket);
            thread = new Thread(user);
        }
        catch(IOException e){
            System.out.println(e);
            stop();
        }
    }
    public void stop(){
        try{
            if(!serverSocket.isClosed()){
                serverSocket.close();
            }
            if(clientSocket.isConnected()){
                clientSocket.close();
            }
            if(thread.isAlive()){
                thread.interrupt();
            }
            request.close();
            serverSocket.close();
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
    public static String generateIP(){
        try{
            return String.valueOf(InetAddress.getLocalHost().getHostAddress());
        }
        catch(UnknownHostException e){
            System.out.println(e);
        }
        return null;
    }
    public boolean isClosed(){
        return serverSocket.isClosed();
    }
}
