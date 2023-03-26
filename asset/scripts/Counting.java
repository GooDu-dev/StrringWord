package asset.scripts;

import java.sql.Time;

import javax.naming.LinkRef;
import javax.swing.JLabel;

import asset.Frame_game;

public class Counting extends Thread{
    public int n;
    private JLabel label, life;
    private Runnable runnable;
    public Counting(int n, JLabel label, JLabel life){
        this.n = n;
        this.label = label;
        this.life = life;
    }
    public Counting(Runnable runnable){
        super(runnable);
        this.runnable = runnable;
    }
    @Override
    public void run(){
        if(runnable != null){
            runnable.run();
            return;
        } 
        while(n>=0){
            // Sytem.out.println(i);
            try{
                // wait(1000);
                Thread.sleep(1000);
                label.setText("Time : "+n--);
            }catch(InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
        Frame_game.hurt(label, life);;
    }
}
