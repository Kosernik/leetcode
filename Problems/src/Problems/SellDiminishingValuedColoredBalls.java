package Problems;

import java.util.Map;
import java.util.TreeMap;

public class SellDiminishingValuedColoredBalls {
    public static void main(String[] args) {
        SellDiminishingValuedColoredBalls solution = new SellDiminishingValuedColoredBalls();

        int[] test0 = {2,5};
        System.out.println("Result is: " + solution.maxProfit(test0, 4));

        int[] test1 = {680754224,895956841,524658639,3161416,992716630,7365440,582714485,422256708,332815744,269407767};
        System.out.println("Result is: " + solution.maxProfit(test1, 707568720));
    }



    private final int MODULO = 1_000_000_007;

    /**
     * LeetCode #1648. Sell Diminishing-Valued Colored Balls.
     *
     *
     * @param inventory - an array of positive integers of the amount of balls
     * @param orders - the total number of required balls.
     * @return - the total price of required balls.
     */
    public int maxProfit(int[] inventory, int orders) {
        //  amount of balls -> number of groups
        TreeMap<Integer, Integer> amounts = new TreeMap<>();
        for (int ball : inventory) {
            amounts.put(ball, amounts.getOrDefault(ball, 0) + 1);
        }

        int ordersLeft = orders;
        long result = 0;

        while (ordersLeft > 0) {
            Map.Entry<Integer, Integer> maxBalls = amounts.lastEntry();

            if (amounts.size() == 1) {
                result += getCost(maxBalls.getKey(), maxBalls.getValue(), ordersLeft);
                result %= MODULO;
                return (int) result;
            } else {
                Integer prevCost = amounts.lowerKey(maxBalls.getKey());

                int diff = maxBalls.getKey() - prevCost;
                int curAmount = Math.min(ordersLeft, diff * maxBalls.getValue());

                result += getCost(maxBalls.getKey(), maxBalls.getValue(), curAmount);
                result %= MODULO;

                ordersLeft -= curAmount;
                amounts.put(prevCost, amounts.getOrDefault(prevCost, 0) + maxBalls.getValue());
                amounts.remove(maxBalls.getKey());
            }
        }
        return (int) result;
    }

    private long getCost(int maxAmount, int numberOfGroups, int required) {
        long result = 0;

        int fullColumns = required / numberOfGroups;

        result += (getSum(maxAmount, fullColumns) * numberOfGroups) % MODULO;
        result += ((long) (maxAmount - fullColumns) * (required % numberOfGroups)) % MODULO;

        return result;
    }

    private long getSum(int cost, int amount) {
        long total = cost * (cost + 1L) / 2;
        long prefix = (cost-amount) * ((cost-amount) + 1L) / 2;
        long result = ((total - prefix) % MODULO);
        return result;
    }
}
