package MonthlyChallenges.Year25.May;

public class ZeroArrayTransformationI {

    /**
     * LeetCode №3355. Zero Array Transformation I.
     * <p>
     * Complexity - O(M+N) N = nums.length, M = queries.length.
     * Memory - O(N)
     * <p>
     * For each queries[i]:
     * * Select a subset of indices within the range [left-index, right-index] in nums.
     * * Decrement the values at the selected indices by 1.
     *
     * @param nums    - an array of non-negative integers.
     * @param queries - a 2d array of queries, where queries[i] = [left-index, right-index].
     * @return - true if it is possible to transform nums into a Zero Array after processing all the queries
     * sequentially, otherwise returns false.
     */
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int[] changes = new int[nums.length + 1];

        for (int[] query : queries) {
            changes[query[0]]++;
            changes[query[1] + 1]--;
        }

        int change = 0;

        for (int i = 0; i < nums.length; i++) {
            change += changes[i];

            if (nums[i] > change) return false;
        }

        return true;
    }
}
