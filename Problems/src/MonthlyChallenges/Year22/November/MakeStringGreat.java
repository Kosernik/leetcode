package MonthlyChallenges.Year22.November;

public class MakeStringGreat {

    /**
     * LeetCode #1544. Make The String Great.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param s - a string of english letters.
     * @return - a string after deleting all bad pairs from "s".
     */
    public String makeGood(String s) {
        StringBuilder builder = new StringBuilder();
        for (char letter : s.toCharArray()) {
            if (builder.length() == 0 ||
                    isValidPairOfChars(builder.charAt(builder.length() - 1), letter)) {
                builder.append(letter);
            } else {
                builder.deleteCharAt(builder.length() - 1);
            }
        }

        if (builder.length() == 0) {
            return "";
        } else {
            return builder.toString();
        }
    }

    /**
     * Checks if 'first' is a lower-case letter and 'second' is the same letter but in upper-case or vice-versa.
     *
     * @param first  - an english lower or upper-case letter.
     * @param second - an english lower or upper-case letter.
     * @return - True - if 'first' and 'second' are different letters or same letters but one of them is upper-case and
     * the other is lower-case. False - otherwise.
     */
    private boolean isValidPairOfChars(char first, char second) {
        if ('a' <= first && first <= 'z') {
            return Character.toUpperCase(first) != second;
        } else {
            return Character.toLowerCase(first) != second;
        }
    }
}
