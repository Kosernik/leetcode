package MonthlyChallenges.Year25.March;

public class NumberOfSubstringsContainingAllThreeCharacters {


    /**
     * LeetCode №1358. Number of Substrings Containing All Three Characters.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param s - a string of 'a', 'b' and 'c'. s.length() >= 3
     * @return - the number of substrings containing at least one occurrence of all these characters 'a', 'b' and 'c'.
     */
    public int numberOfSubstrings(String s) {
        int substrings = 0;

        int length = s.length();
        char[] letters = s.toCharArray();

        int nextA = length, nextB = length, nextC = length;

        for (int i = length - 1; i >= 0; i--) {
            char letter = letters[i];

            if (letter == 'a') {
                nextA = i;
            } else if (letter == 'b') {
                nextB = i;
            } else {    // letter == 'c'
                nextC = i;
            }

            int nextLetterIdx = Math.max(nextA, Math.max(nextB, nextC));

            substrings += length - nextLetterIdx;
        }

        return substrings;
    }


    /**
     * LeetCode №1358. Number of Substrings Containing All Three Characters.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param s - a string of 'a', 'b' and 'c'. s.length() >= 3
     * @return - the number of substrings containing at least one occurrence of all these characters 'a', 'b' and 'c'.
     */
    public int numberOfSubstringsSlow(String s) {
        int substrings = 0;

        int length = s.length();
        char[] letters = s.toCharArray();

        int[][] nextIdx = new int[length][3];
        int nextA = length, nextB = length, nextC = length;

        for (int i = length - 1; i >= 0; i--) {
            char letter = letters[i];

            if (letter == 'a') {
                nextA = i;
            } else if (letter == 'b') {
                nextB = i;
            } else {    // letter == 'c'
                nextC = i;
            }

            nextIdx[i][0] = nextA;
            nextIdx[i][1] = nextB;
            nextIdx[i][2] = nextC;

            int nextLetterIdx = Math.max(nextIdx[i][0], Math.max(nextIdx[i][1], nextIdx[i][2]));

            substrings += length - nextLetterIdx;
        }

        return substrings;
    }
}
