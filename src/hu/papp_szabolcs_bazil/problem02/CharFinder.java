package hu.papp_szabolcs_bazil.problem02;

/**
 * <b>Problems No.2, No.3 and No.4</b>
 * <p>
 * A simple class consisting exclusively of static methods used for finding the first occurence of a
 * {@code char} in a {@code String}.
 * </p><p>
 * The methods {@link #hasA(String)} and {@link #firstAPos(String)} are specifically used to provide
 * solutions to <i>problem No.2</i>.
 * </p><p>
 * The methods {@link #countB(String)} and {@link #listBPositions(String)} are specifically used
 * to provide solutions to <i>problem No.3</i>.
 * </p><p>
 * The method {@link #getRepeatedWsp(String)} is used to provide solutions to <i>problem No.4</i>.
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
     *         the {@code char} can be found. If the {@code String} doesn't contain the character, {@code -1} is
     *         returned.
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
     *         the letter <b>a</b> can be found. If the {@code String} doesn't contain the
     *         letter <b>a</b>, {@code -1} is returned.
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
     *         the {@code String} where the specified {@code char} can be found.
     *         <p>
     *         If the {@code String} doesn't contain the specified character, the array
     *         returned has 0 length.
     *         </p>
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
     *         the {@code String} where the letter <b><i>b</i></b> can be found.
     *         <p>
     *         If the {@code String} doesn't contain the letter <b><i>b</i></b>, the array
     *         returned has 0 length.
     *         </p>
     */
    public static int[] listBPositions(String str) {
        return listCharPositions('b', str);
    }

    // ***************************************************** //
    // Methods belonging to problem No.4 can be found below. //
    // ***************************************************** //

    public static String removeRepeatedWsp(String string) {
        final char WSP = ' ';
        char[] chArray = string.toCharArray();
        char[] result = new char[chArray.length];

        int count = 0;
        result[0] = chArray[0];
        for (int i = 1; i < chArray.length; i++) {
            if (!((chArray[i] == WSP) && (chArray[i] == chArray[i - 1]))) {
                count++;
                result[count] = chArray[i];
            }
        }
        char[] prettyResult = new char[count + 1];
        System.arraycopy(result, 0, prettyResult, 0, prettyResult.length);
        StringBuffer sb = new StringBuffer();
        for (char ch : prettyResult) {
            sb.append(ch);
        }
        return sb.toString();
    }


    /**
     * Searches a {@code String} for repeating whitespaces and returns them in
     * an array. All elements of this array are the whitespaces themselves.
     *
     * @param str a {@code String}
     * @return a {@code char[]} array, every element of which is a whitespace.
     *         The length of this array is the number of repeated whitespaces
     *         the {@code String} parameter contained.
     */
    public static char[] getRepeatedWsp(String str) {
        final char WSP = ' ';
        char[] chArray = str.toCharArray();
        char[] result = new char[chArray.length];

        int count = 0;
        for (int i = 1; i < chArray.length; i++) {
            if ((chArray[i] == WSP) && (chArray[i] == chArray[i - 1])) {
                result[count] = chArray[i];
                count++;
            }
        }

        //If we didn't find anything, let's return an array with length 0.
        if (count == 0) {
            return new char[0];
        } else {
            // If we found something, let's not give back an array with trailing zeros...
            char[] prettyResult = new char[count];
            for (int i = 0; i < prettyResult.length; i++) {
                prettyResult[i] = result[i];
            }
            return prettyResult;
        }
    }
}
