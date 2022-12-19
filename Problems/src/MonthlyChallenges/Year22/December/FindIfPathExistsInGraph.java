package MonthlyChallenges.Year22.December;

import java.util.*;

public class FindIfPathExistsInGraph {

    /**
     * LeetCode #1971. Find if Path Exists in Graph.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param n           - the number of vertices in a graph.
     * @param edges       - an array of edges between vertices.
     * @param source      - starting node.
     * @param destination - ending node.
     * @return - True - if there exists a path between source and destination, false - otherwise.
     */
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, Set<Integer>> graph = getGraph(edges, n);

        return findPathBFS(graph, source, destination);
    }

    private boolean findPathBFS(Map<Integer, Set<Integer>> graph, int source, int destination) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(source);
        Set<Integer> visited = new HashSet<>();

        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (node == destination) return true;

            for (Integer neighbour : graph.get(node)) {
                if (!visited.contains(neighbour)) {
                    queue.add(neighbour);
                    visited.add(neighbour);
                }
            }
        }

        return false;
    }

    private Map<Integer, Set<Integer>> getGraph(int[][] edges, int n) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        return graph;
    }
}
