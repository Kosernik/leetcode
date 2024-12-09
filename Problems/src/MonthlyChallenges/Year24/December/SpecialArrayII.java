package MonthlyChallenges.Year24.December;

public class SpecialArrayII {

    /**
     * LeetCode №3152. Special Array II.
     * <p>
     * Complexity - O(N + M), N = nums.length, M = queries.length.
     * Memory - O(N)
     *
     * @param nums    - an array of positive integers.
     * @param queries - an array of queries, where query[i] = [from-i, to-i] - starting and ending indices of a subarray.
     * @return - an array of results of each query. True - if a query subarray is special, false - otherwise.
     */
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int[] prevSpecialStart = new int[nums.length];
        boolean even = nums[0] % 2 == 0;
        int prevStart = 0;

        for (int i = 1; i < nums.length; i++) {
            boolean curEven = nums[i] % 2 == 0;

            if (curEven == even) {
                prevStart = i;
            }

            prevSpecialStart[i] = prevStart;
            even = curEven;
        }

        boolean[] result = new boolean[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];

            result[i] = prevSpecialStart[query[0]] == prevSpecialStart[query[1]];
        }

        return result;
    }
}
