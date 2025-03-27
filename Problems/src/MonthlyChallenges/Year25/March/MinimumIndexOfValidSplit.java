package MonthlyChallenges.Year25.March;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumIndexOfValidSplit {

    /**
     * LeetCode №2780. Minimum Index of a Valid Split.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param nums - an array of integers.
     * @return - the minimum index of a valid split. If no valid split exists, returns -1.
     */
    public int minimumIndex(List<Integer> nums) {
        int length = nums.size();

        int[] dominantNumberPair = getDominantElement(nums);

        int dominantNumber = dominantNumberPair[0];
        int dominantCount = dominantNumberPair[1];

        int curCount = 0;
        for (int i = 0; i < length; i++) {
            int number = nums.get(i);

            if (number == dominantNumber) {
                curCount++;
                dominantCount--;

                // if ((curCount * 2) > (i + 1) && (dominantCount * 2) > (length - i - 1)) {
                if ((curCount << 1) > (i + 1) && (dominantCount << 1) > (length - i - 1)) {
                    return i;
                }
            }
        }

        return -1;
    }

    private int[] getDominantElement(List<Integer> nums) {
        Map<Integer, Integer> counts = new HashMap<>();

        int bestCount = 0;
        int dominantNumber = nums.get(0);

        for (Integer number : nums) {
            int curCount = counts.getOrDefault(number, 0) + 1;

            counts.put(number, curCount);

            if (curCount > bestCount) {
                bestCount = curCount;
                dominantNumber = number;
            }
        }

        return new int[]{dominantNumber, bestCount};
    }
}
