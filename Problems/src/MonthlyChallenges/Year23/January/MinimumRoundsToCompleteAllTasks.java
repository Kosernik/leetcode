package MonthlyChallenges.Year23.January;

import java.util.HashMap;
import java.util.Map;

public class MinimumRoundsToCompleteAllTasks {

    /**
     * LeetCode #2244. Minimum Rounds to Complete All Tasks.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param tasks - an array of positive integers, tasks[i] = the difficulty level of a task.
     * @return - the minimum rounds required to complete all the tasks, or -1 if it is not possible to complete all the
     * tasks.
     */
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> counts = new HashMap<>();
        int rounds = 0;

        for (int task : tasks) {
            counts.put(task, counts.getOrDefault(task, 0) + 1);
        }

        for (int count : counts.values()) {
            if (count == 1) {
                return -1;
            } else {
//                rounds += Math.ceilDiv(count, 3);     // requires Java 18
                int curCount = count / 3;
                if (count % 3 != 0) {
                    curCount++;
                }
                rounds += curCount;
            }
        }

        return rounds;
    }
}
