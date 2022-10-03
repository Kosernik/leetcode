package MonthlyChallenges.Year22.October;

public class MinimumTimeToMakeRopeColorful {
    public static void main(String[] args) {
        MinimumTimeToMakeRopeColorful solution = new MinimumTimeToMakeRopeColorful();

        System.out.println(solution.minCost("abaac", new int[]{1, 2, 3, 4, 5}));

        System.out.println(solution.minCost(
                "abbbabaaabbbbbbabbaaaabbabbababbababbbabababbbaaababbabbbbbaabaaabbbbaabbaaabaaababbbbbaabaaaaaaaaab",
                new int[]{13, 18, 38, 34, 20, 36, 38, 5, 24, 9, 35, 34, 25, 48, 35, 9, 18, 40, 48, 12, 22, 18, 6, 7, 32, 12, 4, 39, 28, 28, 19, 21, 9,
                        20, 23, 40, 11, 13, 7, 1, 3, 40, 32, 14, 8, 46, 35, 45, 12, 21, 49, 4, 48, 40, 34, 29, 7, 49, 43, 16, 38, 15, 47, 44, 19, 18,
                        29, 49, 18, 2, 38, 9, 40, 1, 45, 6, 8, 26, 15, 30, 14, 23, 48, 27, 22, 41, 20, 6, 27, 25, 24, 25, 27, 41, 50, 27, 6, 12, 19, 19}));
    }

    /**
     * LeetCode  #1578. Minimum Time to Make Rope Colorful.
     *
     * @param colors     - a string of lowercase english letters representing a rope of balloons of different colours.
     * @param neededTime - an array of costs to remove each balloon.
     * @return - the minimum cost to make a rope colorful. No two consecutive balloons of the same colour.
     */
    public int minCost(String colors, int[] neededTime) {
        return getMinCost(0, colors.toCharArray(), neededTime);
    }

    private int getMinCost(int idx, char[] letters, int[] neededTime) {
        if (idx + 1 >= letters.length) return 0;
        if (letters[idx] != letters[idx + 1]) {
            return getMinCost(idx + 1, letters, neededTime);
        }

        char curLetter = letters[idx];
        int nextIdx = idx + 1;

        int maxPrice = neededTime[idx];
        int sum = maxPrice;

        while (nextIdx < letters.length && curLetter == letters[nextIdx]) {
            sum += neededTime[nextIdx];
            maxPrice = Math.max(maxPrice, neededTime[nextIdx]);
            nextIdx++;
        }

        int costToDelete = sum - maxPrice;
        return costToDelete + getMinCost(nextIdx, letters, neededTime);
    }
}
