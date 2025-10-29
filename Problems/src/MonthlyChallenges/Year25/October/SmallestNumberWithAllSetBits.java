package MonthlyChallenges.Year25.October;

public class SmallestNumberWithAllSetBits {

    /**
     * LeetCode №3370. Smallest Number With All Set Bits.
     * <p>
     * Complexity - O(1)
     * Memory - O(1)
     *
     * @param n - an integer. 1 <= n <= 1000
     * @return - the smallest number x greater than or equal to n, such that the binary representation of x contains
     * only set bits
     */
    public int smallestNumber(int n) {
        int lastBitIdx = getLastBitIdx(n);

        int result = 0;
        for (int i = 0; i <= lastBitIdx; i++) {
            result = result | (1 << i);
        }

        return result;
    }

    /**
     * Returns the index of the last set bit.
     *
     * @param number - an integer. 1 <= number <= 1000
     * @return - an index (the least significant bit is 0 index) of the last set bit.
     */
    private int getLastBitIdx(int number) {
        int lastBit = 0;

        for (int i = 0; i < 10; i++) {
            int mask = 1 << i;
            if ((mask & number) == mask) lastBit = i;
        }

        return lastBit;
    }
}
