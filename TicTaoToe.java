import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

class WrongInputException extends Exception {

    public WrongInputException(String errorMessage) {
        super(errorMessage);

    }
}

public class TicTaoToe {

    static void validate(String input) throws WrongInputException {
        input = input.toUpperCase();
        if (input.equals("X") || input.equals("O")) {
            System.out.println("Valid response");
        } else {
            throw new WrongInputException("Wrong input!");
        }
    }

    static void pause(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            System.err.format("IOException: %s%n", e);
        }
    }

    static void printBoard(HashMap<String, String> board) {
        System.out.println(board.get("1") + " |" + board.get("2") + " |" + board.get("3") + " |");
        System.out.println("-- -- --");
        System.out.println(board.get("4") + " |" + board.get("5") + " |" + board.get("6") + " |");
        System.out.println("-- -- --");
        System.out.println(board.get("7") + " |" + board.get("8") + " |" + board.get("9") + " |");

    }

    public static void main(String[] args) {

        HashMap<String, String> board = new HashMap<String, String>();
        board.put("1", "1");
        board.put("2", "2");
        board.put("3", "3");
        board.put("4", "4");
        board.put("5", "5");
        board.put("6", "6");
        board.put("7", "7");
        board.put("8", "8");
        board.put("9", "9");

        printBoard(board);
        System.out.print("Welcome to a game of tic tao toe. \nPick between X and O: ");

        Scanner scan = new Scanner(System.in);
        String playerSide = scan.nextLine();
        playerSide = playerSide.toUpperCase();

        try {
            validate(playerSide);
        } catch (WrongInputException e) {
            System.out.println(e);

        }

        String computerSide = (playerSide.equals("X")) ? "O" : "X";
        System.out.println("You are " + playerSide + " while Computer is " + computerSide);
        System.out.println("Pick a number to play");
        printBoard(board);

        ArrayList<String> boardList = new ArrayList<String>();
        String[] list = { "1", "2", "3", "4", "5", "6", "7", "8", "9" };
        for (String i : list) {
            boardList.add(i);
        }

        Random rand = new Random();

        while (boardList.size() > 0) {
            // player
            System.out.print("Your turn: ");
            String playerInput = scan.nextLine();
            board.replace(playerInput, playerSide);
            boardList.remove(playerInput);
            System.out.println("You play at position " + playerInput);
            printBoard(board);

            if (boardList.size() == 0) {
                break;
            }

            // computer
            System.out.println("\n");
            System.out.println("Computer's turn");
            pause(1000); // pause for a second
            int randomIndex = rand.nextInt(boardList.size());
            String computerInput = boardList.get(randomIndex);
            board.replace(computerInput, computerSide);
            boardList.remove(computerInput);

            System.out.println("Computer play at position " + computerInput);
            printBoard(board);

        }

        scan.close();

    }

}
