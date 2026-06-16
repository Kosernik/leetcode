package MonthlyChallenges.Year26.June;

public class ProcessStringWithSpecialOperationsI {

    /**
     * LeetCode №3612. Process String with Special Operations I.
     * <p>
     * Builds a new string result by processing s according to the following rules from left to right:
     * * If the letter is a lowercase English letter appends it to result.
     * * '*' removes the last character from result, if it exists.
     * * '#' duplicates the current result and appends it to itself.
     * * '%' reverses the current result.
     *
     * @param s - a string.
     * @return - the result string after performing all operations.
     */
    public String processStr(String s) {
        StringBuilder result = new StringBuilder();

        char REMOVE = '*';
        char DUPLICATE = '#';
        char REVERSE = '%';

        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            if (letter == REMOVE) {
                if (!result.isEmpty()) {
                    result.deleteCharAt(result.length() - 1);
                }
            } else if (letter == DUPLICATE) {
                result.append(result);
            } else if (letter == REVERSE) {
                result.reverse();
            } else {
                result.append(letter);
            }
        }

        return result.toString();
    }
}
