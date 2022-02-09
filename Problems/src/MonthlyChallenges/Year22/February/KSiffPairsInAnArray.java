package MonthlyChallenges.Year22.February;

import java.util.*;

public class KSiffPairsInAnArray {

    /**
     * LeetCode #532. K-diff Pairs in an Array.
     *
     * Complexity - O(N)
     * Memory - O(N^2)
     *
     * @param nums - an array of integers.
     * @param k - a non-negative integer.
     * @return - the number of unique k-diff pairs in the array.
     */
    public int findPairs(int[] nums, int k) {
        int numberOfPairs = 0;
        Set<Integer> seen = new HashSet<>();
        Set<String> computed = new HashSet<>();

        for (int number : nums) {
            int targetLow = number - k;
            String pairLow = targetLow + "*" + number;
            String pairLowB = number + "*" + targetLow;

            int targetUp = number + k;
            String pairUp = number + "*" + targetUp;
            String pairUpB = targetUp + "*" + number;

            if (seen.contains(targetLow) && !computed.contains(pairLow) && !computed.contains(pairLowB)) {
                numberOfPairs++;
                computed.add(pairLow);
                computed.add(pairLowB);
            }
            if (seen.contains(targetUp) && !computed.contains(pairUp) && !computed.contains(pairUpB)) {
                numberOfPairs++;
                computed.add(pairUp);
                computed.add(pairUpB);
            }

            seen.add(number);
        }

        return numberOfPairs;
    }
}
