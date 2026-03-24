package MonthlyChallenges.Year26.March;

public class ConstructProductMatrix {

    /**
     * LeetCode №2906. Construct Product Matrix.
     * <p>
     * Complexity - O(N*M), N = grid.length, M = grid[i].length
     * Memory - O(N*M)
     *
     * @param grid - a 2d matrix of positive integers.
     * @return - the product matrix of grid.
     */
    public int[][] constructProductMatrix(int[][] grid) {
        int height = grid.length, width = grid[0].length;

        int MODULO = 12345;
        int[][] result = new int[height][width];

        int[][][] prefixSuffix = new int[height][width][2];

        long product = 1L;
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                prefixSuffix[row][col][0] = (int) product;

                product = (product * grid[row][col]) % MODULO;
            }
        }
        product = 1L;
        for (int row = height - 1; row >= 0; row--) {
            for (int col = width - 1; col >= 0; col--) {
                prefixSuffix[row][col][1] = (int) product;

                product = (product * grid[row][col]) % MODULO;
            }
        }

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                result[row][col] = (prefixSuffix[row][col][0] * prefixSuffix[row][col][1]) % MODULO;
            }
        }

        return result;
    }
}
