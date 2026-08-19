package MonthlyChallenges.Year26.August;

import java.util.HashMap;
import java.util.Map;

public class CinemaSeatAllocation {
    public static void main(String[] args) {
        CinemaSeatAllocation solution = new CinemaSeatAllocation();

        int n0 = 3;
        int[][] reservedSeats0 = {{1, 2}, {1, 3}, {1, 8}, {2, 6}, {3, 1}, {3, 10}};
        int result0 = 4;
        System.out.println(solution.maxNumberOfFamilies(n0, reservedSeats0) == result0);
    }

    /**
     * LeetCode №1386. Cinema Seat Allocation.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     * <p>
     * A four-person group must be assigned to four seats in the same row. The group can be seated in one of the
     * following seat blocks:
     * * seats 2, 3, 4, 5
     * * seats 4, 5, 6, 7
     * * seats 6, 7, 8, 9
     *
     * @param n             - the total number of rows. Rows are 1-indexed.
     * @param reservedSeats - an array representing reserved seats. Seats are 1-indexed.
     *                      reservedSeats[i] = [row-i, seat-i] means that seat seat-i in row row-i is already reserved.
     * @return - the maximum number of four-person groups that can be assigned.
     */
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int MAX_SEATS = 10;
        int defaultSeatConfiguration = (1 << MAX_SEATS) - 1;

        Map<Integer, Integer> occupied = new HashMap<>();

        for (int[] reserved : reservedSeats) {
            int row = reserved[0], seat = reserved[1];

            if (seat == 1 || seat == MAX_SEATS) continue;

            int mask = 1 << seat;
            occupied.put(row, occupied.getOrDefault(row, defaultSeatConfiguration) ^ mask);
        }

        int result = (n - occupied.size()) * 2;

        for (int seatConfiguration : occupied.values()) {
            result += helper(seatConfiguration >> 2);
        }

        return result;
    }

    private int helper(int rowConfiguration) {
        //  ***xxxxxxxxx
        //  ***x11111111 = 255
        //  ***x00001111 = 15
        //  ***x11110000 = 240
        //  ***x00111100 = 60

        int doubleSeatConfiguration = 255;
        int singleSeatConfigurationRight = 15;
        int singleSeatConfigurationLeft = 240;
        int singleSeatConfigurationMiddle = 60;

        if ((rowConfiguration & doubleSeatConfiguration) == doubleSeatConfiguration) {
            return 2;
        } else if ((rowConfiguration & singleSeatConfigurationRight) == singleSeatConfigurationRight) {
            return 1;
        } else if ((rowConfiguration & singleSeatConfigurationLeft) == singleSeatConfigurationLeft) {
            return 1;
        } else if ((rowConfiguration & singleSeatConfigurationMiddle) == singleSeatConfigurationMiddle) {
            return 1;
        } else {
            return 0;
        }
    }
}
