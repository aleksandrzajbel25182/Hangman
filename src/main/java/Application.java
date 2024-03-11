import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Application {



    public static void main(String[] args) {


       Game game = new Game();
       while (game.getStatus()){
           game.Start();
       }
        System.exit(0);


    }
}
