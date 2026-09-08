package MonthlyChallenges.Year26.September;

public class CountCommasInRange {

    /**
     * LeetCode №3870. Count Commas in Range.
     *
     * @param n - a positive integer. 1 <= n <= 100_000
     * @return - the total number of commas used when writing all integers from [1, n] (inclusive) in standard number
     * formatting.
     */
    public int countCommas(int n) {
        if (n < 1000) {
            return 0;
        }

        return n - 999;
    }
}
