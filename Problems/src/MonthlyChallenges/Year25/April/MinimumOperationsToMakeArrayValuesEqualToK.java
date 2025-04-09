package MonthlyChallenges.Year25.April;

import java.util.HashSet;
import java.util.Set;

public class MinimumOperationsToMakeArrayValuesEqualToK {

    /**
     * LeetCode №3375. Minimum Operations to Make Array Values Equal to K.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param nums - an array of integers.
     * @param k    - an integer.
     * @return - the minimum number of operations required to make every element in nums equal to k. If it is impossible
     * to make all elements equal to k, returns -1.
     */
    public int minOperations(int[] nums, int k) {
        Set<Integer> unique = new HashSet<>();
        int min = nums[0];

        for (int number : nums) {
            unique.add(number);
            min = Math.min(min, number);
        }

        if (min < k) {
            return -1;
        } else if (min == k) {
            return unique.size() - 1;
        } else {
            return unique.size();
        }
    }
}
