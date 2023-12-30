package MonthlyChallenges.Year23.December;

import java.util.HashMap;
import java.util.Map;

public class RedistributeCharactersToMakeAllStringsEqual {

    /**
     * LeetCode №1897. Redistribute Characters to Make All Strings Equal.
     *
     * @param words - an array of strings.
     * @return - true if you can make every string in words equal using any number of swap-operations, and false otherwise.
     */
    public boolean makeEqual(String[] words) {
        int numberOfWords = words.length;
        Map<Character, Integer> counts = new HashMap<>();

        for (String word : words) {
            for (char letter : word.toCharArray()) {
                counts.put(letter, counts.getOrDefault(letter, 0) + 1);
            }
        }

        for (Integer count : counts.values()) {
            if (count % numberOfWords != 0) return false;
        }

        return true;
    }
}
