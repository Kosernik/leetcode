package MonthlyChallenges.Year24.November;

public class LargestCombinationWithBitwiseANDGreaterThanZero {

    /**
     * LeetCode №2275. Largest Combination With Bitwise AND Greater Than Zero.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param candidates - an array of positive integers.
     * @return - the size of the largest combination of candidates with a bitwise AND greater than 0.
     */
    public int largestCombination(int[] candidates) {
        int[] bitCounts = new int[31];

        for (int number : candidates) {
            int mask = 1;
            for (int shift = 0; shift < 31; shift++) {
                if ((number & mask) == mask) {
                    bitCounts[shift]++;
                }

                mask = mask << 1;
            }
        }

        int maxGroup = 0;
        for (int count : bitCounts) {
            maxGroup = Math.max(maxGroup, count);
        }

        return maxGroup;
    }
}
