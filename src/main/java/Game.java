import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    //Висилица
    private String[] hangman =  new String[]{

                "     ------\n" +
                "     |    |\n" +
                "     |\n" +
                "     |\n" +
                "     |\n" +
                "     |\n" +
                "     |\n" +
                "    ----------",

                "     ------\n" +
                "     |    |\n" +
                "     |    O\n" +
                "     |\n" +
                "     |\n" +
                "     |\n" +
                "     |\n" +
                "    ----------",

                "     ------\n" +
                "     |    |\n" +
                "     |    O\n" +
                "     |    |\n" +
                "     | \n" +
                "     |   \n" +
                "     |    \n" +
                "    ----------",

                "     ------\n" +
                "     |    |\n" +
                "     |    O\n" +
                "     |   /|\n" +
                "     |   \n" +
                "     |   \n" +
                "     |   \n" +
                "    ----------",

                "     ------\n" +
                "     |    |\n" +
                "     |    O\n" +
                "     |   /|\\\n" +
                "     |   \n" +
                "     |   \n" +
                "     |     \n" +
                "    ----------",

                "     ------\n" +
                "     |    |\n" +
                "     |    O\n" +
                "     |   /|\\\n" +
                "     |   /\n" +
                "     |   \n" +
                "     |    \n" +
                "    ----------",

                "     ------\n" +
                "     |    |\n" +
                "     |    O\n" +
                "     |   /|\\\n" +
                "     |   / \\\n" +
                "     |   \n" +
                "     |   \n" +
                "    ----------"
    };


    //Количество неверных попыток
    private final int maxWrong = hangman.length -1;

    // Количество неверных предположений, сделанных игроком
    private int wrong = 0;

    //Использованные буквы введеные пользователем
     private ArrayList<Character> charUserList = new ArrayList<>();

    //Загаданнео слово
    private StringBuilder randomWord;


    //Строка содержащая "_"
    private StringBuilder so_far ;

    //Статус игры
    private boolean status = true;
    private Words _word ;
    public  Game(){
         _word = new Words();
    }

    public void  Start(){
        wrong = 0;
        charUserList.clear();
        randomWord = new StringBuilder(_word.RandomWord());
        String s = "_".repeat(randomWord.length());
        so_far = new StringBuilder(s);
        status = true;

        System.out.println("Добро пожаловать в игру ВИСИЛИЦА");

        Play();


    }



    private void Play() {
        Scanner scanner = new Scanner(System.in);
        //Пока количество ошибок не будет достигуно максмальных ошибок и не отгадано слово
        while (wrong < maxWrong && !so_far.toString().contentEquals(randomWord)) {

            System.out.println(hangman[wrong]);
            System.out.print("Вы использовали следующие буквы: ");

            for (char ch : charUserList) System.out.print(ch + " ");

            System.out.println("\nНа данный момент слово выглядит так: " + so_far);
            System.out.print("Введите свое предположение: ");

            //Пользователь вводит символ
            char charUse = scanner.next().charAt(0);

            //Проверяем на ввод букву, есть ли такая в списке
            while (charUserList.contains(charUse)) {
                System.out.println("\nВы уже вводили такую букву ");
                charUse = scanner.next().charAt(0);
            }
            //Добавляем букву в список использованных
            charUserList.add(charUse);

            int  numberMatches= 0;
            for (int i = 0; i < randomWord.length(); i++) {

                if(randomWord.charAt(i) == charUse){
                    so_far.setCharAt(i, charUse);
                    numberMatches +=1;
                }
            }

            if (numberMatches == 0) {

                System.out.println("Извините такой буквы нету в слове!");
                wrong += 1;


            } else {

                System.out.println("Да, буква " + charUse + " имется в слове");

            }

        }

        if (wrong == maxWrong) {
            System.out.println(hangman[maxWrong]);
            System.out.println("Тебя повесили");
            System.out.println("Слово было: " + randomWord);



        } else {
            System.out.println("Поздравляем с победой");
            System.out.println("Количество ошибок " + wrong);

        }
        System.out.println("Хотите начать сначала? Для того что бы начать игру заново введите Да, если хотите выйти введите Нет ");
        String answer = scanner.next();
        status = answer.toLowerCase().equals("да") ? true:false ;



    }

    public boolean getStatus() {
        return status;
    }
}
