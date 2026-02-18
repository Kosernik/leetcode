package MonthlyChallenges.Year26.February;

public class BinaryNumberWithAlternatingBits {
    public static void main(String[] args) {
        BinaryNumberWithAlternatingBits solution = new BinaryNumberWithAlternatingBits();

        int test0 = 5;
        boolean result0 = true;
        System.out.println(solution.hasAlternatingBits(test0) == result0);
    }

    /**
     * LeetCode №693. Binary Number with Alternating Bits.
     * <p>
     * Complexity - O(1)
     * Memory - O(1)
     *
     * @param n - a positive integer.
     * @return - true if n has alternating bits: namely, if two adjacent bits will always have different values.
     */
    public boolean hasAlternatingBits(int n) {
        boolean prevOne = (n & 1) == 1;

        int setBits = Integer.bitCount(n) - (prevOne ? 1 : 0);

        for (int mask = 2; setBits > 0; mask = mask << 1) {
            boolean curDigitOne = (n & mask) == mask;

            if (curDigitOne == prevOne) return false;

            if (curDigitOne) {
                setBits--;
            }

            prevOne = curDigitOne;
        }

        return true;
    }
}
