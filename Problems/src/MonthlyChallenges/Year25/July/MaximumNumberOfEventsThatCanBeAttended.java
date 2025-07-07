package MonthlyChallenges.Year25.July;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumNumberOfEventsThatCanBeAttended {
    public static void main(String[] args) {
        MaximumNumberOfEventsThatCanBeAttended solution = new MaximumNumberOfEventsThatCanBeAttended();

        int[][] events0 = {
                {1, 2}, {1, 2}, {3, 3}, {1, 5}, {1, 5}
        };
        System.out.println(solution.maxEvents(events0) == 5);

        int[][] events1 = {
                {1, 5}, {1, 5}, {1, 5}, {2, 3}, {2, 3}
        };
        System.out.println(solution.maxEvents(events1) == 5);
    }

    /**
     * LeetCode №1353. Maximum Number of Events That Can Be Attended.
     *
     * @param events - a 2d array of start and end days of events.
     * @return - the maximum number of events you can attend.
     */
    public int maxEvents(int[][] events) {
        int eventsAttended = 0;

        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));

        int lastDay = 1;
        for (int[] event : events) {
            lastDay = Math.max(lastDay, event[1]);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int day = 1, event = 0; day <= lastDay; day++) {
            while (event < events.length && events[event][0] <= day) {
                pq.offer(events[event][1]);
                event++;
            }

            while (!pq.isEmpty() && pq.peek() < day) {
                pq.poll();
            }

            if (!pq.isEmpty()) {
                eventsAttended++;
                pq.poll();
            }
        }

        return eventsAttended;
    }
}
