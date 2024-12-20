package MonthlyChallenges.Year24.December;

import Utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReverseOddLevelsOfBinaryTree {

    /**
     * LeetCode №2415. Reverse Odd Levels of Binary Tree.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param root - a root of a perfect binary tree.
     * @return - the given tree after reversing the node values at each odd level of the tree.
     */
    public TreeNode reverseOddLevels(TreeNode root) {
        Deque<TreeNode> treeLevel = new ArrayDeque<>();
        treeLevel.offer(root);
        boolean odd = false;

        while (!treeLevel.isEmpty()) {
            Deque<TreeNode> nextLevel = new ArrayDeque<>();

            for (TreeNode node : treeLevel) {
                if (node.left != null) nextLevel.offerLast(node.left);
                if (node.right != null) nextLevel.offerLast(node.right);
            }

            if (odd) {
                while (!treeLevel.isEmpty()) {
                    TreeNode left = treeLevel.removeFirst();
                    TreeNode right = treeLevel.removeLast();

                    int temp = left.val;
                    left.val = right.val;
                    right.val = temp;
                }
            }

            odd = !odd;
            treeLevel = nextLevel;
        }

        return root;
    }
}
