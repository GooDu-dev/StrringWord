package asset.scripts;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Word {
    private static final String PATH = "./asset/data/word.txt";
    private static ArrayList<String> words = new ArrayList<String>();
    protected static ArrayList<String> usedWords = new ArrayList<String>();

    public static String word = getRandomWord();

    private static ArrayList<String> loadWord(){
        ArrayList<String> data = new ArrayList<String>();
        try{
            Scanner file = new Scanner(new File(PATH));
            while(file.hasNextLine()){
                data.add(file.nextLine());
            }
            return data;
        }
        catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    public static ArrayList<String> getWords(){
        if(words.size() == 0) words = loadWord();
        return words;
    }
    public static String getRandomWord(){
        if(words.size() == 0) words = loadWord();
        int index = (new Random().nextInt(words.size()+1)*100000)%(words.size()+1);
        if(usedWords.contains(words.get(index))) return getRandomWord();
        usedWords.add(words.get(index));
        return words.get(index);
    }
}
