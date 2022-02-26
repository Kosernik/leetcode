package MonthlyChallenges.Year22.February;

public class ShortestPathVisitingAllNodes {

    private int[][] computed;

    /**
     * LeetCode #847. Shortest Path Visiting All Nodes.
     *
     *
     * @param graph - an array of edges of each node in a graph.
     * @return - the length of the shortest path that visits every node.
     */
    public int shortestPathLength(int[][] graph) {
        int target = (1 << graph.length) - 1;
        computed = new int[graph.length+1][target+1];
        int shortestPath = Integer.MAX_VALUE;

        for (int i = 0; i < graph.length; i++) {
            shortestPath = Math.min(shortestPath, dfs(graph, i, target));
        }

        return shortestPath;
    }

    private int dfs(int[][] graph, int vertex, int visited) {
        if (Integer.bitCount(visited) == 1) return 0;
        else if (computed[vertex][visited] != 0) return computed[vertex][visited];

        computed[vertex][visited] = Integer.MAX_VALUE;

        for (int neighbour : graph[vertex]) {
            if ((visited & (1 << neighbour)) != 0) {    // Not visited before
                int returningBack = dfs(graph, neighbour, visited);
                int notVisited = dfs(graph, neighbour, visited ^ (1 << vertex));
                int pathLength = Math.min(returningBack, notVisited) + 1;

                computed[vertex][visited] = Math.min(computed[vertex][visited], pathLength);
            }
        }
        return computed[vertex][visited];
    }
}

