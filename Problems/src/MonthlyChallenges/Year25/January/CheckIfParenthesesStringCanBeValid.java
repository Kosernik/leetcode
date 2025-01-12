package MonthlyChallenges.Year25.January;

import java.util.ArrayDeque;
import java.util.Deque;

public class CheckIfParenthesesStringCanBeValid {
    public static void main(String[] args) {
        CheckIfParenthesesStringCanBeValid solution = new CheckIfParenthesesStringCanBeValid();

        String testS0 = "))()))";
        String testLocked0 = "010100";
        boolean result0 = true;
        System.out.println(solution.canBeValid(testS0, testLocked0) == result0);
        System.out.println();

        String testS1 = "()()";
        String testLocked1 = "0000";
        boolean result1 = true;
        System.out.println(solution.canBeValid(testS1, testLocked1) == result1);
        System.out.println();

        String testS2 = "()()((";
        String testLocked2 = "000011";
        boolean result2 = false;
        System.out.println(solution.canBeValid(testS2, testLocked2) == result2);
        System.out.println();

        String testS3 = "(((((())";
        String testLocked3 = "11110011";
        boolean result3 = true;
        System.out.println(solution.canBeValid(testS3, testLocked3) == result3);
        System.out.println();
    }

    /**
     * LeetCode №2116. Check if a Parentheses String Can Be Valid.
     *
     * @param s      - a string of '(' and ')'.
     * @param locked - a string of '0' and '1'. s.length = locked.length.
     * @return - true if you can make s a valid parentheses string. Otherwise, returns false.
     */
    public boolean canBeValid(String s, String locked) {
        if (s.length() % 2 == 1) return false;

        char OPEN = '(';
        char FREE = '0';
        Deque<Character> stack = new ArrayDeque<>();

        int openCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if (locked.charAt(i) == FREE) {
                stack.push(FREE);
            } else {
                if (s.charAt(i) == OPEN) {
                    stack.push(OPEN);
                    openCount++;
                } else {
                    if (stack.isEmpty()) return false;

                    if (openCount == 0) {
                        stack.pop();
                    } else {
                        int freeCount = 0;

                        while (stack.peek() == FREE) {
                            freeCount++;
                            stack.pop();
                        }

                        stack.pop();
                        openCount--;

                        for (int j = 0; j < freeCount; j++) {
                            stack.push(FREE);
                        }
                    }
                }
            }
        }

        int freeCount = 0;
        while (!stack.isEmpty()) {
            char top = stack.pop();
            if (top == FREE) {
                freeCount++;
            } else {
                if (freeCount == 0) return false;
                else freeCount--;
            }
        }

        return true;
    }
}
