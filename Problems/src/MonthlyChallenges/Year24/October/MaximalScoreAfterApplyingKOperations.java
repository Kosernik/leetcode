package MonthlyChallenges.Year24.October;

import java.util.PriorityQueue;

public class MaximalScoreAfterApplyingKOperations {

    /**
     * LeetCode №2530. Maximal Score After Applying K Operations.
     * <p>
     * Complexity - O(NlogN)
     * Memory - O(N)
     *
     * @param nums - an array of integers.
     * @param k    - the number of operations.
     * @return - the maximum possible score you can attain after applying exactly k operations.
     */
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> elements = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for (int number : nums) elements.offer(number);

        long maxScore = 0L;

        for (int i = 0; i < k; i++) {
            int element = elements.poll();

            maxScore += element;

            elements.offer(Math.ceilDiv(element, 3));
        }

        return maxScore;
    }
}
