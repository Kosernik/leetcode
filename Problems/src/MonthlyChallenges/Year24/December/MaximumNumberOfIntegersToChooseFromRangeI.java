package MonthlyChallenges.Year24.December;

import java.util.HashSet;
import java.util.Set;

public class MaximumNumberOfIntegersToChooseFromRangeI {

    /**
     * LeetCode №2554. Maximum Number of Integers to Choose From a Range I.
     * <p>
     * Complexity - O(M + N), M = banned.length, N = n.
     * Memory - O(M)
     *
     * @param banned - an array of banned integer numbers.
     * @param n      - the maximum allowed integer value for a number.
     * @param maxSum - the maximum allowed sum of numbers.
     * @return - the maximum number of integers which sum is not exceeding maxSum.
     */
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> bannedSet = new HashSet<>();
        for (int number : banned) {
            if (number <= n) bannedSet.add(number);
        }

        int curSum = 0;
        int result = 0;

        for (int i = 1; i <= n; i++) {
            if (bannedSet.contains(i)) continue;

            curSum += i;
            if (curSum > maxSum) {
                return result;
            }

            result++;
        }

        return result;
    }
}
