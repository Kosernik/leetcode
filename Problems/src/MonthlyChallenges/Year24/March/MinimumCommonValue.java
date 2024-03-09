package MonthlyChallenges.Year24.March;

public class MinimumCommonValue {

    /**
     * LeetCode №2540. Minimum Common Value.
     * <p>
     * Complexity - O(N+M), N = nums1.length, M = nums2.length.
     * Memory - O(1)
     *
     * @param nums1 - an array of integers sorted in non-decreasing order.
     * @param nums2 - an array of integers sorted in non-decreasing order.
     * @return - the minimum integer common to both arrays.
     */
    public int getCommon(int[] nums1, int[] nums2) {
        int first = 0;
        int second = 0;

        while (true) {
            while (first < nums1.length && nums1[first] < nums2[second]) {
                first++;
            }
            if (first == nums1.length) return -1;
            else if (nums1[first] == nums2[second]) return nums1[first];

            while (second < nums2.length && nums2[second] < nums1[first]) {
                second++;
            }
            if (second == nums2.length) return -1;
        }
    }
}
