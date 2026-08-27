package MonthlyChallenges.Year26.August;

public class LexicographicallySmallestPermutationGreaterThanTarget {
    public static void main(String[] args) {
        LexicographicallySmallestPermutationGreaterThanTarget solution = new LexicographicallySmallestPermutationGreaterThanTarget();

        String s4 = "ab";
        String target4 = "ab";
        String result4 = "ba";
        System.out.println(solution.lexGreaterPermutation(s4, target4).equals(result4));

        String s6 = "aa";
        String target6 = "ab";
        String result6 = "";
        System.out.println(solution.lexGreaterPermutation(s6, target6).equals(result6));
    }

    /**
     * LeetCode №3720. Lexicographically Smallest Permutation Greater Than Target.
     *
     * @param s      - a string of lowercase english letters.
     * @param target - a string of lowercase english letters.
     * @return - the lexicographically smallest permutation of s that is strictly greater than target.
     * If no permutation of s is lexicographically strictly greater than target, returns an empty string.
     */
    public String lexGreaterPermutation(String s, String target) {
        int[] countLetters = new int[26];
        for (int i = 0; i < s.length(); i++) countLetters[s.charAt(i) - 'a']++;

        char[] result = new char[target.length()];

        for (int i = 0; i < target.length(); i++) {
            int charIdx = target.charAt(i) - 'a';

            if (countLetters[charIdx] > 0) {
                countLetters[charIdx]--;

                if (canFormString(countLetters, target.substring(i + 1))) {
                    result[i] = target.charAt(i);
                    continue;
                }

                countLetters[charIdx]++;
            }

            for (int j = charIdx + 1; j < countLetters.length; j++) {
                if (countLetters[j] > 0) {
                    countLetters[j]--;

                    result[i] = (char) (j + 'a');

                    for (int next_i = i + 1, countIdx = 0; next_i < result.length; next_i++) {
                        while (countLetters[countIdx] == 0) countIdx++;
                        result[next_i] = (char) (countIdx + 'a');

                        countLetters[countIdx]--;
                    }

                    return new String(result);
                }
            }

            return "";
        }

        return "";
    }

    private boolean canFormString(int[] count, String suffix) {
        String largest = buildLargest(count);

        return largest.compareTo(suffix) > 0;
    }

    private String buildLargest(int[] count) {
        StringBuilder result = new StringBuilder();

        for (int i = count.length - 1; i >= 0; i--) {
            result.append(String.valueOf((char) (i + 'a')).repeat(count[i]));
        }

        return result.toString();
    }
}
