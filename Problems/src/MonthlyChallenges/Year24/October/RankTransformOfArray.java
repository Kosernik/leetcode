package MonthlyChallenges.Year24.October;

import java.util.Arrays;

public class RankTransformOfArray {

    /**
     * LeetCode №1331. Rank Transform of an Array.
     * <p>
     * Complexity - O(NlogN)
     * Memory - O(N)
     *
     * @param arr - an array of integers.
     * @return - an array of ranks of each element of arr.
     */
    public int[] arrayRankTransform(int[] arr) {
        int length = arr.length;
        int[] ranks = new int[length];

        int[][] copyArr = new int[length][2];
        for (int i = 0; i < length; i++) {
            copyArr[i][0] = arr[i];
            copyArr[i][1] = i;
        }

        Arrays.sort(copyArr, (a, b) -> Integer.compare(a[0], b[0]));

        int rank = 1;
        for (int i = 0; i < length; i++) {
            if (i > 0 && copyArr[i][0] != copyArr[i - 1][0]) {
                rank++;
            }

            int idx = copyArr[i][1];

            ranks[idx] = rank;
        }

        return ranks;
    }
}
