package MonthlyChallenges.Year26.April;

import java.util.Arrays;

public class DecodeSlantedCiphertext {

    /**
     * LeetCode №2075. Decode the Slanted Ciphertext.
     * <p>
     * Complexity - O(N), N = encodedText.length.
     * Memory - O(N)
     *
     * @param encodedText - a string of lowercase english letters and ' '.
     * @param rows        - the total number of rows in a matrix.
     * @return - decoded text.
     */
    public String decodeCiphertext(String encodedText, int rows) {
        if (encodedText.isEmpty()) return "";

        int width = encodedText.length() / rows;
        char[][] matrix = new char[rows][width];

        for (int i = 0, row = 0, col = 0; i < encodedText.length(); i++) {
            matrix[row][col] = encodedText.charAt(i);

            col++;
            if (col >= width) {
                row++;
                col = 0;
            }
        }

        char[] res = new char[rows * width];
        Arrays.fill(res, ' ');
        int resIdx = 0;

        int startingCol = 0;
        int row = 0, col = startingCol;

        while (true) {
            res[resIdx] = matrix[row][col];
            resIdx++;

            row++;
            col++;

            if (row == rows || col == width) {
                startingCol++;

                row = 0;
                col = startingCol;

                if (startingCol >= width) break;
            }
        }

        return new String(res).stripTrailing();
    }
}
