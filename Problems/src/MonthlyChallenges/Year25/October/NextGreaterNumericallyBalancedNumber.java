package MonthlyChallenges.Year25.October;

public class NextGreaterNumericallyBalancedNumber {

    /**
     * LeetCode №2048. Next Greater Numerically Balanced Number.
     *
     * @param n - a non-negative integer. 0 <= n <= 106
     * @return - the smallest numerically balanced number strictly greater than n.
     */
    public int nextBeautifulNumber(int n) {
        for (int candidate = n + 1; candidate <= 1224444; candidate++) {
            if (isNumericallyBalanced(candidate)) return candidate;
        }

        return -1;
    }

    private boolean isNumericallyBalanced(int number) {
        int[] counts = new int[10];

        while (number > 0) {
            counts[number % 10]++;
            number /= 10;
        }

        if (counts[0] > 0) return false;

        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0 && counts[i] != i) return false;
        }

        return true;
    }
}
