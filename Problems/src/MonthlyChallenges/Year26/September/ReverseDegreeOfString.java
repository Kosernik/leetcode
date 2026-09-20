package MonthlyChallenges.Year26.September;

public class ReverseDegreeOfString {

    /**
     * LeetCode №3498. Reverse Degree of a String.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     * <p>
     * The reverse degree is calculated as follows:
     * * For each character, multiply its position in the reversed alphabet ('a' = 26, 'b' = 25, ..., 'z' = 1) with its
     * * position in the string (1-indexed).
     * * Sum these products for all characters in the string.
     *
     * @param s - a string of lowercase english letters.
     * @return - the reverse degree of s.
     */
    public int reverseDegree(String s) {
        int[] reversed = {26, 25, 24, 23, 22, 21, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        int degree = 0;

        for (int i = 0; i < s.length(); i++) {
            degree += (i + 1) * reversed[s.charAt(i) - 'a'];
        }

        return degree;
    }
}
