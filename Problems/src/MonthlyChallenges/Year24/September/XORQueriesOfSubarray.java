package MonthlyChallenges.Year24.September;

public class XORQueriesOfSubarray {

    /**
     * LeetCode №1310. XOR Queries of a Subarray.
     * <p>
     * Complexity - O(N + M), N = arr.length, M = queries.length.
     * Memory - O(N)
     *
     * @param arr     - an array of integers.
     * @param queries - a 2D array of queries where queries[i][0] - starting index of q query, queries[i][1] - ending
     *                index of a query.
     * @return - an array of XORs of queries.
     */
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] preXORs = new int[arr.length + 1];

        for (int i = 0; i < arr.length; i++) {
            preXORs[i + 1] = preXORs[i] ^ arr[i];
        }

        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            result[i] = preXORs[queries[i][1] + 1] ^ preXORs[queries[i][0]];
        }

        return result;
    }
}
