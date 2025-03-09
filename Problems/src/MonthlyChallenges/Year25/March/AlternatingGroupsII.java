package MonthlyChallenges.Year25.March;

public class AlternatingGroupsII {
    public static void main(String[] args) {
        AlternatingGroupsII solution = new AlternatingGroupsII();

        int[] colours0 = {0, 1, 0, 1, 0};
        int k0 = 3;
        int result0 = 3;
        System.out.println("Result is: " + solution.numberOfAlternatingGroups(colours0, k0) + " , should be " + result0);

        int[] colours1 = {1, 1, 0, 1};
        int k1 = 4;
        int result1 = 0;
        System.out.println("Result is: " + solution.numberOfAlternatingGroups(colours1, k1) + " , should be " + result1);

        int[] colours2 = {0, 1, 0, 1, 0, 1};
        int k2 = 3;
        int result2 = 6;
        System.out.println("Result is: " + solution.numberOfAlternatingGroups(colours2, k2) + " , should be " + result2);
    }

    /**
     * LeetCode №3208. Alternating Groups II.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param colors - an array of 0 and 1. 0 means it isa red tile, 1 - blue tile.
     * @param k      - the length of a group of alternating colours.
     * @return - the number of alternating groups of length k.
     */
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int groups = 0;
        boolean foundTwins = false;

        int length = colors.length;

        for (int i = 0; i < length; i++) {
            if (colors[i] == colors[getIndexMod(i + 1, length)]) {
                foundTwins = true;

                int start = i;
                int groupLength = 1;

                while (true) {
                    int prevIdx = getIndexMod(start - 1, length);
                    if (prevIdx == i) break;
                    if (colors[prevIdx] == colors[start]) break;
                    start = prevIdx;

                    groupLength++;
                }

                if (groupLength >= k) {
                    groups += (groupLength - k + 1);
                }
            }
        }

        if (!foundTwins) {
            return colors.length;
        }
        return groups;
    }

    private int getIndexMod(int index, int length) {
        return (index + length) % length;
    }
}
