package MonthlyChallenges.August;

import Utils.TreeNode;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class PathSumIII {

    // O(N*logN)
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;

        int numberOfPaths = 0;
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode currNode = queue.poll();
            int currSum = currNode.val;
            if (currSum == sum) numberOfPaths++;

            TreeNode parent = parents.getOrDefault(currNode, null);
            while (parent != null) {
                currSum += parent.val;
                if (currSum == sum) numberOfPaths++;
                parent = parents.getOrDefault(parent, null);
            }

            if (currNode.left != null) {
                parents.put(currNode.left, currNode);
                queue.offer(currNode.left);
            }
            if (currNode.right != null) {
                parents.put(currNode.right, currNode);
                queue.offer(currNode.right);
            }
        }

        return numberOfPaths;
    }
}
