package MonthlyChallenges.Year21.June21;

import java.util.TreeSet;

public class MyCalendar {

    private final TreeSet<int[]> events;

    /**
     * LeetCode #729.
     */
    public MyCalendar() {
        this.events = new TreeSet<>((int[] a, int[] b) -> Integer.compare(a[0], b[0]));
        this.events.add(new int[]{-1, -1});
    }

    public boolean book(int start, int end) {
        int[] currEvent = new int[]{start, end};
        int[] prev = this.events.floor(currEvent);
        int[] next = this.events.ceiling(currEvent);

        if (prev[1] > start) {
            return false;
        } else if (next == null) {
            this.events.add(currEvent);
            return true;
        } else if (end > next[0]) {
            return false;
        }
        this.events.add(currEvent);
        return true;
    }
}
