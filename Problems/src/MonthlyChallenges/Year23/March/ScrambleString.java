package MonthlyChallenges.Year23.March;

public class ScrambleString {

    /**
     * LeetCode #87. Scramble String.
     * <p>
     * Complexity - O(N^4)
     * Memory - O(N^2)
     *
     * @param s1 - a non-empty string.
     * @param s2 - a non-empty string. s1.length() = s2.length()
     * @return - True - if s2 is scrambled from s1, false - otherwise.
     */
    public boolean isScramble(String s1, String s2) {
        int length = s1.length();
        char[] s1chars = s1.toCharArray();
        char[] s2chars = s2.toCharArray();

        boolean[][][] dpArr = new boolean[length + 1][length][length];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                dpArr[1][i][j] = s1chars[i] == s2chars[j];
            }
        }

        for (int len = 2; len <= length; len++) {
            for (int i = 0; i < (length + 1 - len); i++) {
                for (int j = 0; j < (length + 1 - len); j++) {
                    for (int newLen = 1; newLen < len; newLen++) {
                        dpArr[len][i][j] |=
                                (dpArr[newLen][i][j] && dpArr[len - newLen][i + newLen][j + newLen]) ||
                                        (dpArr[newLen][i][j + len - newLen] && dpArr[len - newLen][i + newLen][j]);
                    }
                }
            }
        }

        return dpArr[length][0][0];
    }
}
