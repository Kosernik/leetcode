package MonthlyChallenges.Year21.September21;

public class ReverseOnlyLetters {
    /**
     * LeetCode #917. Reverse Only Letters.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param s - a string.
     * @return - the given string after reversing all english letters.
     */
    public String reverseOnlyLetters(String s) {
        StringBuilder builder = new StringBuilder();

        int right = s.length();

        for (int i = 0; i < s.length(); i++) {
            if (!Character.isAlphabetic(s.charAt(i))) {
                builder.append(s.charAt(i));
            } else {
                do {
                    right--;
                } while (!Character.isAlphabetic(s.charAt(right)));

                builder.append(s.charAt(right));
            }
        }

        return builder.toString();
    }
}
