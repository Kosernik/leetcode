package MonthlyChallenges.Year23.November;

import java.util.*;

public class SortVowelsInString {
    private final Set<Character> VOWELS = new HashSet<>();

    /**
     * LeetCode №2785. Sort Vowels in a String.
     * <p>
     * Complexity - O(NlogN)
     * Memory - O(N)
     *
     * @param s - a string of english letters.
     * @return - the string 's' after sorting all vowels.
     */
    public String sortVowels(String s) {
        VOWELS.add('a');
        VOWELS.add('e');
        VOWELS.add('i');
        VOWELS.add('o');
        VOWELS.add('u');
        VOWELS.add('A');
        VOWELS.add('E');
        VOWELS.add('I');
        VOWELS.add('O');
        VOWELS.add('U');

        char[] letters = s.toCharArray();
        List<Character> stringVowels = new ArrayList<>();

        for (char letter : letters) {
            if (VOWELS.contains(letter)) {
                stringVowels.add(letter);
            }
        }

        Collections.sort(stringVowels);

        int vowelsIdx = 0;
        for (int i = 0; i < letters.length; i++) {
            if (VOWELS.contains(letters[i])) {
                letters[i] = stringVowels.get(vowelsIdx);
                vowelsIdx++;
            }
        }

        return new String(letters);
    }
}
