package Problems;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    /**
     * LeetCode #217. Contains Duplicate.
     *
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param nums - an array of integers.
     * @return - True - if "nums" contains any duplicate, false - otherwise.
     */
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length <= 1) return false;

        Set<Integer> numbers = new HashSet<>();

        for (int num : nums) {
            if (!numbers.add(num)) return true;
        }

        return false;
    }
}
