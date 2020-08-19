package MonthlyChallenges.August;

import java.util.HashSet;
import java.util.Set;

public class GoatLatin {
    public static void main(String[] args) {
        GoatLatin solution = new GoatLatin();
        solution.testToGoatLatin();
    }

    /**
     * Converts a string to a goat latin string.
     * If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word. For example, the word
     * 'apple' becomes 'applema'.
     * If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add
     * "ma". For example, the word "goat" becomes "oatgma".
     * Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1. For example, the
     * first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
     *
     * @param S - given string, that needs to bee converted.
     * @return - converted to goat latin string. If input is null or empty, returns empty string.
     */
    public String toGoatLatin(String S) {
        if (S == null || S.length() == 0) return "";

        StringBuilder builder = new StringBuilder();
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');vowels.add('e');vowels.add('i');vowels.add('o');vowels.add('u');
        vowels.add('A');vowels.add('E');vowels.add('I');vowels.add('O');vowels.add('U');

        String[] words = S.split("\\s+");
        StringBuilder maaas = new StringBuilder();
        maaas.append("maa");

        for (String word : words) {
            if (vowels.contains(word.charAt(0))) {
                builder.append(word);
            } else {
                builder.append(word.length() > 1 ? (word.substring(1, word.length()) + word.charAt(0)) : word);
            }
            builder.append(maaas);
            builder.append(" ");
            maaas.append('a');
        }

        builder.deleteCharAt(builder.length()-1);
        return builder.toString();
    }
    private void testToGoatLatin() {
        String[] tests = {
                "I speak Goat Latin",
                "",
                "The quick brown fox jumped over the lazy dog",
                "A b c de ef g",
                "yDumm"};
        String[] results = {
                "Imaa peaksmaaa oatGmaaaa atinLmaaaaa",
                "",
                "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa",
                "Amaa bmaaa cmaaaa edmaaaaa efmaaaaaa gmaaaaaaa",
                "Dummymaa"};

        int failed = 0;

        for (int i = 0; i < tests.length; i++) {
            String currResult = toGoatLatin(tests[i]);
            if (!currResult.equals(results[i])) {
                failed++;
                System.out.println("Failed test #" + i);
                System.out.println("Got: " + currResult);
                System.out.println("Should be: " + results[i]);
            }
        }

        System.out.println("Success rate: " + (tests.length - failed) * 100.0 / tests.length);
    }
}
