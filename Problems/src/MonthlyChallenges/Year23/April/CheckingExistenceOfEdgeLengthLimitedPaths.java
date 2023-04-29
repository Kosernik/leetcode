package MonthlyChallenges.Year23.April;

import java.util.Arrays;

public class CheckingExistenceOfEdgeLengthLimitedPaths {
    private int[] parents;

    /**
     * LeetCode #1697. Checking Existence of Edge Length Limited Paths.
     *
     * @param n        - the number of vertices in an undirected graph.
     * @param edgeList - an array of edges in a graph. edgelist[i] = {vertex-A, vertex-B, distance between A and B}
     * @param queries  - an array of queries. queries[i] = {start Vertex, destination Vertex, max allowed edge length}
     * @return - an array of results for each query.
     */
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        this.parents = new int[n];
        for (int i = 0; i < n; i++) {
            this.parents[i] = i;
        }

        boolean[] result = new boolean[queries.length];

        int[][] sortedQueries = new int[queries.length][4];
        for (int i = 0; i < queries.length; i++) {
            sortedQueries[i][0] = queries[i][0];
            sortedQueries[i][1] = queries[i][1];
            sortedQueries[i][2] = queries[i][2];
            sortedQueries[i][3] = i;
        }

        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[2], b[2]));
        Arrays.sort(edgeList, (a, b) -> Integer.compare(a[2], b[2]));
        int edgeIdx = 0;

        for (int[] curQuery : sortedQueries) {
            while (edgeIdx < edgeList.length && edgeList[edgeIdx][2] < curQuery[2]) {
                union(edgeList[edgeIdx][0], edgeList[edgeIdx][1]);
                edgeIdx++;
            }

            boolean sameParent = find(curQuery[0]) == find(curQuery[1]);

            result[curQuery[3]] = sameParent;
        }
        return result;
    }

    private void union(int vertexA, int vertexB) {
        int parentA = find(vertexA);
        int parentB = find(vertexB);

        if (parentA != parentB) {
            this.parents[parentA] = parentB;
        }
    }

    private int find(int vertex) {
        //  COMMENTED CODE CAUSES TLE
//        if (this.parents[vertex] == vertex) {
//            return vertex;
//        }
//        return find(this.parents[vertex]);
        if (this.parents[vertex] != vertex) {
            this.parents[vertex] = find(this.parents[vertex]);
        }
        return this.parents[vertex];
    }
}
