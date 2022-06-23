package MonthlyChallenges.Year22.June;

import java.util.Arrays;
import java.util.PriorityQueue;

public class CourseScheduleIII {

    public static void main(String[] args) {
        CourseScheduleIII solution = new CourseScheduleIII();

        int[][][] tests = {
                { {100,200},{200,1300},{1000,1250},{2000,3200} },
                { {1,2} },
                { {3,2},{4,3} },
                { {5,5},{4,6},{2,6} },
                { {5,15},{3,19},{6,7},{2,10},{5,16},{8,14},{10,11},{2,19} },
                { {5,5},{4,7},{2,7},{2,8} },
                { {1,7},{1,7},{1,7},{1,7},{4,6} }
        };
        int[] results = {
                3,
                1,
                0,
                2,
                5,
                3,
                4
        };

        int wrongResults = 0;
        for (int i = 0; i < tests.length; i++) {
            int result = solution.scheduleCourse(tests[i]);
            if (result != results[i]) {
                wrongResults++;
                System.out.println("Wrong result for test #" + i);
                System.out.println(Arrays.deepToString(tests[i]) + ", got: " + result + " instead of: " + results[i]);
            }
        }
        System.out.println("Wrong results: " + wrongResults);
    }

    /**
     * LeetCode #630. Course Schedule III.
     *
     * Complexity - O(NlogN)
     * Memory - O(N)
     *
     * @param courses - a 2d array of positive integers, where courses[i] = [duration, lastDay].
     * @return - the maximum number of courses that you can take.
     */
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] != b[1] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[0] != b[0] ? Integer.compare(b[0], a[0]) : Integer.compare(a[1], b[1]));

        int stopTime = 0;

        for (int i = 0; i < courses.length; i++) {
            int[] curCourse = courses[i];
            if (stopTime + curCourse[0] <= curCourse[1]) {
                stopTime += curCourse[0];
                pq.offer(curCourse);
            } else {
                if (pq.isEmpty()) continue;
                int[] prevCourse = pq.peek();
                if (prevCourse[0] > curCourse[0]) {
                    int prevStopTime = stopTime - prevCourse[0];
                    if (prevStopTime + curCourse[0] <= curCourse[1]) {
                        pq.remove();
                        stopTime = stopTime - prevCourse[0] + curCourse[0];
                        pq.offer(curCourse);
                    }
                }
            }
        }

        return pq.size();
    }
}
