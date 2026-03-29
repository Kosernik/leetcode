package MonthlyChallenges.Year26.March;

public class CheckIfStringsCanBeMadeEqualWithOperationsI {

    /**
     * LeetCode №2839. Check if Strings Can be Made Equal With Operations I.
     * <p>
     * Complexity - O(N), N = s1.length = s2.length.
     * Memory - O(N)
     * <p>
     * An operation:
     * * Choose any two indices i and j such that j - i = 2, then swap the two characters at those indices in the string.
     *
     * @param s1 - a string of lowercase english letters. s1.length = 4.
     * @param s2 - a string of lowercase english letters. s2.length = 4.
     * @return - true if you can make the strings s1 and s2 equal after performing an operation any number of times on
     * any of the two strings, and false otherwise.
     */
    public boolean canBeEqual(String s1, String s2) {
        char[][] permuted = getPermutations(s1);

        char[] word2 = s2.toCharArray();

        for (char[] candidate : permuted) {
            if (isEqual(candidate, word2)) return true;
        }

        return false;
    }

    private boolean isEqual(char[] word1, char[] word2) {
        for (int i = 0; i < word1.length; i++) {
            if (word1[i] != word2[i]) return false;
        }

        return true;
    }

    private char[][] getPermutations(String word) {
        char[][] permuted = new char[4][word.length()];

        permuted[0] = word.toCharArray();

        permuted[1][0] = permuted[0][2];
        permuted[1][2] = permuted[0][0];
        permuted[1][1] = permuted[0][3];
        permuted[1][3] = permuted[0][1];

        permuted[2][0] = permuted[0][2];
        permuted[2][2] = permuted[0][0];
        permuted[2][1] = permuted[0][1];
        permuted[2][3] = permuted[0][3];

        permuted[3][0] = permuted[0][0];
        permuted[3][2] = permuted[0][2];
        permuted[3][1] = permuted[0][3];
        permuted[3][3] = permuted[0][1];

        return permuted;
    }
}
