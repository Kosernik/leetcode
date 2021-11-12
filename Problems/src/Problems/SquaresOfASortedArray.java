package Problems;

import java.util.Arrays;

public class SquaresOfASortedArray {
    /**
     * LeetCode #977. Squares of a Sorted Array.
     *
     * @param nums - an array of integers sorted in non-decreasing order.
     * @return - an array of the squares of each number sorted in non-decreasing order.
     */
    public int[] sortedSquares(int[] nums) {
        int length =nums .length;
        for (int i = 0; i < length; i++) {
            nums[i] *= nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
}
