package Problems;

import Utils.TreeNode;

import java.util.*;

public class BinaryTreePreorderTraversal {

    /**
     * LeetCode #144. Binary Tree Preorder Traversal.
     *
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param root - a root of a binary tree.
     * @return - a list of the values of all nodes of a tree after preorder traversal.
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);

            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }

        return result;
    }
}
