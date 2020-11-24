package MonthlyChallenges.November;

import java.util.ArrayDeque;

public class BasicCalculatorII {
    public static void main(String[] args) {
//        System.out.println(5 / 2);
//        System.out.println(-5 / 2);

        BasicCalculatorII solution = new BasicCalculatorII();

        String s0 = " 3+5 / 2 ";
        System.out.println(solution.calculate(s0));
    }


    /**
     * LeetCode #227.
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param s - math expression containing only non-negative integers, "+", "-", "*" or "/" signs.
     * @return - result of the given expression.
     */
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        s = removeSpaces(s);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int idx = 0;

        while (idx < s.length()) {
            if (s.charAt(idx) == '+') {
                int currNum = 0;
                idx++;
                while (idx < s.length() && Character.isDigit(s.charAt(idx))) {
                    currNum = currNum * 10 + (s.charAt(idx) - '0');
                    idx++;
                }
                stack.offerLast(currNum);
            } else if (s.charAt(idx) == '-') {
                int currNum = 0;
                idx++;
                while (idx < s.length() && Character.isDigit(s.charAt(idx))) {
                    currNum = currNum * 10 + (s.charAt(idx) - '0');
                    idx++;
                }
                currNum *= -1;
                stack.offerLast(currNum);
            } else if (s.charAt(idx) == '*') {
                int currNum = 0;
                idx++;
                while (idx < s.length() && Character.isDigit(s.charAt(idx))) {
                    currNum = currNum * 10 + (s.charAt(idx) - '0');
                    idx++;
                }
                stack.offerLast(stack.removeLast() * currNum);
            } else if (s.charAt(idx) == '/') {
                int currNum = 0;
                idx++;
                while (idx < s.length() && Character.isDigit(s.charAt(idx))) {
                    currNum = currNum * 10 + (s.charAt(idx) - '0');
                    idx++;
                }
                int prev = stack.removeLast();
                currNum = prev / currNum;
                stack.offerLast(currNum);
            } else {
                int currNum = 0;
                while (idx < s.length() && Character.isDigit(s.charAt(idx))) {
                    currNum = currNum * 10 + (s.charAt(idx) - '0');
                    idx++;
                }
                stack.offerLast(currNum);
            }
        }

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.removeFirst();
        }
        return result;
    }

    private String removeSpaces(String s) {
        StringBuilder builder = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch != ' ') builder.append(ch);
        }
        return builder.toString();
    }
}
