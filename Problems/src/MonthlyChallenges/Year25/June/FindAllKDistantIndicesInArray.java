package MonthlyChallenges.Year25.June;

import java.util.ArrayList;
import java.util.List;

public class FindAllKDistantIndicesInArray {

    /**
     * LeetCode №2200. Find All K-Distant Indices in an Array.
     *
     * @param nums - an array of integers.
     * @param key  - an integer from nums.
     * @param k    - a positive integer. 1 <= k <= nums.length
     * @return - a list of all k-distant indices sorted in increasing order.
     */
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> indices = new ArrayList<>();

        int length = nums.length;

        for (int i = 0; i < length; i++) {
            if (nums[i] == key) {
                int start = Math.max(0, i - k);
                if (!indices.isEmpty() && indices.get(indices.size() - 1) >= start) {
                    start = indices.get(indices.size() - 1) + 1;
                }

                for (; start < Math.min(i + k + 1, length); start++) {
                    indices.add(start);
                }
            }
        }

        return indices;
    }
}
