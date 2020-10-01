package MonthlyChallenges.October;

import java.util.PriorityQueue;

public class NumberOfRecentCalls {

    class RecentCounter {
        PriorityQueue<Integer> heap;

        public RecentCounter() {
            this.heap = new PriorityQueue<>();
        }

        public int ping(int t) {
            heap.offer(t);
            while (!heap.isEmpty() && heap.peek() > (t-3000)) {
                heap.poll();
            }
            return heap.size();
        }
    }
}
