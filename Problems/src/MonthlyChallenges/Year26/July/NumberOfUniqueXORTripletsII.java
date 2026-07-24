package MonthlyChallenges.Year26.July;

import java.util.HashSet;
import java.util.Set;

public class NumberOfUniqueXORTripletsII {

    /**
     * LeetCode №3514. Number of Unique XOR Triplets II.
     * <p>
     * Complexity - O(N^3)
     * Memory - O(N^2)
     * <p>
     * A XOR triplet is defined as the XOR of three elements nums[i] XOR nums[j] XOR nums[k] where i <= j <= k.
     *
     * @param nums - an array of positive integers.
     * @return - the number of unique XOR triplet values from all possible triplets (i, j, k).
     */
    public int uniqueXorTriplets(int[] nums) {
        if (nums.length == 1) return 1;

        Set<Integer> uniquePairs = new HashSet<>();

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                uniquePairs.add(nums[i] ^ nums[j]);
            }
        }

        Set<Integer> uniqueTriplets = new HashSet<>();

        for (int pair : uniquePairs) {
            for (int num : nums) {
                uniqueTriplets.add(pair ^ num);
            }
        }

        return uniqueTriplets.size();
    }
}
