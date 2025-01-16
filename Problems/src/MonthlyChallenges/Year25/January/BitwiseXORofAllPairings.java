package MonthlyChallenges.Year25.January;

public class BitwiseXORofAllPairings {

    /**
     * LeetCode №2425. Bitwise XOR of All Pairings.
     * <p>
     * Complexity - O(N+M), N = nums1.length, M = nums2.length.
     * Memory - O(1)
     *
     * @param nums1 - an array of integers.
     * @param nums2 - an array of integers.
     * @return - the bitwise XOR of all bitwise XOR`s of all pairings of integers between nums1 and nums2 (every integer
     * in nums1 is paired with every integer in nums2 exactly once).
     */
    public int xorAllNums(int[] nums1, int[] nums2) {
        boolean odd1 = nums1.length % 2 == 0;
        boolean odd2 = nums2.length % 2 == 0;
        if (odd1 && odd2) return 0;

        int xor = 0;

        if (!odd1) {
            xor ^= getXOR(nums2);
        }

        if (!odd2) {
            xor ^= getXOR(nums1);
        }

        return xor;
    }

    private static int getXOR(int[] nums) {
        int xor = 0;

        for (int number : nums) {
            xor ^= number;
        }

        return xor;
    }
}
