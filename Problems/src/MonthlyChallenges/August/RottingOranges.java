package MonthlyChallenges.August;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class RottingOranges {
    public static void main(String[] args) {
        RottingOranges solution = new RottingOranges();
        solution.testOrangesRotting();
//        int[][] test = {
//                {1,1,0,0},
//                {1,1,0,1},
//                {0,0,0,2},
//                {1,1,1,1}};
//        System.out.println(solution.orangesRotting(test));
    }

    private void testOrangesRotting() {
        int[][][] grids = {
                {{2,1,1},
                 {1,1,0},
                 {0,1,1}},

                {{2,1,1},
                 {0,1,1},
                 {1,0,1}},

                {{0,2}},

                {{1,1,0,0},
                 {1,1,0,1},
                 {0,0,0,2},
                 {1,1,1,1}}

        };

        int[] results = {4,-1,0,-1};

        int failed = 0;
        for (int i = 0; i < grids.length; i++) {
            int currSol = orangesRotting(grids[i]);
            if (currSol != results[i]) {
                failed++;
                System.out.println("Failed test #" + i);
                System.out.println("Got: " + currSol + ", instead of: " + results[i]);
            }
        }

        System.out.println("Success rate: " + (grids.length - failed) * 100.0 / grids.length);
    }

    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return -1;

        int length = grid.length; int width = grid[0].length;
        int numberOfFresh = 0;
        Queue<int[]> queue = new ArrayDeque<>();

        for (int row = 0; row < length; row++) {
            for (int col = 0; col < width; col++) {
                if (grid[row][col] == 1) {
                    numberOfFresh++;
                    if (isolated(grid, row, col)) return -1;
                } else if (grid[row][col] == 2) {
                    if (!isolated(grid, row, col)) {
                        queue.offer(new int[]{row, col});
                    }
                }
            }
        }
        if (numberOfFresh == 0) return 0;
        if (queue.isEmpty()) return -1;

        int minutes = 0;
        boolean[][] visited = new boolean[length][width];

        while (!queue.isEmpty()) {
            for (int i = 0, size = queue.size(); i < size; i++) {
                int[] coordinates = queue.poll();
                int row = coordinates[0]; int col = coordinates[1];
                visited[row][col] = true;
                numberOfFresh -= markRotten(grid, row, col);
                if (row > 0 && grid[row-1][col] == 2 && !visited[row-1][col]) { queue.offer(new int[]{row-1, col}); }
                if (col > 0 && grid[row][col-1] == 2 && !visited[row][col-1]) { queue.offer(new int[]{row, col-1}); }
                if (row < length - 1 && grid[row+1][col] == 2 && !visited[row+1][col]) { queue.offer(new int[]{row+1, col}); }
                if (col < width - 1 && grid[row][col+1] == 2 && !visited[row][col+1]) { queue.offer(new int[]{row, col+1}); }
            }
            minutes++;

//            System.out.println("After " + minutes);
//            for (int[] r : grid) {
//                System.out.println(Arrays.toString(r));
//            }

            if (numberOfFresh == 0) break;
        }

        if (numberOfFresh != 0) return -1;

        return minutes;
    }

    private int markRotten(int[][] grid, int row, int col) {
        int marked = 0;
        if (row > 0) {
            if (grid[row-1][col] == 1) {
                grid[row-1][col] = 2;
                marked++;
            }
        }
        if (col > 0) {
            if (grid[row][col-1] == 1) {
                grid[row][col-1] = 2;
                marked++;
            }
        }
        if (row < grid.length - 1) {
            if (grid[row+1][col] == 1) {
                grid[row+1][col] = 2;
                marked++;
            }
        }
        if (col < grid[0].length - 1) {
            if (grid[row][col+1] == 1) {
                grid[row][col+1] = 2;
                marked++;
            }
        }
        return marked;
    }

    private boolean isolated(int[][] grid, int row, int col) {
        if (row > 0) {
            if (grid[row-1][col] != 0) return false;
        }
        if (col > 0) {
            if (grid[row][col-1] != 0) return false;
        }
        if (row < grid.length - 1) {
            if (grid[row+1][col] != 0) return false;
        }
        if (col < grid[0].length - 1) {
            if (grid[row][col+1] != 0) return false;
        }
        return true;
    }
}
