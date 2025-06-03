package MonthlyChallenges.Year25.June;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximumCandiesYouCanGetFromBoxes {

    /**
     * LeetCode №1298. Maximum Candies You Can Get from Boxes.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param status         - an array of statuses of boxes. status[i] = 0 if a box is closed, status[i] = 1 if a box
     *                       is open.
     * @param candies        - the number of candies in each box.
     * @param keys           - the keys that each box have.
     * @param containedBoxes - the boxes that are contained in each box.
     * @param initialBoxes   - the boxes you initially have.
     * @return - the maximum number of candies you can get.
     */
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int OPENED = 1;

        int result = 0;

        int numberOfBoxes = status.length;

        boolean[] available = new boolean[numberOfBoxes];

        Deque<Integer> opened = new ArrayDeque<>();

        boolean[] looted = new boolean[numberOfBoxes];

        for (int initialBox : initialBoxes) {
            if (status[initialBox] == OPENED) {
                opened.offer(initialBox);

            }

            available[initialBox] = true;
        }

        while (!opened.isEmpty()) {
            int box = opened.poll();

            if (looted[box]) {
                continue;
            }
            looted[box] = true;

            result += candies[box];

            for (int key : keys[box]) { //  Using all available keys.
                if (looted[key]) {
                    continue;
                }

                status[key] = OPENED;

                if (available[key]) {   //  Box was received earlier
                    opened.offer(key);
                }
            }

            for (int innerBox : containedBoxes[box]) {  //  Checking new boxes
                if (looted[innerBox]) {
                    continue;
                }

                available[innerBox] = true;

                if (status[innerBox] == OPENED) {   //  Key was received earlier
                    opened.offer(innerBox);
                }
            }
        }

        return result;
    }
}
