package MonthlyChallenges.Year26.July;

public class MaximizeActiveSectionWithTradeI {
    public static void main(String[] args) {
        MaximizeActiveSectionWithTradeI solution = new MaximizeActiveSectionWithTradeI();

        String test0 = "10001101100";
        int result0 = 9;
        System.out.println(solution.maxActiveSectionsAfterTrade(test0) == result0);
    }

    /**
     * LeetCode №3499. Maximize Active Section with Trade I.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     * <p>
     * A trade is:
     * * Convert a contiguous block of '1's that is surrounded by '0's to all '0's.
     * * Afterward, convert a contiguous block of '0's that is surrounded by '1's to all '1's.
     *
     * @param s - a binary string of '0' and '1'.
     *          '0' - represents an inactive section.
     *          '1' - represents an active section.
     * @return - the maximum number of active sections in s after making at most one trade.
     */
    public int maxActiveSectionsAfterTrade(String s) {
        char[] letters = s.toCharArray();

        int[] prefixZeroes = new int[letters.length + 1];
        int[] prefixOnes = new int[letters.length + 1];

        int activeSections = 0;

        for (int i = 0; i < letters.length; i++) {
            if (letters[i] == '0') {
                prefixZeroes[i + 1] = prefixZeroes[i] + 1;
            } else {
                activeSections++;

                prefixOnes[i + 1] = prefixOnes[i] + 1;
            }
        }

        int maxResult = activeSections;

        int zeroesOnRight = 0;

        for (int i = letters.length - 1; i > 0; i--) {
            if (letters[i] == '0') {
                zeroesOnRight++;
            } else {
                if (zeroesOnRight > 0) {
                    int onesCount = prefixOnes[i + 1];
                    int idxOnesLeft = i - onesCount + 1;
                    if (idxOnesLeft == 0) break;

                    int zeroesConverted = zeroesOnRight + prefixZeroes[idxOnesLeft];

                    maxResult = Math.max(maxResult, activeSections + zeroesConverted);
                }
                zeroesOnRight = 0;
            }
        }

        return maxResult;
    }
}
