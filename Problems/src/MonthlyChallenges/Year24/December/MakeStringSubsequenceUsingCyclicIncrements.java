package MonthlyChallenges.Year24.December;

public class MakeStringSubsequenceUsingCyclicIncrements {
    public static void main(String[] args) {
        MakeStringSubsequenceUsingCyclicIncrements solution = new MakeStringSubsequenceUsingCyclicIncrements();

        String test01 = "abc";
        String test02 = "ad";
        System.out.println(solution.canMakeSubsequence(test01, test02) == true);
    }

    /**
     * LeetCode №2825. Make String a Subsequence Using Cyclic Increments.
     * <p>
     * Complexity - O(N+M), N = str1.length, M = str2.length.
     * Memory - O(M)
     * <p>
     * An operation: select a set of indices in str1, and for each index i in the set, increment str1[i] to the next
     * character cyclically. That is 'a' becomes 'b', 'b' becomes 'c', and so on, and 'z' becomes 'a'.
     *
     * @param str1 - a string of lowercase english letters.
     * @param str2 - a string of lowercase english letters. str2.length <= str1.length.
     * @return - true if it is possible to make str2 a subsequence of str1 by performing the operation at most once,
     * and false otherwise.
     */
    public boolean canMakeSubsequence(String str1, String str2) {
        char[] targetLetters = str2.toCharArray();
        int targetIdx = 0;
        char targetChar = targetLetters[targetIdx];
        char targetCharPrev = getPreviousLetter(targetChar);

        for (char letter : str1.toCharArray()) {
            if (letter == targetChar || letter == targetCharPrev) {
                targetIdx++;
                if (targetIdx == str2.length()) return true;

                targetChar = targetLetters[targetIdx];
                targetCharPrev = getPreviousLetter(targetChar);
            }
        }

        return false;
    }

    private char getPreviousLetter(char letter) {
        return (char) ((((letter - 'a') - 1 + 26) % 26) + 'a');
    }
}
