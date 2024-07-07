package MonthlyChallenges.Year24.July;

public class WaterBottles {

    /**
     * LeetCode №1518. Water Bottles.
     *
     * @param numBottles  - the given number of full bottles.
     * @param numExchange - the exchange ratio for empty bottles.
     * @return - the maximum number of water bottles you can drink.
     */
    public int numWaterBottles(int numBottles, int numExchange) {
        int drinkCount = 0;
        int emptyBottles = 0;
        int fullBottles = numBottles;

        while (fullBottles > 0) {
            drinkCount += fullBottles;
            emptyBottles += fullBottles;

            fullBottles = emptyBottles / numExchange;
            emptyBottles = emptyBottles % numExchange;
        }

        return drinkCount;
    }
}
