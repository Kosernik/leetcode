package MonthlyChallenges.Year26.February;

public class BinaryGap {

    /**
     * LeetCode №868. Binary Gap.
     * <p>
     * Complexity - O(1)
     * Memory - O(1)
     *
     * @param n - a positive integer.
     * @return - the longest distance between any two adjacent 1's in the binary representation of n.
     */
    public int binaryGap(int n) {
        int maxLength = 0;

        int prevOneIdx = -1;

        for (int i = 0, mask = 1; i <= 31; i++, mask = mask << 1) {
            if ((n & mask) == mask) {
                if (prevOneIdx != -1) {
                    maxLength = Math.max(maxLength, i - prevOneIdx);
                }

                prevOneIdx = i;
            }
        }

        return maxLength;
    }
}
