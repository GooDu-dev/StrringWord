package asset.scripts;

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
        while(n>0){
            try{
                Thread.sleep(1000);
                label.setText("Time : "+--n);
            }catch(InterruptedException e){
                System.out.println(e.getMessage());
                break;
            }
        }
        frame.hurt(label, lifeText);
    }
    public void setN(int n){
        this.n = n;
    }
}
