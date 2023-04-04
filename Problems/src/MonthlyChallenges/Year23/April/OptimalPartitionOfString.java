package MonthlyChallenges.Year23.April;

public class OptimalPartitionOfString {

    /**
     * LeetCode #2405. Optimal Partition of String.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param s - a string of english lowercase letters.
     * @return - the minimum number of sub-strings with unique letters.
     */
    public int partitionString(String s) {
        int result = 1;

        boolean[] letters = new boolean[26];
        for (char ch : s.toCharArray()) {
            int idx = ch - 'a';
            if (letters[idx]) {
                result++;
                letters = new boolean[26];
            }
            letters[idx] = true;
        }

        return result;
    }
}
