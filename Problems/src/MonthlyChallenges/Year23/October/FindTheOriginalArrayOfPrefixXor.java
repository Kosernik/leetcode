package MonthlyChallenges.Year23.October;

public class FindTheOriginalArrayOfPrefixXor {

    /**
     * LeetCode #2433. Find The Original Array of Prefix Xor.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param pref - a non-empty array of integers
     * @return - an array of prefix xor-s
     */
    public int[] findArray(int[] pref) {
        int[] result = new int[pref.length];
        result[0] = pref[0];

        for (int i = 1; i < pref.length; i++) {
            result[i] = pref[i - 1] ^ pref[i];
        }

        return result;
    }
}
