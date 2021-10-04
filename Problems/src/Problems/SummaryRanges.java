package Problems;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    /**
     * LeetCode #228. Summary Ranges.
     *
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param nums - a sorted unique integer array.
     * @return - the smallest sorted list of ranges that cover all the numbers in the array exactly.
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length < 1) return result;

        int idx = 0;

        while (idx < nums.length) {
            int endIdx = idx;

            while ((endIdx+1) < nums.length && (nums[endIdx]+1) == nums[endIdx+1]) endIdx++;

            if (idx == endIdx) result.add(String.valueOf(nums[idx]));
            else {
                result.add(String.valueOf(nums[idx]) + "->" + String.valueOf(nums[endIdx]));
            }
            idx = endIdx+1;
        }

        return result;
    }
}
