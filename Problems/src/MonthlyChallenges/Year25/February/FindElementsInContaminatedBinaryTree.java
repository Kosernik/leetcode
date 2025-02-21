package MonthlyChallenges.Year25.February;

import Utils.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class FindElementsInContaminatedBinaryTree {

    /**
     * LeetCode №1261. Find Elements in a Contaminated Binary Tree.
     */
    class FindElements {
        private final Set<Integer> values;

        public FindElements(TreeNode root) {
            this.values = new HashSet<>();

            processNode(root, 0);
        }

        public boolean find(int target) {
            return this.values.contains(target);
        }

        private void processNode(TreeNode node, int value) {
            if (node == null) return;

            //node.val = value;
            this.values.add(value);

            processNode(node.left, 2 * value + 1);

            processNode(node.right, 2 * value + 2);
        }
    }
}
