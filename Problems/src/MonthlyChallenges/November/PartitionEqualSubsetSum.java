package MonthlyChallenges.November;

public class PartitionEqualSubsetSum {
    /**
     * LeetCode 416.
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length <= 1) return false;

        int sum = 0;

        for (int number : nums) {
            sum += number;
        }

        if (sum % 2 != 0) return false;

        sum /= 2;

        boolean[][] precomputed = new boolean[nums.length+1][sum+1];

        for (int i = 0; i < nums.length+1; i++) {
            precomputed[i][0] = true;
        }

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= sum; j++) {
                precomputed[i][j] = precomputed[i-1][j];
                if (j >= nums[i-1]) {
                    precomputed[i][j] |= precomputed[i-1][j - nums[i-1]];
                }
            }
        }

        return precomputed[nums.length][sum];
    }
}
