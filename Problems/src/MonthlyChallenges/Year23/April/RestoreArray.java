package MonthlyChallenges.Year23.April;

public class RestoreArray {
    private final int MODULO = 1_000_000_007;

    /**
     * LeetCode #1416. Restore The Array.
     *
     * @param s - a string of digit-chars.
     * @param k - the maximum allowed number.
     * @return - the number of the possible arrays.
     */
    public int numberOfArrays(String s, int k) {
        Integer[] computed = new Integer[s.length() + 1];

        return (int) dpNumOfArrays(0, s.toCharArray(), k, computed);
    }

    private long dpNumOfArrays(int idx, char[] s, int k, Integer[] computed) {
        if (idx == s.length) {
            return 1;
        } else if (s[idx] == '0') {
            return 0;
        } else if (computed[idx] != null) {
            return computed[idx];
        }

        long result = 0;
        long number = 0;

        for (int i = idx; i < s.length; i++) {
            number = number * 10 + (s[i] - '0');
            if (number > k) {
                break;
            }
            result += dpNumOfArrays(i + 1, s, k, computed);
            result %= MODULO;
        }

        computed[idx] = (int) result;
        return computed[idx];
    }
}
