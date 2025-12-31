package MonthlyChallenges.Year25.December;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class LastDayWhereYouCanStillCross {

    private int row = 1;
    private int col = 1;

    //  true = water, false = land.
    private boolean[][] grid = new boolean[row][col];

    private final int[] neighbours = {0, 1, 0, -1, 0};

    /**
     * LeetCode №1970. Last Day Where You Can Still Cross.
     *
     * @param row   - the number of rows in a grid.
     * @param col   - the number of columns in a grid.
     * @param cells - an array of coordinates of cell flooded with water. Coordinates are 1 indexed. Cells[i] is filled
     *              with water at day i.
     * @return - the last day where it is possible to walk from the top to the bottom by only walking on land cells.
     */
    public int latestDayToCross(int row, int col, int[][] cells) {
        this.row = row;
        this.col = col;

        this.grid = new boolean[row][col];

        int left = 0, right = cells.length, middle;

        while (left < right) {
            middle = (right - left) / 2 + left;

            if (isPossible(middle, cells)) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        return right;
    }

    private boolean isPossible(int candidateDay, int[][] cells) {
        fillGrid(candidateDay, cells);

        return dfs();
    }

    private boolean dfs() {
        boolean[][] visited = new boolean[row][col];

        Deque<int[]> stack = new ArrayDeque<>();
        for (int i = 0; i < col; i++) {
            if (!grid[0][i]) {  //  Land
                stack.push(new int[]{0, i});
            }
        }

        while (!stack.isEmpty()) {
            int[] cell = stack.pop();
            if (cell[0] == (row - 1)) return true;

            for (int i = 0; i < (neighbours.length - 1); i++) {
                int nextRow = cell[0] + neighbours[i];
                int nextCol = cell[1] + neighbours[i + 1];

                if (0 <= nextRow && nextRow < row && 0 <= nextCol && nextCol < col &&
                        !grid[nextRow][nextCol] && !visited[nextRow][nextCol]) {    //  Land && Not Visited
                    visited[nextRow][nextCol] = true;
                    stack.push(new int[]{nextRow, nextCol});
                }
            }
        }

        return false;
    }

    private void fillGrid(int lastDay, int[][] cells) {
        for (boolean[] row : grid) {
            Arrays.fill(row, false);
        }

        for (int i = 0; i <= lastDay; i++) {
            int[] cell = cells[i];
            grid[cell[0] - 1][cell[1] - 1] = true;
        }
    }
}
