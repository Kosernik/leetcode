package MonthlyChallenges.Year22.July;

import Utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class FlattenBinaryTreeToLinkedList {

    /**
     * LeetCode #114. Flatten Binary Tree to Linked List.
     *
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param root - a root of a binary tree. May be null.
     */
    public void flatten(TreeNode root) {
        if (root == null) return;

        List<TreeNode> preorderList = preorder(root);
        int length = preorderList.size();
        int lastIdx = length - 1;

        for (int i = 0; i < length; i++) {
            TreeNode node = preorderList.get(i);
            node.left = null;

            node.right = i < lastIdx ? preorderList.get(i + 1) : null;
        }
    }

    private List<TreeNode> preorder(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return result;
    }
}
