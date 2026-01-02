package MonthlyChallenges.Year21.February21;

import java.util.ArrayDeque;

public class ValidateStackSequences {
    /**
     * LeetCode #946.
     * <p>
     * Verifies if array "popped" can be formed by push and pop operations on an initially empty stack with digits from
     * array "pushed".
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param pushed - array of integers with distinct values.
     * @param popped - array of integers with distinct values, popped.length = pushed.length.
     * @return - True if "popped" is a result of push and pop operations on array "pushed". False - otherwise.
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed == null || pushed.length == 0) return true;

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int popIdx = 0;

        for (int j : pushed) {
            stack.addLast(j);

            while (!stack.isEmpty() && popIdx < popped.length && stack.peekLast() == popped[popIdx]) {
                popIdx++;
                stack.removeLast();
            }
        }

        return stack.isEmpty() && popIdx == popped.length;
    }
}
