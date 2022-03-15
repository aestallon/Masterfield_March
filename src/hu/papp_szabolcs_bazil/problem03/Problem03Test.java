package hu.papp_szabolcs_bazil.problem03;

import java.util.Arrays;
import java.util.Scanner;

import static hu.papp_szabolcs_bazil.problem02.CharFinder.countB;
import static hu.papp_szabolcs_bazil.problem02.CharFinder.listBPositions;

public class Problem03Test {
    /**
     * A welcome message to be printed when the program starts.
     */
    private static final String WELCOME_MSG =
            "The program will check your inputted string for any occurrences of the letter `b`.\n" +
                    "The program will end if you input `0`";

    /**
     * A message to be printed whenever the user is asked for input.
     */
    private static final String QUERY = "Please type in something: ";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;
        System.out.println(WELCOME_MSG);
        System.out.print(QUERY);

        while (!((input = sc.next()).equals("0"))) {
            int numberOfB = countB(input);
            System.out.println("It has " + numberOfB + " letter `b`(s)!");
            // Only list the positions of `b`, if there is any of it in the String.
            if (numberOfB != 0) {
                System.out.println("Their position(s) in the string is:");
                System.out.println(Arrays.toString(listBPositions(input)));
            }
            System.out.println(QUERY);
        }
    }
}
