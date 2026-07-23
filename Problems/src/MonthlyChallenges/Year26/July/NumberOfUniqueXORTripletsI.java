package MonthlyChallenges.Year26.July;

public class NumberOfUniqueXORTripletsI {

    /**
     * LeetCode №3513. Number of Unique XOR Triplets I.
     * <p>
     * Complexity - O(1)
     * Memory - O(1)
     * <p>
     * A XOR triplet is defined as the XOR of three elements nums[i] XOR nums[j] XOR nums[k] where i <= j <= k.
     *
     * @param nums - an integer array of length N, where nums is a permutation of the numbers in the range [1, N].
     * @return - the number of unique XOR triplet values from all possible triplets (i, j, k).
     */
    public int uniqueXorTriplets(int[] nums) {
        int maxNumber = nums.length;

        if (maxNumber < 3) return maxNumber;

        int lastBitIdx = 0;

        while (maxNumber > 0) {
            lastBitIdx++;
            maxNumber >>= 1;
        }

        return 1 << lastBitIdx;
    }
}
