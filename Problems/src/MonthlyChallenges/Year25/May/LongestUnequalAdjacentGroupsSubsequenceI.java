package MonthlyChallenges.Year25.May;

import java.util.ArrayList;
import java.util.List;

public class LongestUnequalAdjacentGroupsSubsequenceI {

    /**
     * LeetCode №2900. Longest Unequal Adjacent Groups Subsequence I.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param words  - an array of distinct strings.
     * @param groups - an array of 0 and 1.
     * @return - the longest selected subsequence. If there are multiple answers, returns any of them.
     */
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> zero = new ArrayList<>();
        List<String> one = new ArrayList<>();
        int zeroNeeds = 0;
        int oneNeeds = 1;

        for (int i = 0; i < groups.length; i++) {
            int curDigit = groups[i];

            if (zeroNeeds == curDigit) {
                zero.add(words[i]);
                zeroNeeds = (zeroNeeds + 1) % 2;
            }

            if (oneNeeds == curDigit) {
                one.add(words[i]);
                oneNeeds = (oneNeeds + 1) % 2;
            }
        }

        if (zero.size() >= one.size()) {
            return zero;
        } else {
            return one;
        }
    }
}
