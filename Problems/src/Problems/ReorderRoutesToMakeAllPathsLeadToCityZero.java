package Problems;

import java.util.*;

public class ReorderRoutesToMakeAllPathsLeadToCityZero {

    /**
     * LeetCode #1466. Reorder Routes to Make All Paths Lead to the City Zero.
     *
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param n - the number of vertices in a graph.
     * @param connections - an array of directed edges in a graph. connections.length = n-1.
     * @return - the minimum number of reorders such that each path in a graph would lead to vertex 0.
     */
    public int minReorder(int n, int[][] connections) {
        int numberOfReorders = 0;

        ArrayDeque<Integer> safeNodes = new ArrayDeque<>();
        safeNodes.offerLast(0);
        Set<Integer> visited = new HashSet<>();
        visited.add(0);

        Map<Integer, List<Integer>> roadsFrom = new HashMap<>();
        Map<Integer, List<Integer>> roadsTo = new HashMap<>();

        for (int[] connection : connections) {
            List<Integer> curListFrom = roadsFrom.getOrDefault(connection[0], new ArrayList<>());
            curListFrom.add(connection[1]);
            roadsFrom.put(connection[0], curListFrom);

            List<Integer> curListTo = roadsTo.getOrDefault(connection[1], new ArrayList<>());
            curListTo.add(connection[0]);
            roadsTo.put(connection[1], curListTo);
        }

        while (!safeNodes.isEmpty()) {
            int node = safeNodes.removeFirst();

            for (int neighbour : roadsFrom.getOrDefault(node, new ArrayList<>())) {
                if (!visited.contains(neighbour)) {
                    numberOfReorders++;
                    safeNodes.offerLast(neighbour);
                    visited.add(neighbour);
                }
            }

            for (int neighbour : roadsTo.getOrDefault(node, new ArrayList<>())) {
                if (!visited.contains(neighbour)) {
                    safeNodes.offerLast(neighbour);
                    visited.add(neighbour);
                }
            }
        }

        return numberOfReorders;
    }
}
