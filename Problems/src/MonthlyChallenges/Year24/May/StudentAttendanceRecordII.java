package MonthlyChallenges.Year24.May;

import java.util.Arrays;

public class StudentAttendanceRecordII {
    private final int MODULO = 1_000_000_007;

    /**
     * LeetCode №552. Student Attendance Record II.
     *
     * @param n - the total number of days.
     * @return - the number of possible attendance records of length n.
     */
    public int checkRecord(int n) {
        int[][][] computed = new int[n + 1][2][3];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(computed[i][j], -1);
            }
        }
        return dp(n, 0, 0, computed);
    }

    private int dp(int n, int absent, int late, int[][][] computed) {
        if (absent >= 2 || late >= 3) return 0;
        if (n == 0) return 1;
        if (computed[n][absent][late] != -1) return computed[n][absent][late];

        long result = 0;

        result += dp(n - 1, absent + 1, 0, computed) % MODULO;

        result = (result + dp(n - 1, absent, late + 1, computed)) % MODULO;

        result = (result + dp(n - 1, absent, 0, computed)) % MODULO;

        computed[n][absent][late] = (int) result;

        return computed[n][absent][late];
    }
}
