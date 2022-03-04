package MonthlyChallenges.Year22.March;

public class ChampagneTower {

    /**
     * LeetCode #799. Champagne Tower.
     *
     * Complexity - O(N^2), N = query_row
     * Memory - O(N)
     *
     * @param poured - the number of cups of champagne.
     * @param query_row - the index of a row of the pyramid.
     * @param query_glass - the index of a glass in the target row.
     * @return - the amount of champagne in the target glass.
     */
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[] row = new double[1];
        row[0] = poured;

        for (int i = 1; i <= query_row; i++) {
            double[] curRow = new double[row.length+1];

            for (int col = 0; col < row.length; col++) {
                double half = Math.max((row[col] - 1)  / 2, 0);
                curRow[col] += half;
                curRow[col+1] += half;
            }

            row = curRow;
        }

        return Math.min(row[query_glass], 1);
    }
}
