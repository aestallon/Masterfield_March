package hu.papp_szabolcs_bazil.problem02;

/**
 * <b>Problem No.2 & No.3</b>
 * <p>
 * A simple class consisting exclusively of static methods used for finding the first occurence of a
 * {@code char} in a {@code String}.
 * </p><p>
 * The methods {@link #hasA(String)} and {@link #firstAPos(String)} are specifically used to provide
 * solutions to <i>problem No.2</i>.
 * </p><p>
 * The methods {@link #countB(String)} and {@link #listBPositions(String)} are specifically used
 * to provide solutions to <i>problem No.3</i>.
 * </p>
 *
 * @author Szabolcs Bazil Papp
 * @version 1.0
 * @since 17.0.2
 */
public class CharFinder {

    /**
     * Searches a {@code String} for any occurrences of a {@code char}.
     *
     * @param ch  the {@code char} the search aims for
     * @param str a {@code String}
     * @return {@code true} if the {@code String} contains the {@code char}, else {@code false}.
     */
    public static boolean hasChar(char ch, String str) {
        char[] array = str.toCharArray();
        boolean result = false;
        for (char character : array) {
            if (character == ch) {
                result = true;
                break;
            }
        }

        return result;
    }

    /**
     * Searches a {@code String} for the first occurrence of a {@code char}.
     *
     * @param ch  the {@code char} the search aims for
     * @param str a {@code String}
     * @return the {@code int} <strong>first position</strong> in the {@code String} where
     * the {@code char} can be found. If the {@code String} doesn't contain the character, {@code -1} is
     * returned.
     */
    public static int firstMatchingCharPos(char ch, String str) {
        char[] array = str.toCharArray();
        boolean charFound = false;
        int result = 0;
        for (char character : array) {
            if (character == ch) {
                charFound = true;
                break;
            }
            result++;
        }
        if (charFound) {
            return result;
        } else {
            return -1;
        }
    }

    /**
     * Searches a {@code String} for any occurrences of the letter <b>a</b>.
     *
     * @param str a {@code String}
     * @return {@code true} if the {@code String} contains the {@code char}, else {@code false}.
     */
    public static boolean hasA(String str) {
        return hasChar('a', str);
    }

    /**
     * Searches a {@code String} for the first occurrence of the letter <b>a</b>.
     *
     * @param str a {@code String}
     * @return the {@code int} <strong>first position</strong> in the {@code String} where
     * the letter <b>a</b> can be found. If the {@code String} doesn't contain the letter <b>a</b>, {@code -1} is
     * returned.
     */
    public static int firstAPos(String str) {
        return firstMatchingCharPos('a', str);
    }

    // ***************************************************** //
    // Methods belonging to problem No.3 can be found below. //
    // ***************************************************** //

    /**
     * Searches a {@code String} for the number of occurrences of a {@code char}.
     *
     * @param ch  a {@code char} the search aims for
     * @param str a {@code String}
     * @return {@code int} number of occurrences of the specified {@code char}.
     */
    public static int countChar(char ch, String str) {
        char[] array = str.toCharArray();
        int count = 0;
        for (char character : array) {
            if (character == ch) count++;
        }
        return count;
    }

    /**
     * Searches a {@code String} for the positions of a {@code char} within.
     *
     * @param ch  a {@code char} the search aims for
     * @param str a {@code String}
     * @return an ordered {@code int[]} array, listing the positions in
     * the {@code String} where the specified {@code char} can be found.
     * <p>
     * If the {@code String} doesn't contain the specified character, the array
     * returned has 0 length.
     * </p>
     */
    public static int[] listCharPositions(char ch, String str) {
        char[] array = str.toCharArray();
        int[] result = new int[array.length];
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == ch) {
                result[count] = i;
                count++;
            }
        }

        //If we didn't find anything, let's return an array with length 0.
        if (count == 0) {
            return new int[0];
        } else {
            // If we found something, let's not give back an array with trailing zeros...
            int[] prettyResult = new int[count];
            for (int i = 0; i < prettyResult.length; i++) {
                prettyResult[i] = result[i];
            }
            return prettyResult;
        }
    }

    /**
     * Searches a {@code String} for the number of occurrences of the letter <b><i>b</i></b>.
     *
     * @param str a {@code String}
     * @return {@code int} number of occurrences of the letter <b><i>b</i></b>.
     */
    public static int countB(String str) {
        return countChar('b', str);
    }

    /**
     * Searches a {@code String} for the positions of the letter <b><i>b</i></b> within.
     *
     * @param str a {@code String}
     * @return an ordered {@code int[]} array, listing the positions in
     * the {@code String} where the letter <b><i>b</i></b> can be found.
     * <p>
     * If the {@code String} doesn't contain the letter <b><i>b</i></b>, the array
     * returned has 0 length.
     * </p>
     */
    public static int[] listBPositions(String str) {
        return listCharPositions('b', str);
    }
}
