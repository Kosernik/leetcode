package MonthlyChallenges.Year25.February;

import java.util.*;

public class MostProfitablePathInTree {
    public static void main(String[] args) {
        MostProfitablePathInTree solution = new MostProfitablePathInTree();

        int[][] edges0 = {{0, 1}, {1, 2}, {1, 3}, {3, 4}};
        int bob0 = 3;
        int[] amount0 = {-2, 4, 2, -4, 6};
        int result0 = 6;
        System.out.println(solution.mostProfitablePath(edges0, bob0, amount0) == result0);
        System.out.println();

        int[][] edges1 = {{0, 1}, {1, 2}, {1, 3}, {3, 4}};
        int bob1 = 1;
        int[] amount1 = {-2, 4, 2, -4, 6};
        int result1 = 0;
        System.out.println(solution.mostProfitablePath(edges1, bob1, amount1) == result1);
        System.out.println();

        int[][] edges2 = {{0, 1}, {1, 2}, {2, 3}};
        int bob2 = 3;
        int[] amount2 = {-5644, -6018, 1188, -8502};
        int result2 = -11662;
        System.out.println(solution.mostProfitablePath(edges2, bob2, amount2) == result2);
        System.out.println();
    }

    /**
     * LeetCode №2467. Most Profitable Path in a Tree.
     *
     * @param edges  - an array of edges in a tree.
     * @param bob    - the starting node of Bob.
     * @param amount - an array representing prices to unlock nodes.
     * @return - the maximum net income Alice can have if she travels towards the optimal leaf node.
     */
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        Map<Integer, Set<Integer>> graph = buildGraph(edges);

        List<Integer> bobsPath = getPathToRoot(bob, graph);

        for (int i = Math.ceilDiv(bobsPath.size(), 2); i < bobsPath.size(); i++) {
            amount[bobsPath.get(i)] = 0;
        }
        if (bobsPath.size() % 2 == 1) {
            amount[bobsPath.get(bobsPath.size() / 2)] /= 2;
        }

        return getMaxProfit(graph, amount);
    }

    private int getMaxProfit(Map<Integer, Set<Integer>> graph, int[] amount) {
        int maxProfit = Integer.MIN_VALUE;

        Deque<int[]> queue = new ArrayDeque<>();
        queue.offerFirst(new int[]{0, amount[0]});
        Set<Integer> visited = new HashSet<>();
        visited.add(0);

        while (!queue.isEmpty()) {
            int[] node = queue.removeFirst();

            Set<Integer> neighbours = graph.get(node[0]);

            if (neighbours.size() == 1 && node[0] != 0) {
                maxProfit = Math.max(maxProfit, node[1]);
            }

            for (int neighbour : neighbours) {
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    queue.offerLast(new int[]{neighbour, node[1] + amount[neighbour]});
                }
            }
        }

        return maxProfit;
    }

    private List<Integer> getPathToRoot(int start, Map<Integer, Set<Integer>> graph) {
        Map<Integer, Integer> paths = new HashMap<>();

        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        Set<Integer> visited = new HashSet<>();
        visited.add(start);

        while (!queue.isEmpty()) {
            int node = queue.removeFirst();
            if (node == 0) {
                break;
            }

            for (int neighbour : graph.get(node)) {
                if (visited.contains(neighbour)) continue;

                visited.add(neighbour);
                queue.offerLast(neighbour);
                paths.put(neighbour, node);
            }
        }

        List<Integer> path = new ArrayList<>();
        int node = 0;

        while (node != start) {
            path.add(node);
            node = paths.get(node);
        }

        path.add(start);
        return path;
    }

    private Map<Integer, Set<Integer>> buildGraph(int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();

        for (int i = 0; i < edges.length + 1; i++) {
            graph.put(i, new HashSet<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        return graph;
    }
}
