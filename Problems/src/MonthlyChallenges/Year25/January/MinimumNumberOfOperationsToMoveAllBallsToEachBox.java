package MonthlyChallenges.Year25.January;

import java.util.Arrays;

public class MinimumNumberOfOperationsToMoveAllBallsToEachBox {
    public static void main(String[] args) {
        MinimumNumberOfOperationsToMoveAllBallsToEachBox solution = new MinimumNumberOfOperationsToMoveAllBallsToEachBox();

        String test0 = "110";
        System.out.println(Arrays.toString(solution.minOperations(test0)));

        String test1 = "001011";
        System.out.println(Arrays.toString(solution.minOperations(test1)));
    }

    /**
     * LeetCode №1769. Minimum Number of Operations to Move All Balls to Each Box.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param boxes - a binary string of '0' and '1'.
     * @return -  an array result of size n, where result[i] is the minimum number of operations needed to move all
     * the balls to the i-th box.
     */
    public int[] minOperations(String boxes) {
        int length = boxes.length();
        int[] result = new int[length];
        if (length == 1) return result;

        char[] box = boxes.toCharArray();

        int[][] movesAndBalls = new int[length][2];
        if (box[0] == '1') {
            movesAndBalls[0][1] = 1;
        }

        for (int i = 1; i < length; i++) {
            int curBall = box[i] == '1' ? 1 : 0;
            movesAndBalls[i][0] = movesAndBalls[i - 1][0] + movesAndBalls[i - 1][1];
            movesAndBalls[i][1] = movesAndBalls[i - 1][1] + curBall;
        }

        result[length - 1] = movesAndBalls[length - 1][0];
        movesAndBalls[length - 1][0] = 0;
        if (box[length - 1] == '1') {
            movesAndBalls[length - 1][1] = 1;
        } else {
            movesAndBalls[length - 1][1] = 0;
        }

        for (int i = length - 2; i > 0; i--) {
            result[i] = movesAndBalls[i][0] + movesAndBalls[i + 1][0] + movesAndBalls[i + 1][1];

            int curBall = box[i] == '1' ? 1 : 0;
            movesAndBalls[i][0] = movesAndBalls[i + 1][0] + movesAndBalls[i + 1][1];
            movesAndBalls[i][1] = movesAndBalls[i + 1][1] + curBall;
        }

        movesAndBalls[0][0] = movesAndBalls[1][0] + movesAndBalls[1][1];
        result[0] = movesAndBalls[1][0] + movesAndBalls[1][1];

        return result;
    }
}
