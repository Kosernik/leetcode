package Problems;

import Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    /**
     * LeetCode #257. Binary Tree Paths.
     *
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param root - a root of a binary tree.
     * @return - a list of all root-to-leaf paths.
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;
        dfs(root, String.valueOf(root.val), result, "->");
        return result;
    }

    private void dfs(TreeNode node, String path, List<String> paths, String delimiter) {
        if (node.left == null && node.right == null) {
            paths.add(path);
        } else {
            if (node.left != null) {
                dfs(node.left, path + delimiter + node.left.val, paths, delimiter);
            }
            if (node.right != null) {
                dfs(node.right, path + delimiter + node.right.val, paths, delimiter);
            }
        }
    }
}
