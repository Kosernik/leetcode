package Problems;

import java.util.Arrays;

public class LargestPerimeterTriangle {

    /**
     * LeetCode #976. Largest Perimeter Triangle.
     *
     * Complexity - O(NlogN)
     * Memory - O(1)
     *
     * @param nums - an array of positive integers representing lengths.
     * @return - the largest perimeter of a triangle with a non-zero area, formed from three of these lengths, or 0 if
     *           it`s impossible to form a triangle.
     */
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);

        for (int i = nums.length-1; i >= 2; i--) {
            if (nums[i] < (nums[i-1] + nums[i-2])) return nums[i] + nums[i-1] + nums[i-2];
        }

        return 0;
    }
}
