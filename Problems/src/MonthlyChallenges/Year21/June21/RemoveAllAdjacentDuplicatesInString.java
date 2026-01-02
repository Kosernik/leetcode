package MonthlyChallenges.Year21.June21;

import java.util.ArrayDeque;

public class RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicatesBrute(String s) {
        if (s == null || s.length() <= 1) return s;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                String reduced = s.substring(0, i - 1) + ((i + 1) < s.length() ? s.substring(i + 1) : "");
                return removeDuplicatesBrute(reduced);
            }
        }

        return s;
    }

    /**
     * LeetCode #1047.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param s - a non-empty string of lowercase English letters.
     * @return - a final string after repeatedly removing all duplicates in a given string.
     */
    public String removeDuplicates(String s) {
        if (s == null || s.length() <= 1) return s;

        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            if (stack.isEmpty() || stack.peekLast() != ch) {
                stack.addLast(ch);
            } else {
                stack.removeLast();
            }
        }

        String result = convertStackToString(stack);

        if (result.length() == s.length()) {
            return result;
        } else {
            return removeDuplicates(result);
        }
    }

    private String convertStackToString(ArrayDeque<Character> stack) {
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.removeFirst());
        }
        return builder.toString();
    }

}
