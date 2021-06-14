package MonthlyChallenges.June21;

import java.util.Arrays;

public class MaximumUnitsOnATruck {
    /**
     * LeetCode #1710.
     *
     * Complexity - O(NlogN)
     * memory - O(1)
     *
     * @param boxTypes - a 2D array of number of boxes and their capacities.
     * @param truckSize - the maximum number of boxes that can be put on the truck.
     * @return - the maximum total number of units that can be put on the truck.
     */
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));

        int result = 0;
        int slotsLeft = truckSize;

        for (int[] box : boxTypes) {
            if (box[0] <= slotsLeft) {
                result += box[0] * box[1];
                slotsLeft -= box[0];
            } else {
                result += slotsLeft * box[1];
                break;
            }
        }

        return result;
    }
}
