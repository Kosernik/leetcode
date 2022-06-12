package MonthlyChallenges.Year22.June;

import java.util.HashSet;
import java.util.Set;

public class MaximumErasureValue {

    /**
     * LeetCode #1695. Maximum Erasure Value.
     *
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param nums - an array of integers. nums.length > 0
     * @return - the maximum score you can get by erasing exactly one subarray. The score you get by erasing the
     *           subarray is equal to the sum of its elements.
     */
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> usedNumbers = new HashSet<>();
        int result = 0;
        int curSum = 0;
        int leftIdx = 0;

        for (int curNumber : nums) {
            while (!usedNumbers.isEmpty() && usedNumbers.contains(curNumber)) {
                curSum -= nums[leftIdx];
                usedNumbers.remove(nums[leftIdx]);
                leftIdx++;
            }

            curSum += curNumber;
            usedNumbers.add(curNumber);
            result = Math.max(result, curSum);
        }

        return result;
    }
}
