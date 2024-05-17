package MonthlyChallenges.Year24.May;

import Utils.TreeNode;

public class DeleteLeavesWithGivenValue {

    /**
     * LeetCode №1325. Delete Leaves With a Given Value.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param root   - a root of a binary tree.
     * @param target - a value to be deleted.
     * @return - the root of a tree after deleting all the leaf nodes with value 'target'.
     */
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) return null;

        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);

        if (root.val == target && root.left == null && root.right == null) {
            return null;
        } else {
            return root;
        }
    }
}
