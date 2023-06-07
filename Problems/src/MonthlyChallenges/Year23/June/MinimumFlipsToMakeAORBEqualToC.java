package MonthlyChallenges.Year23.June;

public class MinimumFlipsToMakeAORBEqualToC {

    /**
     * LeetCode #1318. Minimum Flips to Make a OR b Equal to c.
     * <p>
     * Complexity - O(1)
     * Memory - O(1)
     *
     * @param a - a positive integer.
     * @param b - a positive integer.
     * @param c - a positive integer.
     * @return - the minimum number of flips in 'a' or 'b' to make 'a | b == c' a valid operation.
     */
    public int minFlips(int a, int b, int c) {
        int or = a | b;

        if (or == c) return 0;
        int result = 0;

        for (int shift = 0; shift < 32; shift++) {
            int bitAtOR = getBit(or, shift);
            int bitAtC = getBit(c, shift);
            if (bitAtOR != bitAtC) {
                //  a-b -- c    = bits to flip
                //  0-1 -- 0    = 1
                //  1-1 -- 0    = 2
                //  1-0 -- 0    = 1
                //  0-0 -- 1    = 1
                if (bitAtC == 1) {
                    result++;
                } else {
                    int bitAtA = getBit(a, shift);
                    int bitAtB = getBit(b, shift);
                    if (bitAtA == 1 && bitAtB == 1) {
                        result += 2;
                    } else {
                        result += 1;
                    }
                }
            }
        }

        return result;
    }

    private int getBit(int number, int shift) {
        shift = 1 << shift;

        if ((number & shift) == shift) {
            return 1;
        } else {
            return 0;
        }
    }
}
