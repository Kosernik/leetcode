package MonthlyChallenges.Year25.August;

public class FindMinimumAreaToCoverAllOnesI {
    public static void main(String[] args) {
        FindMinimumAreaToCoverAllOnesI solution = new FindMinimumAreaToCoverAllOnesI();

        int[][] grid6 = {
                {0, 0, 1},
                {0, 0, 1},
                {0, 0, 0}
        };
        int result6 = 2;
        System.out.println(solution.minimumArea(grid6) + " == " + result6);
    }

    /**
     * LeetCode №3195. Find the Minimum Area to Cover All Ones I.
     * <p>
     * Complexity - O(N*M), N = grig.length, M = grid[i].length.
     * Memory - O(1)
     *
     * @param grid - a 2d array of 0 and 1.
     * @return -the minimum possible area of a rectangle with horizontal and vertical sides, such that all the 1's in
     * grid lie inside this rectangle.
     */
    public int minimumArea(int[][] grid) {
        int length = grid.length, width = grid[0].length;

        int top = length, bottom = -1, left = width, right = -1;

        for (int row = 0; row < length; row++) {
            boolean foundOne = false;

            for (int col = 0; col < width; col++) {
                if (grid[row][col] == 1) {
                    left = Math.min(left, col);
                    right = Math.max(right, col);
                    foundOne = true;
                }
            }

            if (foundOne) {
                if (top == length) {
                    top = row;
                }

                bottom = row;
            }
        }

        if (top == length) return 0;

        return (bottom - top + 1) * (right - left + 1);
    }
}
