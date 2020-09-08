package MonthlyChallenges.July;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockWithCooldown {
    public static void main(String[] args) {
        BestTimeToBuyAndSellStockWithCooldown solution = new BestTimeToBuyAndSellStockWithCooldown();
        int[] test0 = {1,2,3,0,2};
        int result0 = 3;
        System.out.println(solution.maxProfit(test0) == result0 ? "Success" : solution.maxProfit(test0));
    }
    public int maxProfit(int[] prices) {
        int profit = 0;
        if (prices == null || prices.length <= 1) return profit;

        int[] diffs = new int[prices.length];
        diffs[0] = 0;
        diffs[1] = Math.max(prices[1] - prices[0], 0);

        for (int i = 2; i < prices.length; i++) {
            System.out.println(Arrays.toString(diffs));
            diffs[i] = diffs[i-1];
            for (int j = 0; j < i; j++) {
                int prevMax = j >= 2 ? diffs[j-2] : 0;
                diffs[i] = Math.max(diffs[i], prevMax + (prices[i] - prices[j]));
            }
            System.out.println(Arrays.toString(diffs));
            System.out.println();
        }

        return diffs[diffs.length-1];
    }
}
