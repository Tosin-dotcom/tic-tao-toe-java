package classes;

import java.util.HashMap;

class WrongInputException extends Exception {

    public WrongInputException(String errorMessage) {
        super(errorMessage);

    }
}

public class MyMethods {
    public void validate(String input) throws WrongInputException {
        input = input.toUpperCase();
        if (input.equals("X") || input.equals("O")) {
            System.out.println("Valid response");
        } else {
            throw new WrongInputException("Wrong input!");
        }
    }

    public void pause(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            System.err.format("IOException: %s%n", e);
        }
    }

    public void printBoard(HashMap<String, String> board) {
        System.out.println(board.get("1") + " |" + board.get("2") + " |" + board.get("3") + " |");
        System.out.println("-- -- --");
        System.out.println(board.get("4") + " |" + board.get("5") + " |" + board.get("6") + " |");
        System.out.println("-- -- --");
        System.out.println(board.get("7") + " |" + board.get("8") + " |" + board.get("9") + " |");

    }
}
