package MonthlyChallenges.Year25.November;

public class NumberOfSubstringsWithOnly1s {
    private static final int MODULO = 1_000_000_007;

    /**
     * LeetCode №1513. Number of Substrings With Only 1s.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param s - a string of '0' and '1'.
     * @return - the number of substrings with all characters 1's. Result is modulo 1_000_000_007.
     */
    public int numSub(String s) {
        int result = 0;

        int ones = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                result = (result + computeSubstrings(ones)) % MODULO;
                ones = 0;
            } else {
                ones++;
            }
        }

        result = (result + computeSubstrings(ones)) % MODULO;

        return result;
    }

    private static int computeSubstrings(int length) {
        return (int) ((length * (length + 1L) / 2) % MODULO);
    }
}
