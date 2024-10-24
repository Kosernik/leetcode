package MonthlyChallenges.Year24.October;

import Utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class FlipEquivalentBinaryTrees {

    /**
     * LeetCode №951. Flip Equivalent Binary Trees.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param root1 - a root of a binary tree.
     * @param root2 - a root of a binary tree.
     * @return - true if the two trees are flip equivalent or false otherwise.
     */
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        else if (root1 == null || root2 == null) return false;
        else if (root1.val != root2.val) return false;

        Deque<TreeNode[]> queue = new ArrayDeque<>();
        queue.offer(new TreeNode[]{root1, root2});

        while (!queue.isEmpty()) {
            TreeNode[] pair = queue.poll();
            TreeNode first = pair[0];
            TreeNode second = pair[1];

            if (first.left == null && first.right == null) {
                if (second.left != null || second.right != null) {
                    return false;
                }
            } else if (first.left != null && first.right != null) {
                if (second.left == null || second.right == null) {
                    return false;
                } else {
                    if (first.left.val == second.left.val) {
                        if (first.right.val != second.right.val) {
                            return false;
                        }

                        //  NO SWAP
                        queue.offer(new TreeNode[]{first.left, second.left});
                        queue.offer(new TreeNode[]{first.right, second.right});
                    } else {
                        if ((first.left.val != second.right.val) || (first.right.val != second.left.val)) {
                            return false;
                        }

                        //  SWAP
                        queue.offer(new TreeNode[]{first.left, second.right});
                        queue.offer(new TreeNode[]{first.right, second.left});
                    }
                }
            } else {    //  one child is null
                if (first.left == null) {
                    if (second.left == null) {
                        if ((second.right == null) || (first.right.val != second.right.val)) {
                            return false;
                        }

                        //  NO SWAP
                        queue.offer(new TreeNode[]{first.right, second.right});
                    } else {
                        if (second.right != null || first.right.val != second.left.val) {
                            return false;
                        }

                        //  SWAP
                        queue.offer(new TreeNode[]{first.right, second.left});
                    }
                } else {    //  first.right == null
                    if (second.left == null) {
                        if (second.right == null || first.left.val != second.right.val) {
                            return false;
                        }

                        //  SWAP
                        queue.offer(new TreeNode[]{first.left, second.right});
                    } else {
                        if (second.right != null || first.left.val != second.left.val) {
                            return false;
                        }

                        //  NO SWAP
                        queue.offer(new TreeNode[]{first.left, second.left});
                    }
                }
            }
        }

        return true;
    }
}
