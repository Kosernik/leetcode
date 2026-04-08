package MonthlyChallenges.Year26.April;

public class XORAfterRangeMultiplicationQueriesI {

    /**
     * LeetCode №3653. XOR After Range Multiplication Queries I.
     * <p>
     * Complexity - O(N*M), N = nums.length, M = queries.length
     * Memory - O(1)
     * <p>
     * An operation for each query:
     * ** Set index to query[0].
     * ** While index <= query[1] :
     * **** update nums[index] = (nums[index] * query[3]) % (10⁹ + 7).
     * ** Set index += query[2].
     *
     * @param nums    - an array of positive integers.
     * @param queries - an array of queries.
     *                query[0] - left index of a query,
     *                query[1] - right index of a query,
     *                query[2] - the step of shifting an index in a query,
     *                query[3] - the multiplier.
     * @return - the bitwise XOR of all elements in nums after processing all queries.
     */
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int MODULO = 1_000_000_007;

        for (int[] query : queries) {
            int left = query[0], right = query[1];
            int step = query[2];
            long multiplier = query[3];

            for (int idx = left; idx <= right && idx < nums.length; idx += step) {
                nums[idx] = (int) ((nums[idx] * multiplier) % MODULO);
            }
        }

        int result = 0;
        for (int num : nums) {
            result ^= num;
        }

        return result;
    }
}
