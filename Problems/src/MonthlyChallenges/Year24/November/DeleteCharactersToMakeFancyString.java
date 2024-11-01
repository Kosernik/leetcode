package MonthlyChallenges.Year24.November;

public class DeleteCharactersToMakeFancyString {

    /**
     * LeetCode №1957. Delete Characters to Make Fancy String.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     * <p>
     * A fancy string is a string where no three consecutive characters are equal.
     *
     * @param s - a string.
     * @return - the final string after the minimum number of deletion to make "s" a fancy string.
     */
    public String makeFancyString(String s) {
        if (s.length() <= 2) return s;

        StringBuilder result = new StringBuilder();

        char[] letters = s.toCharArray();

        char second = letters[0];
        result.append(second);

        char first = letters[1];
        result.append(first);


        for (int i = 2; i < letters.length; i++) {
            char current = letters[i];

            if (current == first && current == second) {
                continue;
            }

            result.append(current);

            second = first;
            first = current;
        }

        return result.toString();
    }
}
