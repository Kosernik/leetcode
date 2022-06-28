package Problems;

public class UglyNumberIII {

    /**
     * LeetCode #1201. Ugly Number III.
     *
     * Complexity - O(log2^31) = O(31) = O(1)
     * Memory - O(1)
     *
     * @param n - a positive integer.
     * @param a - a positive integer.
     * @param b - a positive integer.
     * @param c - a positive integer.
     * @return - the n-th ugly number. An ugly number is a positive integer that is divisible by a, b, or c.
     */
    public int nthUglyNumber(int n, int a, int b, int c) {
        int left = 1, right = Integer.MAX_VALUE, middle;

        long lcmAB = lcm(a, b);
        long lcmAC = lcm(a, c);
        long lcmBC = lcm(b, c);
        long lcmABC = tripleLCM(a, b, c);

        while (left < right) {
            middle = (right - left) / 2 + left;

            int numberOfDivisible = (int)
                    (middle / a + middle / b + middle / c
                    - middle / lcmAB - middle / lcmAC - middle / lcmBC
                    + middle / lcmABC);

            if (numberOfDivisible < n) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        return left;
    }

    private long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    private long lcm(long a, long b) {
        long product = (long) a * b;

        return product / gcd(a, b);
    }

    private long tripleLCM(long a, long b, long c) {
        return lcm(a, lcm(b, c));
    }
}
