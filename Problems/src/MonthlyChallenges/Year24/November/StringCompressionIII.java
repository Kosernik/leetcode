package MonthlyChallenges.Year24.November;

public class StringCompressionIII {

    /**
     * LeetCode №3163. String Compression III.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param word - a non-empty string.
     * @return - compressed "word".
     */
    public String compressedString(String word) {
        StringBuilder result = new StringBuilder();

        char prev = word.charAt(0);
        int count = 0;

        for (char letter : word.toCharArray()) {
            if (letter != prev) {
                addToBuilder(prev, count, result);

                prev = letter;
                count = 1;
            } else {
                count++;
            }
        }

        addToBuilder(prev, count, result);

        return result.toString();
    }

    private void addToBuilder(char letter, int count, StringBuilder string) {
        for (int nines = count / 9; nines > 0; nines--) {
            string.append("9").append(letter);
        }
        if (count % 9 != 0) {
            string.append(Integer.toString(count % 9)).append(letter);
        }
    }
}
