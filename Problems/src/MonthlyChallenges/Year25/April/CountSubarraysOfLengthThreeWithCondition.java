package MonthlyChallenges.Year25.April;

public class CountSubarraysOfLengthThreeWithCondition {

    /**
     * LeetCode №3392. Count Subarrays of Length Three With a Condition.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param nums - an array of integers. nums.length >= 3.
     * @return - the number of subarrays of length 3 such that the sum of the first and third numbers equals exactly
     * half of the second number.
     */
    public int countSubarrays(int[] nums) {
        int count = 0;

        for (int i = 2; i < nums.length; i++) {
            if ((nums[i - 2] + nums[i]) * 2 == nums[i - 1]) {
                count++;
            }
        }

        return count;
    }
}
