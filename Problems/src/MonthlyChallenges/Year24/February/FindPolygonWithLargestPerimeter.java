package MonthlyChallenges.Year24.February;

import java.util.Arrays;

public class FindPolygonWithLargestPerimeter {

    /**
     * LeetCode №2971. Find Polygon With the Largest Perimeter.
     * <p>
     * Complexity - O(NlogN)
     * Memory - O(N)
     *
     * @param nums - an array of positive integers.
     * @return - the largest possible perimeter of a polygon whose sides can be formed from nums, or -1 if it is not
     * possible to create a polygon.
     */
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long[] presum = new long[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            presum[i + 1] = presum[i] + nums[i];
        }

        for (int i = nums.length - 1; i > 1; i--) {
            if (nums[i] < presum[i]) {
                return presum[i + 1];
            }
        }

        return -1;
    }
}
