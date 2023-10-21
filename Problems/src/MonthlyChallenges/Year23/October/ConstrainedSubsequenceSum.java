package MonthlyChallenges.Year23.October;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ConstrainedSubsequenceSum {

    /**
     * LeetCode #1425. Constrained Subsequence Sum.
     * <p>
     * Complexity - O(N * logK), N = nums.length, K = k.
     * Memory - O(N)
     *
     * @param nums - an array of integers.
     * @param k    - a positive integer, k <= nums.length
     * @return - the maximum sum of a non-empty subsequence of that array such that for every two consecutive integers
     * in the subsequence, nums[i] and nums[j], where i < j, the condition j - i <= k is satisfied.
     */
    public int constrainedSubsetSum(int[] nums, int k) {
        int result = nums[0];

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.offer(new Pair(nums[0], 0));

        for (int j = 1; j < nums.length; j++) {
            int curValue = nums[j];

            while (!pq.isEmpty() && (j - pq.peek().idx) > k) pq.poll();

            int curSum = curValue + Math.max(pq.peek().value, 0);   //  The queue IS NEVER EMPTY
            pq.offer(new Pair(curSum, j));

            result = Math.max(result, curSum);
        }

        return result;
    }

    private class Pair implements Comparable<Pair> {
        int value;
        int idx;

        Pair(int value, int idx) {
            this.value = value;
            this.idx = idx;
        }

        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.value, other.value);
        }
    }
}
