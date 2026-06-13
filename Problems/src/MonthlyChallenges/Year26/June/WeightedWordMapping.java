package MonthlyChallenges.Year26.June;

public class WeightedWordMapping {
    public static void main(String[] args) {
        WeightedWordMapping solution = new WeightedWordMapping();

        String[] words0 = {"abcd", "def", "xyz"};
        int[] weights0 = {5, 3, 12, 14, 1, 2, 3, 2, 10, 6, 6, 9, 7, 8, 7, 10, 8, 9, 6, 9, 9, 8, 3, 7, 7, 2};
        String result0 = "rij";
        System.out.println(solution.mapWordWeights(words0, weights0).equals(result0));
    }

    /**
     * LeetCode №3838. Weighted Word Mapping.
     * <p>
     * Complexity - O(N*M), N = words.length, M = words[i].length()
     * Memory - O(N)
     * <p>
     * The weight of a word is defined as the sum of the weights of its characters.
     * For each word, take its weight modulo 26 and map the result to a lowercase English letter using reverse
     * alphabetical order (0 -> 'z', 1 -> 'y', ..., 25 -> 'a').
     *
     * @param words   - an array of strings, each string consists only of lowercase english letters.
     * @param weights - an array of weights of each letter.
     * @return - a string formed by concatenating the mapped characters for all words in order.
     */
    public String mapWordWeights(String[] words, int[] weights) {
        char[] result = new char[words.length];
        int resultIdx = 0;

        char[] reversed = {'z', 'y', 'x', 'w', 'v', 'u', 't', 's', 'r', 'q', 'p', 'o', 'n', 'm', 'l', 'k', 'j', 'i', 'h', 'g', 'f', 'e', 'd', 'c', 'b', 'a'};

        for (String word : words) {
            int sum = 0;

            for (int i = 0; i < word.length(); i++) {
                sum += weights[word.charAt(i) - 'a'];
            }

            sum %= 26;

            result[resultIdx] = reversed[sum];
            resultIdx++;
        }

        return new String(result);
    }
}
