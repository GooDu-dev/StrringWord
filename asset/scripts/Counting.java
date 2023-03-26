package asset.scripts;

import javax.swing.JLabel;

public class Counting extends Thread{
    public int n;
    private JLabel label;
    private Runnable runnable;
    public Counting(int n, JLabel label){
        this.n = n;
        this.label = label;
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
            // Sytem.out.println(i);
            try{
                // wait(1000);
                Thread.sleep(1000);
                label.setText("Time : "+n);
                System.out.println(n--);
            }catch(InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
