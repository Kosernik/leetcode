package MonthlyChallenges.August;

public class BestTimeToBuyAndSellStockIII {
    public static void main(String[] args) {
        BestTimeToBuyAndSellStockIII solution = new BestTimeToBuyAndSellStockIII();
        solution.testMaxProfit();
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;

        // int[день][количество покупок][наличие акций]
        int[][][] profits = new int[prices.length+1][2][2];
        // Прибыль за -1 день равна 0 при отсутствии акций, и неопределена при наличии акций
        profits[0][0][0] = 0; profits[0][0][1] = Integer.MIN_VALUE;
        profits[0][1][0] = 0; profits[0][1][1] = Integer.MIN_VALUE;

        for (int i = 0; i < prices.length; i++) {
            profits[i+1][1][0] = Math.max(profits[i][1][0], profits[i][1][1] + prices[i]);
            profits[i+1][1][1] = Math.max(profits[i][1][1], profits[i][0][0] - prices[i]);
            profits[i+1][0][0] = Math.max(profits[i][0][0], profits[i][0][1] + prices[i]);
            profits[i+1][0][1] = Math.max(profits[i][0][1], -prices[i]);
        }

        return profits[prices.length][1][0];
    }

    private void testMaxProfit() {
        int[][] tests = {
                null,
                {},
                {9},
                {3,3,5,0,0,3,1,4},  //6
                {2,3,5,0,0,3,1,4},  //7
                {1,2,3,4,5},        //4
                {7,6,4,3,1},        //0
                {3,4,5,7,6,7,8},    //6
                {3,4,5,7,5,7,8,0,1},//7
                {3,4,5,7,5,7,8,0,3} //8
        };
        int[] results = {0,0,0,6,7,4,0,6,7,8};

        int failed = 0;
        for (int i = 0; i < tests.length; i++) {
            int currResult = maxProfit(tests[i]);
            if (currResult != results[i]) {
                failed++;
                System.out.println("Wrong result for test # " + i);
                System.out.println("Got: " + currResult + ", instead of: " + results[i]);
            }
        }

        System.out.println("Success rate: " + (tests.length - failed) * 100.0 / tests.length);
    }
}
