package MonthlyChallenges.Year24.October;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class NumberOfSmallestUnoccupiedChair {
    public static void main(String[] args) {
        NumberOfSmallestUnoccupiedChair solution = new NumberOfSmallestUnoccupiedChair();

        int[][] times0 = {{1, 4}, {2, 3}, {4, 6}};
        int targetFriend0 = 1;
        System.out.println(solution.smallestChair(times0, targetFriend0) == 1);

        int[][] times1 = {{3, 10}, {1, 5}, {2, 6}};
        int targetFriend1 = 0;
        System.out.println(solution.smallestChair(times1, targetFriend1) == 2);

        int[][] times2 = {{3, 10}, {1, 5}, {2, 6}};
        int targetFriend2 = 1;
        System.out.println(solution.smallestChair(times2, targetFriend2) == 0);

        int[][] times3 = {{3, 10}, {1, 5}, {2, 6}};
        int targetFriend3 = 2;
        System.out.println(solution.smallestChair(times3, targetFriend3) == 1);

        int[][] times4 = {{3, 10}, {1, 50}, {2, 3}};
        int targetFriend4 = 0;
        System.out.println(solution.smallestChair(times4, targetFriend4) == 1);

        int[][] times5 = {{3, 10}, {1, 2}, {2, 3}};
        int targetFriend5 = 0;
        System.out.println(solution.smallestChair(times5, targetFriend5) == 0);

        int[][] times6 = {{3, 10}, {1, 2}, {2, 3}};
        int targetFriend6 = 1;
        System.out.println(solution.smallestChair(times6, targetFriend6) == 0);

        int[][] times7 = {{3, 10}, {1, 2}, {2, 3}};
        int targetFriend7 = 2;
        System.out.println(solution.smallestChair(times7, targetFriend7) == 0);
    }

    /**
     * LeetCode №1942. The Number of the Smallest Unoccupied Chair.
     * <p>
     * Complexity - O(NlogN)
     * Memory - O(N)
     *
     * @param times        - a 2d array. times[i] = [arrival-i, leaving-i], indicating the arrival and leaving times of
     *                     the i-th friend respectively.
     * @param targetFriend - the index of a target friend.
     * @return - the chair number that the friend numbered targetFriend will sit on.
     */
    public int smallestChair(int[][] times, int targetFriend) {
        Integer[] indices = new Integer[times.length];
        for (int i = 0; i < indices.length; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, Comparator.comparingInt(a -> times[a][0]));

        PriorityQueue<Integer> freeChairs = new PriorityQueue<>();
        freeChairs.offer(0);

        //  a = {time, chair}
        PriorityQueue<Integer[]> occupiedChairs = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        for (int friendIdx : indices) {
            int[] time = times[friendIdx];

            while (!occupiedChairs.isEmpty() && occupiedChairs.peek()[0] <= time[0]) {
                freeChairs.offer(occupiedChairs.poll()[1]);
            }

            int freeChair = freeChairs.poll();
            if (targetFriend == friendIdx) return freeChair;

            if (freeChairs.isEmpty()) {
                freeChairs.offer(freeChair + 1);
            }

            occupiedChairs.offer(new Integer[]{time[1], freeChair});
        }

        return freeChairs.peek();
    }
}
