package MonthlyChallenges.February21;

public class MinimumRemoveToMakeValidParentheses {
    /**
     * LeetCode #1249.
     *
     * @param s - a string of '(' , ')' and lowercase English characters.
     * @return - valid parentheses string.
     */
    public String minRemoveToMakeValid(String s) {
        StringBuilder result = new StringBuilder();

        int idx = 0;

        while (idx < s.length() && s.charAt(idx) != '(') {
            if (s.charAt(idx) != ')') result.append(s.charAt(idx));
            idx++;
        }
        if (idx >= s.length()) return result.toString();

        int count = 0;
        int open = 0;

        for (int i = idx; i < s.length(); i++) {
            if (s.charAt(i) == '('){
                open++;
                count++;
            }
            else if (s.charAt(i) == ')') count--;

            if (count >= 0) result.append(s.charAt(i));
            else count++;
        }

        if (count == 0) return result.toString();
        open -= count;

        StringBuilder builder = new StringBuilder();

        for (char ch : result.toString().toCharArray()) {
            if (ch == '(') {
                if (open > 0) {
                    open--;
                    builder.append(ch);
                }
            } else {
                builder.append(ch);
            }
        }

        return builder.toString();
    }
}
