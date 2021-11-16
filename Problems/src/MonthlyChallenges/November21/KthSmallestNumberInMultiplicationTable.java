package MonthlyChallenges.November21;

public class KthSmallestNumberInMultiplicationTable {

    /**
     * LeetCode #668. Kth Smallest Number in Multiplication Table.
     *
     * @param m - a dimension of a multiplication table.
     * @param n - a dimension of a multiplication table.
     * @param k - the index of an element, 1-indexed.
     * @return - the k-th smallest element in a multiplication table.
     */
    public int findKthNumber(int m, int n, int k) {
        if (m == 1 || n == 1) return k;
        else if (k == 1) return 1;

        int low = 1; int high = m*n;

        while (low < high) {
            int middle = (high - low) / 2 + low;

            if (!hasEnoughNumbers(middle, m, n, k)) {
                low = middle + 1 ;
            } else {
                high = middle;
            }
        }

        return low;
    }

    private boolean hasEnoughNumbers(int candidate, int m, int n, int k) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += Math.min(candidate / i, n);
        }
        return count >= k;
    }
}
