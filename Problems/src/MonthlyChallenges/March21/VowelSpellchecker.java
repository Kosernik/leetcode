package MonthlyChallenges.March21;

import java.util.*;

public class VowelSpellchecker {
    // LeetCode #966.
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> words = new HashSet<>();
        Map<String, String> capitals = new HashMap<>();
        Map<String, String> vowels = new HashMap<>();

        for (String word : wordlist) {
            words.add(word);
            capitals.putIfAbsent(word.toLowerCase(), word);
            vowels.putIfAbsent(word.toLowerCase().replaceAll("[aeiou]", "#"), word);
        }

        String[] result = new String[queries.length];

        for (int i = 0; i < queries.length; i++) {
            if (words.contains(queries[i])) {
                result[i] = queries[i];
            } else if (capitals.containsKey(queries[i].toLowerCase())) {
                result[i] = capitals.get(queries[i].toLowerCase());
            } else if (vowels.containsKey(queries[i].toLowerCase().replaceAll("[aeiou]", "#"))) {
                result[i] = vowels.get(queries[i].toLowerCase().replaceAll("[aeiou]", "#"));
            } else {
                result[i] = "";
            }
        }

        return result;
    }
}
