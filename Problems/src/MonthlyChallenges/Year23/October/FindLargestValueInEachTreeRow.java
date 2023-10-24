package MonthlyChallenges.Year23.October;

import Utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class FindLargestValueInEachTreeRow {

    /**
     * LeetCode #515. Find Largest Value in Each Tree Row.
     * <p>
     * Complexity - O(N).
     * Memory - O(N).
     *
     * @param root - a root of a binary tree.
     * @return - a list of largest values in each row.
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);

        while (!deque.isEmpty()) {
            int curMax = Integer.MIN_VALUE;

            for (int i = deque.size(); i > 0; i--) {
                TreeNode curNode = deque.removeFirst();
                curMax = Math.max(curMax, curNode.val);

                if (curNode.left != null) deque.offerLast(curNode.left);
                if (curNode.right != null) deque.offerLast(curNode.right);
            }

            result.add(curMax);
        }

        return result;
    }
}
