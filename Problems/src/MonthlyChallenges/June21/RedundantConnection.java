package MonthlyChallenges.June21;

import java.util.*;

public class RedundantConnection {
    //  [[1,2],[2,3],[3,4],[1,4],[1,5]]
    //  [[1,2],[2,3],[3,4],[1,5],[1,4]]
    //  [[2,3],[3,4],[1,4],[1,5],[1,2]]
    //  [[1,2],[2,3],[4,5],[4,6],[3,4],[5,6]]
    public static void main(String[] args) {
        RedundantConnection solution = new RedundantConnection();

        int[][] test0 = {{1,2},{2,3},{4,5},{4,6},{3,4},{5,6}};
        System.out.println(Arrays.toString(solution.findRedundantConnection(test0)));

        int[][] test1 = {{3,4},{1,2},{2,4},{3,5},{2,5}};
        System.out.println(Arrays.toString(solution.findRedundantConnection(test1)));
    }

    /**
     * LeetCode #684.
     *
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param edges - an array of edges in a connected graph.
     * @return - an edge that can be removed so that the resulting graph is a tree of n nodes.
     */
    public int[] findRedundantConnection(int[][] edges) {
        int[] parents = new int[edges.length+1];

        Map<Integer, Set<Integer>> connections = new HashMap<>();
        for (int[] edge : edges) {
            if (parents[edge[0]] != 0 && parents[edge[0]] == parents[edge[1]]) return edge;

            if (parents[edge[0]] == 0 && parents[edge[1]] == 0) {
                parents[edge[0]] = edge[0];
                parents[edge[1]] = edge[0];

                Set<Integer> set = new HashSet<>();
                set.add(edge[1]);
                connections.put(edge[0], set);
            }
            else if (parents[edge[0]] != 0 && parents[edge[1]] == 0) {
                parents[edge[1]] = parents[edge[0]];

                Set<Integer> set = connections.get(parents[edge[0]]);
                set.add(edge[1]);
            }
            else if (parents[edge[0]] == 0 && parents[edge[1]] != 0) {
                parents[edge[0]] = parents[edge[1]];

                Set<Integer> set = connections.get(parents[edge[1]]);
                set.add(edge[0]);
            }
            else {
                int key = parents[edge[1]];
                int newKey = parents[edge[0]];
                parents[key] = newKey;
                Set<Integer> oldSet = connections.get(key);
                Set<Integer> set = connections.get(newKey);
                set.add(key);

                for (int p : oldSet) {
                    parents[p] = newKey;
                    set.add(p);
                }
            }
        }
        return edges[0];
    }
}
