

public class App {


    public static void main(String[] args) {
        CrossCircleGame.printMap();
        CrossCircleGame.prepareToGameCleanMap();
        while (true) {
            CrossCircleGame.checkIsMapNotFull();
            if (CrossCircleGame.sendWinnerMassege()) break;
            CrossCircleGame.playerInput();
            if (CrossCircleGame.checkIsAlreadyHaveWinner()) continue;
            CrossCircleGame.playerAIGenerator();
            CrossCircleGame.printMap();
        }

    }


}