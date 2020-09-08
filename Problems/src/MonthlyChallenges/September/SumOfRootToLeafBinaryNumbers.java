package MonthlyChallenges.September;

import Utils.TreeNode;

import java.util.*;

public class SumOfRootToLeafBinaryNumbers {

    /**
     * Calculating the sum of all root-to-leaf paths in a binary tree where each node has a value either 0 or 1. Root is
     * the most significant bit, leafs are the least significant bits.
     *
     *              1
     *            /   \
     *           0     1
     *          / \   / \
     *         0   1 0   1
     *  Sum = 0b100 + 0b101 + 0b110 + 0b111 = 22
     *
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param root - binary tree.
     * @return - sum of all paths.
     */
    public int sumRootToLeaf(TreeNode root) {
        int sum = 0;
        if (root == null) return sum;

        Map<TreeNode, Integer> pathSums = new HashMap<>();
        pathSums.put(root, 0);
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            for (int i = 0, length = queue.size(); i < length; i++) {
                TreeNode currNode = queue.poll();
                int currNum = pathSums.get(currNode);
                int currPath = (currNum << 1) + currNode.val;

                if (currNode.left == null && currNode.right == null) {
                    sum += currPath;
                } else {
                    if (currNode.left != null) {
                        pathSums.put(currNode.left, currPath);
                        queue.offerLast(currNode.left);
                    }
                    if (currNode.right != null) {
                        pathSums.put(currNode.right, currPath);
                        queue.offerLast(currNode.right);
                    }
                }
            }
        }

        return sum;
    }
}
