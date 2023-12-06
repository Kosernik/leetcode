package MonthlyChallenges.Year23.December;

public class CalculateMoneyInLeetcodeBank {

    /**
     * LeetCode №1716. Calculate Money in Leetcode Bank.
     * <p>
     * Complexity - O(1)
     * Memory - O(1)
     *
     * @param n - the number of days. 1 <= n <= 1000
     * @return - the total amount of money in the bank.
     */
    public int totalMoney(int n) {
        int baseDollarsPerWeek = getSum(7);
        int weeks = n / 7;
        int days = n % 7;

        int weekIncrease = getSum(weeks - 1) * 7;

        return baseDollarsPerWeek * weeks + weekIncrease + getSum(days) + weeks * days;
    }

    private int getSum(int number) {
        return number * (number + 1) / 2;
    }
}
