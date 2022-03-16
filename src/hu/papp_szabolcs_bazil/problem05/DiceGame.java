package hu.papp_szabolcs_bazil.problem05;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * <b>Problem No.5</b>
 * <p>
 * A game played with dice. The three versions of the game
 * specified in the exercise can be played by running one
 * of the <i>playXX()</i> methods ({@link #play01()},
 * {@link #play02()} and {@link #play03()} respectively).
 * </p><p>
 * Descriptions of the functionality of each method is provided
 * at the methods themselves.
 * </p>
 *
 * @author Szabolcs Bazil Papp
 * @version 1.0
 * @since 17.0.2
 */
public class DiceGame {

    /** A variable to store how many dices the game is played with. */
    private static int dice;

    /*
    A driver method to test the game.
    Simply uncomment one of the lines to play a given version of
    the game.
     */
    public static void main(String[] args) {
        // play01();
        // play02();
        play03();
    }

    /**
     * Plays the simplest form of the game.
     * <p>
     * The user is prompted to pick how many dices they want to
     * play with. Then, a dice roll is performed with each dice.
     * The sum of the rolls' result is printed to standard ouput.
     * </p><p>
     * The original Hungarian version of the exercise is as follows:
     * </p><blockquote>
     * Készítsünk dobókocka programot. A program indulásakor a felhasználó megadhatja,
     * hogy 1,2 vagy 3 dobókockával szeretne játszani.
     * Adjuk össze és írjuk ki a dobott értékek eredményeit!
     * </blockquote>
     *
     * @see #pickMode()
     * @see #roll(int)
     */
    private static void play01() {
        pickMode();
        int diceRoll = roll(dice);
        System.out.println("You rolled " + diceRoll + " with " + dice + " dice! ");
    }

    /**
     * Plays an enhanced form of the game.
     * <p>
     * The user is prompted to pick how many dices they want to play with.
     * Then 5 rounds are performed. Each turn, dice are rolled for the computer
     * and the user. After the final round, a winner is determined based
     * on the <b>sum</b> of the rolls.
     * </p><p>
     * The user is informed about the present stage of the game through messages
     * printed to standard output.
     * </p><p>
     * The original Hungarian version of the exercise is as follows:
     * </p><blockquote>
     * Módosítsuk a programot, hogy 5 dobás legyen egymás után. Minden körben először
     * a számítógép dob magának, majd dob nekünk is. Adjuk össze a dobott értékeket és
     * az 5. dobás után írjuk ki, hogy ki nyert, azaz kinek van több pontja.
     * </blockquote>
     *
     * @see #pickMode()
     * @see #roll(int)
     */
    private static void play02() {
        final int TURNS = 5;
        int playerTotal = 0;
        int computerTotal = 0;

        pickMode();
        for (int i = 0; i < TURNS; i++) {
            int compRoll = roll(dice);
            System.out.println("The computer rolled " + compRoll + " with " + dice + " dice... ");

            int playerRoll = roll(dice);
            System.out.println("You rolled " + playerRoll + " with " + dice + " dice! ");

            playerTotal += playerRoll;
            computerTotal += compRoll;
        }

        System.out.println("Your score: " + playerTotal);
        System.out.println("Computer score: " + computerTotal);
        if (playerTotal > computerTotal) {
            printWin();
        } else if (playerTotal < computerTotal) {
            printLose();
        } else System.out.println("TIE!");

    }

    /**
     * Plays the most complicated form of the game.
     * <p>
     * The method works just like {@link #play02()}, with an
     * <i>instant victory</i> condition.
     * </p><p>
     * If the game is played with 3 dice, whoever rolls the maximum
     * value ({@code 3 * 6 = 18}),
     * instantly wins the game.
     * </p><p>
     * The original Hungarian version of the exercise is:
     * </p><blockquote>
     * Módosítsuk a programot, hogy 3 kocka esetén a csupa 6-os dobás azonnali
     * győzelmet jelentsen!
     * </blockquote>
     *
     * @see #pickMode()
     * @see #roll(int)
     * @see #checkBestRoll(int)
     */
    private static void play03() {
        final int TURNS = 5;
        int playerTotal = 0;
        int computerTotal = 0;

        pickMode();

        for (int i = 0; i < TURNS; i++) {
            int compRoll = roll(dice);
            System.out.println("The computer rolled " + compRoll + " with " + dice + " dice... ");
            if (dice == 3 && checkBestRoll(compRoll)) {
                printLose();
                return;
            }

            int playerRoll = roll(dice);
            System.out.println("You rolled " + playerRoll + " with " + dice + " dice! ");
            if (dice == 3 && checkBestRoll(playerRoll)) {
                printWin();
                return;
            }

            playerTotal += playerRoll;
            computerTotal += compRoll;
        }

        System.out.println("Your score: " + playerTotal);
        System.out.println("Computer score: " + computerTotal);
        if (playerTotal > computerTotal) {
            printWin();
        } else if (playerTotal < computerTotal) {
            printLose();
        } else System.out.println("TIE!");
    }

    /**
     * Prompts the user to select the number of dice for the game.
     * <p>
     * The prompt is repeated until the user provides a valid selection.
     * The selection is saved to the {@link #dice} variable.
     * </p>
     */
    private static void pickMode() {
        final String PICK_GAMEMODE_MSG = "Please type in how many dice you want to play with (1-3): ";
        final String WRONG_INPUT = "Invalid selection! Valid entries are: 1, 2, 3";

        Scanner sc = new Scanner(System.in);
        boolean inputIsValid = false;

        System.out.println(PICK_GAMEMODE_MSG);
        while (!inputIsValid) {
            try {
                int input = Integer.parseInt(sc.next());
                if (input < 1 || input > 3) {
                    System.out.println(WRONG_INPUT);
                } else {
                    inputIsValid = true;
                    dice = input;
                }
            } catch (NumberFormatException ex) {
                System.out.println(WRONG_INPUT);
            }
        }

    }

    /**
     * Simulates <b>independent</b> dice rolls with six sided fair dice.
     *
     * @param diceNum {@code int} number of dice to use
     * @return {@code int} pseudorandom number representing the sum of the
     *         dice rolls performed.
     */
    private static int roll(int diceNum) {
        int result = 0;
        for (int i = 0; i < diceNum; i++) {
            result += ThreadLocalRandom.current().nextInt(6) + 1;
        }
        return result;
    }

    /** Prints a victory message to standard output. */
    private static void printWin() {
        System.out.println("YOU WON!!!");
    }

    /** Prints a defeat message to standard output. */
    private static void printLose() {
        System.out.println("You lost.");
    }

    /**
     * Checks if the specified number is the best roll possible in
     * the current game mode.
     *
     * @param diceRoll an {@code int} number
     * @return {@code true} if the parameter equals the best possible roll
     *         in the current game, {@code false} otherwise.
     */
    private static boolean checkBestRoll(int diceRoll) {
        return diceRoll == 6 * dice;
    }
}










