package MonthlyChallenges.Year24.July;

import java.util.*;

public class BuildMatrixWithConditions {
    public static void main(String[] args) {
        BuildMatrixWithConditions solution = new BuildMatrixWithConditions();

        int k0 = 3;
        int[][] row0 = {{1, 2}, {3, 2}};
        int[][] col0 = {{2, 1}, {3, 2}};

        System.out.println(Arrays.deepToString(solution.buildMatrix(k0, row0, col0)));
    }


    /**
     * LeetCpde №2392. Build a Matrix With Conditions.
     * <p>
     * Complexity - O(k^2 + N + M), N = rowConditions.length. M = colConditions.length.
     * Memory - O(k)
     *
     * @param k             - the size of resulting matrix and the number of values to place in a matrix.
     * @param rowConditions - rowConditions[i] = [above-i, below-i]. The number above-i should appear in a row that is
     *                      strictly above the row at which the number below-i appears.
     * @param colConditions - colConditions[i] = [left-i, right-i]. The number left-i should appear in a column that is
     *                      strictly left of the column at which the number right-i appears.
     * @return - any matrix that satisfies the conditions. If no answer exists, returns an empty matrix.
     */
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[] verticalOrder = getOrder(rowConditions, k);
        int[] horizontalOrder = getOrder(colConditions, k);

        if (verticalOrder.length == 0 || horizontalOrder.length == 0) {
            return new int[0][0];
        }

        int[][] matrix = new int[k][k];

        for (int r = 0; r < k; r++) {
            for (int c = 0; c < k; c++) {
                if (verticalOrder[r] == horizontalOrder[c]) {
                    matrix[r][c] = verticalOrder[r];
                }
            }
        }

        return matrix;
    }

    private int[] getOrder(int[][] conditions, int k) {
        int[] order = new int[k];

        List<Integer>[] neighbours = new ArrayList[k + 1];
        for (int i = 0; i <= k; i++) {
            neighbours[i] = new ArrayList<>();
        }
        int[] degree = new int[k + 1];

        for (int[] condition : conditions) {
            neighbours[condition[0]].add(condition[1]);
            degree[condition[1]]++;
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= k; i++) {
            if (degree[i] == 0) queue.offer(i);
        }

        int idx = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();

            order[idx] = node;
            idx++;
            k--;

            for (int neighbour : neighbours[node]) {
                degree[neighbour]--;
                if (degree[neighbour] == 0) {
                    queue.offer(neighbour);
                }
            }
        }

        if (k != 0) return new int[0];
        return order;
    }
}
