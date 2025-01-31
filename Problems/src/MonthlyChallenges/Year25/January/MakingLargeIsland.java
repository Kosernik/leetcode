package MonthlyChallenges.Year25.January;

import java.util.*;

public class MakingLargeIsland {
    public static void main(String[] args) {
        MakingLargeIsland solution = new MakingLargeIsland();

        int[][] test1 = {
                {1, 1},
                {1, 0}
        };
        System.out.println(solution.largestIsland(test1) == 4);
        System.out.println();

        int[][] test2 = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 0, 0},
                {0, 1, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 0, 0},
                {0, 1, 1, 1, 1, 0, 0}
        };
        System.out.println(solution.largestIsland(test2) == 18);
    }

    private final int[] NEIGHBOURS = {0, 1, 0, -1, 0};

    private int height;
    private int width;

    /**
     * LeetCode №827. Making A Large Island.
     * <p>
     * Complexity - O(N*M)
     * Memory - O(N*M)
     *
     * @param grid - a square matrix. grid[i][j] = 0 means it is a water cell, grid[i][j] = 1 means it is a land cell.
     * @return - the size of the largest island in grid after changing at most one 0 to be 1.
     */
    public int largestIsland(int[][] grid) {
        height = grid.length;
        width = grid[0].length;

        Map<Integer, Set<int[]>> idBorders = new HashMap<>();
        Map<Integer, Integer> idAreas = new HashMap<>();

        int[][] ids = new int[height][width];
        int idToBeSet = 1;

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (grid[row][col] == 1 && ids[row][col] == 0) {
                    discoverIsland(row, col, grid, idToBeSet, ids, idBorders, idAreas);

                    idToBeSet++;
                }
            }
        }

        if (idAreas.isEmpty()) return 1;
        int result = 0;

        for (Map.Entry<Integer, Integer> entry : idAreas.entrySet()) {
            int curID = entry.getKey();
            int curArea = entry.getValue();

            if ((curArea * 2 + 1) < result) continue;

            Set<int[]> border = idBorders.get(curID);
            int curResult = curArea;

            for (int[] coordinate : border) {
                int row = coordinate[0];
                int col = coordinate[1];

                for (int i = 0; i < NEIGHBOURS.length - 1; i++) {
                    int nextRow = row + NEIGHBOURS[i];
                    int nextCol = col + NEIGHBOURS[i + 1];

                    if (isValidNeighbour(nextRow, nextCol) && grid[nextRow][nextCol] == 0) {
                        int tempArea = curArea + 1;
                        Set<Integer> usedIDs = new HashSet<>();
                        usedIDs.add(curID);

                        for (int j = 0; j < NEIGHBOURS.length - 1; j++) {
                            int nextNextRow = nextRow + NEIGHBOURS[j];
                            int nextNextCol = nextCol + NEIGHBOURS[j + 1];

                            if (isValidNeighbour(nextNextRow, nextNextCol) &&
                                    grid[nextNextRow][nextNextCol] != 0 && !usedIDs.contains(ids[nextNextRow][nextNextCol])) {
                                usedIDs.add(ids[nextNextRow][nextNextCol]);
                                tempArea += idAreas.get(ids[nextNextRow][nextNextCol]);
                            }
                        }

                        curResult = Math.max(curResult, tempArea);
                    }
                }
            }

            result = Math.max(result, curResult);
        }

        return result;
    }

    private void discoverIsland(
            int row, int column, int[][] grid,
            int id, int[][] ids,
            Map<Integer, Set<int[]>> idBorders, Map<Integer, Integer> idAreas
    ) {
        Set<int[]> border = new HashSet<>();

        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{row, column});
        ids[row][column] = id;

        int area = 0;

        while (!deque.isEmpty()) {
            int[] coordinate = deque.poll();

            area++;

            boolean isBorder = false;

            for (int i = 0; i < NEIGHBOURS.length - 1; i++) {
                int nextRow = coordinate[0] + NEIGHBOURS[i];
                int nextCol = coordinate[1] + NEIGHBOURS[i + 1];

                if (isValidNeighbour(nextRow, nextCol)) {
                    if (grid[nextRow][nextCol] == 0) {
                        isBorder = true;
                    } else {
                        if (ids[nextRow][nextCol] != id) {
                            ids[nextRow][nextCol] = id;
                            deque.offer(new int[]{nextRow, nextCol});
                        }
                    }
                }
            }

            if (isBorder) {
                border.add(coordinate);
            }
        }

        idBorders.put(id, border);
        idAreas.put(id, area);
    }

    private boolean isValidNeighbour(int row, int col) {
        return (0 <= row && row < height && 0 <= col && col < width);
    }
}
