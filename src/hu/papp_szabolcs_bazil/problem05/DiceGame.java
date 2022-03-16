package hu.papp_szabolcs_bazil.problem05;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class DiceGame {

    private static final String PICK_GAMEMODE_MSG = "Please type in how many dice you want to play with (1-3): ";

    private static int dice;

    public static void main(String[] args) {
        play03();
    }
    /*
    Készítsünk dobókocka programot. A program indulásakor a felhasználó megadhatja,
    hogy 1,2 vagy 3 dobókockával szeretne játszani.
    Adjuk össze és írjuk ki a dobott értékek eredményeit!

    Módosítsuk a programot, hogy 5 dobás legyen egymás után. Minden körben először
    a számítógép dob magának, majd dob nekünk is. Adjuk össze a dobott értékeket és
    az 5. dobás után írjuk ki, hogy ki nyert, azaz kinek van több pontja.

    Módosítsuk a programot, hogy 3 kocka esetén a csupa 6-os dobás azonnali
    győzelmet jelentsen!
     */
    private static void play01() {
        pickMode();
        int diceRoll = roll(dice);
        System.out.println("You rolled " + diceRoll + " with " + dice + " dice! ");
    }

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

    private static void pickMode() {
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

    private static int roll(int diceNum) {
        int result = 0;
        for (int i = 0; i < diceNum; i++) {
            result += ThreadLocalRandom.current().nextInt(6) + 1;
        }
        return result;
    }

    private static void printWin() {
        System.out.println("YOU WON!!!");
    }

    private static void printLose() {
        System.out.println("You lost.");
    }

    private static boolean checkBestRoll(int diceRoll) {
        return diceRoll == 6 * dice;
    }
}










