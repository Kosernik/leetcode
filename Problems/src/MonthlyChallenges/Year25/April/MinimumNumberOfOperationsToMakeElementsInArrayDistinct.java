package MonthlyChallenges.Year25.April;

import java.util.HashSet;
import java.util.Set;

public class MinimumNumberOfOperationsToMakeElementsInArrayDistinct {

    /**
     * LeetCode №3396. Minimum Number of Operations to Make Elements in Array Distinct.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     * <p>
     * An operation: remove 3 elements from the beginning of the array. If the array has fewer than 3 elements, remove
     * all remaining elements.
     *
     * @param nums - an array of integers.
     * @return - the minimum number of operations needed to make the elements in the array distinct.
     */
    public int minimumOperations(int[] nums) {
        int NUMBER_OF_ELEMENTS_TO_DELETE = 3;
        Set<Integer> seen = new HashSet<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            if (!seen.add(nums[i])) {
                return Math.ceilDiv(i + 1, NUMBER_OF_ELEMENTS_TO_DELETE);
            }
        }

        return 0;
    }
}
