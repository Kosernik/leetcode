package MonthlyChallenges.Year25.August;

public class MaximumAreaOfLongestDiagonalRectangle {

    /**
     * LeetCode №3000. Maximum Area of Longest Diagonal Rectangle.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param dimensions - a 2d array of dimensions of rectangles. dimensions[i][0] - length, dimensions[i][1] - width.
     * @return - the area of the rectangle having the longest diagonal. If there are multiple rectangles with the
     * longest diagonal, returns the area of the rectangle having the maximum area.
     */
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxDiagonal = 0;
        int maxArea = 0;

        for (int[] dimension : dimensions) {
            int curSquareDiagonal = dimension[0] * dimension[0] + dimension[1] * dimension[1];

            if (curSquareDiagonal > maxDiagonal) {
                maxDiagonal = curSquareDiagonal;
                maxArea = dimension[0] * dimension[1];
            } else if (curSquareDiagonal == maxDiagonal) {
                maxArea = Math.max(maxArea, dimension[0] * dimension[1]);
            }
        }

        return maxArea;
    }
}
