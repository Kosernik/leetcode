package MonthlyChallenges.Year23.May;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumSubsequenceScore {

    /**
     * LeetCode #2542. Maximum Subsequence Score.
     * <p>
     * Complexity - O(NlogN)
     * Memory - O(N)
     *
     * @param nums1 - an array of non-negative integers.
     * @param nums2 - an array of non-negative integers. nums1.length = nums2.length
     * @param k     - the size of a subsequence.
     * @return - the maximum possible score.
     */
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int[][] sortedArr = getSortedCombinedArrays(nums1, nums2);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(a -> sortedArr[a][0]));

        long curSum = 0L;
        for (int i = 0; i < k; i++) {
            pq.offer(i);
            curSum += sortedArr[i][0];
        }
        long result = curSum * sortedArr[k - 1][1];

        for (int i = k; i < sortedArr.length; i++) {
            pq.offer(i);
            int prevMinIdx = pq.poll();

            curSum = curSum - sortedArr[prevMinIdx][0] + sortedArr[i][0];

            result = Math.max(result, curSum * sortedArr[i][1]);
        }

        return result;
    }

    private int[][] getSortedCombinedArrays(int[] nums1, int[] nums2) {
        int[][] result = new int[nums1.length][2];
        for (int i = 0; i < result.length; i++) {
            result[i][0] = nums1[i];
            result[i][1] = nums2[i];
        }

        Arrays.sort(result, (a, b) -> Integer.compare(b[1], a[1]));

        return result;
    }
}
