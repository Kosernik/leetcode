package MonthlyChallenges.Year23.July;

public class PredictWinner {

    /**
     * LeetCode #486. Predict the Winner.
     * <p>
     * Complexity - O(N^2)
     * Memory - O(N^2)
     *
     * @param nums - an array of scores.
     * @return - true - if the first player wins or if it is a draw, false - if the second player wins.
     */
    public boolean PredictTheWinner(int[] nums) {
        int result = helper(0, nums.length - 1, nums, new Integer[nums.length][nums.length]);

        return result >= 0;
    }

    private int helper(int left, int right, int[] nums, Integer[][] computed) {
        if (right == left) {
            return nums[left];
        } else if (right - left == 1) {
            return Math.abs(nums[left] - nums[right]);
        } else if (computed[left][right] != null) {
            return computed[left][right];
        }

        int pickLeft = nums[left] - helper(left + 1, right, nums, computed);
        int pickRight = nums[right] - helper(left, right - 1, nums, computed);

        computed[left][right] = Math.max(pickLeft, pickRight);
        return computed[left][right];
    }
}
