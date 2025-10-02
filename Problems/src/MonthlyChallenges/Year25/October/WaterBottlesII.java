package MonthlyChallenges.Year25.October;

public class WaterBottlesII {

    /**
     * LeetCode №3100. Water Bottles II.
     *
     * @param numBottles  - the number of full bottles ant the beginning.
     * @param numExchange - the initial exchange rate for empty bottles.
     * @return - the maximum number of water bottles you can drink.
     */
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int drinkedBottles = 0;

        int emptyBottles = 0;

        while (numBottles > 0) {
            drinkedBottles += numBottles;

            emptyBottles += numBottles;

            numBottles = 0;

            if (emptyBottles >= numExchange) {
                numBottles += 1;

                emptyBottles -= numExchange;

                numExchange += 1;
            }
        }

        return drinkedBottles;
    }
}
