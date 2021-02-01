package MonthlyChallenges.February21;

public class NumberOfOneBits {
    // you need to treat n as an unsigned value

    /**
     * LeetCode #191.
     *
     * Counts number of '1' bits in an integer.
     *
     * Complexity - O(1)
     * Memory O(1)
     *
     * @param n - an integer.
     * @return - number of '1' bits.
     */
    public int hammingWeight(int n) {
        int result = 0;
        int number = n;

        for (int i = 0; i < 32; i++) {
            if ((number & 1) == 1) {
                result++;
            }
            number = number >> 1;
        }

        return result;
    }
}
