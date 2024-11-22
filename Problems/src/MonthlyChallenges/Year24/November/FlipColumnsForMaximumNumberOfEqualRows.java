package MonthlyChallenges.Year24.November;

import java.util.HashMap;
import java.util.Map;

public class FlipColumnsForMaximumNumberOfEqualRows {

    /**
     * LeetCode №1072. Flip Columns For Maximum Number of Equal Rows.
     * <p>
     * Complexity - O(N*M), N = matrix height, M = matrix width.
     * Memory - O(N*M)
     *
     * @param matrix - a 2d matrix of 0 and 1.
     * @return - the maximum number of rows that have all values equal after some number of flips of columns.
     */
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int result = 0;

        Map<String, Integer> counts = new HashMap<>();

        for (int[] row : matrix) {
            StringBuilder builder = new StringBuilder();

            int count = 1;
            int prevVal = row[0];

            for (int i = 1; i < row.length; i++) {
                int cur = row[i];

                if (cur != prevVal) {
                    builder.append(count).append("*");
                    count = 1;
                    prevVal = cur;
                } else {
                    count++;
                }
            }
            builder.append(count);

            String curSequence = builder.toString();
            int seqCount = counts.getOrDefault(curSequence, 0) + 1;
            counts.put(curSequence, seqCount);

            result = Math.max(result, seqCount);
        }

        return result;
    }
}
