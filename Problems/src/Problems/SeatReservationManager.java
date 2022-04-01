package Problems;

import java.util.PriorityQueue;

public class SeatReservationManager {

    /**
     * LeetCode #1845. Seat Reservation Manager.
     */
    class SeatManager {
        PriorityQueue<Integer> manager = new PriorityQueue<>();

        public SeatManager(int n) {
            for (int i = 1; i <= n; i++) {
                manager.offer(i);
            }
        }

        public int reserve() {
            return manager.poll();
        }

        public void unreserve(int seatNumber) {
            manager.offer(seatNumber);
        }
    }
}
