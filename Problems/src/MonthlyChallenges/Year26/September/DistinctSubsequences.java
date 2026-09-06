package MonthlyChallenges.Year26.September;

import java.util.Arrays;

public class DistinctSubsequences {
    public static void main(String[] args) {
        DistinctSubsequences solution = new DistinctSubsequences();

        String s1 = "rabbbit", t1 = "rabbit";
        int result1 = 3;
        System.out.println(solution.numDistinct(s1, t1) == result1);

        String s2 = "babgbag", t2 = "bag";
        int result2 = 5;
        System.out.println(solution.numDistinct(s2, t2) == result2);

        String s3 = "arabbbit", t3 = "rabbit";
        int result3 = 3;
        System.out.println(solution.numDistinct(s3, t3) == result3);

        String s4 = "arabduit", t4 = "rabbit";
        int result4 = 0;
        System.out.println(solution.numDistinct(s4, t4) == result4);

        String s5 = "bag", t5 = "baggy";
        int result5 = 0;
        System.out.println(solution.numDistinct(s5, t5) == result5);
    }

    /**
     * LeetCode №115. Distinct Subsequences.
     * <p>
     * Complexity - O(N*M), N = source.length, M = target.length.
     * Memory - O(N)
     *
     * @param source - a string of english letters.
     * @param target - a string of english letters.
     * @return - the number of distinct subsequences of source which equals target.
     */
    public int numDistinct(String source, String target) {
        int targetLength = target.length(), sourceLength = source.length();

        int[] dpArr = new int[sourceLength + 1];

        char firstChar = target.charAt(0);
        for (int i = 0; i < (sourceLength - targetLength + 1); i++) {
            dpArr[i + 1] = dpArr[i];
            if (source.charAt(i) == firstChar) {
                dpArr[i + 1]++;
            }
        }

        int[] curDp = new int[sourceLength + 1];
        for (int row = 1; row < targetLength; row++) {
            Arrays.fill(curDp, 0);

            for (int col = row; col < (sourceLength - targetLength + row + 1); col++) {
                curDp[col + 1] = curDp[col];
                if (source.charAt(col) == target.charAt(row)) {
                    curDp[col + 1] += dpArr[col];
                }
            }

            int[] temp = dpArr;
            dpArr = curDp;
            curDp = temp;
        }

        return dpArr[sourceLength];
    }
}
