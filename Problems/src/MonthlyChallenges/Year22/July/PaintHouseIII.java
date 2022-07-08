package MonthlyChallenges.Year22.July;

public class PaintHouseIII {

    private Integer[][][] minCosts;
    private int numberOfHouses;
    private int numberOfColors;
    private int[] houses;
    private int[][] cost;

    private final int COST_UPPER_LIMIT = 1_000_001;

    /**
     * LeetCode #1473. Paint House III.
     *
     * @param houses - an array of colors for each house. 0 means the house is not painted yet.
     * @param cost - an array of costs of painting i-th house with j-th color.
     * @param m - the number of houses.
     * @param n - the number of colors.
     * @param target - the required number of neighbourhoods.
     * @return - the minimum cost of painting all the remaining houses in such a way that there are exactly target
     *           neighborhoods. If it is not possible, returns -1.
     */
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        this.houses = houses;
        this.cost = cost;
        this.numberOfHouses = m;
        this.numberOfColors = n;
        //  Minimum cost for: house -> color -> neighbourhoods
        minCosts = new Integer[m][n + 1][target+1];

        int result = dfs(0, 0, target);
        return result >= COST_UPPER_LIMIT ? -1 : result;
    }

    private int dfs(int currentHouse, int prevColor, int target) {
        if (currentHouse == numberOfHouses ) {
            if (target == 0) return 0;
            return COST_UPPER_LIMIT;
        }
        if (target < 0) {
            return COST_UPPER_LIMIT;
        }
        if (minCosts[currentHouse][prevColor][target] != null) {
            return minCosts[currentHouse][prevColor][target];
        }

        int result = COST_UPPER_LIMIT;
        int nextHouse = currentHouse + 1;

        if (houses[currentHouse] != 0) {
            if (houses[currentHouse] == prevColor) {
                result = dfs(nextHouse, prevColor, target);
            } else {
                result = dfs(nextHouse, houses[currentHouse], target - 1);
            }
        } else {
            for (int color = 1; color <= numberOfColors; color++) {
                int curTarget;
                if (color == prevColor) {
                    curTarget = target;
                } else {
                    curTarget = target - 1;
                }
                int curRes = dfs(nextHouse, color, curTarget) + cost[currentHouse][color-1];
                result = Math.min(result, curRes);
            }
        }

        minCosts[currentHouse][prevColor][target] = result;
        return result;
    }
}
