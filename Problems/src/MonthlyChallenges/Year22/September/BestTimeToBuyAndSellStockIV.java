package MonthlyChallenges.Year22.September;

public class BestTimeToBuyAndSellStockIV {

    /**
     * LeetCode #188. Best Time to Buy and Sell Stock IV.
     * <p>
     * Complexity - O(N*k), N = prices.length
     * Memory - O(N*k)
     *
     * @param k      - the maximum number of transactions. 0 <= k <= 100
     * @param prices - an array of prices. 0 <= prices[i] <= 1000
     * @return - the maximum profit after performing at most 'k' transactions.
     */
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        if (k >= prices.length / 2) return unlimitedTransactions(prices);

        int[][] profits = new int[k + 1][prices.length];

        for (int i = 1; i <= k; i++) {
            int curMax = profits[i - 1][0] - prices[0];
            for (int j = 1; j < prices.length; j++) {
                profits[i][j] = Math.max(profits[i][j - 1], prices[j] + curMax);
                curMax = Math.max(curMax, profits[i - 1][j] - prices[j]);
            }
        }

        return profits[k][prices.length - 1];
    }

    private int unlimitedTransactions(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}
