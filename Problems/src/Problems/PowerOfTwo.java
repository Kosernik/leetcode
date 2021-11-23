package Problems;

public class PowerOfTwo {

    /**
     * LeetCode #231. Power of Two.
     *
     * Complexity - O(1)
     * Memory - O(1)
     *
     * @param n - an integer.
     * @return - True if "n" is a power of two. False - otherwise.
     */
    public boolean isPowerOfTwo(int n) {
        if (n == 1) {
            return true;
        } else if (n <= 0 || n % 2 != 0) {
            return false;
        }

        int ones = Integer.bitCount(n);
        return ones == 1;
    }
}
