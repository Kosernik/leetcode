package MonthlyChallenges.Year26.June;

public class MaximumTotalSubarrayValueI {

    /**
     * LeetCode №3689. Maximum Total Subarray Value I.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     * <p>
     * * The value of a subarray nums[l..r] is defined as: max(nums[l..r]) - min(nums[l..r]).
     * * The total value is the sum of the values of all chosen subarrays.
     *
     * @param nums - an array of non-negative integers.
     * @param k    - the total number of subarrays.
     * @return - the maximum possible total value.
     */
    public long maxTotalValue(int[] nums, int k) {
        int min = nums[0];
        int max = nums[0];

        for (int number : nums) {
            min = Math.min(min, number);
            max = Math.max(max, number);
        }

        return (long) k * (max - min);
    }
}
