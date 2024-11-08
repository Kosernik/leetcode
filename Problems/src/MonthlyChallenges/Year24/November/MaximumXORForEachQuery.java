package MonthlyChallenges.Year24.November;

public class MaximumXORForEachQuery {

    /**
     * LeetCode №1829. Maximum XOR for Each Query.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     * <p>
     * You are given a sorted array nums of n non-negative integers and an integer maximumBit. You want to perform the
     * following query n times:
     * <p>
     * - Find a non-negative integer k < 2maximumBit such that:
     * nums[0] XOR nums[1] XOR ... XOR nums[nums.length-1] XOR k is maximized. k is the answer to the ith query.
     * - Remove the last element from the current array nums.
     * <p>
     * Return an array answer, where answer[i] is the answer to the ith query.
     *
     * @param nums       - an array of non-negative numbers.
     * @param maximumBit - a positive integer.
     * @return - the result of maximising XOR operations.
     */
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int[] result = new int[nums.length];
        int resultIdx = nums.length - 1;

        int allBitsSet = (1 << maximumBit) - 1;

        int currentXOR = 0;
        for (int number : nums) {
            currentXOR ^= number;

            result[resultIdx] = allBitsSet ^ currentXOR;
            resultIdx--;
        }

        return result;
    }
}
