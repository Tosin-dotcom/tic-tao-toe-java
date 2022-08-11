import classes.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.util.HashMap;

public class TicTaoToe {
    public static void main(String[] args) {
        MyMethods obj = new MyMethods();

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

        obj.printBoard(board);
        System.out.print("Welcome to a game of tic tao toe. \nPick between X and O: ");

        Scanner scan = new Scanner(System.in);
        String playerSide = scan.nextLine();
        playerSide = playerSide.toUpperCase();

        String computerSide = (playerSide.equals("X")) ? "O" : "X";

        System.out.println("You are " + playerSide + " while Computer is " + computerSide);

        System.out.println("Pick a number to play");
        obj.printBoard(board);

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
            obj.printBoard(board);

            if (boardList.size() == 0) {
                break;
            }

            // computer
            System.out.println("\n");
            System.out.println("Computer's turn");
            obj.pause(1000); // pause for a second
            int randomIndex = rand.nextInt(boardList.size());
            String computerInput = boardList.get(randomIndex);
            board.replace(computerInput, computerSide);
            boardList.remove(computerInput);

            System.out.println("Computer play at position " + computerInput);
            obj.printBoard(board);

        }

        scan.close();

    }

}
