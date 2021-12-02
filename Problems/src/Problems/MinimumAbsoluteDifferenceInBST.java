package Problems;

import Utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class MinimumAbsoluteDifferenceInBST {

    /**
     * LeetCode #530. Minimum Absolute Difference in BST.
     * LeetCode #783. Minimum Distance Between BST Nodes.
     *
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param root - a root of a binary search tree. 0 <= Node.val <= 10^5.
     * @return - the minimum absolute difference between any two nodes.
     */
    public int getMinimumDifference(TreeNode root) {
        List<Integer> inorder = inorderTraversal(root);
        int min = Integer.MAX_VALUE;

        for (int i = 1; i < inorder.size(); i++) {
            if (inorder.get(i-1).intValue() == inorder.get(i).intValue()) return 0;
            min = Math.min(min, inorder.get(i) - inorder.get(i - 1));
        }

        return min;
    }

    private List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorderList = new ArrayList<>();

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;

        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            inorderList.add(node.val);

            node = node.right;
        }
        return inorderList;
    }
}
