package MonthlyChallenges.Year23.December;

public class MinimumChangesToMakeAlternatingBinaryString {

    /**
     * LeetCode №1758. Minimum Changes To Make Alternating Binary String.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param s - a string of '0' and '1'.
     * @return - the minimum number of operations needed to make s alternating.
     */
    public int minOperations(String s) {
        int zeroes = 0;
        int ones = 0;
        boolean odd = true;

        for (char ch : s.toCharArray()) {
            if (odd) {
                if (ch == '0') {
                    ones++;
                } else {
                    zeroes++;
                }
            } else {
                if (ch == '0') {
                    zeroes++;
                } else {
                    ones++;
                }
            }
            odd = !odd;
        }

        return Math.min(zeroes, ones);
    }
}
