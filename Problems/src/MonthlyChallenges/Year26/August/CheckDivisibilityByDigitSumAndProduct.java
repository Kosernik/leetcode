package MonthlyChallenges.Year26.August;

public class CheckDivisibilityByDigitSumAndProduct {

    /**
     * LeetCode №3622. Check Divisibility by Digit Sum and Product.
     * <p>
     * Complexity - O(logN)
     * Memory - O(1)
     *
     * @param n - a positive integer.
     * @return - true if n is divisible by the sum of:
     * sum of digits of n,
     * product of digits of n.
     * Otherwise, returns false.
     */
    public boolean checkDivisibility(int n) {
        int sum = 0, product = 1, number = n;

        while (number > 0) {
            int lastDigit = number % 10;
            sum += lastDigit;
            product *= lastDigit;

            number /= 10;
        }

        return n % (sum + product) == 0;
    }
}
