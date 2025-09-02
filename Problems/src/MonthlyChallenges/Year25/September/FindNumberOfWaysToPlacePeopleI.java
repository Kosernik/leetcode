package MonthlyChallenges.Year25.September;

import java.util.Arrays;

public class FindNumberOfWaysToPlacePeopleI {
    public static void main(String[] args) {
        FindNumberOfWaysToPlacePeopleI solution = new FindNumberOfWaysToPlacePeopleI();

        int[][] points0 = {{1, 1}, {2, 2}, {3, 3}};
        int result0 = 0;
        System.out.println(solution.numberOfPairs(points0) == result0);

        System.out.println();
        int[][] points1 = {{6, 2}, {4, 4}, {2, 6}};
        int result1 = 2;
        System.out.println(solution.numberOfPairs(points1) == result1);

        System.out.println();
        int[][] points2 = {{3, 1}, {1, 3}, {1, 1}};
        int result2 = 2;
        System.out.println(solution.numberOfPairs(points2) == result2);
    }

    /**
     * LeetCode №3025. Find the Number of Ways to Place People I.
     * <p>
     * Complexity - O(N*logN + N^3), N = points.length.
     * Memory - O(sorting memory)
     * <p>
     * A pair of points A and B is valid when:
     * * A is on the upper left side of B, and
     * * there are no other points in the rectangle (or line) they make (including the border).
     *
     * @param points - a 2d array of coordinates of points. points[i] = [x-i, y-i]
     * @return - the number of valid pairs.
     */
    public int numberOfPairs(int[][] points) {
        Arrays.sort(points,
                (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(b[1], a[1])
        );

        int result = 0;

        int length = points.length;
        for (int i = 0; i < length - 1; i++) {
            int[] point = points[i];
            int y1 = point[1];

            for (int j = i + 1; j < length; j++) {
                int[] candidate = points[j];
                int y2 = candidate[1];
                if (y2 > y1) continue;

                boolean valid = true;

                for (int k = i + 1; k < j; k++) {
                    int[] susPoint = points[k];
                    int ySus = susPoint[1];

                    if (y2 <= ySus && ySus <= y1) {
                        valid = false;
                        break;
                    }
                }

                if (valid) result++;
            }
        }

        return result;
    }
}
