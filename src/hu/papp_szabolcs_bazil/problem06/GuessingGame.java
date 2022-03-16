package hu.papp_szabolcs_bazil.problem06;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class GuessingGame {

    private static final String WELCOME_MSG = "This is a guessing game!\n" +
            "You guess a number, and the computer" +
            "will roll a dice until it can reproduce your guess!";

    private static int guess;
    private static int rollCounter = 0;
    /*
    Készítsünk tippelős játékot. A program kérjen be egy tippet (1-6)
    a játékostól és addig dobjon a kockával, amíg a dobott érték meg
    nem egyezik a tippelt számmal. Egyezés esetén írjuk ki, hogy
    talált és írjuk ki a dobások számát. Ekkor kilépünk a programból.
     */

    public static void main(String[] args) {
        play();
    }

    private static void play() {
        System.out.println(WELCOME_MSG);
        getGuess();
        while (!isRollMatchingGuess()) {
            rollCounter++;
        }
        System.out.println("It took me " + rollCounter + " rolls to match your guess!");
    }

    private static boolean isRollMatchingGuess() {
        return rollADice() == guess;
    }

    private static int rollADice() {
        return ThreadLocalRandom.current().nextInt(6) + 1;
    }

    private static void getGuess() {
        final String ASK_FOR_INPUT = "Please enter a guess between 1 and 6 (inclusive):";
        final String WRONG_INPUT = "Invalid selection! Valid entries are: 1-6";

        Scanner sc = new Scanner(System.in);
        boolean inputIsValid = false;

        System.out.println(ASK_FOR_INPUT);
        while (!inputIsValid) {
            try {
                int input = Integer.parseInt(sc.next());
                if (input < 1 || input > 6) {
                    System.out.println(WRONG_INPUT);
                } else {
                    inputIsValid = true;
                    guess = input;
                }
            } catch (NumberFormatException ex) {
                System.out.println(WRONG_INPUT);
            }
        }
    }
}
