package MonthlyChallenges.Year25.February;

import java.util.PriorityQueue;

public class MinimumOperationsToExceedThresholdValueII {

    /**
     * LeetCode №3066. Minimum Operations to Exceed Threshold Value II.
     * <p>
     * Complexity - O(NlogN)
     * Memory - O(N)
     *
     * @param nums - an array of positive integers.
     * @param k    - a positive integer.
     * @return - the minimum number of operations needed so that all elements of the array are greater than or equal
     * to k.
     */
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();

        int numberOfOperations = 0;
        long kLong = (long) k;

        for (int number : nums) minHeap.offer((long) number);

        while (true) {
            if (minHeap.size() < 2) break;

            long min = minHeap.poll();
            if (min >= kLong) break;

            long secondMin = minHeap.poll();

            minHeap.offer(min * 2L + secondMin);

            numberOfOperations++;
        }

        return numberOfOperations;
    }
}
