package MonthlyChallenges.Year25.January;

public class NeighboringBitwiseXOR {

    /**
     * LeetCode №2683. Neighboring Bitwise XOR.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param derived - a binary array.
     * @return - true if there exists an original array or false otherwise.
     */
    public boolean doesValidArrayExist(int[] derived) {
        if (derived.length == 1) {
            return derived[0] == 0;
        }

        int[] original = new int[derived.length + 1];

        if (derived[0] == 0) {
            if (helper(1, derived, original)) {
                return true;
            }

            original = new int[derived.length + 1];
            original[1] = 1;
        } else {
            original[1] = 1;
            if (helper(1, derived, original)) {
                return true;
            }

            original = new int[derived.length + 1];
        }

        original[0] = 1;
        original[original.length - 1] = 1;
        return helper(1, derived, original);
    }

    private boolean helper(int idx, int[] derived, int[] original) {
        if (idx == derived.length) {
            return original[0] == original[original.length - 1];
        }

        original[idx + 1] = derived[idx] ^ original[idx];
        return helper(idx + 1, derived, original);
    }
}
