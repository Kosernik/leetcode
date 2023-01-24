package MonthlyChallenges.Year23.January;

import java.util.ArrayDeque;
import java.util.Deque;

public class SnakesAndLadders {
    public static void main(String[] args) {
        SnakesAndLadders solution = new SnakesAndLadders();

        int[][] testBoard0 = {
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 35, -1, -1, 13, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 15, -1, -1, -1, -1}
        };

        System.out.println(solution.snakesAndLadders(testBoard0));
    }


    private int width = 0;

    /**
     * LeetCode #909. Snakes and Ladders.
     *
     * @param board - a square matrix. board[n - 1][0] - is the starting position.
     *              board[r][c] == -1 means there is no snake or ladder on this cell.
     *              board[r][c] != -1 means there is a ladder or a snake, and it leads to the cell board[r][c].
     * @return -  the least number of moves required to reach the square n2.
     * If it is not possible to reach the square, return -1.
     */
    public int snakesAndLadders(int[][] board) {
        this.width = board.length;
        int size = width * width;

        boolean[] visited = new boolean[size + 1];
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        int steps = 1;
        visited[1] = true;

        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                int cell = queue.poll();

                for (int j = 1; j <= 6; j++) {
                    int nextCell = cell + j;

                    int[] nextCoordinates = getCoordinates(nextCell);
                    if (board[nextCoordinates[0]][nextCoordinates[1]] != -1) {
                        nextCell = board[nextCoordinates[0]][nextCoordinates[1]];
                    }
                    if (nextCell == size) return steps;

                    if (!visited[nextCell]) {
                        visited[nextCell] = true;
                        queue.offer(nextCell);
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    private int[] getCoordinates(int cellNumber) {
        int row = this.width - (cellNumber - 1) / this.width - 1;
        int col;
        if ((cellNumber - 1) / this.width % 2 == 0) {
            col = (cellNumber - 1) % this.width;
        } else {
            col = this.width - 1 - (cellNumber - 1) % this.width;
        }
        return new int[]{row, col};
    }
}
