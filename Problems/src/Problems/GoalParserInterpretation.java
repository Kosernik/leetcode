package Problems;

public class GoalParserInterpretation {

    /**
     * LeetCode #1678. Goal Parser Interpretation.
     *
     * Complexity - O(N)
     * Memory -O(N)
     *
     * @param command - a string, command consists of "G", "()", and/or "(al)" in some order.
     * @return - parsed command.
     */
    public String interpret(String command) {
        StringBuilder builder = new StringBuilder();
        int idx = 0;
        char[] letters = command.toCharArray();

        while (idx < letters.length) {
            if (letters[idx] == 'G') {
                builder.append('G');
                idx++;
            } else {
                if (letters[idx+1] == ')') {
                    builder.append('o');
                    idx += 2;
                } else {
                    builder.append("al");
                    idx += 4;
                }
            }
        }

        return builder.toString();
    }
}
