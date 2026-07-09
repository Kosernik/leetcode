package MonthlyChallenges.Year26.July;

public class PathExistenceQueriesInGraphI {

    /**
     * LeetCode №3532. Path Existence Queries in a Graph I.
     *
     * @param n       - the total number of nodes in a graph.
     * @param nums    - an array of integers sorted in non-decreasing order.
     * @param maxDiff - the maximum allowed difference between two nodes.
     *                An undirected edge exists between nodes i and j if the absolute difference between nums[i] and
     *                nums[j] is at most maxDiff (i.e., |nums[i] - nums[j]| <= maxDiff).
     * @param queries - an array of queries, where queries[i][0] = Ui and queries[i][1] = Vi are nodes in a graph.
     * @return - a boolean array result, where result[i] is true if there exists a path between Ui and Vi in the i-th
     * query and false otherwise.
     */
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[] parents = new int[n];
        parents[0] = 0;

        for (int i = 1; i < n; i++) {
            if ((nums[i] - nums[i - 1]) <= maxDiff) {
                parents[i] = parents[i - 1];
            } else {
                parents[i] = i;
            }
        }

        boolean[] result = new boolean[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            result[i] = parents[query[0]] == parents[query[1]];
        }

        return result;
    }
}
