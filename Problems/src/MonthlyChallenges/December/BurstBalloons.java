package MonthlyChallenges.December;

public class BurstBalloons {

    // LeetCode #312.
    public int maxCoins(int[] nums) {
        int[][] dpArr = new int[nums.length][nums.length];
        return helper(nums, 0, nums.length-1, dpArr);
    }

    private int helper(int[] nums, int left, int right, int[][] dpArr) {
        if (left > right) return 0;
        else if (dpArr[left][right] != 0) return dpArr[left][right];

        int result = nums[left];

        for (int i = left; i <= right; i++) {
            int curVal = nums[i];
            if ((left - 1) >= 0) curVal *= nums[left-1];
            if ((right + 1) < nums.length) curVal *= nums[right+1];
            int currRes = helper(nums, left, i-1, dpArr) + curVal + helper(nums, i+1, right, dpArr);
            result = Math.max(result, currRes);
        }
        dpArr[left][right] = result;
        return result;
    }
}
