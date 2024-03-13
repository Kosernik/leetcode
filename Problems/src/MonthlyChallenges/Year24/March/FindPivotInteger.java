package MonthlyChallenges.Year24.March;

public class FindPivotInteger {

    /**
     * LeetCode №2485. Find the Pivot Integer.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param n - An integer, 1 <= n <= 1000
     * @return - the pivot integer.
     */
    public int pivotInteger(int n) {
        int leftSum = n * (n + 1) / 2;
        int rightSum = 0;

        for (int i = n; i >= 1; i--) {
            rightSum += i;
            if (rightSum == leftSum) {
                return i;
            }
            leftSum -= i;
        }
        return -1;
    }

}
