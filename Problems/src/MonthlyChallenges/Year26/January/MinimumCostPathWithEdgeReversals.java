package MonthlyChallenges.Year26.January;

import java.util.*;

public class MinimumCostPathWithEdgeReversals {

    /**
     * LeetCode №3650. Minimum Cost Path with Edge Reversals.
     *
     * @param n     - the total number of nodes in a graph.
     * @param edges - an array of edges in a graph, edges[i] = {from, to, weight}
     * @return - the minimum total cost to travel from node 0 to node n - 1. If it is not possible, return -1.
     */
    public int minCost(int n, int[][] edges) {
        //  node -> { { neighbour, weight }, { neighbour, weight }, .... }
        Map<Integer, List<int[]>> graph = convertToGraph(n, edges);

        int target = n - 1;

        if (!graph.containsKey(target)) {
            return -1;
        }

        //  { node, total weight }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{0, 0});
        Set<Integer> visited = new HashSet<>();

        while (!pq.isEmpty()) {
            int[] nodePair = pq.poll();
            int node = nodePair[0], weight = nodePair[1];

            if (node == target) return nodePair[1];
            if (visited.contains(node)) continue;
            visited.add(node);

            for (int[] neighbour : graph.get(node)) {
                pq.offer(new int[]{neighbour[0], neighbour[1] + weight});
            }
        }

        return -1;  //  No path
    }

    private Map<Integer, List<int[]>> convertToGraph(int n, int[][] edges) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int node = 0; node < n; node++) {
            graph.put(node, new ArrayList<>());
        }

        for (int[] edge : edges) {
            int from = edge[0], to = edge[1];
            int weight = edge[2];

            graph.get(from).add(new int[]{to, weight});
            graph.get(to).add(new int[]{from, weight * 2});
        }

        return graph;
    }
}
