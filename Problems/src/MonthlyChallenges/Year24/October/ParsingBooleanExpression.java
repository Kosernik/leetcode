package MonthlyChallenges.Year24.October;

public class ParsingBooleanExpression {
    public static void main(String[] args) {
        ParsingBooleanExpression solution = new ParsingBooleanExpression();

        String test0 = "&(|(f))";
        System.out.println(solution.parseBoolExpr(test0) == false);

        String test1 = "|(f,f,f,t)";
        System.out.println(solution.parseBoolExpr(test1) == true);

        String test2 = "!(&(f,t))";
        System.out.println(solution.parseBoolExpr(test2) == true);

        String testCustom = "!(&(t,t,t,|(f,f,&(t)),t,|(f,f,!(f)),f))";
        System.out.println(solution.parseBoolExpr(testCustom) == true);

    }

    private final char TRUE = 't';
    private final char FALSE = 'f';
    private final char AND = '&';
    private final char OR = '|';
    private final char NOT = '!';
    private final char SEPARATOR = ',';


    /**
     * 1106. Parsing A Boolean Expression.
     * <p>
     * Complexity - O(N^2)
     * Memory - O(1)
     *
     * @param expression - a valid boolean expression.
     * @return - the evaluation of the expression.
     */
    public boolean parseBoolExpr(String expression) {
        if (expression.length() == 1) {
            return expression.charAt(0) == TRUE;
        }

        return parseBoolExpr(0, expression.length() - 1, expression.toCharArray());
    }

    private boolean parseBoolExpr(int start, int end, char[] expression) {
        char firstChar = expression[start];

        if (start == end) return firstChar == TRUE;

        if (firstChar == AND) {
            return parseAND(start + 2, end - 1, expression);
        } else if (firstChar == OR) {
            return parseOR(start + 2, end - 1, expression);
        } else {
            return parseNOT(start + 2, end - 1, expression);
        }
    }

    private boolean parseAND(int start, int end, char[] expression) {
        for (int i = start; i <= end; i++) {
            char curChar = expression[i];

            if (curChar == FALSE) {
                return false;
            } else if (curChar == SEPARATOR || curChar == TRUE) {
                continue;
            } else if (curChar == ')') {
                return true;
            }

            int parenthesisBalance = 1;
            int currEnd = i + 2;

            while (parenthesisBalance != 0) {
                if (expression[currEnd] == '(') {
                    parenthesisBalance++;
                } else if (expression[currEnd] == ')') {
                    parenthesisBalance--;
                }
                currEnd++;
            }
            currEnd--;

            boolean curResult;
            if (curChar == AND) {
                curResult = parseAND(i + 2, currEnd - 1, expression);
            } else if (curChar == OR) {
                curResult = parseOR(i + 2, currEnd - 1, expression);
            } else {    //  curChar == NOT
                curResult = parseNOT(i + 2, currEnd - 1, expression);
            }

            if (curResult == false) return false;
            i = currEnd;
        }

        return true;
    }

    private boolean parseOR(int start, int end, char[] expression) {
        for (int i = start; i <= end; i++) {
            char curChar = expression[i];

            if (curChar == TRUE) {
                return true;
            } else if (curChar == SEPARATOR || curChar == FALSE) {
                continue;
            } else if (curChar == ')') {
                return true;
            }

            int parenthesisBalance = 1;
            int currEnd = i + 2;

            while (parenthesisBalance != 0) {
                if (expression[currEnd] == '(') {
                    parenthesisBalance++;
                } else if (expression[currEnd] == ')') {
                    parenthesisBalance--;
                }
                currEnd++;
            }
            currEnd--;

            boolean curResult;
            if (curChar == AND) {
                curResult = parseAND(i + 2, currEnd - 1, expression);
            } else if (curChar == OR) {
                curResult = parseOR(i + 2, currEnd - 1, expression);
            } else {    //  curChar == NOT
                curResult = parseNOT(i + 2, currEnd - 1, expression);
            }

            if (curResult == true) return true;
            i = currEnd;
        }

        return false;
    }

    private boolean parseNOT(int start, int end, char[] expression) {
        return !parseBoolExpr(start, end, expression);
    }
}
