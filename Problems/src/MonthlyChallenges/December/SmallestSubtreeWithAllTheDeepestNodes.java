package MonthlyChallenges.December;

import Utils.TreeNode;

import java.util.Map;

public class SmallestSubtreeWithAllTheDeepestNodes {

    /**
     * LeetCode #865/1123.
     *
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param root - root of a binary tree.
     * @return - smallest subtree with all the deepest nodes.
     */
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        Pair res = helper(root);

        return res.node;
    }

    private Pair helper(TreeNode root) {
        if (root == null) {
            return new Pair(null, 0);
        } else {
            Pair left = helper(root.left);
            Pair right = helper(root.right);

            if (left.depth == right.depth) {
                return new Pair(root, left.depth+1);
            } else if (left.depth > right.depth) {
                return new Pair(left.node, left.depth+1);
            } else {
                return new Pair(right.node, right.depth+1);
            }
        }
    }

    private class Pair {
        TreeNode node;
        int depth;
        Pair(TreeNode n, int d) {
            node = n;
            depth = d;
        }
    }
}