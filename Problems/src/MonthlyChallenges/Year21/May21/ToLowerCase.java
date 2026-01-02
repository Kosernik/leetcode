package MonthlyChallenges.Year21.May21;

public class ToLowerCase {
    /**
     * LeetCode #709.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param s - a string of printable ASCII characters.
     * @return - the string after replacing every uppercase letter with the same lowercase letter.
     */
    public String toLowerCase(String s) {
        StringBuilder result = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if ('A' <= ch && ch <= 'Z') {
                result.append((char) ((ch - 'A') + 'a'));
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }
}
