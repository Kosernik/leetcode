package MonthlyChallenges.Year25.June;

public class MaximumDifferenceBetweenAdjacentElementsInCircularArray {

    /**
     * LeetCode №3423. Maximum Difference Between Adjacent Elements in a Circular Array.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param nums - a circular array of integers.
     * @return - the maximum absolute difference between adjacent elements.
     */
    public int maxAdjacentDistance(int[] nums) {
        int maxDiff = Math.abs(nums[0] - nums[nums.length - 1]);

        for (int i = 1; i < nums.length; i++) {
            maxDiff = Math.max(maxDiff, Math.abs(nums[i] - nums[i - 1]));
        }

        return maxDiff;
    }
}
