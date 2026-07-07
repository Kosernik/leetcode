package MonthlyChallenges.Year26.July;

public class ConcatenateNonZeroDigitsAndMultiplyBySumI {

    /**
     * LeetCode №3754. Concatenate Non-Zero Digits and Multiply by Sum I.
     * <p>
     * Complexity - O(1)
     * Memory - O(1)
     * <p>
     * Form a new integer x by concatenating all the non-zero digits of n in their original order. If there are no non-zero digits, x = 0.
     * Let sum be the sum of digits in x.
     *
     * @param n - a positive integer.
     * @return - an integer representing the value of x * sum.
     */
    public long sumAndMultiply(int n) {
        int concatenated = 0;
        long sum = 0L;
        int multiplier = 1;

        while (n > 0) {
            int lastDigit = n % 10;

            if (lastDigit != 0) {
                concatenated = concatenated + lastDigit * multiplier;
                multiplier *= 10;

                sum += lastDigit;
            }

            n /= 10;
        }

        return concatenated * sum;
    }
}
