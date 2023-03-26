package asset.scripts;

import java.util.Random;

import javax.swing.JTextField;


public class Bot implements Runnable{
    
    private JTextField textField;
    private int current_index = 0;

    public Bot(JTextField textField){
        this.textField = textField;
    }

    private char randomChar(){
        // A = 65
        // Z = 90
        return (char)(new Random().nextInt(26)+65);
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        while(true){
            char c = randomChar();
            if(Word.word.equals(textField.getText())){
                // TODO : bot win here !
                break;
            }
            if(Word.word.charAt(current_index) == c){
                textField.setText(String.valueOf(c));
                current_index++;
                if(current_index > Word.word.length()){
                    // reset textField
                    textField.setText("");
                    current_index = 0;
                }
            }
            try{
                Thread.sleep(1000-(Word.usedWords.size()*30) >= 100 ? 1000-(Word.usedWords.size()*30) : 100 ); 
            }
            catch(InterruptedException e){
                System.out.println(e);
            }
        }
    }
}
