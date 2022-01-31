package MonthlyChallenges.Year22.January;

public class RichestCustomerWealth {

    /**
     * LeetCode #1672. Richest Customer Wealth.
     *
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param accounts - a 2d array of positive integers.
     *                 accounts[i][j] is the amount of money the i-th customer has in the j-th bank
     * @return - the wealth that the richest customer has.
     */
    public int maximumWealth(int[][] accounts) {
        int maxWealth = 0;

        for (int[] account : accounts) {
            int curMoney = getWealth(account);

            maxWealth = Math.max(maxWealth, curMoney);
        }

        return maxWealth;
    }

    private int getWealth(int[] account) {
        int wealth = 0;

        for (int money : account) {
            wealth += money;
        }

        return wealth;
    }
}
