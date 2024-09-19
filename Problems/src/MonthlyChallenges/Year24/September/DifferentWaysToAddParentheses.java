package MonthlyChallenges.Year24.September;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DifferentWaysToAddParentheses {
    Map<String, List<Integer>> computed = new HashMap<>();

    /**
     * LeetCode №241. Different Ways to Add Parentheses.
     *
     * @param expression - a string that consists of digits and the operator '+', '-', and '*'. All the integer values
     *                   in the input expression are in the range [0, 99].
     * @return - all possible results from computing all the different possible ways to group numbers and operators.
     */
    public List<Integer> diffWaysToCompute(String expression) {
        if (expression.isEmpty()) return new ArrayList<>();

        List<Integer> results = new ArrayList<>();

        if (expression.length() == 1) {
            results.add(Integer.parseInt(expression));
            computed.put(expression, results);
        }
        if (expression.length() == 2 && Character.isDigit(expression.charAt(0))) {
            results.add(Integer.parseInt(expression));
            computed.put(expression, results);
        }

        if (computed.containsKey(expression)) return computed.get(expression);

        for (int i = 0; i < expression.length(); i++) {
            char curChar = expression.charAt(i);

            if (Character.isDigit(curChar)) continue;

            List<Integer> leftResults = diffWaysToCompute(expression.substring(0, i));
            List<Integer> rightResults = diffWaysToCompute(expression.substring(i + 1));

            for (int left : leftResults) {
                for (int right : rightResults) {
                    int curRes;

                    if (curChar == '+') {
                        curRes = left + right;
                    } else if (curChar == '-') {
                        curRes = left - right;
                    } else {    //  curChar == '*'
                        curRes = left * right;
                    }

                    results.add(curRes);
                }
            }
        }

        computed.put(expression, results);
        return results;
    }
}
