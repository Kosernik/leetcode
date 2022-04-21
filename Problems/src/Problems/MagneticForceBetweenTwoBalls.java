package Problems;

import java.util.Arrays;

public class MagneticForceBetweenTwoBalls {
    public static void main(String[] args) {
        MagneticForceBetweenTwoBalls solution = new MagneticForceBetweenTwoBalls();
    }

    /**
     * LeetCode #1552. Magnetic Force Between Two Balls.
     *
     * Complexity - O(NlogN)
     * Memory - O(1)
     *
     * @param position - an array of positive integers.
     * @param m - the number of balls. 2 <= m <= position.length.
     * @return - the required force.
     */
    public int maxDistance(int[] position, int m) {
        if (m == 2) {
            return getMaxDiff(position);
        }
        Arrays.sort(position);
        if (position.length == m) {
            return getDiff(position);
        }

        int left = 0, right = position[position.length - 1] - position[0], middle;

        while (left < right) {
            middle = right - (right - left) / 2;

            if (ballsNeeded(position, middle) >= m) {
                left = middle;
            } else {
                right = middle - 1;
            }
        }

        return left;
    }

    private int ballsNeeded(int[] position, int candidateForce) {
        int ballsPlaced = 1;
        int prev = position[0];
        int idx = 1;

        while (idx < position.length) {
            if ((position[idx] - prev) >= candidateForce) {
                ballsPlaced++;
                prev = position[idx];
            }
            idx++;
        }

        return ballsPlaced;
    }

    private int getMaxDiff(int[] position) {
        int min = position[0];
        int max = position[0];

        for (int pos : position) {
            min = Math.min(min, pos);
            max = Math.max(max, pos);
        }

        return max - min;
    }

    private int getDiff(int[] position) {
        int diff = Integer.MAX_VALUE;

        for (int i = 1; i < position.length; i++) {
            diff = Math.min(diff, position[i] - position[i - 1]);
        }

        return diff;
    }
}
