package asset.scripts;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class Data {
    private static final String PATH = "./asset/data/data.txt";
    private static Map<String, Integer> data = loadSaved();
    private static final String CHAPTER = "chapter", EPISODE = "episode", HIGHEST_SCORE = "highestScore";

    public static int life = 3, score = 0;

    private static Map<String, Integer> loadSaved(){
        Map<String, Integer> d = new HashMap<String, Integer>();
        try{
            Scanner file = new Scanner(new File(PATH));
            do{
                String[] dt = file.nextLine().split(":");
                d.put(dt[0], Integer.parseInt(dt[1]));
            }
            while(file.hasNextLine());
            return d;
        }
        catch(FileNotFoundException | NoSuchElementException e){
            System.out.println(e.getMessage());
            try{
                FileWriter fw = new FileWriter(new File(PATH));
                fw.write("chapter:1\n");
                fw.write("episode:1\n");
                fw.write("highestScore:0\n");
                fw.close();
                return loadSaved();
            }
            catch(IOException err){
                System.out.println(err.getMessage());
            }
        }
        return null;
    }
    public static Map<String, Integer> getData(){
        if(data.size() == 0) data = loadSaved();
        return data;
    }
    public static int getChapter(){
        if(!data.keySet().contains(CHAPTER)) return -1;
        return data.get(CHAPTER);
    }
    public static int getEpisode(){
        if(!data.keySet().contains(EPISODE)) return -1;
        return data.get(EPISODE);
    }
    public static int getScore(){
        if(!data.keySet().contains(HIGHEST_SCORE)) return -1;
        return data.get(HIGHEST_SCORE);
    }
}
