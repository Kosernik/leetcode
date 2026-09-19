package MonthlyChallenges.Year26.September;

public class CircleAndRectangleOverlapping {

    /**
     * LeetCode №1401. Circle and Rectangle Overlapping.
     * <p>
     * Complexity - O(1)
     * Memory - O(1)
     *
     * @param radius  - the radius of the circle.
     * @param xCenter - x coordinate of the center of the circle.
     * @param yCenter - y coordinate of the center of the circle.
     * @param x1      - x coordinate of the bottom left point of the rectangle.
     * @param y1      - y coordinate of the bottom left point of the rectangle.
     * @param x2      - x coordinate of the top right point of the rectangle.
     * @param y2      - y coordinate of the top right point of the rectangle.
     * @return - true if the circle and rectangle are overlapped, otherwise returns false.
     */
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        if ((xCenter - radius) > x2 || (xCenter + radius) < x1 || (yCenter + radius) < y1 || (yCenter - radius) > y2) {
            return false;
        }
        if (x1 <= xCenter && xCenter <= x2) {
            return true;
        }
        if (y1 <= yCenter && yCenter <= y2) {
            return true;
        }

        int squareRadius = radius * radius;

        int distToBotLeftX = Math.abs(xCenter - x1);
        int distToBotLeftY = Math.abs(yCenter - y1);
        if ((distToBotLeftX * distToBotLeftX + distToBotLeftY * distToBotLeftY) <= squareRadius) return true;

        int distToBotRightX = Math.abs(xCenter - x2);
        int distToBotRightY = Math.abs(yCenter - y1);
        if ((distToBotRightX * distToBotRightX + distToBotRightY * distToBotRightY) <= squareRadius) return true;

        int distToTopLeftX = Math.abs(xCenter - x1);
        int distToTopLeftY = Math.abs(yCenter - y2);
        if ((distToTopLeftX * distToTopLeftX + distToTopLeftY * distToTopLeftY) <= squareRadius) return true;

        int distToTopRightX = Math.abs(xCenter - x2);
        int distToTopRightY = Math.abs(yCenter - y2);
        if ((distToTopRightX * distToTopRightX + distToTopRightY * distToTopRightY) <= squareRadius) return true;

        return false;
    }
}
