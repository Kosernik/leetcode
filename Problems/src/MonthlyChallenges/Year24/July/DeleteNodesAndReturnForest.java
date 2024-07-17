package MonthlyChallenges.Year24.July;

import Utils.TreeNode;

import java.util.*;

public class DeleteNodesAndReturnForest {

    /**
     * LeetCode №1110. Delete Nodes And Return Forest.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param root      - a root of a binary tree with all node values distinct.
     * @param to_delete - an array of values of nodes to be deleted.
     * @return - a list of the roots of the trees in the remaining forest.
     */
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Map<Integer, TreeNode> forest = new HashMap<>();
        forest.put(root.val, root);

        Set<Integer> toDelete = new HashSet<>();
        for (int node : to_delete) {
            toDelete.add(node);
        }

        deleteNodes(root, toDelete, forest);

        return new ArrayList<>(forest.values());
    }

    private void deleteNodes(TreeNode root, Set<Integer> toDelete, Map<Integer, TreeNode> forest) {
        if (toDelete.contains(root.val)) {
            forest.remove(root.val);
            if (root.left != null) {
                forest.put(root.left.val, root.left);
            }
            if (root.right != null) {
                forest.put(root.right.val, root.right);
            }
        }

        if (root.left != null) {
            TreeNode left = root.left;
            if (toDelete.contains(root.left.val)) {
                root.left = null;
            }
            deleteNodes(left, toDelete, forest);
        }

        if (root.right != null) {
            TreeNode right = root.right;
            if (toDelete.contains(root.right.val)) {
                root.right = null;
            }
            deleteNodes(right, toDelete, forest);
        }
    }
}
