package MonthlyChallenges.Year24.December;

import Utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;

public class MinimumNumberOfOperationsToSortBinaryTreeByLevel {

    /**
     * LeetCode №2471. Minimum Number of Operations to Sort a Binary Tree by Level.
     *
     * @param root - a root of a binary tree.
     * @return - the minimum number of swap-operations needed to make the values at each level sorted in a strictly
     * increasing order.
     */
    public int minimumOperations(TreeNode root) {
        int result = 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);


        while (!queue.isEmpty()) {
            int[][] sortedValues = new int[queue.size()][2];

            for (int i = queue.size(), idx = 0; i > 0; i--, idx++) {
                TreeNode node = queue.removeFirst();
                sortedValues[idx][0] = node.val;
                sortedValues[idx][1] = idx;

                if (node.left != null) queue.offerLast(node.left);
                if (node.right != null) queue.offerLast(node.right);
            }

            Arrays.sort(sortedValues, Comparator.comparingInt(a -> a[0]));

            int swaps = 0;

            for (int i = 0; i < sortedValues.length; i++) {
                while (i != sortedValues[i][1]) {
                    swaps++;

                    int tempVal = sortedValues[i][0];
                    int tempIdx = sortedValues[i][1];

                    sortedValues[i][0] = sortedValues[tempIdx][0];
                    sortedValues[i][1] = sortedValues[tempIdx][1];

                    sortedValues[tempIdx][0] = tempVal;
                    sortedValues[tempIdx][1] = tempIdx;
                }
            }

            result += swaps;
        }

        return result;
    }
}
