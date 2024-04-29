package MonthlyChallenges.Year24.April;

public class MinimumNumberOfOperationsToMakeArrayXOREqualToK {

    /**
     * LeetCode №2997. Minimum Number of Operations to Make Array XOR Equal to K.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param nums - an array of integers.
     * @param k    - a positive integer.
     * @return - the minimum number of flip operations required to make the bitwise XOR of all elements of the final
     * array equal to k.
     */
    public int minOperations(int[] nums, int k) {
        int result = k;
        for (int number : nums) {
            result ^= number;
        }

        return Integer.bitCount(result);
    }
}
