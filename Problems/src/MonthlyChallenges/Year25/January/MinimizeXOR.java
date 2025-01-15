package MonthlyChallenges.Year25.January;

public class MinimizeXOR {

    /**
     * LeetCode №2429. Minimize XOR.
     * <p>
     * Complexity - O(1)
     * Memory - O(1)
     *
     * @param num1 - a positive integer.
     * @param num2 - a positive integer.
     * @return - the integer x such that x has the same number of set bits as num2, and the value x XOR num1 is minimal.
     */
    public int minimizeXor(int num1, int num2) {
        int bitsToUse = Integer.bitCount(num2);

        int result = 0;
        int mask;

        for (int i = 30; i >= 0; i--) {
            if (bitsToUse == 0) break;

            mask = 1 << i;
            if ((mask & num1) == mask) {
                result = result | mask;
                bitsToUse--;
            }
        }

        for (int i = 0; i < 31; i++) {
            if (bitsToUse == 0) break;

            mask = 1 << i;
            if ((mask & num1) == 0) {
                result = result | mask;
                bitsToUse--;
            }
        }

        return result;
    }
}
