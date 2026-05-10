package MonthlyChallenges.Year26.May;

public class MaximumNumberOfJumpsToReachLastIndex {

    /**
     * LeetCode №2770. Maximum Number of Jumps to Reach the Last Index.
     * <p>
     * Complexity - O(N^2)
     * Memory - O(N)
     *
     * @param nums   - an array of integers.
     * @param target - the maximum allowed difference between values.
     * @return - the maximum number of jumps you can make to reach index n - 1.
     */
    public int maximumJumps(int[] nums, int target) {
        int length = nums.length;

        int negative = -target;

        int[] maxJumps = new int[length];
        maxJumps[length - 1] = -1;

        for (int i = 0; i < length - 1; i++) {
            if (i > 0 && maxJumps[i] == 0) continue;

            int number = nums[i];
            int jumps = maxJumps[i] + 1;
            for (int j = i + 1; j < length; j++) {
                int diff = nums[j] - number;

                if (negative <= diff && diff <= target) {
                    maxJumps[j] = Math.max(maxJumps[j], jumps);
                }
            }
        }

        return maxJumps[length - 1];
    }
}
