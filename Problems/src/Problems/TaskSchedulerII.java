package Problems;

import java.util.HashMap;
import java.util.Map;

public class TaskSchedulerII {

    /**
     * LeetCode #2365. Task Scheduler II.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param tasks - an array of IDs of tasks.
     * @param space - the minimum number of days that must pass after the completion of a task before another task of
     *              the same type can be performed.
     * @return - the minimum number of days needed to complete all tasks.
     */
    public long taskSchedulerII(int[] tasks, int space) {
        long currentDay = 0L;
        Map<Integer, Long> prevDays = new HashMap<>();

        for (int task : tasks) {
            long prevDay = prevDays.getOrDefault(task, -1L);

            if (prevDay != -1L && (prevDay + space) > currentDay) {
                currentDay = prevDay + space;
            }

            currentDay++;
            prevDays.put(task, currentDay);
        }

        return currentDay;
    }
}
