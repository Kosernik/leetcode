package MonthlyChallenges.Year22.October;

import Utils.TreeNode;

import java.util.ArrayDeque;

public class AddOneRowToTree {

    /**
     * LeetCode #623. Add One Row to Tree.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param root  - a root of a binary tree.
     * @param val   - the value for all new nodes.
     * @param depth - the required depth for all new nodes.
     * @return - the tree after inserting all new nodes at the required depth.
     */
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (root == null) return root;
        if (depth == 1) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }

        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        for (int i = depth - 2; i > 0; i--) {
            for (int size = queue.size(); size > 0; size--) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }

        if (queue.isEmpty()) return root;

        for (TreeNode node : queue) {
            TreeNode leftChild = new TreeNode(val);
            leftChild.left = node.left;
            node.left = leftChild;

            TreeNode rightChild = new TreeNode(val);
            rightChild.right = node.right;
            node.right = rightChild;
        }

        return root;
    }
}
