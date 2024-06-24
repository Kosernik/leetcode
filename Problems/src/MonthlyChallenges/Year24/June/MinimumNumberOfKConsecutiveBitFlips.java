package MonthlyChallenges.Year24.June;

import java.util.ArrayDeque;
import java.util.Queue;

public class MinimumNumberOfKConsecutiveBitFlips {

    /**
     * LeetCode №995. Minimum Number of K Consecutive Bit Flips.
     * <p>
     * Complexity - O(N)
     * Memory - O(k)
     *
     * @param nums - an array of 0 and 1.
     * @param k    - the length of a subarray.
     * @return - the minimum number of flips so there are no 0`s in nums. If it is not possible, returns -1.
     */
    public int minKBitFlips(int[] nums, int k) {
        int flips = 0;

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (queue.isEmpty() || queue.size() % 2 == 0) {
                    flips++;
                    queue.offer(i + k - 1);
                }
            } else {
                if (queue.size() % 2 != 0) {
                    flips++;
                    queue.offer(i + k - 1);
                }
            }
            if (!queue.isEmpty() && queue.peek() <= i) {
                queue.poll();
            }
        }

        return queue.isEmpty() ? flips : -1;
    }

    /**
     * LeetCode №995. Minimum Number of K Consecutive Bit Flips.
     * <p>
     * Complexity - O(N*K), N = nums.lengt, K = k.
     * Memory - O(1)
     *
     * @param nums - an array of 0 and 1.
     * @param k    - the length of a subarray.
     * @return - the minimum number of flips so there are no 0`s in nums. If it is not possible, returns -1.
     */
    public int minKBitFlipsTLE(int[] nums, int k) {
        if (nums.length == k) {
            return baseCase(nums);
        }
        int flips = 0;

        for (int i = 0; i <= nums.length - k; i++) {
            if (nums[i] == 0) {
                flips++;

                for (int j = 0; j < k; j++) {
                    nums[i + j] = (nums[i + j] + 1) % 2;
                }
            }
        }

        //  Checking if there are 0`s remaining
        for (int i = k; i < nums.length; i++) {
            if (nums[i] == 0) return -1;
        }

        return flips;
    }

    private int baseCase(int[] nums) {
        if (nums.length == 1) return nums[0] == 1 ? 0 : 1;

        int value = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != value) return -1;
        }
        return value == 1 ? 0 : 1;
    }
}
