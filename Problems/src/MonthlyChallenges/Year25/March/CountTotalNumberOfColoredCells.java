package MonthlyChallenges.Year25.March;

public class CountTotalNumberOfColoredCells {

    /**
     * LeetCode №2579. Count Total Number of Colored Cells.
     * <p>
     * Complexity - O(1)
     * Memory - O(1)
     *
     * @param n - a positive integer.
     * @return - the number of colored cells at the end of n minutes.
     */
    public long coloredCells(int n) {
        long number = (long) n;

        long halfOdd = (((number - 1) * 2 - 1) + 1) / 2;
        long doubleOddSum = halfOdd * halfOdd * 2;

        return (number * 2 - 1) + doubleOddSum;
    }
}
