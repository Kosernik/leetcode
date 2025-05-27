package MonthlyChallenges.Year25.May;

public class DivisibleAndNonDivisibleSumsDifference {

    /**
     * LeetCode №2894. Divisible and Non-divisible Sums Difference.
     * <p>
     * Complexity - O(N) N = n
     * Memory - O(1)
     * <p>
     * num1: The sum of all integers in the range [1, n] (both inclusive) that are not divisible by m.
     * num2: The sum of all integers in the range [1, n] (both inclusive) that are divisible by m.
     * Result = nums1 - nums2.
     *
     * @param n - a positive integer.
     * @param m - a positive integer.
     * @return - the difference between two sums.
     */
    public int differenceOfSums(int n, int m) {
        int sum = n * (n + 1) / 2;

        for (int i = m; i <= n; i += m) {
            sum -= 2 * i;
        }

        return sum;
    }

    /**
     * LeetCode №2894. Divisible and Non-divisible Sums Difference.
     * <p>
     * Complexity - O(N) N = n
     * Memory - O(1)
     * <p>
     * num1: The sum of all integers in the range [1, n] (both inclusive) that are not divisible by m.
     * num2: The sum of all integers in the range [1, n] (both inclusive) that are divisible by m.
     * Result = nums1 - nums2.
     *
     * @param n - a positive integer.
     * @param m - a positive integer.
     * @return - the difference between two sums.
     */
    public int differenceOfSumsSlow(int n, int m) {
        int divSum = 0;
        int nonDivSum = Math.min(m - 1, n) * (Math.min(m - 1, n) + 1) / 2;

        for (int i = m; i <= n; i++) {
            if (i % m == 0) {
                divSum += i;
            } else {
                nonDivSum += i;
            }
        }

        return nonDivSum - divSum;
    }
}
