package MonthlyChallenges.November;

import java.util.Arrays;

public class ValidSquare {
    public static void main(String[] args) {
        ValidSquare solution = new ValidSquare();
        int[][][] points = {
                {{0,0},{1,1},{1,0},{0,1}},
                {{8,6},{3,7},{7,1},{2,2}},
                {{8,6},{3,7},{9,11},{4,12}}
        };
        System.out.println(solution.validSquare(points[0][0], points[0][1], points[0][2], points[0][3]));
        System.out.println(solution.validSquare(points[1][0], points[1][1], points[1][2], points[1][3]));
        System.out.println(solution.validSquare(points[2][0], points[2][1], points[2][2], points[2][3]));
    }

    /**
     * Checking if the 4 given points forms a square.
     * Coordinate points are in a range [-10000, 10000].
     *
     * Complexity - O(1)
     * Memory - O(1)
     *
     * @param p1 - integer coordinates of a point.
     * @param p2 - integer coordinates of a point.
     * @param p3 - integer coordinates of a point.
     * @param p4 - integer coordinates of a point.
     * @return - True - if 4 given points are coordinates of a square, False - otherwise.
     */
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        if (Arrays.equals(p1, p2) && Arrays.equals(p1, p3) && Arrays.equals(p1, p4)) return false;
        return validSquareHelper(p1, p2, p3, p4) || validSquareHelper(p1, p3, p2, p4);
    }

    public boolean validSquareHelper(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[] secondP = {p2[0] - p1[0], p2[1] - p1[1]};
        int[] orthoToP11 = {secondP[1] + p1[0], -secondP[0] + p1[1]};
        int[] orthoToP12 = {-secondP[1] + p1[0], secondP[0] + p1[1]};

        if (Arrays.equals(p3, orthoToP11)) {
            return Arrays.equals(p4, new int[] {secondP[1] + p2[0], -secondP[0] + p2[1]});
        } else if (Arrays.equals(p3, orthoToP12)) {
            return Arrays.equals(p4, new int[] {-secondP[1] + p2[0], secondP[0] + p2[1]});
        } else if (Arrays.equals(p4, orthoToP11)) {
            return Arrays.equals(p3, new int[] {secondP[1] + p2[0], -secondP[0] + p2[1]});
        } else if (Arrays.equals(p4, orthoToP12)) {
            return Arrays.equals(p3, new int[] {-secondP[1] + p2[0], secondP[0] + p2[1]});
        } else {
            return false;
        }
    }
}
