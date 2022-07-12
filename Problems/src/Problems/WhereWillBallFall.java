package Problems;

import java.util.ArrayDeque;
import java.util.Arrays;

public class WhereWillBallFall {
    public static void main(String[] args) {
        WhereWillBallFall solution = new WhereWillBallFall();

        int[][] test0 = {
                {1,1,1,-1,-1},
                {1,1,1,-1,-1},
                {-1,-1,-1,1,1},
                {1,1,1,1,-1},
                {-1,-1,-1,-1,-1}
        };

        System.out.println(Arrays.toString(solution.findBall(test0)));
    }

    /**
     * LeetCode #1706. Where Will the Ball Fall.
     *
     * @param grid - a 2d array representing the grid.
     *             grid[i][j] = 1 means that the ball moves to the right.
     *             grid[i][j] = -1 means that the ball moves to the left.
     * @return - an array of indexes of columns where each ball falls, result[i] = -1 if a ball is stuck.
     */
    public int[] findBall(int[][] grid) {
        int width = grid[0].length;
        int[] result = new int[width];

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < width; i++) {
            //  current position, start index
            queue.offer(new int[] {i, i});
        }

        for (int[] row : grid) {
            if (queue.isEmpty()) break;

            for (int i = queue.size(); i > 0; i--) {
                int[] currentBall = queue.removeFirst();
                if (row[currentBall[0]] == 1) {
                    if (currentBall[0] < width - 1 && row[currentBall[0]] == row[currentBall[0]+1]) {
                        currentBall[0] = currentBall[0] + 1;
                        queue.offerLast(currentBall);
                    } else {
                        result[currentBall[1]] = -1;
                    }
                } else {
                    if (currentBall[0] > 0 && row[currentBall[0]-1] == row[currentBall[0]]) {
                        currentBall[0] = currentBall[0] - 1;
                        queue.offerLast(currentBall);
                    } else {
                        result[currentBall[1]] = -1;
                    }
                }
            }
        }
        for (int[] ball : queue) {
            result[ball[1]] = ball[0];
        }

        return result;
    }
}
