package MonthlyChallenges.Year23.January;

public class DeleteColumnsToMakeSorted {


    /**
     * LeetCode #944. Delete Columns to Make Sorted.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param strs - an array of strings of the same length.
     * @return - the number of COLUMNS that are not sorted lexicographically.
     */
    public int minDeletionSize(String[] strs) {
        int columnsToDelete = 0;

        int height = strs.length;
        int width = strs[0].length();

        for (int i = 0; i < width; i++) {
            for (int j = 1; j < height; j++) {
                if (strs[j].charAt(i) < strs[j - 1].charAt(i)) {
                    columnsToDelete++;
                    break;
                }
            }
        }

        return columnsToDelete;
    }
}
