package MonthlyChallenges.Year26.January;

public class FindLargestAreaOfSquareInsideTwoRectangles {
    public static void main(String[] args) {
        FindLargestAreaOfSquareInsideTwoRectangles solution = new FindLargestAreaOfSquareInsideTwoRectangles();

        int[][] bottomLeft0 = {{1, 1}, {2, 2}, {3, 1}};
        int[][] topRight0 = {{3, 3}, {4, 4}, {6, 6}};
        int result0 = 1;
        System.out.println(solution.largestSquareArea(bottomLeft0, topRight0) == result0);

        System.out.println();
        int[][] bottomLeft1 = {{1, 1}, {1, 3}, {1, 5}};
        int[][] topRight1 = {{5, 5}, {5, 7}, {5, 9}};
        int result1 = 4;
        System.out.println(solution.largestSquareArea(bottomLeft1, topRight1) == result1);

        System.out.println();
        int[][] bottomLeft2 = {{1, 1}, {2, 2}, {1, 2}};
        int[][] topRight2 = {{3, 3}, {4, 4}, {3, 4}};
        int result2 = 1;
        System.out.println(solution.largestSquareArea(bottomLeft2, topRight2) == result2);

        System.out.println();
        int[][] bottomLeft3 = {{1, 1}, {3, 3}, {3, 1}};
        int[][] topRight3 = {{2, 2}, {4, 4}, {4, 2}};
        int result3 = 0;
        System.out.println(solution.largestSquareArea(bottomLeft3, topRight3) == result3);
    }

    /**
     * LeetCode №3047. Find the Largest Area of Square Inside Two Rectangles.
     * <p>
     * Complexity - O(N^2), N = bottomLeft.length = topRight.length.
     * Memory - O(1)
     *
     * @param bottomLeft - an array of coordinates of bottom left corners of rectangles.
     * @param topRight   - an array of coordinates of top right corners of rectangles.
     *                   bottomLeft.length = topRight.length.
     * @return - the maximum area of a square that can fit inside the intersecting region of at least two rectangles.
     * Returns 0 if such square does not exist.
     */
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int maxSide = 0;

        for (int i = 1; i < bottomLeft.length; i++) {
            for (int j = 0; j < i; j++) {
                maxSide = Math.max(maxSide, getSide(bottomLeft[i], topRight[i], bottomLeft[j], topRight[j]));
            }
        }

        return maxSide * (long) maxSide;
    }

    private int getSide(int[] firstBottom, int[] firstTop, int[] secondBottom, int[] secondTop) {
        if (firstBottom[1] > secondBottom[1]) return getSide(secondBottom, secondTop, firstBottom, firstTop);

        int x1 = firstBottom[0];
        int y1 = firstBottom[1];
        int x2 = firstTop[0];
        int y2 = firstTop[1];

        int x3 = secondBottom[0];
        int y3 = secondBottom[1];
        int x4 = secondTop[0];
        int y4 = secondTop[1];

        if (y3 >= y2) return 0;   //  Too high
        if (x4 <= x1) return 0;   //  Too far left
        if (x3 >= x2) return 0;   //  Too far right

        int horizontalSide = Math.min(x2, x4) - Math.max(x1, x3);
        int verticalSide = Math.min(y2, y4) - y3;

        return Math.min(horizontalSide, verticalSide);
    }
}
