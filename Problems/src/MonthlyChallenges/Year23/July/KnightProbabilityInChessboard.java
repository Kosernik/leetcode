package MonthlyChallenges.Year23.July;

public class KnightProbabilityInChessboard {

    /**
     * LeetCode #688. Knight Probability in Chessboard.
     *
     * @param n      - the size of a chessboard.
     * @param k      - the total number of moves.
     * @param row    - starting row of the knight.
     * @param column - starting column of the knight.
     * @return - the probability that the knight stays on a chessboard after k-moves.
     */
    public double knightProbability(int n, int k, int row, int column) {
        double[][][] dpArr = new double[k + 1][n][n];
        dpArr[0][row][column] = 1.0;

        int[][] moves = {{-1, 2}, {1, 2}, {-2, 1}, {2, 1}, {-1, -2}, {1, -2}, {-2, -1}, {2, -1}};

        for (int move = 1; move <= k; move++) {
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {

                    for (int[] m : moves) {
                        int nextR = r + m[0];
                        int nextC = c + m[1];

                        // If move is valid
                        if (0 <= nextR && nextR < n && 0 <= nextC && nextC < n) {
                            dpArr[move][nextR][nextC] += (dpArr[move - 1][r][c] / 8.0);
                        }
                    }
                }
            }
        }

        double result = 0.0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                result += dpArr[k][r][c];
            }
        }
        return result;
    }
}
