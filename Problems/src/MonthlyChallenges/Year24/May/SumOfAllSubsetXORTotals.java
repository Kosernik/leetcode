package MonthlyChallenges.Year24.May;

public class SumOfAllSubsetXORTotals {
    private int xorSum = 0;

    /**
     * LeetCode №1863. Sum of All Subset XOR Totals.
     * <p>
     * Complexity - O(2^N)
     * Memory - O(1)
     *
     * @param nums - an array of integers.
     * @return - the sum of all XOR totals for every subset of nums.
     */
    public int subsetXORSum(int[] nums) {
        backtrack(nums, 0, 0);
        return this.xorSum;
    }

    private void backtrack(int[] nums, int idx, int xor) {
        if (idx >= nums.length) return;

        int curXor = xor ^ nums[idx];
        this.xorSum += curXor;

        backtrack(nums, idx + 1, xor);
        backtrack(nums, idx + 1, curXor);
    }
}
