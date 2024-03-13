import com.sun.nio.sctp.SctpChannel;

import java.util.ArrayList;
import java.util.Scanner;

public class GameContext {

    private static final String[] hangman = new String[]{

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

    private final int MAX_WRONG = hangman.length - 1;
    private ArrayList<Character> charUserList = new ArrayList<>();

    private int wrong = 0;

    private State state;

    private Scanner scanner;

    private Character userAnswer;

    public abstract class State {

        public void execute() {
            this.executeImpl();
            System.out.println(this.getStateInfo());
        }

        public abstract void executeImpl();

        public abstract String getStateInfo();
    }

    private class StartState extends State{

        @Override
        public void executeImpl() {

        }

        @Override
        public String getStateInfo() {
            return null;
        }
    }
    private class UserInputState extends State{

        @Override
        public void executeImpl() {
            userAnswer = scanner.next().charAt(0);

            while (charUserList.contains(userAnswer)) {
                System.out.println("\nВы уже вводили такую букву ");
                state  = new UserInput();
            }
            charUserList.add(userAnswer);
        }

        @Override
        public String getStateInfo() {
            return null;
        }
    }
}
