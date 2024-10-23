package MonthlyChallenges.Year24.October;

import Utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class CousinsInBinaryTreeII {

    /**
     * LeetCode №2641. Cousins in Binary Tree II.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param root - a root of a binary tree.
     * @return - the root of a binary tree, after replacing the value of each node in the tree with the sum of all its
     * cousins' values. Two nodes of a binary tree are cousins if they have the same depth with different parents.
     */
    public TreeNode replaceValueInTree(TreeNode root) {
        if (root == null) return root;
        root.val = 0;

        Deque<TreeNode[]> queue = new ArrayDeque<>();
        queue.offer(new TreeNode[]{root.left, root.right});

        while (!queue.isEmpty()) {
            long sum = 0L;

            for (TreeNode[] pair : queue) {
                if (pair[0] != null) sum += pair[0].val;
                if (pair[1] != null) sum += pair[1].val;
            }

            for (int i = queue.size(); i > 0; i--) {
                TreeNode[] pair = queue.removeFirst();
                TreeNode left = pair[0];
                TreeNode right = pair[1];

                int pairSum = 0;
                if (left != null) pairSum += left.val;
                if (right != null) pairSum += right.val;

                int pairVal = (int) (sum - pairSum);

                if (left != null) {
                    left.val = pairVal;

                    TreeNode[] next = new TreeNode[]{left.left, left.right};
                    queue.offerLast(next);
                }

                if (right != null) {
                    right.val = pairVal;

                    TreeNode[] next = new TreeNode[]{right.left, right.right};
                    queue.offerLast(next);
                }
            }
        }

        return root;
    }
}
