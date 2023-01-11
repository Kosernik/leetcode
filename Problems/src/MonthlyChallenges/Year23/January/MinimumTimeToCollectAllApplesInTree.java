package MonthlyChallenges.Year23.January;

import java.util.*;

public class MinimumTimeToCollectAllApplesInTree {

    /**
     * LeetCode #1443. Minimum Time to Collect All Apples in a Tree.
     * <p>
     * Complexity - O(V*E), V = n, E = edges.length
     * Memory - O(E)
     *
     * @param n        - the total number of nodes in a graph.
     * @param edges    - an array of edges between nodes.
     * @param hasApple - a list representing if a node has an apple.
     * @return - the minimum time to collect al apples.
     */
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer, List<Integer>> graph = buildGraph(edges);

        return dfs(0, 0, graph, hasApple, new HashSet<>());
    }

    private int dfs(int node, int duration, Map<Integer, List<Integer>> graph, List<Boolean> hasApple, Set<Integer> visited) {
        if (visited.contains(node)) {
            return 0;
        }
        visited.add(node);

        int childrenDuration = 0;
        for (int children : graph.get(node)) {
            childrenDuration += dfs(children, 2, graph, hasApple, visited);
        }
        if (childrenDuration == 0 && !hasApple.get(node)) {
            return 0;
        }

        return duration + childrenDuration;
    }

    private Map<Integer, List<Integer>> buildGraph(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        //  edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]]
        for (int[] edge : edges) {
            List<Integer> neighboursList1 = graph.getOrDefault(edge[0], new ArrayList<>());
            neighboursList1.add(edge[1]);
            graph.put(edge[0], neighboursList1);

            List<Integer> neighboursList2 = graph.getOrDefault(edge[1], new ArrayList<>());
            neighboursList2.add(edge[0]);
            graph.put(edge[1], neighboursList2);
        }

        return graph;
    }
}
