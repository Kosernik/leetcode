package MonthlyChallenges.Year26.May;

import java.util.Arrays;

public class MinimumInitialEnergyToFinishTasks {
    public static void main(String[] args) {
        MinimumInitialEnergyToFinishTasks solution = new MinimumInitialEnergyToFinishTasks();

        int[][] tasks0 = {{1, 2}, {2, 4}, {4, 8}};
        int result0 = 8;
        System.out.println(solution.minimumEffort(tasks0) == result0);

        int[][] tasks1 = {{1, 3}, {2, 4}, {10, 11}, {10, 12}, {8, 9}};
        int result1 = 32;
        System.out.println(solution.minimumEffort(tasks1) == result1);

        int[][] tasks2 = {{1, 7}, {2, 8}, {3, 9}, {4, 10}, {5, 11}, {6, 12}};
        int result2 = 27;
        System.out.println(solution.minimumEffort(tasks2) == result2);

        int[][] tasks3 = {{1, 3}, {2, 4}, {10, 11}, {10, 12}, {8, 9}, {11, 12}};
        int result3 = 43;
        System.out.println(solution.minimumEffort(tasks3) == result3);
    }

    /**
     * LeetCode №1665. Minimum Initial Energy to Finish Tasks.
     * <p>
     * Complexity - O(NlogN)
     * Memory - O(N) - sorting algorithm complexity.
     *
     * @param tasks - an array of pairs of positive integers. tasks[i].length = 2. tasks[i][0] <= tasks[i][1].
     * @return - the minimum initial amount of energy you will need to finish all the tasks.
     */
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks,
                (a, b) -> (a[1] - a[0]) == (b[1] - b[0]) ?
                        Integer.compare(a[1], b[1]) :
                        Integer.compare(b[1] - b[0], a[1] - a[0])
        );

        int minTotalEnergy = 0;

        for (int i = tasks.length - 1; i >= 0; i--) {
            int[] task = tasks[i];
            int spent = task[0];
            int require = task[1];

            minTotalEnergy = Math.max(require, minTotalEnergy + spent);
        }

        return minTotalEnergy;
    }
}
