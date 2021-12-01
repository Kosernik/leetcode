package Problems;

import Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SubtreeOfAnotherTree {

    /**
     * LeetCode #572. Subtree of Another Tree.
     *
     * Complexity - O(N*M), N - the size of "root", M - the size of "subTree"
     * Memory - O(1)
     *
     * @param root - a root of a binary tree.
     * @param subRoot - a root of a binary tree.
     * @return - True - if "subRoot" is a sub root of "root". False - otherwise.
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        else if (root == null || subRoot == null) return false;

        if (root.val != subRoot.val) return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        return isSameTree(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode root, TreeNode node) {
        if (root == null && node == null) return true;
        else if (root == null || node == null) return false;
        return root.val == node.val && isSameTree(root.left, node.left) && isSameTree(root.right, node.right);
    }
}
