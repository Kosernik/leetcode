package MonthlyChallenges.February21;

import java.util.ArrayDeque;

public class IsGraphBipartite {
    /**
     * LeetCode #785.
     *
     * Checks if given graph is bipartite.
     *
     * Complexity O(N^2)
     * memory - O(N^2)
     *
     * @param graph - 2d array representing edges from each vertex.
     * @return - true - if a graph is bipartite, false - otherwise.
     */
    public boolean isBipartite(int[][] graph) {
        if (graph.length == 1) return true;

        int[] redBlack = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (redBlack[i] == 0) {
                redBlack[i] = -1;
                if (!isBipartiteHelper(graph, i, redBlack)) return false;
            }
        }

        return true;
    }

    private boolean isBipartiteHelper (int[][] graph, int vertex, int[] redBlack) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offerLast(vertex);

        while (!queue.isEmpty()) {
            int currV = queue.removeFirst();

            for (int n : graph[currV]) {
                if (redBlack[currV] == redBlack[n]) return false;
                else if(redBlack[n] == 0) {
                    redBlack[n] = -redBlack[currV];
                    queue.offerLast(n);
                }
            }
        }
        return true;
    }

}
