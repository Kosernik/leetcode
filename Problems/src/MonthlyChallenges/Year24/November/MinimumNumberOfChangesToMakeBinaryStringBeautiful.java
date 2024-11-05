package MonthlyChallenges.Year24.November;

public class MinimumNumberOfChangesToMakeBinaryStringBeautiful {

    /**
     * LeetCode №2914. Minimum Number of Changes to Make Binary String Beautiful.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param s - a binary string of '0' and '1', s.length is even.
     * @return - the minimum number of changes required to make the string "s" beautiful.
     */
    public int minChanges(String s) {
        int changes = 0;

        for (int i = 0; i < s.length(); i += 2) {
            if (s.charAt(i) != s.charAt(i + 1)) changes++;
        }

        return changes;
    }
}
