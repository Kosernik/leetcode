package MonthlyChallenges.Year24.March;

import java.util.ArrayDeque;
import java.util.Deque;

public class CountSubarraysWhereMaxElementAppearsAtLeastKTimes {

    /**
     * LeetCode №2962. Count Subarrays Where Max Element Appears at Least K Times.
     * <p>
     * Complexity - O(N)
     * Memory - O(k)
     *
     * @param nums - an array of integers.
     * @param k    - tha minimum number of appearances of a maximum element.
     * @return - the number of subarrays where the maximum element of nums appears at least k times in that subarray.
     */
    public long countSubarrays(int[] nums, int k) {
        long result = 0;
        int maxElement = getMaxElement(nums);

        Deque<Integer> indices = new ArrayDeque<>();
        int prevNumberOfSubarrays = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == maxElement) {
                indices.offerLast(i);
                if (indices.size() > k) {
                    indices.removeFirst();
                }

                if (indices.size() == k) {
                    prevNumberOfSubarrays = indices.peekFirst() + 1;
                }
            }

            result += prevNumberOfSubarrays;
        }

        return result;
    }

    private int getMaxElement(int[] nums) {
        int maxElement = nums[0];

        for (int number : nums) {
            maxElement = Math.max(maxElement, number);
        }

        return maxElement;
    }
}
