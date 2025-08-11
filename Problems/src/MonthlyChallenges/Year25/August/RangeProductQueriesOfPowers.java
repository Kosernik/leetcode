package MonthlyChallenges.Year25.August;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RangeProductQueriesOfPowers {
    public static void main(String[] args) {
        RangeProductQueriesOfPowers solution = new RangeProductQueriesOfPowers();

        System.out.println("Test 0:");
        int n0 = 1_000_000_000;
        int[][] queries0 = {{8, 12}, {2, 9}, {0, 12}};
        int[] result0 = {948232808, 526741586, 371048337};
        System.out.println(Arrays.toString(solution.productQueries(n0, queries0)));
        System.out.println(Arrays.toString(result0));

        System.out.println("\n" + "Test 1:");
        int n1 = 15;
        int[][] queries1 = {{0, 1}, {2, 2}, {0, 3}};
        int[] result1 = {2, 4, 64};
        System.out.println(Arrays.toString(solution.productQueries(n1, queries1)));
        System.out.println(Arrays.toString(result1));
    }

    /**
     * LeetCode №2438. Range Product Queries of Powers.
     * <p>
     * Complexity - O(M) M = queries.length.
     * Memory - O(1)
     *
     * @param n       - a positive integer. 1 <= n <= 1_000_000_000
     * @param queries - a 2d array of queries. queries[i] = {left_idx, right_idx}
     * @return - an array of size queries.length.
     */
    public int[] productQueries(int n, int[][] queries) {
        int MODULO = 1_000_000_007;

        int[] result = new int[queries.length];

        List<Integer> powers = new ArrayList<>();

        int currentPower = 1 << 29;
        while (currentPower != 0) {
            if (n >= currentPower) {
                powers.add(currentPower);
                n -= currentPower;
            }

            currentPower = currentPower >> 1;
        }

        int left = 0, right = powers.size() - 1;
        while (left < right) {
            int temp = powers.get(left);
            powers.set(left, powers.get(right));
            powers.set(right, temp);

            left++;
            right--;
        }

        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];

            long res = 1;
            for (int j = query[0]; j <= query[1]; j++) {
                res = (res * powers.get(j)) % MODULO;
            }

            result[i] = (int) res;
        }

        return result;
    }
}
