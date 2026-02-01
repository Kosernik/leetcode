package MonthlyChallenges.Year26.February;

public class DivideArrayIntoSubarraysWithMinimumCostI {

    /**
     * LeetCode №3010. Divide an Array Into Subarrays With Minimum Cost I.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     * <p>
     * The cost of an array is the value of its first element.
     *
     * @param nums - an array of integers. nums.length >= 3
     * @return - the minimum possible sum of the cost of 3 disjoint contiguous subarrays.
     */
    public int minimumCost(int[] nums) {
        int min = Math.min(nums[1], nums[2]);
        int secMin = Math.max(nums[1], nums[2]);

        for (int i = 3; i < nums.length; i++) {
            if (nums[i] < min) {
                secMin = min;
                min = nums[i];
            } else if (nums[i] < secMin) {
                secMin = nums[i];
            }
        }

        return nums[0] + min + secMin;
    }
}
