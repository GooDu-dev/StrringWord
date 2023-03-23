package asset.scripts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private BufferedReader request;
    private PrintWriter response;
    public Server(ServerSocket serverSocket){
        this.serverSocket = serverSocket;
    }
    public void start(){
        try{
            clientSocket = serverSocket.accept();
            
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
}
