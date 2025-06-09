package MonthlyChallenges.Year25.June;

public class KthSmallestInLexicographicalOrder {
    public static void main(String[] args) {
        KthSmallestInLexicographicalOrder solution = new KthSmallestInLexicographicalOrder();

        int n0 = 681692778;
        int k0 = 351251360;
        int res0 = 416126219;

        System.out.println(solution.findKthNumberTLE(n0, k0) == res0);
        System.out.println(solution.findKthNumberIterativeTLE(n0, k0) == res0);
        System.out.println(solution.findKthNumber(n0, k0) == res0);
    }

    /**
     * LeetCode №440. K-th Smallest in Lexicographical Order.
     *
     * @param n - a positive integer.
     * @param k - a positive integer. k <= n.
     * @return - the k-th lexicographically smallest integer in the range [1, n].
     */
    public int findKthNumber(int n, int k) {
        int curNumber = 1;
        k--;

        while (k > 0) {
            int numbersBetween = countNumbersBetween(n, curNumber);

            if (numbersBetween <= k) {
                curNumber++;
                k -= numbersBetween;
            } else {
                curNumber *= 10;
                k--;
            }
        }

        return curNumber;
    }

    private int countNumbersBetween(int max, long start) {
        long count = 0;
        long end = start + 1;

        while (start <= max) {
            count += Math.min(max + 1, end) - start;
            start *= 10;
            end *= 10;
        }

        return (int) count;
    }

    private boolean foundKNumber = false;
    private int kNumber = -1;
    private int idx = 0;

    public int findKthNumberTLE(int n, int k) {
        if (n <= 9) return k;

        for (int i = 1; i <= 9; i++) {
            dfs(i, n, k);
        }

        return kNumber;
    }

    private void dfs(int number, int max, int k) {
        if (foundKNumber || number > max) return;

        idx++;

        if (idx == k) {
            foundKNumber = true;
            kNumber = number;
            return;
        }

        for (int i = 0; i <= 9; i++) {
            int nextNumber = number * 10 + i;
            if (nextNumber > 0 && nextNumber <= max) {
                dfs(nextNumber, max, k);
            }
        }
    }

    public int findKthNumberIterativeTLE(int n, int k) {
        if (n <= 9) return k;

        int curIdx = 0;
        long curNumber = 1;

        for (int i = 0; i <= k; i++) {
            curIdx++;
            if (curIdx == k) {
                return (int) curNumber;
            }

            if (curNumber * 10 <= n) {
                curNumber *= 10;
            } else {

                if (curNumber >= n) curNumber /= 10;
                curNumber++;
                while (curNumber % 10 == 0) {
                    curNumber /= 10;
                }
            }
        }

        return (int) curNumber;
    }
}
