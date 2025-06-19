package MonthlyChallenges.Year25.June;

import java.util.NavigableSet;
import java.util.TreeSet;

public class PartitionArraySuchThatMaximumDifferenceIsK {

    /**
     * LeetCode №2294. Partition Array Such That Maximum Difference Is K.
     * <p>
     * Complexity - O(NlogN)
     * Memory - O(N)
     *
     * @param nums - an array of integers. 0 <= nums[i] <= 10e5
     * @param k    - a non-negative integer.
     * @return - the minimum number of subsequences needed such that the difference between the maximum and minimum
     * values in each subsequence is at most k.
     */
    public int partitionArray(int[] nums, int k) {
        NavigableSet<Integer> orderedNumbers = new TreeSet<>();
        for (int number : nums) {
            orderedNumbers.add(number);
        }

        int result = 0;
        int prev = Integer.MIN_VALUE;

        while (true) {
            Integer cur = orderedNumbers.higher(prev);
            if (cur == null) break;
            result++;

            int next = cur + k;
            prev = orderedNumbers.floor(next);
        }

        return result;
    }
}
