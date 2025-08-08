package MonthlyChallenges.Year25.August;

import java.util.HashMap;
import java.util.Map;

public class SoupServings {

    /**
     * LeetCode №808. Soup Servings.
     * <p>
     * Available operations:
     * * pour 100 mL from type A and 0 mL from type B
     * * pour 75 mL from type A and 25 mL from type B
     * * pour 50 mL from type A and 50 mL from type B
     * * pour 25 mL from type A and 75 mL from type B
     *
     * @param n - the total volume of both A and B bowls.
     * @return - the probability that A is used up before B, plus half the probability that both soups are used up in
     * the same turn.
     */
    public double soupServings(int n) {
        if (n > 4800) return 1.0;
        return dp(n, n, new HashMap<>());
    }

    private double dp(int firstBowl, int secondBowl, Map<Integer, Map<Integer, Double>> computed) {
        if (firstBowl <= 0 && secondBowl <= 0) {
            return 0.5;
        } else if (secondBowl <= 0) {
            return 0.0;
        } else if (firstBowl <= 0) {
            return 1.0;
        } else if (computed.containsKey(firstBowl) && computed.get(firstBowl).containsKey(secondBowl)) {
            return computed.get(firstBowl).get(secondBowl);
        }

        double firstOperation = dp(firstBowl - 100, secondBowl, computed);
        double secondOperation = dp(firstBowl - 75, secondBowl - 25, computed);
        double thirdOperation = dp(firstBowl - 50, secondBowl - 50, computed);
        double fourthOperation = dp(firstBowl - 25, secondBowl - 75, computed);

        double curResult = (firstOperation + secondOperation + thirdOperation + fourthOperation) / 4.0;

        if (!computed.containsKey(firstBowl)) {
            computed.put(firstBowl, new HashMap<>());
        }
        computed.get(firstBowl).put(secondBowl, curResult);

        return curResult;
    }
}
