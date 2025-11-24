package MonthlyChallenges.Year25.November;

import java.util.ArrayList;
import java.util.List;

public class BinaryPrefixDivisibleBy5 {
    /**
     * LeetCode №1018. Binary Prefix Divisible By 5.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param nums - an array of 0 and 1.
     * @return - a list result where result[i] is true if x-i is divisible by 5.
     */
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> result = new ArrayList<>();

        int remainder = 0;

        for (int num : nums) {
            remainder = ((remainder * 2) + num) % 5;

            result.add(remainder == 0);
        }

        return result;
    }
}
