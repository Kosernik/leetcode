package MonthlyChallenges.Year25.February;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveAllOccurrencesOfSubstring {

    /**
     * LeetCode №1910. Remove All Occurrences of a Substring.
     * <p>
     * Complexity - O(N^2)
     * Memory - O(N)
     *
     * @param s    - a string.
     * @param part - a string.
     * @return - string s after removing all occurrences of part.
     */
    public String removeOccurrences(String s, String part) {
        Deque<Character> stack = new ArrayDeque<>();
        char[] partLetter = part.toCharArray();
        int partLength = part.length();

        for (char letter : s.toCharArray()) {
            stack.push(letter);

            if (stack.peek() == partLetter[partLength - 1] && stack.size() >= partLength) {
                removeIfExist(stack, partLetter);
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = stack.size(); i > 0; i--) {
            result.append(stack.removeLast());
        }

        return result.toString();
    }

    private void removeIfExist(Deque<Character> stack, char[] partLetter) {
        for (int i = partLetter.length - 1; i >= 0; i--) {
            if (stack.peek() == partLetter[i]) {
                stack.pop();
            } else {
                for (int j = i + 1; j < partLetter.length; j++) {
                    stack.push(partLetter[j]);
                }
                return;
            }
        }
    }
}
