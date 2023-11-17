package MonthlyChallenges.Year23.November;

import java.util.Arrays;

public class MinimizeMaximumPairSumInArray {

    /**
     * LeetCode №1877. Minimize Maximum Pair Sum in Array.
     * <p>
     * Complexity - O(NlogN)
     * Memory - O(1)
     *
     * @param nums - an array of integers. nums.length is even.
     * @return - the minimized maximum pair sum after optimally pairing up the elements.
     */
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);

        int minPairSum = nums[0] + nums[1];

        int left = 0, right = nums.length - 1;
        while (left < right) {
            minPairSum = Math.max(minPairSum, nums[left] + nums[right]);
            left++;
            right--;
        }

        return minPairSum;
    }
}
