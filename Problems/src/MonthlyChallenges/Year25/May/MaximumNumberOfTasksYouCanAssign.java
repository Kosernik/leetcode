package MonthlyChallenges.Year25.May;

import java.util.Arrays;
import java.util.NavigableMap;
import java.util.TreeMap;

public class MaximumNumberOfTasksYouCanAssign {

    /**
     * LeetCode №2071. Maximum Number of Tasks You Can Assign.
     *
     * @param tasks    - an array of required strength for each task.
     * @param workers  - an array of strength of each worker.
     * @param pills    - the total number of available pills.
     * @param strength - the strength increase by a pill.
     * @return - the maximum number of tasks that can be completed.
     */
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);

        int left = 0, right = Math.min(tasks.length, workers.length), middle;

        while (left < right) {
            middle = right - (right - left) / 2;

            if (canAssign(middle, tasks, workers, pills, strength)) {
                left = middle;
            } else {
                right = middle - 1;
            }
        }

        return left;
    }

    private boolean canAssign(int candidate, int[] tasks, int[] workers, int pills, int strength) {
        NavigableMap<Integer, Integer> bestWorkers = new TreeMap<>();
        for (int w = workers.length - candidate; w < workers.length; w++) {
            int worker = workers[w];
            bestWorkers.put(worker, bestWorkers.getOrDefault(worker, 0) + 1);
        }

        for (int t = candidate - 1; t >= 0; t--) {
            int task = tasks[t];

            Integer bestStrength = bestWorkers.lastKey();

            if (bestStrength >= task) {
                bestWorkers.put(bestStrength, bestWorkers.get(bestStrength) - 1);

                if (bestWorkers.get(bestStrength) == 0) {
                    bestWorkers.remove(bestStrength);
                }
            } else {
                if (pills == 0) return false;
                pills--;

                bestStrength = bestWorkers.ceilingKey(task - strength);

                if (bestStrength == null) return false;

                bestWorkers.put(bestStrength, bestWorkers.get(bestStrength) - 1);

                if (bestWorkers.get(bestStrength) == 0) {
                    bestWorkers.remove(bestStrength);
                }
            }
        }

        return true;
    }
}
