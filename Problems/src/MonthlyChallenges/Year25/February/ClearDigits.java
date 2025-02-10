package MonthlyChallenges.Year25.February;

public class ClearDigits {

    /**
     * LeetCode №3174. Clear Digits.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param s - a string.
     * @return - the resulting string after removing all digits.
     */
    public String clearDigits(String s) {
        StringBuilder result = new StringBuilder();

        for (char letter : s.toCharArray()) {
            if (Character.isDigit(letter)) {
                if (!result.isEmpty()) {
                    result.deleteCharAt(result.length() - 1);
                }
            } else {
                result.append(letter);
            }
        }

        return result.toString();
    }
}
