package MonthlyChallenges.Year24.December;

import java.util.Arrays;

public class MaximumBeautyOfArrayAfterApplyingOperation {

    /**
     * LeetCode №2779. Maximum Beauty of an Array After Applying Operation.
     * <p>
     * Complexity - O(NlogN)
     * Memory - O(N)
     *
     * @param nums - an array of integers.
     * @param k    - a positive integer.
     * @return - the maximum possible beauty of the array nums.
     */
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);

        int length = nums.length;
        int twiceK = k * 2;
        int result = 0;

        for (int i = 0; i < length; i++) {
            if (length - i < result) return result;

            int curNumber = nums[i];
            int target = curNumber + twiceK;
            int idx = binarySearchRightmost(target, nums);

            int curLength = idx - i + 1;

            result = Math.max(result, curLength);
        }

        return result;
    }

    private int binarySearchRightmost(int target, int[] nums) {
        int left = 0, right = nums.length - 1, middle;

        while (left < right) {
            middle = right - (right - left) / 2;

            if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle;
            }
        }

        return left;
    }
}
