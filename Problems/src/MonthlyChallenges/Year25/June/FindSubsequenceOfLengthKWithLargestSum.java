package MonthlyChallenges.Year25.June;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FindSubsequenceOfLengthKWithLargestSum {

    /**
     * LeetCode №2099. Find Subsequence of Length K With the Largest Sum.
     * <p>
     * Complexity - O(NlogK + K) N = nums.length, K = k
     * Memory - O(K)
     *
     * @param nums - an array of integers.
     * @param k    - a positive integer. 1 <= k <= nums.length
     * @return - a subsequence of nums of length k that has the largest sum.
     */
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<int[]> elements = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < nums.length; i++) {
            elements.offer(new int[]{nums[i], i});

            if (elements.size() > k) elements.poll();
        }

        int[][] greatestElements = new int[k][2];
        for (int i = 0, size = elements.size(); i < size; i++) {
            greatestElements[i] = elements.poll();
        }

        Arrays.sort(greatestElements, Comparator.comparingInt(a -> a[1]));

        int[] result = new int[k];

        for (int i = 0; i < greatestElements.length; i++) {
            result[i] = greatestElements[i][0];
        }

        return result;
    }
}
