package MonthlyChallenges.Year22.June;

import Utils.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class BinaryTreeCameras {
    public static void main(String[] args) {
        BinaryTreeCameras solution = new BinaryTreeCameras();

        TreeNode root = new TreeNode(0);
        TreeNode lft = new TreeNode(1);
        TreeNode rgt = new TreeNode(2);
        root.left = lft;
        root.right = rgt;

        System.out.println("Solution is: " + solution.minCameraCover(root));

    }


    /**
     * LeetCode #968. Binary Tree Cameras.
     *
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param root - a root of a binary tree.
     * @return - the minimum number of cameras needed to monitor all nodes of the tree.
     */
    public int minCameraCover(TreeNode root) {
        Set<TreeNode> cameras = new HashSet<>();
        Set<TreeNode> observed = new HashSet<>();
        TreeNode dummyNode = new TreeNode(-1);

        dfs(root, dummyNode, cameras, observed);

        return cameras.size();
    }

    private void dfs (TreeNode node, TreeNode parent, Set<TreeNode> cameras, Set<TreeNode> observed) {
        if (node == null) {
            return;
        }

        dfs(node.left, node, cameras, observed);
        dfs(node.right, node, cameras, observed);

        if (node.left == null && node.right == null) {
            cameras.add(parent);
            return;
        }

        if (cameras.contains(node)) {
            observed.add(parent);
            return;
        }
        if (!observed.contains(node)) {
            cameras.add(parent);
        }
    }
}
