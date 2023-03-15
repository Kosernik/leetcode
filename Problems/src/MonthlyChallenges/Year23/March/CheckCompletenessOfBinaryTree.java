package MonthlyChallenges.Year23.March;

import Utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class CheckCompletenessOfBinaryTree {

    /**
     * LeetCode #958. Check Completeness of a Binary Tree.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param root - a root of a binary tree.
     * @return - True - is the tree is complete, false - otherwise.
     */
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        int width = 1;

        while (!deque.isEmpty()) {
            boolean foundNull = false;
            Deque<TreeNode> nextLevel = new ArrayDeque<>();
            int curWidth = deque.size();

            for (int i = curWidth; i > 0; i--) {
                TreeNode node = deque.removeFirst();

                if (node.left != null) {
                    if (foundNull) return false;
                    nextLevel.offerLast(node.left);
                } else {
                    foundNull = true;
                }
                if (node.right != null) {
                    if (foundNull) return false;
                    nextLevel.offerLast(node.right);
                } else {
                    foundNull = true;
                }
            }

            if (!nextLevel.isEmpty() && curWidth != width) {
                return false;
            }

            width *= 2;
            deque = nextLevel;
        }
        return true;
    }
}
