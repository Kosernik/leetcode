package MonthlyChallenges.Year26.October;

public class CreateGridWithExactlyOnePath {

    /**
     * LeetCode №3963. Create Grid With Exactly One Path.
     *
     * @param m - the height of the grid.
     * @param n - the width of the grid.
     * @return - a grid with exactly one valid path.
     */
    public String[] createGrid(int m, int n) {
        String[] result = new String[m];
        result[0] = ".".repeat(n);
        for (int i = 1; i < m; i++) {
            result[i] = "#".repeat(n - 1).concat(".");
        }
        return result;
    }
}
