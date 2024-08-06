package MonthlyChallenges.Year24.August;

import java.util.Arrays;

public class MinimumNumberOfPushesToTypeWordII {

    /**
     * LeetCode №3016. Minimum Number of Pushes to Type Word II.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param word - a string of lowercase english letters.
     * @return - the minimum number of pushes needed to type word after remapping the keys.
     */
    public int minimumPushes(String word) {
        int pushes = 0;

        int[] counts = new int[26];
        for (char letter : word.toCharArray()) {
            counts[letter - 'a']++;
        }

        Arrays.sort(counts);
        int curPush = 1;
        for (int i = 25, count = 1; i >= 0; i--, count++) {
            if (count == 9) {
                count = 1;
                curPush++;
            }
            pushes += counts[i] * curPush;
        }

        return pushes;
    }
}
