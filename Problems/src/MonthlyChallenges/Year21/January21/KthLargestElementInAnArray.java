package MonthlyChallenges.Year21.January21;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInAnArray {

    /**
     * LeetCode #215.
     * <p>
     * Returns K-th largest element of an array.
     * <p>
     * Complexity - O(NlogN)
     * Memory - O(k)
     *
     * @param nums - array of integers. Not empty.
     * @param k    - 1 ≤ k ≤ nums's length.
     * @return - k-th largest element of an array "nums".
     */
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>();

        for (int n : nums) {
            pq.offer(n);
            while (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.poll();
    }
}
