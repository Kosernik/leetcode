package MonthlyChallenges.Year26.February;

public class LongestBalancedSubstringI {

    /**
     * LeetCode №3713. Longest Balanced Substring I.
     * <p>
     * Complexity - O(N^2)
     * Memory - O(1)
     *
     * @param s - a string of english lowercase letters.
     * @return - the length of the longest valid substring.
     */
    public int longestBalanced(String s) {
        int result = 0;

        for (int i = 0, length = s.length(); i < length; i++) {
            int[] counts = new int[26];
            for (int j = i; j < length; j++) {
                counts[s.charAt(j) - 'a']++;

                if (isSubstringValid(counts)) {
                    result = Math.max(result, j - i + 1);
                }
            }
        }

        return result;
    }

    private boolean isSubstringValid(int[] counts) {
        int count = -1;

        for (int c : counts) {
            if (c > 0) {
                if (count == -1) {
                    count = c;
                } else if (c != count) {
                    return false;
                }
            }
        }

        return true;
    }
}
