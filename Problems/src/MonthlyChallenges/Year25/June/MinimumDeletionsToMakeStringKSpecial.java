package MonthlyChallenges.Year25.June;

import java.util.Arrays;

public class MinimumDeletionsToMakeStringKSpecial {
    public static void main(String[] args) {
        MinimumDeletionsToMakeStringKSpecial solution = new MinimumDeletionsToMakeStringKSpecial();

        String word0 = "aabcaba";
        int k0 = 0;
        int result0 = 3;
        System.out.println(solution.minimumDeletions(word0, k0) == result0);

        String word1 = "dabdcbdcdcd";
        int k1 = 2;
        int result1 = 2;
        System.out.println(solution.minimumDeletions(word1, k1) == result1);

        String word2 = "aaabaaa";
        int k2 = 2;
        int result2 = 1;
        System.out.println(solution.minimumDeletions(word2, k2) == result2);
    }

    /**
     * LeetCode №3085. Minimum Deletions to Make String K-Special.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param word- a string of lowercase english letters.
     * @param k     - a non-negative integer.
     * @return - the minimum number of characters you need to delete to make word k-special.
     */
    public int minimumDeletions(String word, int k) {
        int length = 26;
        int[] counts = new int[length];

        for (char letter : word.toCharArray()) {
            counts[letter - 'a']++;
        }

        Arrays.sort(counts);

        int deletions = Integer.MAX_VALUE;

        int start = 0;
        while (counts[start] == 0) start++;

        for (int i = start; i < length; i++) {
            int curCountDeletions = counts[i] + k;
            int curDeletions = 0;

            for (int j = start; counts[j] < counts[i]; j++) {
                curDeletions += counts[j];
            }

            for (int j = length - 1; counts[j] > curCountDeletions; j--) {
                curDeletions += counts[j] - curCountDeletions;
            }

            deletions = Math.min(deletions, curDeletions);
        }

        return deletions;
    }
}
