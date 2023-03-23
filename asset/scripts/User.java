package asset.scripts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.Runnable;

import java.util.ArrayList;

import java.net.Socket;

public class User implements Runnable{
    
    private static ArrayList<User> users = new ArrayList<User>();

    private Socket user;
    private BufferedReader request;
    private PrintWriter response;
    private Player player;
    public enum Player {
        BLUE,
        RED
    }

    public User(Socket user){
        try{
            this.user = user;
            request = new BufferedReader(new InputStreamReader(user.getInputStream()));
            response = new PrintWriter(user.getOutputStream());
            player = player.RED;            
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
    
    @Override
    public void run() {
        
    }
}
