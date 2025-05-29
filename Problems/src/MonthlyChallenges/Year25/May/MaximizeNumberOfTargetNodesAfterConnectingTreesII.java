package MonthlyChallenges.Year25.May;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximizeNumberOfTargetNodesAfterConnectingTreesII {

    /**
     * LeetCode №3373. Maximize the Number of Target Nodes After Connecting Trees II
     *
     * @param edges1 - an array of edges in a tree. edges.length = n-1
     * @param edges2 - an array of edges in a tree.
     * @return -an array of n integers result, where result[i] is the maximum possible number of nodes that are target
     * to node i of the first tree if you had to connect one node from the first tree to another node in the second tree.
     */
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        int[] result = new int[edges1.length + 1];

        int[] firstOddOrEven = new int[edges1.length + 1];
        int[] secondOddOrEven = new int[edges2.length + 1];
        int[] firstCounts = buildGraphAndGetCounts(edges1, firstOddOrEven);
        int[] secondCounts = buildGraphAndGetCounts(edges2, secondOddOrEven);

        int bestSecondCount = Math.max(secondCounts[0], secondCounts[1]);

        for (int i = 0; i < result.length; i++) {
            result[i] = bestSecondCount + firstCounts[firstOddOrEven[i]];
        }

        return result;
    }

    private int[] buildGraphAndGetCounts(int[][] edges, int[] oddEven) {
        Map<Integer, List<Integer>> graph = buildGraph(edges);

        int result = dfs(0, -1, 0, graph, oddEven);

        return new int[]{result, edges.length + 1 - result};
    }

    private int dfs(int node, int parent, int depth, Map<Integer, List<Integer>> graph, int[] oddEven) {
        int result = 1 - depth;
        oddEven[node] = depth;

        int nextDepth = (depth + 1) % 2;

        for (int neighbour : graph.get(node)) {
            if (neighbour != parent) {
                result += dfs(neighbour, node, nextDepth, graph, oddEven);
            }
        }

        return result;
    }

    private int dfsSlow(int node, int parent, int depth, Map<Integer, List<Integer>> graph, int[] oddEven) {
        int result = 1 - (depth % 2);
        oddEven[node] = depth % 2;

        for (int neighbour : graph.get(node)) {
            if (neighbour != parent) {
                result += dfs(neighbour, node, depth + 1, graph, oddEven);
            }
        }

        return result;
    }

    public int[] maxTargetNodesTLE(int[][] edges1, int[][] edges2) {
        int[] result = new int[edges1.length + 1];

        Map<Integer, List<Integer>> graph1 = buildGraph(edges1);
        Map<Integer, List<Integer>> graph2 = buildGraph(edges2);

        int bestSecondGraphNodes = 0;
        for (int i = 0; i < graph2.size(); i++) {
            bestSecondGraphNodes = Math.max(bestSecondGraphNodes, getNumberOfNodes(i, -1, graph2, false));
        }

        for (int i = 0; i < graph1.size(); i++) {
            result[i] = bestSecondGraphNodes + getNumberOfNodes(i, -1, graph1, true);
        }

        return result;
    }

    private int getNumberOfNodes(int node, int parent, Map<Integer, List<Integer>> graph, boolean odd) {
        int numberOfNodes = odd ? 1 : 0;

        for (int neighbour : graph.get(node)) {
            if (neighbour != parent) {
                numberOfNodes += getNumberOfNodes(neighbour, node, graph, !odd);
            }
        }

        return numberOfNodes;
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
}
