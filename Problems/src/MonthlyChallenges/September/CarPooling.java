package MonthlyChallenges.September;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class CarPooling {
    public static void main(String[] args) {
        CarPooling solution = new CarPooling();
        solution.testCarPooling();
    }

    /**
     * Returns answer if it is possible to finish all trips with "capacity" empty seats in a car.
     *
     * Complexity - O(NlogN)
     * Memory - O(N)
     *
     * @param trips - array of integers where trip[i] = [num_passengers, start_location, end_location]
     * @param capacity - number of empty seats.
     * @return - True - if it is possible to finish all trips, False - otherwise.
     */
    public boolean carPooling(int[][] trips, int capacity) {
        if (trips == null || trips.length == 0) return true;

        Arrays.sort(trips, (a, b) -> Integer.compare(a[1], b[1]));

        int freeSeats = capacity;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));

        for (int[] trip : trips) {
            int currPassengers = trip[0];
            int start = trip[1];
            int finish = trip[2];

            if (!pq.isEmpty()) {
                while (!pq.isEmpty() && pq.peek()[2] <= start) {
                    freeSeats += pq.peek()[0];
                    pq.poll();
                }
            }

            freeSeats -= currPassengers;
            if (freeSeats < 0) return false;
            pq.offer(trip);
        }

        return true;
    }

    private void testCarPooling(){
        int[][][] trips = {
                {{2,1,5},{3,3,7}},
                {{2,1,5},{3,3,7}},
                {{2,1,5},{3,5,7}},
                {{3,2,7},{3,7,9},{8,3,9}}
        };
        int[] capacities = {4, 5, 3, 11};
        boolean[] results = {false, true, true, true};

        int failed = 0;
        for (int i = 0; i < results.length; i++) {
            if (carPooling(trips[i], capacities[i]) != results[i]) {
                failed++;
                System.out.println("Wrong result for test # " + i);
                System.out.println(Arrays.deepToString(trips[i]) + ", capacity: " + capacities[i]);
                System.out.println("Got: " + !results[i] + ", instead of: " + results[i]);
            }
        }

        System.out.println("Success rate: " + (results.length - failed) * 100.0 / results.length);
    }
}
