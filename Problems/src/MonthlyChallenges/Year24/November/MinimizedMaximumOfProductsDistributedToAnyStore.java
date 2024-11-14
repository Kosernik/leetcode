package MonthlyChallenges.Year24.November;

public class MinimizedMaximumOfProductsDistributedToAnyStore {

    /**
     * LeetCode №2064. Minimized Maximum of Products Distributed to Any Store.
     * <p>
     * Complexity - (logK*M) K = the maximum value in quantities, M = quantities.length.
     * Memory - O(1)
     *
     * @param n          - the total number of stores.
     * @param quantities - an array of quantities of different products. 1 <= quantities[i] <= 100_000
     * @return -the minimum possible number 'x'. 'x' represents the maximum number of products given to any store.
     */
    public int minimizedMaximum(int n, int[] quantities) {
        int left = 1, right = 100000, middle;

        while (left < right) {
            middle = (right - left) / 2 + left;

            if (!isValidQuantity(middle, n, quantities)) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        return left;
    }

    private boolean isValidQuantity(int candidate, int n, int[] quantities) {
        int splits = 0;

        for (int quantity : quantities) {
            splits += Math.ceilDiv(quantity, candidate);

            if (splits > n) return false;
        }

        return true;
    }
}
