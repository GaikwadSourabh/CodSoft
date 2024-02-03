import java.util.Scanner;
import java.util.Random;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int score = 0;

        while (true) {
            int secretNumber = random.nextInt(100) + 1;
            int attempts = 0;

            System.out.println("Welcome to Guess the Number!");
            System.out.println("Try to guess the number between 1 and 100.");

            while (true) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();

                attempts++;
                if (userGuess == secretNumber) {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    score++;
                    break;
                } else if (userGuess < secretNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }

                if (attempts == 5) {
                    System.out.println("Sorry, you've reached the maximum attempts. The correct number was " + secretNumber + ".");
                    break;
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next();
            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
        }

        System.out.println("Your total score: " + score);

        scanner.close();
    }
}
