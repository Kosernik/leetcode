package MonthlyChallenges.Year25.August;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WaysToExpressIntegerAsSumOfPowers {
    public static void main(String[] args) {
        WaysToExpressIntegerAsSumOfPowers solution = new WaysToExpressIntegerAsSumOfPowers();

        System.out.print("Test 0 \t");
        int n0 = 10, x0 = 2, result0 = 1;
        System.out.println(solution.numberOfWays(n0, x0) == result0);

        System.out.print("\n" + "Test 1 \t");
        int n1 = 4, x1 = 1, result1 = 2;
        System.out.println(solution.numberOfWays(n1, x1) == result1);

        System.out.print("\n" + "Test 2 \t");
        int n2 = 160, x2 = 3, result2 = 1;
        System.out.println(solution.numberOfWays(n2, x2) == result2);

        System.out.print("\n" + "Test 3 \t");
        int n3 = 160, x3 = 1, result3 = 38328320;
        System.out.println(solution.numberOfWays(n3, x3) == result3);

        System.out.print("\n" + "Test 4 \t");
        int n4 = 168, x4 = 3, result4 = 0;
        System.out.println(solution.numberOfWays(n4, x4) == result4);

        System.out.print("\n" + "Test 5 \t");
        int n5 = 25, x5 = 2, result5 = 2;
        System.out.println(solution.numberOfWays(n5, x5) == result5);

        System.out.println();
    }


    int MODULO = 1_000_000_007;

    /**
     * LeetCode №2787. Ways to Express an Integer as Sum of Powers.
     *
     * @param n - a positive integer. 1 <= n <= 300
     * @param x - a positive integer. 1 <= x <= 5
     * @return - the number of ways n can be expressed as the sum of the x-th power of unique positive integers.
     * Result is modulo 1_000_000_007.
     */
    public int numberOfWays(int n, int x) {
        if (x > 1) {
            return canBuild(n, x);
        } else {
            return countBaseOne(n);
        }
    }

    private int canBuild(int number, int power) {
        List<Integer> powers = new ArrayList<>();

        for (int base = 1; ; base++) {
            int curPower = (int) Math.pow(base, power);

            if (curPower > number) break;

            powers.add(curPower);
        }

        int[][] computed = new int[number + 1][powers.size()];
        for (int[] row : computed) {
            Arrays.fill(row, -1);
        }

        return helper(number, powers.size() - 1, powers, computed);
    }

    private int helper(int number, int powIdx, List<Integer> powers, int[][] computed) {
        if (powIdx < 0) {
            return number == 0 ? 1 : 0;
        } else if (number < 0) {
            return 0;
        } else if (number == 0) {
            return 1;
        } else if (computed[number][powIdx] != -1) {
            return computed[number][powIdx];
        }

        int picCurrentPower = helper(number - powers.get(powIdx), powIdx - 1, powers, computed);

        int ignoreCurrentPower = helper(number, powIdx - 1, powers, computed);

        computed[number][powIdx] = (picCurrentPower + ignoreCurrentPower) % MODULO;
        return computed[number][powIdx];
    }

    private int countBaseOne(int number) {
        int[][] computed = new int[number + 1][number + 1];
        for (int[] row : computed) {
            Arrays.fill(row, -1);
        }

        return helperPowerOne(number, number, computed);
    }

    private int helperPowerOne(int number, int integerPowerOne, int[][] computed) {
        if (integerPowerOne == 0) {
            return number == 0 ? 1 : 0;
        } else if (number < 0) {
            return 0;
        } else if (computed[number][integerPowerOne] != -1) {
            return computed[number][integerPowerOne];
        }

        int ignoreCurrentPower = helperPowerOne(number, integerPowerOne - 1, computed);

        int pickCurrentPower = helperPowerOne(number - integerPowerOne, integerPowerOne - 1, computed);
        computed[number][integerPowerOne] = (ignoreCurrentPower + pickCurrentPower) % MODULO;

        return computed[number][integerPowerOne];
    }
}
