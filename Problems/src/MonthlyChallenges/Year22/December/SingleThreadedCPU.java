package MonthlyChallenges.Year22.December;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SingleThreadedCPU {

    /**
     * LeetCode #1834. Single-Threaded CPU.
     * <p>
     * Complexity - O(NlogN)
     * Memory - O(N)
     *
     * @param tasks - an array of integers representing tasks, tasks[i] = [enqueueTime-i, processingTime-i]
     * @return - the order in which the CPU will process the tasks.
     */
    public int[] getOrder(int[][] tasks) {
        int[] resultingOrder = new int[tasks.length];

        //  tasksWithIdx[i][0] - enqueueTime-i
        //  tasksWithIdx[i][1] - processingTime-i
        //  tasksWithIdx[i][2] - index of the task
        int[][] tasksWithIdx = new int[tasks.length][3];
        for (int i = 0; i < tasks.length; i++) {
            tasksWithIdx[i][0] = tasks[i][0];
            tasksWithIdx[i][1] = tasks[i][1];
            tasksWithIdx[i][2] = i;
        }

        Arrays.sort(tasksWithIdx, new TaskComparator());
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new OrderComparator());

        int time = 0;
        int idx = 0;
        int startIDX = 0;
        while (idx < tasks.length) {
            startIDX = addTasksToPQandReturnIDX(time, startIDX, tasksWithIdx, priorityQueue);

            if (priorityQueue.isEmpty()) {  //  Next task starts after some idle period.
                priorityQueue.offer(tasksWithIdx[startIDX]);
                time = tasksWithIdx[startIDX][0];
                startIDX++;
            }
            int[] task = priorityQueue.poll();
            resultingOrder[idx] = task[2];
            idx++;
            time += task[1];    //  Updating end time
        }

        return resultingOrder;
    }

    /**
     * Adds tasks to a given priority queue that starts before current end time and returns the index of the last added
     * task + 1.
     *
     * @param endTime       - inclusive
     * @param startIDX      - inclusive
     * @param tasksWithIdx  - an array of tasks.
     *                      tasksWithIdx[i][0] - enqueueTime-i,
     *                      tasksWithIdx[i][1] - processingTime-i,
     *                      tasksWithIdx[i][2] - index of the task
     * @param priorityQueue - a priority queue for tasks.
     * @return - the index of the last added task + 1.
     */
    private int addTasksToPQandReturnIDX(int endTime, int startIDX, int[][] tasksWithIdx, PriorityQueue<int[]> priorityQueue) {
        for (int i = startIDX; i < tasksWithIdx.length; i++) {
            if (tasksWithIdx[i][0] > endTime) {
                return i;
            }
            priorityQueue.offer(tasksWithIdx[i]);
        }
        return tasksWithIdx.length;
    }

    static class OrderComparator implements Comparator<int[]> {

        @Override
        public int compare(int[] task1, int[] task2) {
            if (task1[1] != task2[1]) {
                return Integer.compare(task1[1], task2[1]);
            }
            return Integer.compare(task1[2], task2[2]);
        }
    }

    static class TaskComparator implements Comparator<int[]> {

        @Override
        public int compare(int[] task1, int[] task2) {
            if (task1[0] != task2[0]) {
                return Integer.compare(task1[0], task2[0]);
            }
            if (task1[1] != task2[1]) {
                return Integer.compare(task1[1], task2[1]);
            }
            return Integer.compare(task1[2], task2[2]);
        }
    }
}
