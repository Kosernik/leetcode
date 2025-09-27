package MonthlyChallenges.Year25.September;

public class LargestTriangleArea {
    public static void main(String[] args) {
        LargestTriangleArea solution = new LargestTriangleArea();

        int[][] points2 = {
                {2, 5},
                {7, 7},
                {10, 8},
                {10, 10},
                {1, 1}
        };
        double result2 = 14.5;
        System.out.println(solution.largestTriangleArea(points2) == result2);
    }

    /**
     * LeetCode №812. Largest Triangle Area.
     *
     * @param points - a 2d array of coordinates of points. points[i] = {x-i, y-i}
     * @return - the area of the largest triangle that can be formed by any three different points.
     */
    public double largestTriangleArea(int[][] points) {
        double maxArea = 0.0;

        int length = points.length;
        for (int i = 0; i < length - 2; i++) {
            for (int j = i + 1; j < length - 1; j++) {
                for (int k = j + 1; k < length; k++) {
                    maxArea = Math.max(maxArea, getArea(points[i], points[j], points[k]));
                }
            }
        }

        return maxArea;
    }

    private static double getArea(int[] first, int[] second, int[] third) {
        //S = 0.5 * |x₁(y₂ - y₃) + x₂(y₃ - y₁) + x₃(y₁ - y₂)|.
        return
                Math.abs(first[0] * (second[1] - third[1]) +
                        second[0] * (third[1] - first[1]) +
                        third[0] * (first[1] - second[1])
                ) / 2.0;
    }
}
