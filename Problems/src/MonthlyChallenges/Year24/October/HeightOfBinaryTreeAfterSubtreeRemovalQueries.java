package MonthlyChallenges.Year24.October;

import Utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class HeightOfBinaryTreeAfterSubtreeRemovalQueries {
    Map<Integer, Integer> depths;
    Map<Integer, TreeNode> parents;

    /**
     * LeetCode №2458. Height of Binary Tree After Subtree Removal Queries.
     * <p>
     * Complexity - O(N + M*N), N = the number of nodes in a tree, M = queries.length.
     * Memory - O(N)
     *
     * @param root    - a root of a binary tree.
     * @param queries - a query array of node values to delete from the tree. Each query is independent. The root of
     *                the tree is never in queries.
     * @return - an array result of heights. result[i] is the height of the tree after performing the i-th query.
     */
    public int[] treeQueries(TreeNode root, int[] queries) {
        int[] result = new int[queries.length];

        depths = new HashMap<>();
        parents = new HashMap<>();

        int fullDepth = computeDepths(root);

        for (int i = 0; i < queries.length; i++) {
            int treeDepth;

            int nodeToDelete = queries[i];

            int nodeDepth = depths.get(nodeToDelete);
            TreeNode parent = parents.get(nodeToDelete);

            if (depths.get(parent.val) > (nodeDepth + 1)) {
                result[i] = fullDepth;
                continue;
            }
            int siblingDepth;
            if (parent.left != null && parent.left.val != nodeToDelete) {
                siblingDepth = depths.get(parent.left.val);
            } else if (parent.right != null && parent.right.val != nodeToDelete) {
                siblingDepth = depths.get(parent.right.val);
            } else {
                siblingDepth = -1;
            }

            int updatedParentDepth = siblingDepth + 1;
            if (updatedParentDepth == depths.get(parent.val)) {
                result[i] = fullDepth;
                continue;
            }

            while (parent != root && depths.get(parent.val).intValue() != updatedParentDepth) {
                TreeNode nextParent = parents.get(parent.val);
                int otherDepth;
                if (nextParent.left != null && nextParent.left != parent) {
                    otherDepth = depths.get(nextParent.left.val);
                } else if (nextParent.right != null && nextParent.right != parent) {
                    otherDepth = depths.get(nextParent.right.val);
                } else {
                    otherDepth = -1;
                }

                updatedParentDepth = Math.max(otherDepth, updatedParentDepth) + 1;
                parent = nextParent;
            }
            if (parent == root) {
                treeDepth = updatedParentDepth;
            } else {
                treeDepth = fullDepth;
            }

            result[i] = treeDepth;
        }

        return result;
    }

    private int computeDepths(TreeNode root) {
        int leftDepth;
        if (root.left != null) {
            leftDepth = computeDepths(root.left);
            parents.put(root.left.val, root);
        } else {
            leftDepth = -1;
        }

        int rightDepth;
        if (root.right != null) {
            rightDepth = computeDepths(root.right);
            parents.put(root.right.val, root);
        } else {
            rightDepth = -1;
        }

        int curDepth = Math.max(leftDepth, rightDepth) + 1;
        depths.put(root.val, curDepth);
        return curDepth;
    }
}
