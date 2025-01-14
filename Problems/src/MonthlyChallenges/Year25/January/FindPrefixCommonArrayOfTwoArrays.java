package MonthlyChallenges.Year25.January;

public class FindPrefixCommonArrayOfTwoArrays {

    /**
     * LeetCode №2657. Find the Prefix Common Array of Two Arrays.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param A - a permutation array of numbers from 1 to A.length.
     * @param B - a permutation array of numbers from 1 to B.length. A.length = B.length.
     * @return - the prefix common array of A and B.
     */
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int length = A.length;
        int[] result = new int[length];

        boolean[] seen = new boolean[length + 1];

        for (int i = 0; i < length; i++) {
            int first = A[i];
            int second = B[i];

            if (first != second) {
                if (i > 0) {
                    result[i] = result[i - 1];
                    if (seen[first] && seen[second]) {
                        result[i] += 2;
                    } else if (seen[first] || seen[second]) {
                        result[i] += 1;
                    }
                }
            } else {
                if (i == 0) {
                    result[i] = 1;
                } else {
                    result[i] = result[i - 1] + 1;
                }
            }

            seen[first] = true;
            seen[second] = true;
        }

        return result;
    }
}
