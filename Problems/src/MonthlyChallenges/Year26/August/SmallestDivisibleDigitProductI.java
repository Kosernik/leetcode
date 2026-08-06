package MonthlyChallenges.Year26.August;

public class SmallestDivisibleDigitProductI {

    /**
     * LeetCode №3345. Smallest Divisible Digit Product I.
     * <p>
     * Complexity - O(1)
     * Memory - O(1)
     *
     * @param n - a positive integer. 1 <= n <= 100
     * @param t - a positive integer. 1 <= t <= 10
     * @return - the smallest number greater than or equal to n such that the product of its digits is divisible by t.
     */
    public int smallestNumber(int n, int t) {
        for (int i = 0; i < 10; i++) {
            if (getProductOfDigits(n + i) % t == 0) return n + i;
        }

        return -1; // Unreachable
    }

    private int getProductOfDigits(int number) {
        int product = 1;

        while (number > 0) {
            product *= (number % 10);
            number /= 10;
        }

        return product;
    }
}
