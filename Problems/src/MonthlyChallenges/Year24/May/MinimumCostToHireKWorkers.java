package MonthlyChallenges.Year24.May;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumCostToHireKWorkers {

    /**
     * LeetCode №857. Minimum Cost to Hire K Workers.
     * <p>
     * <p>
     * Every worker in the paid group must be paid at least their minimum wage expectation.
     * <p>
     * In the group, each worker's pay must be directly proportional to their quality. This means if a worker’s quality
     * is double that of another worker in the group, then they must be paid twice as much as the other worker.
     *
     * @param quality - an array of positive integers representing the quality of each worker.
     * @param wage    - an array of positive integers representing the wage of each worker. quality.length = wage.length.
     * @param k       - the number of required workers.
     * @return - the least amount of money needed to form a paid group satisfying the above conditions.
     */
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int[][] workers = new int[quality.length][2];
        for (int i = 0; i < quality.length; i++) {
            workers[i][0] = quality[i];
            workers[i][1] = wage[i];
        }

        Arrays.sort(workers,
                Comparator.comparingDouble(a -> ((double) a[1] / a[0]))
        );

        PriorityQueue<Integer> qualities = new PriorityQueue<>(Comparator.reverseOrder());


        double totalQuality = 0.0;
        for (int i = 0; i < k; i++) {
            qualities.offer(workers[i][0]);
            totalQuality += workers[i][0];
        }

        double result = totalQuality * ((double) workers[k - 1][1] / workers[k - 1][0]);

        for (int i = k; i < workers.length; i++) {
            int[] curWorker = workers[i];
            qualities.offer(curWorker[0]);
            totalQuality += curWorker[0];

            totalQuality -= qualities.poll();

            double curRes = totalQuality * ((double) workers[i][1] / workers[i][0]);
            result = Math.min(result, curRes);
        }

        return result;
    }
}
