package MonthlyChallenges.September;

import java.util.PriorityQueue;

public class FirstMissingPositive {

    /**
     * Returns the smallest missing positive integer.
     *
     * Complexity - O(NlogN)
     * Memory - (N)
     *
     * @param nums - unsorted array of integers.
     * @return - the smallest missing positive integer.
     */
    public int firstMissingPositive(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int number : nums) {
            if (number > 0) {
                queue.offer(number);
            }
        }

        if (queue.isEmpty()) {
            return 1;
        }
        int prev = queue.poll();
        if (prev > 1) {
            return 1;
        }

        while (!queue.isEmpty()) {
            if (prev+1 < queue.peek()) {
                return prev+1;
            } else {
                prev = queue.poll();
            }
        }

        return prev+1;
    }

    /**
     * Returns the smallest missing positive integer.
     *
     * Complexity - O(NlogN)
     * Memory - (N)
     *
     * @param nums - unsorted array of integers.
     * @return - the smallest missing positive integer.
     */
    public int firstMissingPositiveAlt(int[] nums) {

        boolean[] presented = new boolean[nums.length+1];

        for (int number : nums) {
            if (number > 0 && number <= nums.length) {
                presented[number] = true;
            }
        }

        for (int i = 1; i < presented.length; i++) {
            if (!presented[i]) return i;
        }
        return nums.length+1;
    }
}
