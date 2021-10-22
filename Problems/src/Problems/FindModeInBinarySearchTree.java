package Problems;

import Utils.TreeNode;

import java.util.*;

public class FindModeInBinarySearchTree {
    /**
     * LeetCode #501. Find Mode in Binary Search Tree.
     *
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param root - a root of a binary tree.
     * @return - an array of all modes.
     */
    public int[] findMode(TreeNode root) {
        int maxCount = 0;
        Map<Integer, Integer> counts = new HashMap<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            int curCount = counts.getOrDefault(node.val, 0) + 1;
            counts.put(node.val, curCount);
            maxCount = Math.max(maxCount, curCount);

            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }

        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (entry.getValue() == maxCount) result.add(entry.getKey());
        }

        int[] modes = new int[result.size()];
        for (int i = 0; i < result.size(); i++) modes[i] = result.get(i);

        return modes;
    }
}
