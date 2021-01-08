package MonthlyChallenges.January21;

public class CheckIfTwoStringArraysAreEquivalent {
    /**
     * LeetCode #1662.
     * Checking if two arrays represents the same word.
     *
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param word1 - array of strings.
     * @param word2 - array of strings.
     * @return - True if the two arrays represent the same string, and False otherwise.
     */
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        if (word1 == null && word2 == null) return true;
        else if (word1 == null || word2 == null) return false;

        int firstIdx = 0;
        int firstFirst = 0;

        int secondIdx = 0;
        int secondSecond = 0;

        int len = 0;
        for (String s : word1) len += s.length();

        int len2 = 0;
        for (String s : word2) len2 += s.length();

        if (len != len2) return false;

        for (int i = 0; i < len; i++) {
            if (word1[firstIdx].charAt(firstFirst) != word2[secondIdx].charAt(secondSecond)) {
                return false;
            }

            if (firstFirst+1 >= word1[firstIdx].length()) {
                firstIdx++;
                firstFirst = 0;
            } else {
                firstFirst++;
            }

            if (secondSecond+1 >= word2[secondIdx].length()) {
                secondIdx++;
                secondSecond = 0;
            } else {
                secondSecond++;
            }
        }
        return true;
    }
}
