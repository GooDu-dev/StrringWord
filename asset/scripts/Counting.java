package asset.scripts;

import java.awt.Frame;
import java.sql.Time;

import javax.naming.LinkRef;
import javax.swing.JLabel;

import asset.Frame_game;

public class Counting extends Thread{
    public int n;
    private JLabel label, lifeText;
    private Frame_game frame;
    private Runnable runnable;
    public Counting(int n, JLabel label, JLabel lifeText, Frame_game frame){
        this.n = n;
        this.label = label;
        this.lifeText = lifeText;
        this.frame = frame;
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
        frame.hurt(label, lifeText);
    }
}
