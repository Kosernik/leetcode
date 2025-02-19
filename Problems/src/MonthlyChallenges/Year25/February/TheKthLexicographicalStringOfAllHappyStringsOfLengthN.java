package MonthlyChallenges.Year25.February;

import java.util.ArrayList;
import java.util.List;

public class TheKthLexicographicalStringOfAllHappyStringsOfLengthN {
    public static void main(String[] args) {
        TheKthLexicographicalStringOfAllHappyStringsOfLengthN solution =
                new TheKthLexicographicalStringOfAllHappyStringsOfLengthN();

        int testN0 = 1, testK0 = 3;
        System.out.println(solution.getHappyString(testN0, testK0).equals("c"));

        System.out.println();
        int testN1 = 1, testK1 = 4;
        System.out.println(solution.getHappyString(testN1, testK1).equals(""));

        System.out.println();
        int testN2 = 3, testK2 = 9;
        System.out.println(solution.getHappyString(testN2, testK2).equals("cab"));
    }

    private final char[] letters = {'a', 'b', 'c'};

    /**
     * LeetCode №1415. The k-th Lexicographical String of All Happy Strings of Length n.
     *
     * @param n - the required length of strings.
     * @param k - a positive integer representing the number of a target string.
     * @return - the k-th happy string of a resulting list.
     */
    public String getHappyString(int n, int k) {
        List<String> happyStrings = new ArrayList<>();

        backtrack(new char[n], k, 0, happyStrings);

        if (happyStrings.size() < k) return "";
        return happyStrings.get(k - 1);
    }

    private void backtrack(char[] word, int targetNumberOfStrings, int idx, List<String> happyStrings) {
        if (idx == word.length) {
            happyStrings.add(new String(word));
            return;
        }

        if (happyStrings.size() > targetNumberOfStrings) return;

        for (char letter : this.letters) {
            if (idx == 0 || word[idx - 1] != letter) {
                char prev = word[idx];
                word[idx] = letter;

                backtrack(word, targetNumberOfStrings, idx + 1, happyStrings);

                word[idx] = prev;
            }
        }
    }
}
