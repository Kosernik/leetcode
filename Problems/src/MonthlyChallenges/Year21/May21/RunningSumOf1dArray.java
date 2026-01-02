package MonthlyChallenges.Year21.May21;

public class RunningSumOf1dArray {
    /**
     * LeetCode #1480.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param nums - array of integers.
     * @return - result array.
     */
    public int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] + nums[i];
        }

        return result;
    }
}
