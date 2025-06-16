package MonthlyChallenges.Year25.June;

public class MaximumDifferenceBetweenIncreasingElements {

    /**
     * LeetCode №2016. Maximum Difference Between Increasing Elements.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param nums - an array of positive integers.
     * @return - the maximum difference between two numbers nums[i] and nums[j], such that 0 <= i < j < nums.length
     * and nums[i] < nums[j].
     */
    public int maximumDifference(int[] nums) {
        int maxDiff = -1;
        int prevMaxNumber = nums[nums.length - 1];

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < prevMaxNumber) {
                maxDiff = Math.max(maxDiff, prevMaxNumber - nums[i]);
            } else {
                prevMaxNumber = nums[i];
            }
        }

        return maxDiff;
    }
}
