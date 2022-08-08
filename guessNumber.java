import java.util.Scanner;

public class guessNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to guess the number.\nPick a number between 0 to 10");
        int randomNum = (int) (Math.random() * 11);

        for (int i = 0; i < 5; i++) {
            int number = scan.nextInt();

            if (number == randomNum) {
                System.out.println("Congatulations!! \nYou Guess the right number");
                break;
            } else if (number > 10 || number < 0) {
                System.out.println("Enter a number in the range of 0 to 10");
            } else if (number > randomNum) {
                System.out.println("Your number is greater than the guess.\nTry again.");
            } else if (number < randomNum) {
                System.out.println("Your number is less than the guess.\nTry again.");
            }

            if (i == 4) {
                System.out.println("You have guessed five times. \nGame again.");
            }

        }

    }

}
