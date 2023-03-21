package asset.scripts;

public class Counting extends Thread{
    private int n;
    private Runnable runnable;
    public Counting(int n){
        this.n = n;
    }
    public Counting(int n, Runnable runnable){
        super(runnable);
        this.n = n;
        this.runnable = runnable;
    }
    @Override
    public void run(){
        if(runnable != null){
            runnable.run();
            return;
        } 
        for(int i=0; i<n; i++){
            System.out.println(i);
            try{
                sleep(1000);
            }catch(InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
