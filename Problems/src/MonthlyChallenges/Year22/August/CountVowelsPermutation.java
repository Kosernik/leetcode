package MonthlyChallenges.Year22.August;

public class CountVowelsPermutation {
    public static void main(String[] args) {
        CountVowelsPermutation solution = new CountVowelsPermutation();

        System.out.println(solution.countVowelPermutation(1) == 5);
        System.out.println();

        System.out.println(solution.countVowelPermutation(2) == 10);
        System.out.println();

        System.out.println(solution.countVowelPermutation(5) == 68);
        System.out.println();

        System.out.println(solution.countVowelPermutation(20_000) == 759959057);
    }

    /**
     * LeetCode #1220. Count Vowels Permutation.
     * <p>
     * Each character is a lower case vowel ('a', 'e', 'i', 'o', 'u')
     * Each vowel 'a' may only be followed by an 'e'.
     * Each vowel 'e' may only be followed by an 'a' or an 'i'.
     * Each vowel 'i' may not be followed by another 'i'.
     * Each vowel 'o' may only be followed by an 'i' or a 'u'.
     * Each vowel 'u' may only be followed by an 'a'.
     *
     * @param n - the length of a string.
     * @return - the number of valid strings of length 'n'.The answer is modulo 1_000_000_007.
     */
    public int countVowelPermutation(int n) {
        int MODULO = 1_000_000_007;

        // 0    1    2    3    4
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        int[][] prevIdxs = {
                {1, 2, 4},    // a
                {0, 2},      // e
                {1, 3},      // i
                {2},        // o
                {2, 3}       // u
        };

        long[][] dp = new long[n][vowels.length];
        for (int i = 0; i < vowels.length; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < vowels.length; j++) {
                for (int idx : prevIdxs[j]) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][idx]) % MODULO;
                }
            }
        }

        long result = 0;
        for (int i = 0; i < vowels.length; i++) {
            result = (result + dp[n - 1][i]) % MODULO;
        }
        return (int) result;
    }
}
