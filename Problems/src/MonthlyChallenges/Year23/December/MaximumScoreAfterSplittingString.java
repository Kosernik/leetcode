package MonthlyChallenges.Year23.December;

public class MaximumScoreAfterSplittingString {

    /**
     * LeetCode №1422. Maximum Score After Splitting a String.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param s - a string of '0' and '1'.
     * @return - the maximum score after splitting the string into two non-empty substrings
     */
    public int maxScore(String s) {
        int result = 0;
        char[] letters = s.toCharArray();
        int[] preSumZeroes = new int[s.length() + 1];

        for (int i = 0; i < letters.length; i++) {
            preSumZeroes[i + 1] = preSumZeroes[i] + (letters[i] == '0' ? 1 : 0);
        }

        int curOnes = 0;
        for (int i = letters.length - 1; i > 0; i--) {
            if (letters[i] == '1') {
                curOnes++;
            }
            result = Math.max(result, preSumZeroes[i] + curOnes);
        }

        return result;
    }
}
