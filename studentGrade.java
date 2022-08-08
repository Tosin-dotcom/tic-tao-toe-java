import java.util.Scanner;

public class studentGrade {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome. Let's calculate student grade");

        System.out.print("Enter your score: ");
        int score = scan.nextInt();

        System.out.println(score);
        if (score > 69 && score < 101) {
            System.out.println("Grade A");
        } else if (score > 60 && score < 70) {
            System.out.println("Grade B");
        } else if (score > 49 && score < 61) {
            System.out.println("Grade C");
        } else if (score > 44 && score < 59) {
            System.out.println("Grade D");
        } else if (score > 39 && score < 45) {
            System.out.println("Grade E");
        } else {
            System.out.println("Grade F");
        }
    }
}
