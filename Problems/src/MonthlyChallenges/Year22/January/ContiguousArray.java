package MonthlyChallenges.Year22.January;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {

    /**
     * LeetCode #525. Contiguous Array.
     *
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param nums - an array of '0' and '1'.
     * @return - the maximum length of a contiguous subarray with an equal number of 0 and 1.
     */
    public int findMaxLength(int[] nums) {
        int balanceOfOnesAndZeroes = 0;
        Map<Integer, Integer> balanceToIndices = new HashMap<>();

        int maxLength = 0;

        for (int i = 0; i < nums.length; i++) {
            balanceOfOnesAndZeroes += nums[i] == 0 ? -1 : 1;

            if (balanceOfOnesAndZeroes == 0) maxLength = i+1;

            if (balanceToIndices.containsKey(balanceOfOnesAndZeroes)) {
                maxLength = Math.max(maxLength, i-balanceToIndices.get(balanceOfOnesAndZeroes));
            }

            balanceToIndices.putIfAbsent(balanceOfOnesAndZeroes, i);
        }

        if (balanceOfOnesAndZeroes == 0) return nums.length;

        return maxLength;
    }
}
