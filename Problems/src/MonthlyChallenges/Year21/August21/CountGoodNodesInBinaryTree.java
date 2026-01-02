package MonthlyChallenges.Year21.August21;

import Utils.TreeNode;

import java.util.ArrayDeque;

public class CountGoodNodesInBinaryTree {
    // LeetCode #1448.
    public int goodNodes(TreeNode root) {
        int result = 0;
        if (root == null) return result;

        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(root, Integer.MIN_VALUE));

        while (!queue.isEmpty()) {
            Pair curPair = queue.removeFirst();
            if (curPair.maximum <= curPair.node.val) result++;

            if (curPair.node.left != null) {
                queue.offer(new Pair(curPair.node.left, Math.max(curPair.maximum, curPair.node.val)));
            }
            if (curPair.node.right != null) {
                queue.offer(new Pair(curPair.node.right, Math.max(curPair.maximum, curPair.node.val)));
            }
        }

        return result;
    }

    private class Pair {
        TreeNode node;
        int maximum;

        public Pair(TreeNode node, int maximum) {
            this.node = node;
            this.maximum = maximum;
        }
    }
}
