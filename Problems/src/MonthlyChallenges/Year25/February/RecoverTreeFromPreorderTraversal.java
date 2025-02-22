package MonthlyChallenges.Year25.February;

import Utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class RecoverTreeFromPreorderTraversal {

    /**
     * LeetCode №1028. Recover a Tree From Preorder Traversal.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param traversal - a string representation of a result of a preorder traversal of a binary tree.
     * @return - the root of a parsed tree.
     */
    public TreeNode recoverFromPreorder(String traversal) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        char[] chars = traversal.toCharArray();

        int number = 0;
        int idx = 0;

        while (idx < chars.length && chars[idx] != '-') {
            number = number * 10 + (chars[idx] - '0');
            idx++;
        }

        TreeNode root = new TreeNode(number);

        stack.push(root);

        int level = 0;

        while (idx < chars.length) {
            level = stack.size() - 1;

            int nextLvl = 0;
            while (idx < chars.length && chars[idx] == '-') {
                nextLvl++;
                idx++;
            }

            number = 0;
            while (idx < chars.length && chars[idx] != '-') {
                number = number * 10 + (chars[idx] - '0');
                idx++;
            }

            TreeNode node = new TreeNode(number);

            if (nextLvl > level) {
                if (stack.peek().left == null) {
                    stack.peek().left = node;
                } else {
                    stack.peek().right = node;
                }
            } else if (nextLvl == level) {
                stack.pop();
                stack.peek().right = node;
            } else {
                while (stack.size() > nextLvl) {
                    stack.pop();
                }
                stack.peek().right = node;
            }

            stack.push(node);
        }

        return root;
    }
}
