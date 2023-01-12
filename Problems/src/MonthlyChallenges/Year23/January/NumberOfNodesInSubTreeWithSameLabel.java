package MonthlyChallenges.Year23.January;

import java.util.*;

public class NumberOfNodesInSubTreeWithSameLabel {
    public static void main(String[] args) {
        NumberOfNodesInSubTreeWithSameLabel solution = new NumberOfNodesInSubTreeWithSameLabel();
        int test3n = 4;
        int[][] test3edges = {{0, 2}, {0, 3}, {1, 2}};
        String test3Labels = "aeed";

        System.out.println(Arrays.toString(solution.countSubTrees(test3n, test3edges, test3Labels)));
    }

    private int[] result = null;

    /**
     * LeetCode #1519. Number of Nodes in the Sub-Tree With the Same Label.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param n      - the total number of nodes in a tree.
     * @param edges  - an array of edges in a tree.
     * @param labels - a string representing values of each node.
     * @return - an array of size n where ans[i] is the number of nodes in the subtree of the 'i'-th node which have the
     * same label as node 'i'.
     */
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        this.result = new int[n];
        Arrays.fill(this.result, 1);

        TreeNode root = buildTree(n, edges, labels);
        postOrderTraversal(root, null);

        return this.result;
    }

    private int[] postOrderTraversal(TreeNode node, TreeNode parent) {
        int[] counts = new int[26];

        for (TreeNode child : node.children) {
            if (child == parent) continue;
            int[] childCount = postOrderTraversal(child, node);
            addCounts(counts, childCount);
        }

        counts[node.value - 'a']++;
        this.result[node.number] = counts[node.value - 'a'];
        return counts;
    }

    private void addCounts(int[] target, int[] source) {
        for (int i = 0; i < target.length; i++) {
            target[i] += source[i];
        }
    }

    private TreeNode buildTree(int n, int[][] edges, String labels) {
        char[] values = labels.toCharArray();
        Map<Integer, TreeNode> nodes = new HashMap<>();
        for (int i = 0; i < n; i++) {
            nodes.put(i, new TreeNode(i, values[i]));
        }

        for (int[] edge : edges) {
            nodes.get(edge[0]).addChildren(nodes.get(edge[1]));
            nodes.get(edge[1]).addChildren(nodes.get(edge[0]));
        }

        return nodes.get(0);
    }

    class TreeNode {
        char value;
        int number;
        List<TreeNode> children = new ArrayList<>();

        TreeNode(int number, char value) {
            this.number = number;
            this.value = value;
        }

        void addChildren(TreeNode child) {
            this.children.add(child);
        }
    }
}
