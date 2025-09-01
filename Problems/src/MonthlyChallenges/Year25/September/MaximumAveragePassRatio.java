package MonthlyChallenges.Year25.September;

import java.util.PriorityQueue;

public class MaximumAveragePassRatio {
    public static void main(String[] args) {
        MaximumAveragePassRatio solution = new MaximumAveragePassRatio();

        System.out.println("Test 0");
        int[][] classes0 = {
                {1, 2}, {3, 5}, {2, 2}
        };
        int extraStudents0 = 2;
        System.out.println(solution.maxAverageRatio(classes0, extraStudents0));

        System.out.println("\nTest 1");
        int[][] classes1 = {
                {2, 4}, {3, 9}, {4, 5}, {2, 10}
        };
        int extraStudents1 = 4;
        System.out.println(solution.maxAverageRatio(classes1, extraStudents1));
    }

    /**
     * LeetCode №1792. Maximum Average Pass Ratio.
     * <p>
     * Complexity - O(N*logN + M*logN), N = classes.length, M = extraStudents.
     * Memory - O(N)
     *
     * @param classes       - a 2d array of stats of classes.
     * @param extraStudents - the total number of extra students that are guaranteed to pass the exam of any class they
     *                      are assigned to.
     * @return - the maximum possible average pass ratio after assigning the extraStudents students.
     */
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> Double.compare(getIncrease(b), getIncrease(a))
        );

        int hundredPercentClasses = 0;
        for (int[] classStat : classes) {
            if (classStat[0] == classStat[1]) {
                hundredPercentClasses++;
                continue;
            }
            pq.offer(classStat);
        }

        int extra = pq.isEmpty() ? extraStudents : 0;
        for (; extra < extraStudents; extra++) {
            int[] bestCandidateClass = pq.poll();
            bestCandidateClass[0]++;
            bestCandidateClass[1]++;

            pq.offer(bestCandidateClass);
        }

        double result = hundredPercentClasses * 1.0d;

        while (!pq.isEmpty()) {
            int[] curClass = pq.poll();
            result += curClass[0] / (double) curClass[1];
        }

        return result / classes.length;
    }

    private static double getIncreaseAlt(int[] classStat) {
        double current = classStat[0] / (double) classStat[1];
        double updated = (classStat[0] + 1.0d) / (classStat[1] + 1.0d);
        return updated - current;
    }

    private static double getIncrease(int[] classStat) {
        return (classStat[1] - classStat[0]) / ((1.0d + classStat[1]) * classStat[1]);
    }
}
