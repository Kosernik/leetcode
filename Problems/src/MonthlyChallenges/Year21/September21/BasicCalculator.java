package MonthlyChallenges.Year21.September21;

import java.util.ArrayDeque;

public class BasicCalculator {
    //  "(1+(4+5+2)-3)+(6+8)"
    // LeetCode #224. Basic Calculator.
    public int calculate(String s) {
        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        int result = 0;
        int sign = 1;

        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            if (Character.isDigit(curChar)) {
                int curNum = s.charAt(i) - '0';
                while ((i + 1) < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    curNum = curNum * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                result += curNum * sign;
            } else if (curChar == '+') {
                sign = 1;
            } else if (curChar == '-') {
                sign = -1;
            } else if (curChar == '(') {
                numbers.push(result);
                numbers.push(sign);
                result = 0;
                sign = 1;
            } else if (curChar == ')') {
                result = result * numbers.pop() + numbers.pop();
            }
        }

        return result;
    }
}
