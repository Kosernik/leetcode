package MonthlyChallenges.Year26.June;

import java.util.*;

public class NumberOfWaysToAssignEdgeWeightsI {
    public static void main(String[] args) {
        NumberOfWaysToAssignEdgeWeightsI solution = new NumberOfWaysToAssignEdgeWeightsI();

        int[][] edges2 = {{1, 2}, {1, 3}, {3, 4}, {3, 5}};
        int result2 = 2;
        System.out.println(solution.assignEdgeWeights(edges2) == result2);
    }

    /**
     * LeetCode №3558. Number of Ways to Assign Edge Weights I.
     *
     * @param edges - an array of edges between nodes in an undirected tree.
     * @return - the number of ways to assign edge weights in the path from node 1 to the deepest node such that its
     * total cost is odd. The result is modulo 10⁹ + 7.
     */
    public int assignEdgeWeights(int[][] edges) {
        if (edges.length == 1) return 1;

        int MODULO = 1_000_000_007;

        Map<Integer, List<Integer>> graph = buildGraph(edges);

        int maxLength = computeLength(graph);

        return (int) pow(2, maxLength - 1, MODULO);
    }

    private int computeLength(Map<Integer, List<Integer>> graph) {
        int length = -1;

        // BFS
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(1);

        boolean[] visited = new boolean[graph.size() + 1];
        visited[1] = true;

        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                int node = queue.removeFirst();

                for (int neighbour : graph.get(node)) {
                    if (!visited[neighbour]) {
                        visited[neighbour] = true;

                        queue.offerLast(neighbour);
                    }
                }
            }

            length++;
        }

        return length;
    }

    private Map<Integer, List<Integer>> buildGraph(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] edge : edges) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.putIfAbsent(edge[1], new ArrayList<>());

            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        return graph;
    }

    private long pow(long base, long power, int MODULO) {
        if (power == 0) {
            return 1L;
        } else if (power == 1) {
            return base;
        }

        long result = pow(base, power / 2, MODULO);
        result = result * result % MODULO;

        if ((power & 1) == 1) {
            result = result * base % MODULO;
        }

        return result;
    }
}
