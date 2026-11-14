package MonthlyChallenges.Year26.November;

import java.util.List;

public class MinimumPositiveSumSubarray {

    /**
     * LeetCode №3364. Minimum Positive Sum Subarray.
     * <p>
     * Complexity - O(N*M) N = nums.size(), M = r - l.
     * Memory - O(N)
     *
     * @param nums - a list of integers.
     * @param l    - the minimum size of a subarray.
     * @param r    - the maximum size of a subarray.
     * @return - the minimum sum of a subarray whose size is between l and r (inclusive) and whose sum is greater than 0.
     * If no such subarray exists, returns -1.
     */
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int[] prefixSums = new int[nums.size() + 1];
        for (int i = 0; i < nums.size(); i++) {
            prefixSums[i + 1] = prefixSums[i] + nums.get(i);
        }

        int minSum = Integer.MAX_VALUE;
        for (int i = 1, end = prefixSums.length - l + 1; i < end; i++) {
            for (int j = l; j <= r; j++) {
                int endIdx = i + j - 1;
                if (endIdx == prefixSums.length) break;

                int curSum = prefixSums[endIdx] - prefixSums[i - 1];
                if (curSum > 0) {
                    minSum = Math.min(minSum, curSum);
                }
            }
        }

        return minSum == Integer.MAX_VALUE ? -1 : minSum;
    }
}
