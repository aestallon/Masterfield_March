package hu.papp_szabolcs_bazil.problem02;

import java.util.Scanner;

import static hu.papp_szabolcs_bazil.problem02.CharFinder.firstAPos;
import static hu.papp_szabolcs_bazil.problem02.CharFinder.hasA;

public class Problem02Test {

    /**
     * A welcome message to be printed when the program starts.
     */
    private static final String WELCOME_MSG =
            "The program will check your inputted string if it has 'a' in it.\n" +
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

            boolean aFound = hasA(input);
            System.out.println("It has `a` in it: " + aFound);

            // Only look for the position of the first `a`, if there is any.
            if (aFound) {
                System.out.println("The position of the first `a` is: " + firstAPos(input));
            }
            System.out.print(QUERY);
        }
    }
}
