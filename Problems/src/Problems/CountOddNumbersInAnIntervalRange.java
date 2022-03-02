package Problems;

public class CountOddNumbersInAnIntervalRange {

    /**
     * LeetCode #1523. Count Odd Numbers in an Interval Range.
     *
     * Complexity - O(1)
     * Memory - O(1)
     *
     * @param low - start number, inclusive.
     * @param high - end number, inclusive.
     * @return - the count of odd numbers between low and high (inclusive).
     */
    public int countOdds(int low, int high) {
        if (low == high) {
            return low % 2;
        }

        if (low % 2 == 0) return countOdds(low+1, high);
        if (high % 2 == 1) return countOdds(low, high+1);

        return (high - low + 1) / 2;
    }
}
