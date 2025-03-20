package MonthlyChallenges.Year25.March;

public class MinimumCostWalkInWeightedGraph {
    private int[] parents;
    private int[] bitCosts;

    /**
     * LeetCode №3108. Minimum Cost Walk in Weighted Graph.
     *
     * @param n     - the total number of nodes in a graph.
     * @param edges - an array of edges in a graph, where edges[i][0] and edges[i][1] are nodes in a graph and
     *              edges[i][2] is the weight of an edge connecting these nodes.
     * @param query - an array of queries, where query[i][0] is a starting node and query[i][1] is a target node.
     * @return - an array result of length query.length where result[i] is the minimum cost of a walk for query i. If
     * there is no path between two nodes result[i] = -1.
     */
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        this.parents = new int[n];
        this.bitCosts = new int[n];

        for (int i = 0; i < n; i++) {
            parents[i] = i;
            bitCosts[i] = -1;
        }

        for (int[] edge : edges) {
            union(edge[0], edge[1], edge[2]);
        }

        int[] result = new int[query.length];

        for (int i = 0; i < query.length; i++) {
            int[] q = query[i];

            int first = q[0];
            int second = q[1];

            int parentFirst = find(first);
            int parentSecond = find(second);

            if (parentFirst != parentSecond) {
                result[i] = -1;
            } else {
                result[i] = bitCosts[parentFirst];
            }
        }

        return result;
    }

    private int find(int node) {
        if (parents[node] != node) {
            parents[node] = find(parents[node]);
        }

        return parents[node];
    }

    private void union(int first, int second, int edgeCost) {
        int parentFirst = find(first);
        int parentSecond = find(second);

        if (bitCosts[parentFirst] == -1) bitCosts[parentFirst] = edgeCost;
        if (bitCosts[parentSecond] == -1) bitCosts[parentSecond] = edgeCost;

        if (parentFirst != parentSecond) {
            bitCosts[parentFirst] &= bitCosts[parentSecond];
            parents[parentSecond] = parentFirst;
        }

        bitCosts[parentFirst] &= edgeCost;
    }
}
