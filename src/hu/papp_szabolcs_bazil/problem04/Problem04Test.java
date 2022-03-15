package hu.papp_szabolcs_bazil.problem04;

import java.util.Arrays;
import java.util.Scanner;

import static hu.papp_szabolcs_bazil.problem02.CharFinder.getRepeatedWsp;

public class Problem04Test {
    /**
     * A welcome message to be printed when the program starts.
     */
    private static final String WELCOME_MSG =
            "The program will check your inputted string for any repeated whitespaces.\n" +
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

        while (!((input = sc.nextLine()).equals("0"))) {
            char[] whitespaces = getRepeatedWsp(input);
            System.out.println("The repeated whitespaces are: " + Arrays.toString(whitespaces));
            System.out.println(QUERY);
        }
    }
}
