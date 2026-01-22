package MonthlyChallenges.Year26.January;

public class MinimumPairRemovalToSortArrayI {

    /**
     * LeetCode №3507. Minimum Pair Removal to Sort Array I.
     * <p>
     * Complexity - O(N^2)
     * Memory - O(N)
     * <p>
     * Available operation:
     * * Select the adjacent pair with the minimum sum in nums. If multiple such pairs exist, choose the leftmost one.
     * * Replace the pair with their sum.
     *
     * @param nums - an array of integers.
     * @return - the minimum number of operations needed to make the array non-decreasing.
     */
    public int minimumPairRemoval(int[] nums) {
        if (nums.length <= 1) return 0;

        boolean isNonDecreasing = nums[1] >= nums[0];

        int minSum = nums[0] + nums[1];
        int minSumIdx = 0;

        for (int i = 2; i < nums.length; i++) {
            if ((nums[i] + nums[i - 1]) < minSum) {
                minSum = nums[i] + nums[i - 1];
                minSumIdx = i - 1;
            }

            if (nums[i] < nums[i - 1]) {
                isNonDecreasing = false;
            }
        }

        if (isNonDecreasing) return 0;

        int[] updatedNums = new int[nums.length - 1];
        System.arraycopy(nums, 0, updatedNums, 0, minSumIdx);
        updatedNums[minSumIdx] = minSum;

        int rightLength = nums.length - minSumIdx - 2;
        if (rightLength < nums.length) {
            System.arraycopy(nums, minSumIdx + 2, updatedNums, minSumIdx + 1, rightLength);
        }

        return 1 + minimumPairRemoval(updatedNums);
    }
}
