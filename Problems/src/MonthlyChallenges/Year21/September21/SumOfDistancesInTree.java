package MonthlyChallenges.Year21.September21;


import java.util.*;

public class SumOfDistancesInTree {
    public static void main(String[] args) {
        SumOfDistancesInTree solution = new SumOfDistancesInTree();

        int[][] test0 = {{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}};
        System.out.println(Arrays.toString(solution.sumOfDistancesInTree(6, test0)));
    }


    /**
     * LeetCode #834. Sum of Distances in Tree.
     * <p>
     * Complexity - O(N)
     * Memory O(N)
     *
     * @param n     - number of nodes in the tree.
     * @param edges - an array of edges of the tree, where edges[i] = [Ai, Bi] indicates that there is an edge between
     *              nodes Ai and Bi in the tree.
     * @return - an array of distances from each node to every other none in the tree.
     */
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++) tree.add(new ArrayList<>());

        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }

        int[] result = new int[n];
        int[] nodesCount = new int[n];
        Arrays.fill(nodesCount, 1);

        postOrder(-1, 0, tree, result, nodesCount);
        preOrder(-1, 0, tree, result, nodesCount);

        return result;
    }

    private void postOrder(int parent, int node, List<List<Integer>> tree, int[] result, int[] nodesCount) {
        for (int neighbor : tree.get(node)) {
            if (neighbor != parent) {
                postOrder(node, neighbor, tree, result, nodesCount);

                nodesCount[node] += nodesCount[neighbor];
                result[node] += result[neighbor] + nodesCount[neighbor];
            }
        }
    }

    private void preOrder(int parent, int node, List<List<Integer>> tree, int[] result, int[] nodesCount) {
        for (int neighbor : tree.get(node)) {
            if (neighbor != parent) {
                result[neighbor] = result[node] - nodesCount[neighbor] * 2 + result.length;

                preOrder(node, neighbor, tree, result, nodesCount);
            }
        }
    }
}
