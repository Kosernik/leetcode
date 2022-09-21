package MonthlyChallenges.Year22.September;

public class SumOfEvenNumbersAfterQueries {

    /**
     * LeetCode #985. Sum of Even Numbers After Queries.
     * <p>
     * Complexity - O(N + M), N = nums.length, M = queries.length.
     * Memory - O(1)
     *
     * @param nums    - an array of integers.
     * @param queries - an array of queries, queries[i] = [val-i, index-i]
     * @return - an array of sums of even numbers after each query.
     */
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int[] result = new int[queries.length];
        int idx = 0;

        int sum = 0;
        for (int number : nums) {
            if (number % 2 == 0) sum += number;
        }

        for (int[] query : queries) {
            if (nums[query[1]] % 2 == 0) {
                sum -= nums[query[1]];
            }

            nums[query[1]] += query[0];

            if (nums[query[1]] % 2 == 0) {
                sum += nums[query[1]];
            }

            result[idx++] = sum;
        }

        return result;
    }
}
