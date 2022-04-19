package MonthlyChallenges.Year22.April;

import Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class RecoverBinarySearchTree {

    /**
     * LeetCode #99. Recover Binary Search Tree.
     *
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param root - a root of a BST where the values of exactly two nodes of the tree were swapped by mistake.
     */
    public void recoverTree(TreeNode root) {
        List<TreeNode> inorder = new ArrayList<>();
        inorderTraversal(root, inorder);

        int idx = 0;
        TreeNode first = null;
        for (;idx < inorder.size()-1; idx++) {
            if (inorder.get(idx).val > inorder.get(idx+1).val) {
                first = inorder.get(idx++);
                break;
            }
        }
        if (first == null) return;

        TreeNode second = null;
        for (; idx < inorder.size(); idx++) {
            TreeNode node = inorder.get(idx);
            if (second == null || (second.val > node.val)) {
                second = node;
            }
        }

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorderTraversal(TreeNode root, List<TreeNode> inorder) {
        if (root == null) return;

        inorderTraversal(root.left, inorder);

        inorder.add(root);

        inorderTraversal(root.right, inorder);
    }
}
