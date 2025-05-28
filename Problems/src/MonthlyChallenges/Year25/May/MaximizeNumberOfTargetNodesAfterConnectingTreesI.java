package MonthlyChallenges.Year25.May;

import java.util.*;

public class MaximizeNumberOfTargetNodesAfterConnectingTreesI {

    /**
     * LeetCode №3372. Maximize the Number of Target Nodes After Connecting Trees I
     *
     * @param edges1 - an array of edges in a tree. edges.length = n-1
     * @param edges2 - an array of edges in a tree.
     * @param k      - the maximum allowed distance from a node.
     * @return - an array of n integers result, where result[i] is the maximum possible number of nodes target to
     * node i of the first tree if you have to connect one node from the first tree to another node in the second tree.
     */
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int[] result = new int[edges1.length + 1];

        Map<Integer, List<Integer>> graph1 = buildGraph(edges1);
        Map<Integer, List<Integer>> graph2 = buildGraph(edges2);

        int bestScoreInSecondGraph = getMaxNodesWithinK(graph2, k - 1);

        for (int i = 0; i < graph1.size(); i++) {
            result[i] = getNumberOfNodesWithinK(i, graph1, k) + bestScoreInSecondGraph;
        }

        return result;
    }

    private int getMaxNodesWithinK(Map<Integer, List<Integer>> graph, int k) {
        int maxNodes = 0;

        for (int i = 0; i < graph.size(); i++) {
            maxNodes = Math.max(maxNodes, getNumberOfNodesWithinK(i, graph, k));
        }

        return maxNodes;
    }

    private Map<Integer, List<Integer>> buildGraph(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < edges.length + 1; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];

            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }

        return graph;
    }

    private int getNumberOfNodesWithinK(int node, Map<Integer, List<Integer>> graph, int k) {
        Queue<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();

        queue.offer(node);
        visited.add(node);

        int nodesWithinK = 0;

        while (k >= 0 && !queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                int curNode = queue.poll();
                nodesWithinK++;

                for (int neighbour : graph.get(curNode)) {
                    if (!visited.contains(neighbour)) {
                        visited.add(neighbour);
                        queue.offer(neighbour);
                    }
                }
            }

            k--;
        }

        return nodesWithinK;
    }
}
