package MonthlyChallenges.Year25.May;

import java.util.ArrayList;
import java.util.List;

public class Finding3DigitEvenNumbers {

    /**
     * LeetCode №2094. Finding 3-Digit Even Numbers.
     *
     * @param digits - an array of digits.
     * @return - a sorted array of the unique even integers.
     */
    public int[] findEvenNumbers(int[] digits) {
        int[] count = new int[10];
        for (int digit : digits) count[digit]++;

        List<Integer> result = new ArrayList<>();
        for (int candidate = 100; candidate <= 998; candidate += 2) {
            if (validCandidate(candidate, count)) result.add(candidate);
        }

        return result.stream().mapToInt(integer -> integer).toArray();
    }

    private boolean validCandidate(int candidate, int[] count) {
        int[] candidateCount = new int[10];

        while (candidate > 0) {
            candidateCount[candidate % 10]++;
            candidate /= 10;
        }

        for (int i = 0; i < 10; i++) {
            if (candidateCount[i] > count[i]) return false;
        }

        return true;
    }
}
