package MonthlyChallenges.Year23.March;

import java.util.HashMap;
import java.util.Map;

public class LongestCycleInGraph {
    public static void main(String[] args) {
        LongestCycleInGraph solution = new LongestCycleInGraph();

        int[] test0 = {3, 3, 4, 2, 3};
        System.out.println(solution.longestCycle(test0));

        int[] test1 = {2, -1, 3, 1};
        System.out.println(solution.longestCycle(test1));
    }

    /**
     * LeetCode #2360. Longest Cycle in a Graph.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param edges - an array of destinations for edges from nodes, if edges[i] = -1 - there is no outgoing edge from
     *              node 'i'. Each node has at most one outgoing edge.
     * @return - the length of the longest cycle. If there is no cycle returns -1.
     */
    public int longestCycle(int[] edges) {
        int result = -1;
        boolean[] visited = new boolean[edges.length];

        for (int i = 0; i < edges.length; i++) {
            if (visited[i]) continue;

            int curLength = 0;
            int node = i;
            Map<Integer, Integer> orderOfVisits = new HashMap<>();

            while (node != -1) {
                if (orderOfVisits.containsKey(node)) {
                    result = Math.max(result, curLength - orderOfVisits.get(node));
                    break;
                }
                if (visited[node]) break;
                visited[node] = true;

                orderOfVisits.put(node, curLength);
                node = edges[node];
                curLength++;
            }
        }

        return result;
    }
}
