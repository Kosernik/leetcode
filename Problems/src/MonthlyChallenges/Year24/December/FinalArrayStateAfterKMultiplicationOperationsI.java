package MonthlyChallenges.Year24.December;

import java.util.PriorityQueue;

public class FinalArrayStateAfterKMultiplicationOperationsI {

    /**
     * LeetCode №3264. Final Array State After K Multiplication Operations I.
     * <p>
     * Complexity - O(NlogN + KlogN), N = nums.length, K = k.
     * Memory - O(N)
     *
     * @param nums       - an array of integers.
     * @param k          - a positive integer.
     * @param multiplier - a positive integer.
     * @return - array nums after k-operations.
     */
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0])
        );

        for (int i = 0; i < nums.length; i++) {
            pq.offer(new int[]{nums[i], i});
        }

        for (int i = 0; i < k; i++) {
            int[] num = pq.poll();
            num[0] *= multiplier;
            pq.offer(num);
        }

        int[] result = new int[nums.length];
        while (!pq.isEmpty()) {
            int[] number = pq.poll();
            result[number[1]] = number[0];
        }

        return result;
    }
}
