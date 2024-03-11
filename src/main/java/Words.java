import java.io.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;

public class Words {

    private ArrayList<String> wordList = new ArrayList<>();

    public  Words(){
        ReaderFile();
    }
    private void ReaderFile() {

        try (InputStream is = this.getClass().getResourceAsStream("/words.txt");
             InputStreamReader isr = new InputStreamReader(is);
             BufferedReader br = new BufferedReader(isr)
        ) {
            //чтение построчно
            String str;
            while ((str = br.readLine()) != null) {

                wordList.add(str.toLowerCase());
            }

        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }

    }

    public String RandomWord(){

        Random random_method = new Random();
        int index = random_method.nextInt(wordList.size());

        return  wordList.get(index);
    }
}
