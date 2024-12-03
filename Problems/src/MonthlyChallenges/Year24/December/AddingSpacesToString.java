package MonthlyChallenges.Year24.December;

public class AddingSpacesToString {

    /**
     * LeetCode №2109. Adding Spaces to a String.
     * <p>
     * Complexity - O(N+M), N = s.length, M = spaces.length.
     * Memory - O(1)
     *
     * @param s      - a string.
     * @param spaces - the indices of white spaces. All the values of spaces are strictly increasing.
     * @return - the string s after inserting all the white spaces.
     */
    public String addSpaces(String s, int[] spaces) {
        char SPACE = ' ';
        StringBuilder result = new StringBuilder();

        int sIdx = 0;
        int spacesIdx = 0;
        if (spaces[spacesIdx] == 0) {
            result.append(SPACE);
            spacesIdx++;
        }

        for (char ch : s.toCharArray()) {
            result.append(ch);

            if (spacesIdx < spaces.length && (sIdx + 1) == spaces[spacesIdx]) {
                result.append(SPACE);
                spacesIdx++;
            }

            sIdx++;
        }

        return result.toString();
    }
}
