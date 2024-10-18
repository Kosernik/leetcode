package MonthlyChallenges.Year24.October;

public class CountNumberOfMaximumBitwiseORSubsets {

    /**
     * LeetCode №2044. Count Number of Maximum Bitwise-OR Subsets.
     * <p>
     * Complexity - O(N * 2^N), N = nums.length.
     * Memory - O(1)
     *
     * @param nums - an array of positive integers. 1 <= nums.length <= 16
     * @return - the number of different non-empty subsets with the maximum bitwise OR.
     */
    public int countMaxOrSubsets(int[] nums) {
        int maxOR = 0;
        int maxCount = 0;

        for (int mask = 1; mask < (1 << nums.length); mask++) {
            int curOR = computeOR(mask, nums);

            if (curOR > maxOR) {
                maxOR = curOR;
                maxCount = 1;
            } else if (curOR == maxOR) {
                maxCount++;
            }
        }

        return maxCount;
    }

    private int computeOR(int combinationMask, int[] nums) {
        int or = 0;

        for (int i = 0; i < nums.length; i++) {
            int checkBit = 1 << i;
            if ((combinationMask & checkBit) == checkBit) {
                or |= nums[i];
            }
        }

        return or;
    }
}
