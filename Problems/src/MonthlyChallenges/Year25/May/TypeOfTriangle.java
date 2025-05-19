package MonthlyChallenges.Year25.May;

import java.util.Arrays;

public class TypeOfTriangle {

    /**
     * LeetCode №3024. Type of Triangle.
     * <p>
     * Complexity - O(1)
     * Memory - O(1)
     * <p>
     * A triangle is called equilateral if it has all sides of equal length.
     * A triangle is called isosceles if it has exactly two sides of equal length.
     * A triangle is called scalene if all its sides are of different lengths.
     *
     * @param nums - an array of 3 integers.
     * @return - a string representing the type of triangle that can be formed or "none" if it cannot form a triangle.
     */
    public String triangleType(int[] nums) {
        Arrays.sort(nums);

        if ((nums[0] + nums[1]) <= nums[2]) {
            return "none";
        } else if (nums[0] == nums[1] && nums[1] == nums[2]) {
            return "equilateral";
        } else if (nums[0] == nums[1] || nums[1] == nums[2] || nums[0] == nums[2]) {
            return "isosceles";
        } else {
            return "scalene";
        }
    }
}
