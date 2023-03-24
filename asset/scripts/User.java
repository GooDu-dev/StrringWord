package asset.scripts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.Runnable;

import java.util.ArrayList;

import javax.swing.JTextArea;

import java.net.Socket;

public class User implements Runnable{
    
    private static ArrayList<User> users = new ArrayList<User>();
    private static int player_count=0;

    private Socket user;
    private BufferedReader request;
    private PrintWriter response;
    private Player player;
    private JTextArea text;
    public enum Player {
        BLUE,
        RED,
        GREEN,
        YELLOW
    }

    public User(Socket user){
        try{
            this.user = user;
            request = new BufferedReader(new InputStreamReader(user.getInputStream()));
            response = new PrintWriter(user.getOutputStream());
            switch(player_count){
                case 1 -> player = Player.RED;
                case 2 -> player = Player.BLUE;
                case 3 -> player = Player.GREEN;
                case 4 -> player = Player.YELLOW;
                default -> clearUser();
            }
            player_count++;
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
    public void clearUser(){
        try{
            if(user.isConnected()) user.close();
            request.close();
            response.close();
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
    
    @Override
    public void run() {
        while(user.isConnected()){
            
        }
    }
}
