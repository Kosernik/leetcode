package MonthlyChallenges.Year24.August;

public class FractionAdditionAndSubtraction {
    public static void main(String[] args) {
        FractionAdditionAndSubtraction solution = new FractionAdditionAndSubtraction();

        String test0 = "-1/2+1/2";
        System.out.println(solution.fractionAddition(test0).equals("0/1"));

        String test2 = "1/3-1/2";
        System.out.println(solution.fractionAddition(test2).equals("-1/6"));
    }

    /**
     * LeetCode №592. Fraction Addition and Subtraction.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param expression - a string representing an expression of fraction addition and subtraction.
     * @return - the calculation result in string format. The final result is an irreducible fraction. If the final
     * result is an integer, returns a fraction that has a denominator 1.
     */
    public String fractionAddition(String expression) {
        long[] fraction = new long[2];
        fraction[1] = 1;

        int idx = 0;
        boolean operationAdd = true;
        if (expression.startsWith("-")) {
            idx++;
            operationAdd = false;
        }

        while (idx < expression.length()) {
            long curNumerator = 0;
            long curDenominator = 0;

            while (expression.charAt(idx) != '/') {
                curNumerator = curNumerator * 10 + (expression.charAt(idx) - '0');
                idx++;
            }

            idx++;

            while (idx < expression.length() && Character.isDigit(expression.charAt(idx))) {
                curDenominator = curDenominator * 10 + (expression.charAt(idx) - '0');
                idx++;
            }

            if (!operationAdd) curNumerator *= -1;

            addAndSimplify(fraction, curNumerator, curDenominator);

            operationAdd = idx < expression.length() && expression.charAt(idx) == '+';
            idx++;
        }

        return fraction[0] + "/" + fraction[1];
    }

    private void addAndSimplify(long[] fraction, long numerator, long denominator) {
        if (fraction[1] == denominator) {
            fraction[0] += numerator;
        } else {
            fraction[0] = fraction[0] * denominator + numerator * fraction[1];
            fraction[1] *= denominator;
        }

        long fractionGCD = gcd(Math.abs(fraction[0]), Math.abs(fraction[1]));
        fraction[0] /= fractionGCD;
        fraction[1] /= fractionGCD;
    }

    /**
     * Greatest Common Divider
     *
     * @param a - a positive long.
     * @param b - a positive long.
     * @return - the greatest common divider.
     */
    public static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
