package Problems;

import Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal {

    /**
     * LeetCode #145. Binary Tree Postorder Traversal.
     *
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param root - a root of a binary tree.
     * @return - a list of the values of all nodes of a tree.
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<Integer> result = new ArrayList<>();
        postorder(root, result);

        return result;
    }

    private void postorder(TreeNode root, List<Integer> result) {
        if (root == null) return;

        postorder(root.left, result);
        postorder(root.right, result);

        result.add(root.val);
    }
}
