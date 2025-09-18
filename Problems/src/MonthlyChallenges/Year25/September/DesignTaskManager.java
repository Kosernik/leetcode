package MonthlyChallenges.Year25.September;

import java.util.*;

public class DesignTaskManager {

    /**
     * LeetCode №3408. Design Task Manager.
     */
    class TaskManager {
        private final Map<Integer, Task> taskIdToTask;
        private final NavigableSet<Task> taskManager;

        public TaskManager(List<List<Integer>> tasks) {
            this.taskIdToTask = new HashMap<>();
            this.taskManager = new TreeSet<>();

            for (List<Integer> taskEntry : tasks) {
                Task task = new Task(taskEntry.get(0), taskEntry.get(1), taskEntry.get(2));
                taskManager.add(task);
                taskIdToTask.put(taskEntry.get(1), task);
            }
        }

        public void add(int userId, int taskId, int priority) {
            Task task = new Task(userId, taskId, priority);
            taskIdToTask.put(taskId, task);
            taskManager.add(task);
        }

        public void edit(int taskId, int newPriority) {
            Task toEdit = taskIdToTask.remove(taskId);
            taskManager.remove(toEdit);

            toEdit.setPriority(newPriority);

            taskIdToTask.put(taskId, toEdit);
            taskManager.add(toEdit);
        }

        public void rmv(int taskId) {
            Task toRemove = taskIdToTask.remove(taskId);
            taskManager.remove(toRemove);
        }

        public int execTop() {
            if (taskManager.isEmpty()) return -1;

            Task top = taskManager.pollFirst();
            taskIdToTask.remove(top.taskID);
            return top.userID;
        }

        static class Task implements Comparable<Task> {
            private final int userID;
            private final int taskID;
            private int priority;

            Task(int userID, int taskID, int priority) {
                this.userID = userID;
                this.taskID = taskID;
                this.priority = priority;
            }

            @Override
            public int compareTo(Task other) {
                return priority != other.priority ?
                        Integer.compare(other.priority, priority) : // Highest priority first.
                        Integer.compare(other.taskID, taskID);      // If priority is the same - highest taskId first.
            }

            public int getUserID() {
                return userID;
            }

            public int getTaskID() {
                return taskID;
            }

            public int getPriority() {
                return priority;
            }

            public void setPriority(int priority) {
                this.priority = priority;
            }
        }
    }
}
