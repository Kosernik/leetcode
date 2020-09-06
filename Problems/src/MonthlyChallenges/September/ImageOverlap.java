package MonthlyChallenges.September;

import java.util.Arrays;

public class ImageOverlap {
    public static void main(String[] args) {
        ImageOverlap solution = new ImageOverlap();

        int[][] testA0 = {
                {1,1,0},
                {0,1,0},
                {0,1,0}};
        int[][] testB0 = {
                {0,0,0},
                {0,1,1},
                {0,0,1}};
        System.out.println(solution.largestOverlap(testA0, testB0) == 3);

        int[][] testA1 = {
                {1,0,0,0},
                {1,1,1,1},
                {1,0,0,1},
                {1,0,0,1}};
        int[][] testB1 = {
                {1,1,1,1},
                {0,0,1,0},
                {0,0,1,0},
                {0,1,1,0}};
        System.out.println(solution.largestOverlap(testA1, testB1) == 5);
    }

    /**
     * Bruteforce checking if images are overlapping.
     *
     * O(n^2)
     *
     * @param A - square array of 0 or 1, representing first image.
     * @param B - square array of 0 or 1, representing second image.
     * @return - maximum number of overlapping 1-s if you move any picture.
     */
    public int largestOverlap(int[][] A, int[][] B) {
        if (A == null || B == null) return 0;
        else if (A.length == 1 || B.length == 1) {
            return (A[0][0] == 1 && B[0][0] == 1) ? 1 : 0;
        }

        int length = A.length;
        int scaleSize = length + 2 * (length - 1);
        int[][] scaledA = new int[scaleSize][scaleSize];

        for (int i = 0; i < length; i++) {
            System.arraycopy(A[i], 0, scaledA[i + length - 1], length - 1, length);
        }

        int maxOverlap = 0;

        int boundTopLeft = length - 1;
        int boundBotRight = length + length - 2;
        int numOfOperations = 1 + 2 * (length - 1);
        for (int i = 0; i < numOfOperations; i++) {
            for (int j = 0; j < numOfOperations; j++) {
                int currOverlap = 0;

                for (int row = 0; row < length; row++) {
                    for (int col = 0; col < length; col++) {
                        if (i+row >= boundTopLeft && i+row <= boundBotRight && j+col >= boundTopLeft && j+col <= boundBotRight) {
                            if (scaledA[i+row][j+col] == 1 && B[row][col] == 1) {
                                currOverlap++;
                            }
                        }
                    }
                }

                maxOverlap = Math.max(currOverlap, maxOverlap);
            }
        }
        return maxOverlap;
    }
}
