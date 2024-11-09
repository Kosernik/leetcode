package MonthlyChallenges.Year24.November;

public class MinimumArrayEnd {
    public static void main(String[] args) {
        MinimumArrayEnd solution = new MinimumArrayEnd();

        int n0 = 3;
        int x0 = 4;
        int result0 = 6;
        System.out.println(solution.minEnd(n0, x0) == result0);
    }

    /**
     * LeetCode №3133. Minimum Array End.
     * <p>
     * Complexity - O(1)
     * Memory - O(1)
     * <p>
     * You are given two integers n and x. You have to construct an array of positive integers nums of size n where for
     * every 0 <= i < n - 1, nums[i + 1] is greater than nums[i], and the result of the bitwise AND operation between
     * all elements of nums is x.
     *
     * @param n - a positive integers.
     * @param x - a positive integer.
     * @return - the minimum possible value of nums[n - 1].
     */
    public long minEnd(int n, int x) {
        long result = x;
        int mask = n - 1;

        int idx = 0;

        for (int bit = 0; bit < 31; bit++) {
            long curBit = getBit(mask, bit);

            while ((result & (1L << idx)) == (1L << idx)) {
                idx++;
            }

            result = result | (curBit << idx);
            idx++;
        }

        return result;
    }

    private int getBit(int number, int position) {
        return (number >> position) & 1;
    }
}
