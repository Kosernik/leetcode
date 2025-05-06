package MonthlyChallenges.Year25.May;

public class BuildArrayFromPermutation {

    /**
     * LeetCode №1920. Build Array from Permutation.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     * <p>
     * A zero-based permutation nums is an array of distinct integers from 0 to nums.length - 1 (inclusive).
     *
     * @param nums -  a zero-based permutation.
     * @return - an array result, where result[i] = nums[nums[i]].
     */
    public int[] buildArray(int[] nums) {
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[nums[i]];
        }

        return result;
    }
}
