public class Application {


    public static void main(String[] args) {
        Game game = new Game();
        while (game.getStatus()) {
            game.Start();
        }
        System.exit(0);
    }
}
