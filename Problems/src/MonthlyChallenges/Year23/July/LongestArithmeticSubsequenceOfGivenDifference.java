package MonthlyChallenges.Year23.July;

import java.util.HashMap;
import java.util.Map;

public class LongestArithmeticSubsequenceOfGivenDifference {

    /**
     * LeetCode #1218. Longest Arithmetic Subsequence of Given Difference.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param arr        - an array of integers.-10_000 <= arr[i] <= 10_000
     * @param difference - an integer. -10_000 <= difference <= 10_000
     * @return - the length of the longest subsequence in 'arr' which is an arithmetic sequence such that the difference
     * between adjacent elements in the subsequence equals 'difference'.
     */
    public int longestSubsequence(int[] arr, int difference) {
        int maxLength = 1;
        Map<Integer, Integer> dp = new HashMap<>();

        for (int number : arr) {
            int curRes = dp.getOrDefault(number - difference, 0) + 1;

            dp.put(number, curRes);
            maxLength = Math.max(maxLength, curRes);
        }

        return maxLength;
    }
}
