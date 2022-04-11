package Problems;

import java.util.Arrays;

public class SpecialArrayWithXElementsGreaterThanOrEqualX {

    /**
     * LeetCode #1608. Special Array With X Elements Greater Than or Equal X.
     *
     * Complexity - O(NlogN + logN), N = nums.length.
     * Memory - O(1)
     *
     * @param nums - an array of non-negative integers.
     * @return - X - if nums is special, -1 - otherwise.
     */
    public int specialArray(int[] nums) {
        Arrays.sort(nums);

        if (nums[nums.length-1] == 0) return -1;

        int left = 0, right = nums.length, middle;

        while (left < right) {
            middle = (right - left) / 2 + left;

            int candidateLength = nums.length - middle;

            if (nums[middle] < candidateLength) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        if (nums[left] >= (nums.length-left)) {
            if (left > 0 && nums[left-1] >= (nums.length-left)) return -1;
            return nums.length-left;
        }
        return -1;
    }
}
