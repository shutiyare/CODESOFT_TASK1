package com.shutiye;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final int MAX_ATTEMPTS = 5; // Maximum number of attempts
    private static int totalRounds = 0; // Total rounds played
    private static int roundsWon = 0; // Roun
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain;

        do {
            playAgain = false;
            totalRounds++;
            int numberToGuess = random.nextInt(100) + 1; // Generate random number between 1 and 100
            int attempts = 0;
            boolean hasGuessedCorrectly = false;

            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("I have generated a number between 1 and 100. You have " + MAX_ATTEMPTS + " attempts to guess it.");

            while (!hasGuessedCorrectly && attempts < MAX_ATTEMPTS) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else if (guess > numberToGuess) {
                    System.out.println("Too high! Try again.");
                } else {
                    hasGuessedCorrectly = true;
                    roundsWon++;
                    System.out.println("Congratulations! You've guessed the number " + numberToGuess + " in " + attempts + " attempts.");
                }

                if (attempts == MAX_ATTEMPTS && !hasGuessedCorrectly) {
                    System.out.println("Sorry, you've used all your attempts. The correct number was " + numberToGuess + ".");
                }
            }

            // Ask if the user wants to play again
            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next().toLowerCase();
            if (response.equals("yes")) {
                playAgain = true;
            }

        } while (playAgain);

        // Display final score
        System.out.println("\nGame Over!");
        System.out.println("Total Rounds Played: " + totalRounds);
        System.out.println("Rounds Won: " + roundsWon);
        double scorePercentage = ((double) roundsWon / totalRounds) * 100;
        System.out.printf("Your Score: %.2f%%\n", scorePercentage);

        scanner.close();
    }

}