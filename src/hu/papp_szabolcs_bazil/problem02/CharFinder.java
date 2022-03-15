package hu.papp_szabolcs_bazil.problem02;

/**
 * <b>Problem No.2</b>
 * <p>
 * A simple class consisting exclusively of static methods used for finding the first occurence of a
 * {@code char} in a {@code String}.
 * </p><p>
 * The methods {@link #hasA(String)} and {@link #firstAPos(String)} are specifically used to provide
 * solution to the problem.
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
        boolean hasChar = false;
        int result = 0;
        for (char character : array) {
            if (character == ch) {
                hasChar = true;
                break;
            }
            result++;
        }
        if (hasChar) {
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

}
