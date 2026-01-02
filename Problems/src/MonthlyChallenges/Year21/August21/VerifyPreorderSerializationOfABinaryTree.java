package MonthlyChallenges.Year21.August21;

import java.util.ArrayDeque;

public class VerifyPreorderSerializationOfABinaryTree {
    public static void main(String[] args) {
        VerifyPreorderSerializationOfABinaryTree solution = new VerifyPreorderSerializationOfABinaryTree();

        String test0 = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        System.out.println(solution.isValidSerialization(test0));
    }
    //  "9,3,4,#,#,1,#,#,2,#,6,#,#"

    /**
     * LeetCode #331. Verify Preorder Serialization of a Binary Tree.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param preorder - a string representation of a binary tree, '#' - means Null node.
     * @return - True - if a given string is valid representation of a binary tree, False - otherwise.
     */
    public boolean isValidSerialization(String preorder) {
        // True - integer value of a TreeNode, False - Null
        ArrayDeque<Boolean> stack = new ArrayDeque<>();

        int idx = 0;
        while (idx < preorder.length()) {
            if (preorder.charAt(idx) == '#') {
                if (!stack.isEmpty()) {
                    if (stack.peek() == false) {
                        stack.pop();
                        if (stack.isEmpty() || stack.peek() == false) return false;
                        stack.pop();
                    }
                }
                stack.push(false);
                idx++;
                emptyStack(stack);
            } else {
                while (idx < preorder.length() && preorder.charAt(idx) != ',') idx++;

                stack.push(true);
            }
            idx++;
        }
        emptyStack(stack);

        return stack.size() == 1 && !stack.peek();
    }

    private void emptyStack(ArrayDeque<Boolean> stack) {
        while (true) {
            if (stack.isEmpty() || stack.size() < 3 || stack.peek()) return;
            stack.pop();
            if (stack.peek()) {
                stack.push(false);
                return;
            } else {
                stack.pop();
                if (stack.peek()) {
                    stack.pop();
                    stack.push(false);
                } else {
                    stack.push(false);
                    stack.push(false);
                    return;
                }
            }
        }
    }
}
