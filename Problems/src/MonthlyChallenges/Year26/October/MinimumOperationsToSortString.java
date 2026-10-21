package MonthlyChallenges.Year26.October;

public class MinimumOperationsToSortString {
    public static void main(String[] args) {
        MinimumOperationsToSortString solution = new MinimumOperationsToSortString();

        String[] tests = {"dog", "card", "gf", "fz", "acard", "zcara", "zcbra", "zcazra"};
        int[] results = {1, 2, -1, 0, 1, 2, 3, 2};

        for (int i = 0; i < tests.length; i++) {
            int solResult = solution.minOperations(tests[i]);
            if (solResult != results[i]) {
                System.out.println("Test: " + (i + 1) + " " + tests[i] + ", got: " + solResult + ", should be: " + results[i]);
            }
        }

        System.out.println("Done!");
    }

    /**
     * LeetCode №3863. Minimum Operations to Sort a String.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     * <p>
     * In one operation, you can select any substring of s that is not the entire string and sort it in non-descending
     * alphabetical order.
     *
     * @param s - a string.
     * @return - the minimum number of operations required to make s sorted in non-descending order. If it is not
     * possible, returns -1.
     */
    public int minOperations(String s) {
        if (s.length() <= 1) {
            return 0;
        } else if (s.length() == 2) {
            return s.charAt(0) <= s.charAt(1) ? 0 : -1;
        }

        char prevChar = s.charAt(0);

        char minChar = prevChar;
        int minCharFirstIdx = 0;

        char maxChar = prevChar;
        int maxCharLastIdx = 0;

        boolean isSorted = true;

        for (int i = 1; i < s.length(); i++) {
            char curChar = s.charAt(i);
            if (curChar < prevChar) {
                isSorted = false;
            }

            if (curChar < minChar) {
                minChar = curChar;
                minCharFirstIdx = i;
            }
            if (curChar >= maxChar) {
                maxChar = curChar;
                maxCharLastIdx = i;
            }

            prevChar = curChar;
        }

        if (isSorted) return 0;

        char first = s.charAt(0);
        char last = s.charAt(s.length() - 1);

        if (first == minChar || last == maxChar) {
            return 1;
        }
        if (first == maxChar && last == minChar) {
            if (minCharFirstIdx == (s.length() - 1) && maxCharLastIdx == 0) {
                return 3;
            } else {
                return 2;
            }
        }

        return 2;
    }
}
