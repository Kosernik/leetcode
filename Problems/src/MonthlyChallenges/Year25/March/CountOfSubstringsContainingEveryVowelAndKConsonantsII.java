package MonthlyChallenges.Year25.March;

import java.util.HashMap;
import java.util.Map;

public class CountOfSubstringsContainingEveryVowelAndKConsonantsII {
    public static void main(String[] args) {
        CountOfSubstringsContainingEveryVowelAndKConsonantsII solution = new CountOfSubstringsContainingEveryVowelAndKConsonantsII();

        String word0 = "iqeaouqi";
        int k0 = 2;
        int result0 = 3;
        System.out.println(solution.countOfSubstrings(word0, k0) + " --- " + result0);
    }

    private final char[] VOWELS = {'a', 'e', 'i', 'o', 'u'};

    /**
     * LeetCode №3306. Count of Substrings Containing Every Vowel and K Consonants II.
     *
     * @param word - a string of lowercase english letters.
     * @param k    - a non-negative integer.
     * @return - the total number of substrings of word that contain every vowel ('a', 'e', 'i', 'o', and 'u') at least
     * once and exactly k consonants.
     */
    public long countOfSubstrings(String word, int k) {
        long result = 0;

        char[] letters = word.toCharArray();

        Map<Character, Integer> vowels = new HashMap<>();

        int consonantCount = 0;

        int leftIdx = 0;

        int[] nextConsonantIdx = new int[letters.length];
        int consonantIdx = letters.length;
        for (int i = letters.length - 1; i >= 0; i--) {
            nextConsonantIdx[i] = consonantIdx;
            if (!isVowel(letters[i])) {
                consonantIdx = i;
            }
        }

        for (int i = 0; i < letters.length; i++) {
            char letter = letters[i];

            if (isVowel(letter)) {
                vowels.put(letter, vowels.getOrDefault(letter, 0) + 1);
            } else {
                consonantCount++;
            }

            while (consonantCount > k) {
                char leftChar = letters[leftIdx];

                if (isVowel(leftChar)) {
                    int prevCount = vowels.get(leftChar);
                    if (prevCount == 1) {
                        vowels.remove(leftChar);
                    } else {
                        vowels.put(leftChar, prevCount - 1);
                    }
                } else {
                    consonantCount--;
                }

                leftIdx++;
            }

            while (leftIdx < letters.length && vowels.size() == 5 && consonantCount == k) {
                result += nextConsonantIdx[i] - i;

                char leftChar = letters[leftIdx];

                if (isVowel(leftChar)) {
                    int prevCount = vowels.get(leftChar);
                    if (prevCount == 1) {
                        vowels.remove(leftChar);
                    } else {
                        vowels.put(leftChar, prevCount - 1);
                    }
                } else {
                    consonantCount--;
                }

                leftIdx++;
            }
        }

        return result;
    }

    private boolean isVowel(char letter) {
        for (char ch : VOWELS) {
            if (ch == letter) return true;
        }
        return false;
    }
}
