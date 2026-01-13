package MonthlyChallenges.Year26.January;

public class SeparateSquaresI {

    /**
     * LeetCode №3453. Separate Squares I.
     *
     * @param squares - an array of coordinates and lengths of squares. squares[i] = [Xi, Yi, Li], Li = length
     * @return - the minimum y-coordinate value of a horizontal line such that the total area of the squares above the
     * line equals the total area of the squares below the line.
     */
    public double separateSquares(int[][] squares) {
        double MAX_ERROR = 0.00_001;

        double left = 0;
        double right = squares[0][1] + squares[0][2];

        double totalArea = 0;

        for (int[] square : squares) {
            double length = square[2];

            totalArea += length * length;

            right = Math.max(right, square[1] + length);
        }

        double middle;
        double halfArea = totalArea / 2;

        while (Math.abs(right - left) > MAX_ERROR) {
            middle = (left + right) / 2;

            if (moreOrHalf(middle, squares, halfArea)) {
                right = middle;
            } else {
                left = middle;
            }
        }

        return right;
    }

    private boolean moreOrHalf(double candidate, int[][] squares, double halfArea) {
        double area = 0.0;

        for (int[] square : squares) {
            int y = square[1];
            double length = square[2];

            if (y < candidate) {
                area += length * (Math.min(candidate - y, length));
            }
        }

        return area >= halfArea;
    }
}
