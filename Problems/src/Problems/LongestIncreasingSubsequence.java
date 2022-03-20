package Problems;

import java.util.Arrays;
import java.util.Random;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        LongestIncreasingSubsequence solution = new LongestIncreasingSubsequence();
        Random random = new Random();

        int[] arr = new int[123];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(10000);
        }
        System.out.println(solution.lengthOfLIS(arr));
        System.out.println(Arrays.toString(arr));
    }

    /**
     * LeetCode #300. Longest Increasing Subsequence.
     *
     * Complexity - O(N^2)
     * Memory - O(N)
     *
     * @param nums - an array of integers.
     * @return - the length of the longest increasing subsequence.
     */
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 1) return 1;
        int result = 1;

        //  dp[i][0] - value, dp[i][1] - length
        int[][] dp = new int[nums.length][2];
        dp[0][0] = nums[0];
        dp[0][1] = 1;

        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = nums[i];
            dp[i][1] = 1;
            for (int j = i-1; j >= 0; j--) {
                if (dp[j][0] < nums[i]) {
                    dp[i][1] = Math.max(dp[i][1], dp[j][1] + 1);
                }
            }
            result = Math.max(result, dp[i][1]);
        }

        return result;
    }
}
