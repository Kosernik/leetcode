package MonthlyChallenges.Year25;

import java.util.ArrayList;
import java.util.List;

public class MergeTwo2DArraysBySummingValues {

    /**
     * LeetCode №2570. Merge Two 2D Arrays by Summing Values.
     * <p>
     * Complexity - O(N+M)
     * Memory - O(N+M)
     *
     * @param nums1 - an array of pairs {id, value}, array contains unique ids and is sorted in ascending order by id.
     * @param nums2 - an array of pairs {id, value}, array contains unique ids and is sorted in ascending order by id.
     * @return - the result of merging nums1 and nums2.
     */
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        List<int[]> result = new ArrayList<>();

        int idx1 = 0, idx2 = 0;

        while (idx1 < nums1.length && idx2 < nums2.length) {
            if (nums1[idx1][0] < nums2[idx2][0]) {
                result.add(nums1[idx1]);
                idx1++;
            } else if (nums1[idx1][0] > nums2[idx2][0]) {
                result.add(nums2[idx2]);
                idx2++;
            } else {
                result.add(new int[]{nums1[idx1][0], nums1[idx1][1] + nums2[idx2][1]});
                idx1++;
                idx2++;
            }
        }

        while (idx1 < nums1.length) {
            result.add(nums1[idx1]);
            idx1++;
        }
        while (idx2 < nums2.length) {
            result.add(nums2[idx2]);
            idx2++;
        }

        int[][] merged = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            merged[i] = result.get(i);
        }

        return merged;
    }
}
