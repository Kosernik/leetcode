package MonthlyChallenges.Year25.August;

import java.util.Arrays;

public class FindMaximumNumberOfFruitsCollected {
    public static void main(String[] args) {
        FindMaximumNumberOfFruitsCollected solution = new FindMaximumNumberOfFruitsCollected();

        int[][] fruits0 = {
                {8, 5, 0, 17, 15},
                {6, 0, 15, 6, 0},
                {7, 19, 16, 8, 18},
                {11, 3, 2, 12, 13},
                {17, 15, 15, 4, 6}
        };
        int result0 = 145;
        System.out.println(solution.maxCollectedFruits(fruits0) == result0);

        int[][] fruits1 = {
                {1, 2, 3, 4},
                {5, 6, 8, 7},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int result1 = 100;
        System.out.println(solution.maxCollectedFruits(fruits1) == result1);

        int[][] fruits2 = {
                {8, 5, 0, 17, 15, 7},
                {6, 0, 15, 6, 0, 3},
                {7, 19, 16, 8, 18, 8},
                {11, 3, 2, 12, 13, 3},
                {17, 15, 15, 4, 6, 7},
                {8, 6, 7, 2, 65, 7}
        };
        int result2 = 204;
        System.out.println(solution.maxCollectedFruits(fruits2) == result2);
    }


    private int lastValidIdx;

    /**
     * LeetCode №3363. Find the Maximum Number of Fruits Collected.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param fruits - a 2d square array of non-negative integers.
     * @return - the maximum number of fruits the children can collect from the dungeon.
     */
    public int maxCollectedFruits(int[][] fruits) {
        this.lastValidIdx = fruits.length - 1;

        int[][] visited = new int[fruits.length][fruits.length];

        int result = 0;
        for (int i = 0; i <= lastValidIdx; i++) {
            Arrays.fill(visited[i], -1);
            result += fruits[i][i];
        }

        result += getMaxScoreVertical(lastValidIdx - 1, lastValidIdx, fruits, visited);
        result += getMaxScoreHorizontal(lastValidIdx, lastValidIdx - 1, fruits, visited);

        return result;
    }

    private int getMaxScoreVertical(int row, int column, int[][] fruits, int[][] visited) {
        if (row < 0 || column > lastValidIdx || (column + row) < lastValidIdx) {
            return 0;
        } else if (visited[row][column] != -1) {
            return visited[row][column];
        }

        int bestTopResult = 0;

        for (int i = -1; i <= 1; i++) {
            bestTopResult = Math.max(bestTopResult, getMaxScoreVertical(row - 1, column + i, fruits, visited));
        }

        visited[row][column] = bestTopResult + fruits[row][column];
        return visited[row][column];
    }

    private int getMaxScoreHorizontal(int row, int column, int[][] fruits, int[][] visited) {
        if (column < 0 || row > lastValidIdx || (column + row) < lastValidIdx) {
            return 0;
        } else if (visited[row][column] != -1) {
            return visited[row][column];
        }

        int bestTopResult = 0;

        for (int i = -1; i <= 1; i++) {
            bestTopResult = Math.max(bestTopResult, getMaxScoreHorizontal(row + i, column - 1, fruits, visited));
        }

        visited[row][column] = bestTopResult + fruits[row][column];
        return visited[row][column];
    }
}
