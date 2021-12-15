package Problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaxPointsOnALine {

    /**
     * LeetCode #149. Max Points on a Line.
     *
     * Complexity - O(N^2)
     * Memory - O(N^2)
     *
     * @param points - an array of coordinates of points.
     * @return - the maximum number of points that lie on the same straight line.
     */
    public int maxPoints(int[][] points) {
        if (points.length <= 2) return points.length;

        int maxCount = 1;
        Map<String, Set<String>> count = new HashMap<>();

        for (int i = 0; i < points.length-1; i++) {
            for (int j = i+1; j < points.length; j++) {
                String curEquation = getEquation(points[i], points[j]);

                Set<String> curSet = count.getOrDefault(curEquation, new HashSet<>());
                curSet.add(getPoint(points[i]));
                curSet.add(getPoint(points[j]));
                count.put(curEquation, curSet);

                maxCount = Math.max(maxCount, curSet.size());
            }
        }

        return maxCount;
    }

    private String getPoint(int[] point) {
        return point[0] + "*" + point[1];
    }

    private String getEquation(int[] point1, int[] point2) {
        int deltaX = point1[0] - point2[0];
        int deltaY = point1[1] - point2[1];

        if (deltaX == 0) {
            return "Vertical x=" + point1[0];
        }

        float a =(float) deltaY / deltaX;
        float b = point1[1] - (a * point1[0]);

        return a + "x + " + b;
    }
}
