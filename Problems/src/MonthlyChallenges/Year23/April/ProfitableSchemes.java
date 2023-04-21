package MonthlyChallenges.Year23.April;

public class ProfitableSchemes {
    private final long MODULO = 1_000_000_007L;
    private int n;
    private int minProfit;
    private int[] group;
    private int[] profit;
    private Long[][][] dp;

    /**
     * LeetCode #879. Profitable Schemes
     *
     * @param n         - the number of members.
     * @param minProfit - minimum required profit.
     * @param group     - an array of required members for each job.
     * @param profit    - an array of profits for each job.
     * @return - the total number of valid schemes.
     */
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        this.n = n;
        this.minProfit = minProfit;
        this.group = group;
        this.profit = profit;

        this.dp = new Long[group.length + 1][n + 1][minProfit + 1];

        return (int) (countSchemes(0, 0, 0) % MODULO);
    }

    private long countSchemes(int i, int curParticipants, int curProfit) {
        if (i == group.length) return curProfit >= minProfit ? 1 : 0;

        if (dp[i][curParticipants][curProfit] != null) {
            return dp[i][curParticipants][curProfit];
        }

        long ignoreCurrent = countSchemes(i + 1, curParticipants, curProfit);
        long pickCurrent = 0;

        if (curParticipants + group[i] <= n) {
            pickCurrent = countSchemes(i + 1, curParticipants + group[i], Math.min(curProfit + profit[i], minProfit));
        }

        dp[i][curParticipants][curProfit] = (ignoreCurrent + pickCurrent) % MODULO;
        return dp[i][curParticipants][curProfit];
    }
}
