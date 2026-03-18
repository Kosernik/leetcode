package MonthlyChallenges.Year26.March;

public class CountSubmatricesWithTopLeftElementAndSumLessThanK {
    public static void main(String[] args) {
        CountSubmatricesWithTopLeftElementAndSumLessThanK solution = new CountSubmatricesWithTopLeftElementAndSumLessThanK();

        int[][] grid0 = {
                {7, 6, 3},
                {6, 6, 1}};
        int k0 = 18;
        int result0 = 4;
        System.out.println(solution.countSubmatrices(grid0, k0) == result0);

        int[][] grid1 = {
                {7, 2, 9},
                {1, 5, 0},
                {2, 6, 6}};
        int k1 = 20;
        int resul1 = 6;
        System.out.println(solution.countSubmatrices(grid1, k1) == resul1);
    }

    /**
     * LeetCode №3070. Count Submatrices with Top-Left Element and Sum Less Than k.
     * <p>
     * Complexity - O(N*M), N = grid.length, M = grid[0].length
     * Memory - O(M)
     *
     * @param grid - a 2d matrix of non-negative integers.
     * @param k    - a positive integer.
     * @return - the number of submatrices that contain the top-left element of the grid, and have a sum less than or
     * equal to k.
     */
    public int countSubmatrices(int[][] grid, int k) {
        int totalCount = 0;

        int width = grid[0].length;
        int[] prevRowsSums = new int[width];

        for (int[] row : grid) {
            int curRowSum = 0;

            for (int col = 0; col < width; col++) {
                curRowSum += row[col];
                prevRowsSums[col] += curRowSum;

                if (prevRowsSums[col] <= k) {
                    totalCount++;
                } else {
                    break;
                }
            }
        }

        return totalCount;
    }
}
