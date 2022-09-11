package MonthlyChallenges.Year22.September;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumPerformanceOfTeam {

    /**
     * LeetCode #1383. Maximum Performance of a Team.
     * <p>
     * Complexity - O(NlogN)
     * Memory - O(N)
     *
     * @param n          - the number of engineers.
     * @param speed      - an array of speeds of engineers.
     * @param efficiency - an array of efficiencies of engineers.
     * @param k          - the maximum size of a team.
     * @return - the maximum performance of a team. Result is modulo 1_000_000_007.
     */
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] speedEfficiencyPairs = new int[n][2];

        for (int i = 0; i < n; i++) {
            speedEfficiencyPairs[i] = new int[]{speed[i], efficiency[i]};
        }

        Arrays.sort(speedEfficiencyPairs, (a, b) -> Integer.compare(b[1], a[1]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long curSpeedSum = 0L, result = 0L;

        for (int[] sePair : speedEfficiencyPairs) {
            curSpeedSum += sePair[0];
            pq.offer(sePair[0]);

            if (pq.size() > k) {
                curSpeedSum -= pq.poll();
            }

            result = Math.max(result, curSpeedSum * sePair[1]);
        }

        return (int) (result % 1_000_000_007);
    }
}
