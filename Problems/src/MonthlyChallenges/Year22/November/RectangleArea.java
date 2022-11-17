package MonthlyChallenges.Year22.November;

public class RectangleArea {

    public static void main(String[] args) {
        RectangleArea solution = new RectangleArea();

        int[][] tests = {
                {-3, 0, 3, 4, 0, -1, 9, 2},
                {-2, -2, 2, 2, -2, -2, 2, 2},
                {0, 0, 5, 5, 0, 0, 4, 4},
                {0, 0, 4, 4, 0, 0, 5, 5},
                {-2, -2, 2, 2, 1, -3, 3, 3},
                {-2, -2, 2, 2, 3, 3, 4, 4}
        };

        int[] results = {45, 16, 25, 25, 24, 17};

        for (int i = 0; i < tests.length; i++) {
            int[] rectangle = tests[i];
            int res = solution.computeArea(
                    rectangle[0], rectangle[1], rectangle[2], rectangle[3],
                    rectangle[4], rectangle[5], rectangle[6], rectangle[7]);

            System.out.println("Test #" + i + " - " + (res == results[i]));
        }
    }

    /**
     * LeetCode #223. Rectangle Area.
     * <p>
     * Complexity - O(1)
     * Memory - O(1)
     *
     * @param ax1 - bottom-left x-coordinate of a rectangle A.
     * @param ay1 - bottom-left y-coordinate of a rectangle A.
     * @param ax2 - top-right x-coordinate of a rectangle A.
     * @param ay2 - top-right y-coordinate of a rectangle A.
     * @param bx1 - bottom-left x-coordinate of a rectangle B.
     * @param by1 - bottom-left y-coordinate of a rectangle B.
     * @param bx2 - top-right x-coordinate of a rectangle B.
     * @param by2 - top-right y-coordinate of a rectangle B.
     * @return - the total area covered by the two rectangles.
     */
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        if (ax1 > bx1 || (ax1 == bx1 && ay1 > by1)) {
            return computeArea(bx1, by1, bx2, by2, ax1, ay1, ax2, ay2);
        }

        int firstArea = getArea(ax1, ay1, ax2, ay2);
        int secondArea = getArea(bx1, by1, bx2, by2);
        int intersectionArea = 0;

        if (areIntersects(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2)) {
            intersectionArea = getArea(bx1, Math.max(ay1, by1), Math.min(ax2, bx2), Math.min(ay2, by2));
        }

        return firstArea + secondArea - intersectionArea;
    }

    private boolean areIntersects(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        if (((ay1 <= by1 && by1 < ay2) || (ay1 < by2 && by2 <= ay2)) && (ax1 <= bx1 && bx1 < ax2)) {
            return true;
        } else if ((ay1 > by1 && ay2 < by2) && (ax1 <= bx1 && bx1 < ax2)) {
            return true;
        }
        return false;
    }

    private int getArea(int ax1, int ay1, int ax2, int ay2) {
        return (ax2 - ax1) * (ay2 - ay1);
    }
}
