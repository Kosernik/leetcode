package MonthlyChallenges.Year22.May;

public class DivideTwoIntegers {

    /**
     * LeetCode #29. Divide Two Integers.
     *
     * @param dividend - an integer.
     * @param divisor - an integer.
     * @return - an integer result of the division.
     */
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        else if (dividend == divisor) return 1;
        else if (divisor == 1) return dividend;
        else if (dividend == 0) return 0;

        boolean isResultPositive = (dividend < 0) == (divisor < 0);

        int dividendAbs = Math.abs(dividend);
        int divisorAbs = Math.abs(divisor);

        int result = 0;

        while (dividendAbs - divisorAbs >= 0) {
            int quotient = 0;
            while (dividendAbs - ((divisorAbs << quotient) << 1) >= 0) {
                quotient++;
            }

            result += (1<<quotient);
            dividendAbs = dividendAbs - (divisorAbs<<quotient);
        }

        return isResultPositive ? result : -result;
    }
}
