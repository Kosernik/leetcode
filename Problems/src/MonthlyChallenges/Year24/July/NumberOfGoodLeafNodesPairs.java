package MonthlyChallenges.Year24.July;

import Utils.TreeNode;

public class NumberOfGoodLeafNodesPairs {
    private int distance;

    private int pairs = 0;

    /**
     * LeetCode №1530. Number of Good Leaf Nodes Pairs.
     * <p>
     * Complexity - O(N)
     * Memory - O(D), D = distance.
     * <p>
     * A pair of two different leaf nodes of a binary tree is said to be good if the length of the shortest path between
     * them is less than or equal to distance.
     *
     * @param root     - a root of a binary tree.
     * @param distance - the maximum distance between leafs.
     * @return - the number of good leaf node pairs in the tree.
     */
    public int countPairs(TreeNode root, int distance) {
        if (distance == 1) return 0;
        this.distance = distance;

        postOrder(root);

        return pairs;
    }

    private int[] postOrder(TreeNode root) {
        int[] distances = new int[distance];
        if (root == null) {
            return distances;
        }
        if (root.left == null && root.right == null) {
            distances[1] = 1;
            return distances;
        }

        int[] left = postOrder(root.left);
        int[] right = postOrder(root.right);

        for (int i = 1; i < distance; i++) {
            int leftNodes = left[i];
            if (leftNodes == 0) continue;

            for (int j = distance - i; j >= 1; j--) {
                int rightNodes = right[j];
                if (rightNodes == 0) continue;
                pairs += leftNodes * rightNodes;
            }
        }

        for (int i = 1; i < distance; i++) {
            distances[i] = left[i - 1] + right[i - 1];
        }

        return distances;
    }
}
