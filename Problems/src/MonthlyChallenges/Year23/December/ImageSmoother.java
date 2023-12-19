package MonthlyChallenges.Year23.December;

public class ImageSmoother {

    /**
     * LeetCode №661. Image Smoother.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param img - a square array representing an image.
     * @return - smoothed image.
     */
    public int[][] imageSmoother(int[][] img) {
        int height = img.length, width = img[0].length;
        int[][] result = new int[height][width];

        int[] neighbours = {-1, -1, 0, -1, 1, 1, 0, 1, -1};

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                int sum = img[row][col];
                int cells = 1;

                for (int neigh = 0; neigh < neighbours.length - 1; neigh++) {
                    int r = row + neighbours[neigh];
                    int c = col + neighbours[neigh + 1];

                    if (r >= 0 && r < height && c >= 0 && c < width) {
                        sum += img[r][c];
                        cells++;
                    }
                }
                result[row][col] = sum / cells;
            }
        }

        return result;
    }
}
