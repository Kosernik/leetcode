package Problems;

import Utils.TreeNode;

public class LowestCommonAncestorOfABinaryTree {

    /**
     * LeetCode #236. Lowest Common Ancestor of a Binary Tree.
     *
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param root - a root of a binary tree.
     * @param p - a node in a binary tree.
     * @param q - a node in a binary tree.
     * @return - the lowest common ancestor of 'p' and 'q' in a tree.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        else if (root == p) return p;
        else if (root == q) return q;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if ((left == p && right == q) || (left == q && right == p)) {
            return root;
        }
        else if ((left == p || right == q) || (left == q || right == p)) {
            if (left == p || left == q) return left;
            else return right;
        }
        else if (left != null) {
            return left;
        } else if (right != null) {
            return right;
        }

        return null;
    }
}
