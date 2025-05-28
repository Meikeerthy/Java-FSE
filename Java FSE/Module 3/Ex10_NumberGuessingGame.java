import java.util.Scanner;
import java.util.Random;

public class Ex10_NumberGuessingGame {
    public static void main(String[] args) {
        Random rand = new Random();
        int numberToGuess = rand.nextInt(100) + 1;
        int guess = 0;
        Scanner sc = new Scanner(System.in);

        while (guess != numberToGuess) {
            System.out.print("Guess the number (1-100): ");
            if (sc.hasNextInt()) {
                guess = sc.nextInt();
                if (guess < numberToGuess) System.out.println("Too low!");
                else if (guess > numberToGuess) System.out.println("Too high!");
                else System.out.println("Correct!");
            } else {
                System.out.println("Please enter a valid integer.");
                sc.next(); // consume the invalid input
            }
        }
        sc.close();
    }
}
