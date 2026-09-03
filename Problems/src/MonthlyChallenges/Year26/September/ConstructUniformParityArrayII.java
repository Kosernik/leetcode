package MonthlyChallenges.Year26.September;

public class ConstructUniformParityArrayII {

    /**
     * LeetCode №3876. Construct Uniform Parity Array II.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     * <p>
     * For each index i, you must choose exactly one of the following (in any order):
     * * nums2[i] = nums1[i]
     * * nums2[i] = nums1[i] - nums1[j], for an index j != i, such that nums1[i] - nums1[j] >= 1
     *
     * @param nums1 - an array of distinct positive integers.
     * @return - True if it is possible to construct an array nums2 consisting of either all odd or all even numbers.
     * False - otherwise.
     */
    public boolean uniformArray(int[] nums1) {
        int minOdd = Integer.MAX_VALUE;
        int minEven = Integer.MAX_VALUE;

        for (int number : nums1) {
            if ((number & 1) == 1) {
                minOdd = Math.min(minOdd, number);
            } else {
                minEven = Math.min(minEven, number);
            }
        }

        return minOdd == Integer.MAX_VALUE || minEven == Integer.MAX_VALUE || minEven > minOdd;
    }
}
