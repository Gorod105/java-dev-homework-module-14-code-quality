import java.util.Scanner;

public class CrossCircleGame {
    private char[] box = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private boolean boxAvailable = false;
    private byte winner = 0;

    public boolean checkIsAlreadyHaveWinner() {
        if (didPlayerWin('X')) {
            winner = 1;
            return true;
        }
        if (didPlayerWin('O')) {
            winner = 2;
            return true;
        }
        if (!boxAvailable) {
            winner = 3;
            return true;
        }
        return false;
    }

    private boolean didPlayerWin(char symbol) {
        return (box[0] == symbol && box[1] == symbol && box[2] == symbol) || (box[3] == symbol && box[4] == symbol && box[5] == symbol) || (box[6] == symbol && box[7] == symbol && box[8] == symbol) ||
                (box[0] == symbol && box[3] == symbol && box[6] == symbol) || (box[1] == symbol && box[4] == symbol && box[7] == symbol) || (box[2] == symbol && box[5] == symbol && box[8] == symbol) ||
                (box[0] == symbol && box[4] == symbol && box[8] == symbol) || (box[2] == symbol && box[4] == symbol && box[6] == symbol);
    }

    public void playerInput() {
        byte input;
        Scanner scan = new Scanner(System.in);
        while (true) {

            input = scan.nextByte();
            if (input > 0 && input < 10) {
                if (box[input - 1] == 'X' || box[input - 1] == 'O')
                    System.out.println("That one is already in use. Enter another.");
                else {
                    box[input - 1] = 'X';
                    break;
                }
            } else
                System.out.println("Invalid input. Enter again.");
        }
    }

    public boolean sendWinnerMassege() {
        if (winner == 1) {
            System.out.println("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
            return true;
        } else if (winner == 2) {
            System.out.println("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
            return true;
        } else if (winner == 3) {
            System.out.println("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
            return true;
        }
        return false;
    }

    public void playerAIGenerator() {
        byte rand;
        while (true) {
            rand = (byte) (Math.random() * (9 - 1 + 1) + 1);
            if (box[rand - 1] != 'X' && box[rand - 1] != 'O') {
                box[rand - 1] = 'O';
                break;
            }
        }
    }

    public void checkIsMapNotFull() {
        for (int i = 0; i < 9; i++) {
            if (box[i] != 'X' && box[i] != 'O') {
                boxAvailable = true;
                break;
            }
        }
    }

    public void prepareToGameCleanMap() {
        for (int i = 0; i < 9; i++)
            box[i] = ' ';
    }

    public void printMap() {
        System.out.println("Enter box number to select. Enjoy!\n");
        System.out.println("\n " + box[0] + " | " + box[1] + " | " + box[2] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[3] + " | " + box[4] + " | " + box[5] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[6] + " | " + box[7] + " | " + box[8] + " \n");
    }
}
