package MonthlyChallenges.Year24.June;

import java.util.Arrays;

public class MinimumNumberOfMovesToSeatEveryone {

    /**
     * LeetCode №2037. Minimum Number of Moves to Seat Everyone.
     * <p>
     * Complexity - O(NlogN + N)
     * Memory - O(1) + O(sortingMemory)
     *
     * @param seats    - an array of positive integers, representing the positions of each seat.
     * @param students - an array of positive integers, representing the positions of each student.
     *                 seats.length = students.length.
     * @return - the minimum number of moves required to move each student to a seat such that no two students are in
     * the same seat.
     */
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);

        int moves = 0;

        for (int studentIdx = 0, seatIdx = 0; studentIdx < students.length; studentIdx++, seatIdx++) {
            moves += Math.abs(seats[seatIdx] - students[studentIdx]);
        }

        return moves;
    }
}
