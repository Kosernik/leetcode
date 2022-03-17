package Problems;

import java.util.*;

public class ShortestPathWithAlternatingColors {

    /**
     * LeetCode #1129. Shortest Path with Alternating Colors.
     *
     * Complexity - O(N*M), N = n, M = total number of edges.
     * Memory - O(M)
     *
     * @param n - the number of vertices in a graph
     * @param redEdges - an array of directed red edges.
     * @param blueEdges - an array of directed blue edges.
     * @return - an array of lengths of the shortest paths from 0-node to i-th node.
     */
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int[] result = new int[n];
        result[0] = 1;

        Map<Integer, Set<Integer>> redConnections = getConnections(redEdges);
        Map<Integer, Set<Integer>> blueConnections = getConnections(blueEdges);

        for (int i = 1; i < n; i++) {
            result[i] = bfs(i, redConnections, blueConnections);
        }

        return result;
    }

    private int bfs( int target,
                    Map<Integer, Set<Integer>> redConnections, Map<Integer, Set<Integer>> blueConnections) {

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offerLast(new int[]{0, 1});
        queue.offerLast(new int[]{0, -1});

        Set<String> visited = new HashSet<>();
        visited.add(0 + "*" + 1);
        visited.add(0 + "*" + (-1));

        int length = 0;
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                int[] curNodePair = queue.removeFirst();
                int curNode = curNodePair[0];
                int curColour = curNodePair[1];

                if (curNode == target) return length;

                // Getting edges of the opposite colour of curColour
                Map<Integer, Set<Integer>> connections = curColour == 1 ? redConnections : blueConnections;
                Set<Integer> neighbours = connections.get(curNode);
                if (neighbours == null) continue;

                for (int neighbour : neighbours) {
                    if (!visited.contains(neighbour + "*" + (-curColour))) {
                        queue.offerLast(new int[] {neighbour, -curColour});
                        visited.add(neighbour + "*" + (-curColour));
                    }
                }
            }
            length++;
        }

        return -1;
    }

    private Map<Integer, Set<Integer>> getConnections(int[][] edges) {
        Map<Integer, Set<Integer>> connections = new HashMap<>();

        for (int[] edge : edges) {
            Set<Integer> curList = connections.getOrDefault(edge[0], new HashSet<>());
            curList.add(edge[1]);
            connections.put(edge[0], curList);
        }

        return connections;
    }
}
