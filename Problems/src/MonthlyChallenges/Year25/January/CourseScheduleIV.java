package MonthlyChallenges.Year25.January;

import java.util.*;

public class CourseScheduleIV {

    /**
     * LeetCode №1462. Course Schedule IV.
     *
     * @param numCourses    - the total number of courses.
     * @param prerequisites - a 2d array of pairs where prerequisites[i] = [a-i, b-i] indicates that you must take
     *                      course a-i first if you want to take course b-i.
     * @param queries       - a 2d array of queries.
     * @return - a list of answers for each query. True if query[0]-course is a prerequisite for query[1]-course,
     * false - otherwise.
     */
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        Map<Integer, Set<Integer>> graph = buildGraph(numCourses, prerequisites);

        List<Boolean> result = new ArrayList<>();

        for (int[] query : queries) {
            result.add(checkPrerequisite(query, graph));
        }

        return result;
    }

    private boolean checkPrerequisite(int[] query, Map<Integer, Set<Integer>> graph) {
        int prerequisite = query[0];
        int course = query[1];

        if (graph.get(course).contains(prerequisite)) {
            return true;
        }

        Deque<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(course);
        visited.add(course);

        while (!queue.isEmpty()) {
            int curCourse = queue.removeFirst();

            if (curCourse == prerequisite) {
                graph.get(course).add(prerequisite);
                return true;
            }

            for (int prereq : graph.get(curCourse)) {
                if (!visited.contains(prereq)) {
                    visited.add(prereq);
                    queue.offerLast(prereq);
                }
            }
        }

        return false;
    }

    private Map<Integer, Set<Integer>> buildGraph(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new HashSet<>());
        }

        for (int[] prerequisite : prerequisites) {
            int prereq = prerequisite[0];
            int course = prerequisite[1];

            graph.get(course).add(prereq);
        }

        return graph;
    }
}
