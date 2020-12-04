package MonthlyChallenges.December;

public class TheKthFactorOfN {

    /**
     * LeetCode #1492.
     *
     * Complexity - O(n)
     * Memory - O(1)
     *
     * @param n - a positive integer.
     * @param k - a positive integer.
     * @return - K-th factor of "n".
     */
    public int kthFactor(int n, int k) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                count++;
                if (count == k) return i;
            }
        }
        return -1;
    }
}
