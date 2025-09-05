package MonthlyChallenges.Year25.September;

public class MinimumOperationsToMakeIntegerZero {

    /**
     * LeetCode №2749. Minimum Operations to Make the Integer Zero.
     * <p>
     * Complexity - O(1), maximum 61 loops.
     * Memory - O(1)
     * <p>
     * An operation: subtract (2 ^ i + num2) from num1. "i" is in the range [0, 60]
     *
     * @param num1 - a positive integer.
     * @param num2 - an integer.
     * @return - the integer denoting the minimum number of operations needed to make num1 equal to 0.
     */
    public int makeTheIntegerZero(int num1, int num2) {
        int operations = 1;

        while (true) {
            long sumOfPowersOfTwo = num1 - (long) num2 * operations;

            if (sumOfPowersOfTwo < operations) return -1;

            if (operations >= Long.bitCount(sumOfPowersOfTwo)) {
                return operations;
            }

            operations++;
        }
    }
}
