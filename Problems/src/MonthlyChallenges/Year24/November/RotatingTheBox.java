package MonthlyChallenges.Year24.November;

import java.util.Arrays;

public class RotatingTheBox {

    private final char STONE = '#';
    private final char OBSTACLE = '*';
    private final char EMPTY = '.';

    /**
     * LeetCode №1861. Rotating the Box.
     * <p>
     * Complexity - O(N*M)
     * Memory - O(1)
     *
     * @param box - an M*N matrix, representing a box. Each cell is either '#'(stone), or '*'(obstacle), or '.'(empty).
     * @return - an N x M matrix representing the box after the rotation 90 degrees clockwise.
     */
    public char[][] rotateTheBox(char[][] box) {
        int height = box.length, width = box[0].length;

        char[][] result = new char[width][height];
        for (char[] row : result) {
            Arrays.fill(row, EMPTY);
        }

        for (int row = 0; row < height; row++) {
            int stoneCount = 0;
            for (int col = 0; col < width; col++) {
                if (box[row][col] == STONE) {
                    stoneCount++;
                } else if (box[row][col] == OBSTACLE) {
                    result[col][height - row - 1] = OBSTACLE;

                    for (int stone = 0; stone < stoneCount; stone++) {
                        result[col - stone - 1][height - row - 1] = STONE;
                    }

                    stoneCount = 0;
                }
            }

            for (int stone = 0; stone < stoneCount; stone++) {
                result[width - stone - 1][height - row - 1] = STONE;
            }
        }

        return result;
    }
}
