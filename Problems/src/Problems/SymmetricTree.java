package Problems;

import Utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class SymmetricTree {

    /**
     * LeetCode #101. Symmetric Tree.
     *
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param root - a root of a binary tree.
     * @return - True - if a tree is symmetric around its center, false - otherwise.
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        else if (root.left == null && root.right == null) return true;
        else if (root.left == null || root.right == null) return false;

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offerFirst(root.left);
        deque.offerLast(root.right);

        while (!deque.isEmpty()) {
            Deque<TreeNode> nextLevel = new ArrayDeque<>();

            for (int i = 0, length = deque.size(); i < length; i+=2) {
                TreeNode left = deque.removeFirst();
                TreeNode right = deque.removeLast();

                if (left.val != right.val) return false;

                if (left.left != null && right.right != null) {
                    nextLevel.offerFirst(left.left);
                    nextLevel.offerLast(right.right);
                }
                else if (left.left != null || right.right != null) return false;

                if (left.right != null && right.left != null) {
                    nextLevel.offerFirst(left.right);
                    nextLevel.offerLast(right.left);
                }
                else if (left.right != null || right.left != null) return false;
            }

            deque = nextLevel;
        }

        return true;
    }
}
