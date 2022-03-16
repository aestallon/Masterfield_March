package hu.papp_szabolcs_bazil.problem06;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * <b>Problem No.6</b>
 * <p>
 * A guessing game using standard input/output. The user is prompted to
 * guess a number between 1 and 6 (inclusive), then the computer simulates
 * dice rolls with a six sided dice, up until a roll matches the user's
 * guess. At this point, the number of performed rolls is printed to
 * standard output, and the program ends.
 * </p><p>
 * The original text of the exercise provided in Hungarian is as
 * follows:
 * </p><blockquote>
 * Készítsünk tippelős játékot. A program kérjen be egy tippet (1-6)
 * a játékostól és addig dobjon a kockával, amíg a dobott érték meg
 * nem egyezik a tippelt számmal. Egyezés esetén írjuk ki, hogy
 * talált és írjuk ki a dobások számát. Ekkor kilépünk a programból.
 * </blockquote>
 *
 * @author Szabolcs Bazil Papp
 * @version 1.0
 * @since 17.0.2
 */
public class GuessingGame {

    /** A message to be printed to standard output upon program launch. */
    private static final String WELCOME_MSG = "This is a guessing game!\n" +
            "You guess a number, and the computer" +
            "will roll a dice until it can reproduce your guess!";

    /** A variable to store the user's guess. */
    private static int guess;

    /** A static variable to count the dicerolls performed. */
    private static int rollCounter = 0;


    public static void main(String[] args) {
        play();
    }

    /**
     * Performs the guessing game.
     * <ol>
     *     <li>Prints the welcoming message.
     *     <li>Acquires a guess from the user.
     *     <li>Simulates a dice roll until one matches the user's guess.
     *     <li>Prints a message about the number of dice rolls it performed.
     * </ol>
     *
     * @see #getGuess()
     * @see #isRollMatchingGuess()
     */
    private static void play() {
        System.out.println(WELCOME_MSG);
        getGuess();
        while (!isRollMatchingGuess()) {
            rollCounter++;
        }
        System.out.println("It took me " + rollCounter + " rolls to match your guess!");
    }

    /**
     * Performs a dice roll and compares it to the user's guess.
     *
     * @return {@code true}, if the dice roll matches the user's guess, {@code false} otherwise.
     * @see #rollADice()
     */
    private static boolean isRollMatchingGuess() {
        return rollADice() == guess;
    }

    /**
     * Simulates a dice roll with a six sided fair dice.
     *
     * @return a pseudorandom {@code int} between {@code 1..6} (inclusive)
     */
    private static int rollADice() {
        return ThreadLocalRandom.current().nextInt(6) + 1;
    }

    /**
     * Acquires a valid guess from the user, communicating
     * through standard input/output.
     * <p>
     * The user's guess is saved to {@link #guess}.
     * </p>
     */
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
