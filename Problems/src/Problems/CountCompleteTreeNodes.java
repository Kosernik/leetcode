package Problems;

import Utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class CountCompleteTreeNodes {

    /**
     * leetCode #222. Count Complete Tree Nodes.
     *
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param root - a root of a complete binary tree.
     * @return - the number of the nodes in the tree.
     */
    public int countNodes(TreeNode root) {
        int result = 0;
        if (root == null) return 0;
        else if (root.left == null && root.right == null) return 1;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            result += queue.size();
            if (queue.element().left != null) {
                for (int i = 0, length = queue.size(); i < length; i++) {
                    TreeNode currNode = queue.remove();
                    if (currNode.left != null) {
                        queue.offer(currNode.left);
                    }
                    if (currNode.right != null) {
                        queue.offer(currNode.right);
                    }
                }
            } else {
                return result;
            }
        }

        return result;
    }

    /**
     * leetCode #222. Count Complete Tree Nodes.
     *
     * Complexity - O(logN*logN)
     * Memory - O(1)
     *
     * @param root - a root of a complete binary tree.
     * @return - the number of the nodes in the tree.
     */
    public int countNodesBinSearch(TreeNode root) {
        if (root == null) return 0;
        else if (root.left == null && root.right == null) return 1;

        int height = getHeight(root);

        int left = (int) Math.pow(2, height-1);   // Inclusive
        int right = (int) Math.pow(2, height) - 1;    // Inclusive
        int shift = height-2;

        while (left < right) {
            int middle = right - (right - left) / 2;

            if (isValidNode(root, middle, shift)) {
                left = middle;
            } else {
                right = middle - 1;
            }
        }

        return left;
    }

    private boolean isValidNode(TreeNode root, int path, int shift) {
        if (shift == -1) return root != null;
        int direction = path & (1 << shift);

        if (direction == 0) {   // left
            return isValidNode(root.left, path, shift-1);
        } else {    // right
            return isValidNode(root.right, path, shift-1);
        }
    }

    private int getHeight(TreeNode root) {
        if (root == null) return 0;
        return 1 + getHeight(root.left);
    }
}
