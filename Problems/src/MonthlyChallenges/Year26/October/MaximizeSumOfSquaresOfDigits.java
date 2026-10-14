package MonthlyChallenges.Year26.October;

import java.util.Arrays;

public class MaximizeSumOfSquaresOfDigits {

    /**
     * LeetCode №3723. Maximize Sum of Squares of Digits.
     * <p>
     * Complexity - O(N), N = num
     * Memory - O(1)
     * <p>
     * A positive integer n is good if it satisfies both of the following:
     * *    The number of digits in n is exactly num.
     * *    The sum of digits in n is exactly sum.
     * The score of a good integer n is the sum of the squares of digits in n.
     *
     * @param num - a positive integer representing the length of the resulting number.
     * @param sum - a positive integer representing the sum of all digits of the resulting number.
     * @return - a string denoting the good integer n that achieves the maximum score. If there are multiple possible
     * integers, returns the maximum one. If no such integer exists, returns an empty string.
     */
    public String maxSumOfSquares(int num, int sum) {
        char[] result = new char[num];
        Arrays.fill(result, '0');

        int idx = 0;
        while (idx < num && sum > 0) {
            int digit = Math.min(sum, 9);
            result[idx] = (char) ('0' + digit);

            sum -= digit;
            idx++;
        }

        if (sum > 0) return "";

        return new String(result);
    }
}
