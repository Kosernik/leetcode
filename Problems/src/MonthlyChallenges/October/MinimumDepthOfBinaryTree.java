package MonthlyChallenges.October;

import Utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinimumDepthOfBinaryTree {

    /**
     * Returns the minimum depth of a binary tree.
     * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
     *
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param root of a binary tree, can be null.
     * @return - minimum depth of a given binary tree.
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        int result = 1;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offerLast(root);

        while (!stack.isEmpty()) {
            for (int i = 0, length = stack.size(); i < length; i++) {
                TreeNode currNode = stack.pollFirst();
                if (currNode.left == null && currNode.right == null) {
                    return result;
                } else {
                    if (currNode.left != null) {
                        stack.offerLast(currNode.left);
                    }
                    if (currNode.right != null) {
                        stack.offerLast(currNode.right);
                    }
                }
            }

            result++;
        }

        return result;
    }
}
