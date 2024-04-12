

public class App {


    public static void main(String[] args) {
        CrossCircleGame game = new CrossCircleGame();
        game.printMap();
        game.prepareToGameCleanMap();
        while (true) {
            game.checkIsMapNotFull();
            if (game.sendWinnerMassege()) break;
            game.playerInput();
            if (game.checkIsAlreadyHaveWinner()) continue;
            game.playerAIGenerator();
            game.printMap();
        }

    }


}