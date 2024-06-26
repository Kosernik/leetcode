package MonthlyChallenges.Year24.June;

import Utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BalanceBinarySearchTree {

    /**
     * LeetCode №1382. Balance a Binary Search Tree.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param root - a root of a binary search tree.
     * @return - balanced binary search tree.
     */
    public TreeNode balanceBST(TreeNode root) {
        if (root == null) return root;

        List<Integer> inorderTree = inorderTraversal(root);

        return balancedTree(inorderTree, 0, inorderTree.size() - 1);
    }

    private TreeNode balancedTree(List<Integer> inorderTree, int leftIdx, int rightIdx) {
        if (leftIdx > rightIdx)
            return null;
        else if (leftIdx == rightIdx) {
            return new TreeNode(inorderTree.get(leftIdx));
        }

        int middle = (rightIdx + leftIdx) / 2;
        TreeNode root = new TreeNode(inorderTree.get(middle));

        root.left = balancedTree(inorderTree, leftIdx, middle - 1);
        root.right = balancedTree(inorderTree, middle + 1, rightIdx);

        return root;
    }

    private List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorderTree = new ArrayList<>();

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;

        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            inorderTree.add(node.val);
            node = node.right;
        }

        return inorderTree;
    }
}
