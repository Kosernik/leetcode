package MonthlyChallenges.March21;

import java.util.*;

public class PacificAtlanticWaterFlow {
    /**
     * LeetCode #417
     *
     * Complexity - O(M*N), M - height of a matrix, N - width of a matrix.
     * Memory O(M*N)
     *
     * @param matrix - a 2d array of integers.
     * @return - a list of coordinates
     */
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return new ArrayList<>();

        int[][][] canReach = new int[matrix.length][matrix[0].length][2];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                reachPacific(matrix, canReach, r, c);
                reachAtlantic(matrix, canReach, r, c);
            }
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                if (canReach[r][c][0] == 1 && canReach[r][c][1] == 1) {
                    List<Integer> coordinates = new ArrayList<>();
                    coordinates.add(r); coordinates.add(c);
                    result.add(coordinates);
                }
            }
        }

        return result;
    }

    private void reachPacific(int[][] matrix, int[][][] canReach, int row, int col){
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{row, col});
        Set<String> visited = new HashSet<>();

        while (!queue.isEmpty()) {
            int[] curr = queue.removeFirst();
            if (curr[0] == 0 || curr[1] == 0 || canReach[curr[0]][curr[1]][0] == 1) {
                canReach[row][col][0] = 1;
                return;
            }

            if ((curr[0]+1) < matrix.length
                    && !visited.contains((curr[0]+1) + "*" + curr[1])
                    && matrix[(curr[0]+1)][curr[1]] <= matrix[curr[0]][curr[1]]
                    && canReach[curr[0]+1][curr[1]][0] != -1) {
                visited.add((curr[0]+1) + "*" + curr[1]);
                queue.offerLast(new int[] {curr[0]+1, curr[1]});
            }
            if ((curr[1]+1) < matrix[0].length
                    && !visited.contains((curr[0]) + "*" + (curr[1]+1))
                    && matrix[(curr[0])][curr[1]+1] <= matrix[curr[0]][curr[1]]
                    && canReach[curr[0]][curr[1]+1][0] != -1) {
                visited.add(curr[0]+ "*" + (curr[1]+1));
                queue.offerLast(new int[] {curr[0], curr[1]+1});
            }
            if (!visited.contains((curr[0]-1) + "*" + curr[1])
                    && matrix[curr[0]-1][curr[1]] <= matrix[curr[0]][curr[1]]
                    && canReach[curr[0]-1][curr[1]][0] != -1) {
                visited.add((curr[0]-1) + "*" + curr[1]);
                queue.offerLast(new int[] {curr[0]-1, curr[1]});
            }
            if (!visited.contains(curr[0] + "*" + (curr[1]-1))
                    && matrix[curr[0]][curr[1]-1] <= matrix[curr[0]][curr[1]]
                    && canReach[curr[0]][curr[1]-1][0] != -1) {
                visited.add(curr[0] + "*" + (curr[1]-1));
                queue.offerLast(new int[] {curr[0], curr[1]-1});
            }
        }

        canReach[row][col][0] = -1;
    }

    private void reachAtlantic(int[][] matrix, int[][][] canReach, int row, int col){
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{row, col});
        Set<String> visited = new HashSet<>();
        int height = matrix.length-1;
        int width = matrix[0].length-1;

        while (!queue.isEmpty()) {
            int[] curr = queue.removeFirst();
            if (curr[0] == height || curr[1] == width || canReach[curr[0]][curr[1]][1] == 1) {
                canReach[row][col][1] = 1;
                return;
            }

            if (curr[0] > 0
                    && !visited.contains((curr[0]-1) + "*" + curr[1])
                    && matrix[curr[0]-1][curr[1]] <= matrix[curr[0]][curr[1]]
                    && canReach[curr[0]-1][curr[1]][1] != -1) {
                visited.add((curr[0]-1) + "*" + curr[1]);
                queue.offerLast(new int[]{curr[0]-1, curr[1]});
            }
            if (curr[1] > 0
                    && !visited.contains(curr[0] + "*" + (curr[1]-1))
                    && matrix[curr[0]][curr[1]-1] <= matrix[curr[0]][curr[1]]
                    && canReach[curr[0]][curr[1]-1][1] != -1) {
                visited.add(curr[0] + "*" + (curr[1]-1));
                queue.offerLast(new int[] {curr[0], curr[1]-1});
            }
            if (!visited.contains((curr[0]+1) + "*" + curr[1])
                    && matrix[curr[0]+1][curr[1]] <= matrix[curr[0]][curr[1]]
                    && canReach[curr[0]+1][curr[1]][1] != -1) {
                visited.add((curr[0]+1) + "*" + curr[1]);
                queue.offerLast(new int[] {curr[0]+1, curr[1]});
            }
            if (!visited.contains(curr[0] + "*" + (curr[1]+1))
                    && matrix[curr[0]][curr[1]+1] <= matrix[curr[0]][curr[1]]
                    && canReach[curr[0]][curr[1]+1][1] != -1) {
                visited.add(curr[0] + "*" + (curr[1]+1));
                queue.offerLast(new int[] {curr[0], curr[1]+1});
            }
        }
        canReach[row][col][1] = -1;
    }
}
