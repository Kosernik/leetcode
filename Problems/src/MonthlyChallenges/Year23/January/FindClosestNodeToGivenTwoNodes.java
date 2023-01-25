package MonthlyChallenges.Year23.January;

import java.util.Arrays;

public class FindClosestNodeToGivenTwoNodes {
    private int minMaxDistance = Integer.MAX_VALUE;
    private int nodeIndex = -1;

    /**
     * LeetCode #2359. Find Closest Node to Given Two Nodes.
     * <p>
     * Complexity - O(N), N = edges.length.
     * Memory - O(N)
     *
     * @param edges - an array of integers. Where edges[i] is the end node of an edge from 'i'. If edges[i] = -1 then
     *              there is no outgoing edge from node 'i'.
     * @param node1 - an index of the first edge.
     * @param node2 - an index of the second edge.
     * @return -  the index of the node that can be reached from both node1 and node2, such that the maximum between the
     * distance from node1 to that node, and from node2 to that node is minimized. If there are multiple answers, return
     * the node with the smallest index, and if no possible answer exists, return -1.
     */
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int[] distances = new int[edges.length];
        Arrays.fill(distances, -1);

        dfs(node1, 0, edges, distances);

        boolean[] visited = new boolean[edges.length];
        dfsWithDistances(node2, 0, edges, distances, visited);

        return nodeIndex;
    }

    private void dfsWithDistances(int node, int distance, int[] edges, int[] distances, boolean[] visited) {
        if (node == -1 || visited[node]) return;
        visited[node] = true;

        if (distances[node] != -1) {
            int maxDist = Math.max(distance, distances[node]);
            if (maxDist < minMaxDistance) {
                nodeIndex = node;
                minMaxDistance = maxDist;
            } else if (maxDist == minMaxDistance) {
                nodeIndex = Math.min(nodeIndex, node);
            }
        }

        dfsWithDistances(edges[node], distance + 1, edges, distances, visited);
    }

    private void dfs(int node, int distance, int[] edges, int[] distances) {
        if (node == -1 || distances[node] != -1) {
            return;
        }

        distances[node] = distance;
        dfs(edges[node], distance + 1, edges, distances);
    }
}
