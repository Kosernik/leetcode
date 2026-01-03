package MonthlyChallenges.Year26.January;

import java.util.ArrayList;
import java.util.List;

public class NumberOfWaysToPaintNx3Grid {
    public static void main(String[] args) {
        NumberOfWaysToPaintNx3Grid solution = new NumberOfWaysToPaintNx3Grid();

        int test0 = 1, result0 = 12;
        System.out.println(solution.numOfWays(test0) == result0);

        int test1 = 5000, result1 = 30228214;
        System.out.println(solution.numOfWays(test1) == result1);

        int test2 = 2, result2 = 54;
        System.out.println(solution.numOfWays(test2) == result2);

        int test3 = 3, result3 = 246;
        System.out.println(solution.numOfWays(test3) == result3);

        int test4 = 4, result4 = 1122;
        System.out.println(solution.numOfWays(test4) == result4);
    }

    private final int[] combinations = {121, 123, 131, 132, 212, 213, 231, 232, 312, 313, 321, 323};
    private final int[][] nextCombinations = {
            {4, 5, 7, 8, 9},    //  121
            {4, 6, 7, 8},       //  123
            {4, 5, 8, 9, 11},   //  131
            {5, 9, 10, 11},     //  132
            {0, 1, 2, 10, 11},  //  212
            {0, 2, 3, 10},      //  213
            {1, 8, 9, 11},      //  231
            {0, 1, 9, 10, 1},   //  232
            {0, 1, 2, 6},       //  312
            {0, 2, 3, 6, 7},    //  313
            {3, 4, 5, 7},       //  321
            {2, 3, 4, 6, 7},    //  323
    };

    /**
     * LeetCode №1411. Number of Ways to Paint N × 3 Grid.
     *
     * @param n - the total number of rows in a grid.
     * @return - the number of ways you can paint the grid. Result is modulo 1_000_000_007.
     */
    public int numOfWays(int n) {
        int MODULO = 1_000_000_007;

        long colourPattern121 = 6L, colourPattern123 = 6L;

        for (int row = 1; row < n; row++) {
            long next121 = colourPattern121 * 3 + colourPattern123 * 2;
            long next123 = (colourPattern121 + colourPattern123) * 2;

            colourPattern121 = next121 % MODULO;
            colourPattern123 = next123 % MODULO;
        }

        return (int) ((colourPattern121 + colourPattern123) % MODULO);
    }

    private void buildNextCombinations() {
        List<List<Integer>> nextCombinations = new ArrayList<>();
        for (int i = 0; i < combinations.length; i++) {
            nextCombinations.add(new ArrayList<>());
        }

        for (int i = 0; i < (combinations.length - 1); i++) {
            int first = combinations[i];

            for (int j = i + 1; j < combinations.length; j++) {
                int second = combinations[j];

                if (isValidPair(first, second)) {
                    nextCombinations.get(i).add(j);
                    nextCombinations.get(j).add(i);

                    System.out.println(first + " " + second);
                }
            }
        }

        for (int i = 0; i < nextCombinations.size(); i++) {
            System.out.println(i + " -- " + nextCombinations.get(i).toString());
        }
    }

    private boolean isValidPair(int first, int second) {
        while (first > 0) {
            if ((first % 10) == (second % 10)) {
                return false;
            }

            first /= 10;
            second /= 10;
        }

        return true;
    }
}
