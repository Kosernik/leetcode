package MonthlyChallenges.Year23.October;

import java.util.*;

public class ParallelCoursesIII {

    /**
     * LeetCode #2050. Parallel Courses III.
     *
     * @param n         - the total number of courses.
     * @param relations - an array of prerequisites, relations[i][0] opens course relations[i][1]. Courses are 1-indexed.
     * @param time      - the time needed to complete i-th course. Array is 0-indexed.
     * @return - the minimum number of months needed to complete all the courses.
     */
    public int minimumTime(int n, int[][] relations, int[] time) {
        List<Integer> empty = new ArrayList<>();
        Map<Integer, List<Integer>> nextCourses = new HashMap<>();
        int[] prerequisites = new int[n + 1];
        int[] timeOpened = new int[n + 1];

        for (int[] relation : relations) {
            int prev = relation[0];
            int next = relation[1];

            if (!nextCourses.containsKey(prev)) {
                nextCourses.put(prev, new ArrayList<>());
            }
            nextCourses.get(prev).add(next);

            prerequisites[next]++;
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (prerequisites[i] == 0) {
                timeOpened[i] = time[i - 1];
                queue.offer(i);
            }
        }

        int minTime = 0;
        while (!queue.isEmpty()) {
            int curCourse = queue.removeFirst();

            for (int next : nextCourses.getOrDefault(curCourse, empty)) {
                prerequisites[next]--;
                timeOpened[next] = Math.max(timeOpened[next], timeOpened[curCourse] + time[next - 1]);
                if (prerequisites[next] == 0) {
                    queue.offerLast(next);
                }
            }
        }
        for (int openTime : timeOpened) {
            minTime = Math.max(minTime, openTime);
        }

        return minTime;
    }
}
