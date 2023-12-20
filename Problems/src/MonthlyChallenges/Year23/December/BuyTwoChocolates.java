package MonthlyChallenges.Year23.December;

public class BuyTwoChocolates {

    /**
     * LeetCode №2706. Buy Two Chocolates.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param prices - an array of prices of chocolates.
     * @param money  - the given amount of money.
     * @return - the amount of money you will have leftover after buying the two chocolates. If there is no way for you
     * to buy two chocolates without ending up in debt, returns money.
     */
    public int buyChoco(int[] prices, int money) {
        int cheapest = Integer.MAX_VALUE;
        int secondCheapest = Integer.MAX_VALUE;

        for (int price : prices) {
            if (price < cheapest) {
                secondCheapest = cheapest;
                cheapest = price;
            } else if (price < secondCheapest) {
                secondCheapest = price;
            }
        }

        if (secondCheapest == Integer.MAX_VALUE) return money;

        if (cheapest + secondCheapest > money) return money;

        return money - cheapest - secondCheapest;
    }
}
