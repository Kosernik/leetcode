package MonthlyChallenges.Year21.June21;

import java.util.ArrayDeque;
import java.util.Arrays;

public class OutOfBoundaryPaths {
    public static void main(String[] args) {
        OutOfBoundaryPaths solution = new OutOfBoundaryPaths();
        System.out.println(solution.findPaths(2, 2, 2, 0, 0));
        System.out.println("");

        System.out.println(solution.findPaths(1, 3, 3, 0, 1));
    }

    /**
     * LeetCode #576
     *
     * @param m           - the height of the field.
     * @param n           - the width of the field.
     * @param maxMove     - the maximum number of moves.
     * @param startRow    - starting row position (0-indexed).
     * @param startColumn - starting column position (0-indexed).
     * @return - the number of paths to move the ball out of the grid boundary. (modulo 1_000_000_007).
     */
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int MODULO = 1_000_000_007;

        int[][] grid = new int[m][n];
        grid[startRow][startColumn] = 1;

        int result = 0;
        for (int i = 0; i < maxMove; i++) {
            int[][] curGrid = new int[m][n];

            for (int row = 0; row < m; row++) {
                for (int col = 0; col < n; col++) {
                    if (row == 0) result = (result + grid[row][col]) % MODULO;
                    if (col == 0) result = (result + grid[row][col]) % MODULO;
                    if (row + 1 == m) result = (result + grid[row][col]) % MODULO;
                    if (col + 1 == n) result = (result + grid[row][col]) % MODULO;

                    int top = row > 0 ? grid[row - 1][col] : 0;
                    int left = col > 0 ? grid[row][col - 1] : 0;
                    int bottom = row + 1 < m ? grid[row + 1][col] : 0;
                    int right = col + 1 < n ? grid[row][col + 1] : 0;
                    curGrid[row][col] = ((top + left) % MODULO + (bottom + right) % MODULO) % MODULO;
                }
            }

            grid = curGrid;
        }

        return result;
    }

    @Deprecated
    public int findPathsAlt(int m, int n, int maxMove, int startRow, int startColumn) {
        int MODULO = 1_000_000_007;
        int result = 0;

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startRow, startColumn});

        while (maxMove != 0) {
            for (int i = queue.size(); i > 0; i--) {
                int[] curCell = queue.removeFirst();
                int row = curCell[0];
                int col = curCell[1];

                if (row == 0) result = (result + 1) % MODULO;
                if (col == 0) result = (result + 1) % MODULO;
                if (row + 1 == m) result = (result + 1) % MODULO;
                if (col + 1 == n) result = (result + 1) % MODULO;

                if (row > 0) queue.offerLast(new int[]{row - 1, col});
                if (col > 0) queue.offerLast(new int[]{row, col - 1});
                if (row + 1 < m) queue.offerLast(new int[]{row + 1, col});
                if (col + 1 < n) queue.offerLast(new int[]{row, col + 1});
            }

            maxMove--;
        }

        return result;
    }

    @Deprecated
    public int findPathsSlow(int m, int n, int maxMove, int startRow, int startColumn) {
        int MODULO = 1_000_000_007;

        int[][] bigGrid = new int[m + 2][n + 2];
        bigGrid[startRow + 1][startColumn + 1] = 1;

//        printArr(bigGrid);

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startRow + 1, startColumn + 1});

        while (maxMove > 1) {
            int[][] currGrid = new int[m + 2][];
            for (int j = 0; j < bigGrid.length; j++) {
                currGrid[j] = new int[n + 2];
                ;
                System.arraycopy(bigGrid[j], 0, currGrid[j], 0, n + 2);
            }

            for (int i = queue.size(); i > 0; i--) {
                int[] curCoords = queue.removeFirst();
                int row = curCoords[0];
                int col = curCoords[1];

                if (row - 1 > 0) {
                    currGrid[row - 1][col] = (currGrid[row - 1][col] + bigGrid[row][col]) % MODULO;
                    queue.offerLast(new int[]{row - 1, col});
                }
                if (col - 1 > 0) {
                    currGrid[row][col - 1] = (currGrid[row][col - 1] + bigGrid[row][col]) % MODULO;
                    queue.offerLast(new int[]{row, col - 1});
                }
                if (row + 1 <= m) {
                    currGrid[row + 1][col] = (currGrid[row + 1][col] + bigGrid[row][col]) % MODULO;
                    queue.offerLast(new int[]{row + 1, col});
                }
                if (col + 1 <= n) {
                    currGrid[row][col + 1] = (currGrid[row][col + 1] + bigGrid[row][col]) % MODULO;
                    queue.offerLast(new int[]{row, col + 1});
                }
            }

            bigGrid = currGrid;
            maxMove--;

//            printArr(bigGrid);
        }

        int result = 0;
        for (int i = 1; i < bigGrid[0].length; i++) {
            result = (result + bigGrid[1][i]) % MODULO;
            result = (result + bigGrid[m][i]) % MODULO;
        }
        for (int i = 1; i < bigGrid.length - 1; i++) {
            result = (result + bigGrid[i][1]) % MODULO;
            result = (result + bigGrid[i][n]) % MODULO;
        }
//        for (int i = 0; i < bigGrid[0].length; i++) {
//            result = (result + bigGrid[0][i]) % MODULO;
//            result = (result + bigGrid[m+1][i]) % MODULO;
//        }
//        for (int i = 1; i < bigGrid.length-1; i++) {
//            result = (result + bigGrid[i][0]) % MODULO;
//            result = (result + bigGrid[i][n+1]) % MODULO;
//        }

//        printArr(bigGrid);
        return result;
    }

    private void printArr(int[][] grid) {
        for (int[] ints : grid) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println("--------------");
    }
}
