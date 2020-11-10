package MonthlyChallenges.November;

public class FlippingAnImage {

    /**
     * Returns a flipped version of a given image. First the method flips an input horizontally, second it inverts an
     * input.
     * To flip an image horizontally means that each row of the image is reversed.  For example, flipping [1, 1, 0]
     * horizontally results in [0, 1, 1].
     * To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example, inverting
     * [0, 1, 1] results in [1, 0, 0].
     *
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param A - 2d array of integers of values "1" or "0".
     * @return - flipped version of an input.
     */
    public int[][] flipAndInvertImage(int[][] A) {
        if (A == null) return null;
        int[][] flipped = new int[A.length][A[0].length];

        int width = A[0].length;
        int halfWidth = (int) Math.ceil(width / 2.0);

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < halfWidth; j++) {
                int rightIdx = width - j - 1;
                if (A[i][rightIdx] == 1) {
                    flipped[i][j] = 0;
                } else {
                    flipped[i][j] = 1;
                }
                if (A[i][j] == 1) {
                    flipped[i][rightIdx] = 0;
                } else {
                    flipped[i][rightIdx] = 1;
                }
            }
        }
        return flipped;
    }
}
