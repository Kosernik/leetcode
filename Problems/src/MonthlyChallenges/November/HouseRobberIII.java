package MonthlyChallenges.November;

import Utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class HouseRobberIII {
    @Deprecated
    public int robWrong(TreeNode root) {
        if (root == null) return 0;

        int[] dpArray = new int[2];
        int prevDeadEnd = 0;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int currSum = 0;
            int currDeadEnd = 0;

            for (int i = 0, length = queue.size(); i < length; i++) {
                TreeNode node = queue.poll();
                currSum += node.val;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                if (node.left == null && node.right == null) currDeadEnd += node.val;
            }
            int today = Math.max(dpArray[0] + currSum, dpArray[1]);
            dpArray[0] = dpArray[1];
            dpArray[1] = today;
            prevDeadEnd = currDeadEnd;
        }
        return dpArray[1];
    }

    /**
     * LeetCode #337.
     *
     * Complexity - O(N)
     * Memory - O(logN)
     *
     * @param root - root of a binary tree.
     * @return - maximum amount of "money".
     */
    public int rob(TreeNode root) {
        if (root == null) return 0;
        else if (root.left == null && root.right == null) return root.val;
        int[] res = helper(root);
        return Math.max(res[0], res[1]);
    }

    private int[] helper (TreeNode root) {
        if (root == null) return new int[]{0,0};
        else if (root.left == null && root.right == null) return new int[]{root.val, 0};
        else {
            int[] left = helper(root.left);
            int[] right = helper(root.right);

            int[] curr = new int[2];
            curr[0] = root.val + left[1] + right[1];
            curr[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
            return curr;
        }
    }
}
