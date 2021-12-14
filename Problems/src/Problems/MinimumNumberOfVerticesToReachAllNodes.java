package Problems;

import java.util.ArrayList;
import java.util.List;

public class MinimumNumberOfVerticesToReachAllNodes {

    /**
     * LeetCode #1557. Minimum Number of Vertices to Reach All Nodes.
     *
     * Complexity - O(N + n), N = edges.size(), n = n.
     * Memory - O(n)
     * @param n - the number of vertices.
     * @param edges - a list of edges in a directed graph.
     * @return - the smallest set of vertices from which all nodes in the graph are reachable.
     */
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] countInConnections = new int[n];

        for (List<Integer> edge : edges) {
            countInConnections[edge.get(1)]++;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < countInConnections.length; i++) {
            if (countInConnections[i] == 0) result.add(i);
        }
        return result;
    }
}
