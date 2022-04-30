package Contests;

import java.util.HashSet;
import java.util.Set;

public class BiweeklyContest77 {

    public static void main(String[] args) {
        BiweeklyContest77 solution = new BiweeklyContest77();

        solution.test("Hello world!");
    }

    private void test(String input) {
        System.out.println(input);
    }

    //  1
    public int countPrefixes(String[] words, String s) {
        int result = 0;

        for (String word : words) {
            if (s.startsWith(word)) result++;
        }

        return result;
    }

    //  2
    public int minimumAverageDifference(int[] nums) {
        if (nums.length == 1) return 0;
        int length = nums.length;
        long[] prefixSum = new long[length+1];

        for (int i = 0; i < length; i++) {
            prefixSum[i+1] = prefixSum[i] + nums[i];
        }

        int minAverageDiff = Integer.MAX_VALUE;
        int minIdx = -1;

        for (int i = 0; i < length-1; i++) {
            int left = (int) (prefixSum[i+1] / (i+1));
            int right = (int) ((prefixSum[length] - prefixSum[i+1]) / (length - i - 1));

            int curDiff = Math.abs(left - right);
            if (curDiff < minAverageDiff) {
                minAverageDiff = curDiff;
                minIdx = i;
            }
        }

        int last = (int) (prefixSum[length] / length);
        if (last < minAverageDiff) minIdx = length-1;

        return minIdx;
    }

    //  3
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        //  1 = wall, 2 = guard, 3 = guarded
        int[][] grid = new int[m][n];

        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = 1;
        }

        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = 2;
        }

        for (int[] guard : guards) {
            guardCells(grid, guard, 3);
        }

        int unguardedCells = 0;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 0) unguardedCells++;
            }
        }

        return unguardedCells;
    }
    private void guardCells(int[][] grid, int[] guard, int val) {
        int row = guard[0];
        int col = guard[1];

        while (row-1 >= 0) {
            if (grid[row-1][col] != 1 && grid[row-1][col] != 2) {
                grid[row-1][col] = val;
                row--;
            } else {
                break;
            }
        }

        row = guard[0];
        while (row+1 < grid.length) {
            if (grid[row+1][col] != 1 && grid[row+1][col] != 2) {
                grid[row+1][col] = val;
                row++;
            } else {
                break;
            }
        }

        row = guard[0];
        while (col-1 >= 0) {
            if (grid[row][col-1] != 1 && grid[row][col-1] != 2) {
                grid[row][col-1] = val;
                col--;
            } else {
                break;
            }
        }

        col = guard[1];
        while (col+1 < grid[row].length) {
            if (grid[row][col+1] != 1 && grid[row][col+1] != 2) {
                grid[row][col+1] = val;
                col++;
            } else {
                break;
            }
        }
    }

    //  4
    int[] directions = {0,1,0,-1,0};
    public int maximumMinutes(int[][] grid) {
        boolean[][] validCells = new boolean[grid.length][grid[0].length];

        markValidCells(grid, validCells);
        if (!validCells[0][0]) return -1;

        return -1;
    }

    private void markValidCells(int[][] grid, boolean[][] validCells) {
        isValid(grid, validCells, 0, 0, new HashSet<>());
    }

    private boolean isValid(int[][] grid, boolean[][] validCells, int row, int col, Set<String> visited) {
        if (row+1 == grid.length && col+1 == grid[0].length) return true;
        else if (grid[row][col] == 1 || grid[row][col] == 2) return false;

        boolean result = false;

        for (int i = 0; i < 4; i++) {
            int neighbourRow = row + directions[i];
            int neighbourCol = col + directions[i+1];
            if (neighbourRow >= 0 && neighbourRow < grid.length &&
                    neighbourCol >= 0 && neighbourCol < grid[0].length &&
                    !visited.contains(neighbourRow + "*" + neighbourCol)) {
                visited.add(neighbourRow + "*" + neighbourCol);
                result |= isValid(grid, validCells, neighbourRow, neighbourCol, visited);
            }
        }

        validCells[row][col] = result;
        return result;
    }
}
