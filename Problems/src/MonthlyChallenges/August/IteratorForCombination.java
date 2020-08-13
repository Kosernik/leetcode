package MonthlyChallenges.August;

import java.util.ArrayList;
import java.util.List;

public class IteratorForCombination {

    class CombinationIterator {

        private final char[] givenCharacters;
        private final int combinationLength;
        private final List<String> allCombinations;
        private int nextIdx;

        public CombinationIterator(String characters, int combinationLength) {
            givenCharacters = new char[characters.length()];
            allCombinations = new ArrayList<>();
            this.combinationLength = combinationLength;

            for (int i = 0; i < characters.length(); i++) {
                givenCharacters[i] = characters.charAt(i);
            }

            boolean[] usedChars = new boolean[26];

            generateAllCombinations(new StringBuilder(), usedChars, 0);
            nextIdx = 0;
        }
        private void generateAllCombinations(StringBuilder currString, boolean[] usedChars, int currCharIdx) {
            if (currString.length() == combinationLength) {
                allCombinations.add(currString.toString());
            } else {
                for (int i = currCharIdx; i < givenCharacters.length; i++) {
                    if (!usedChars[givenCharacters[i] - 'a']) {
                        usedChars[givenCharacters[i] - 'a'] = true;
                        currString.append(givenCharacters[i]);

                        generateAllCombinations(currString, usedChars, i);

                        currString.deleteCharAt(currString.length()-1);
                        usedChars[givenCharacters[i] - 'a'] = false;
                    }
                }
            }
        }

        public String next() {
            if (hasNext()) {
                return allCombinations.get(nextIdx++);
            } else {
                return "";
            }
        }

        public boolean hasNext() {
            return nextIdx < allCombinations.size();
        }
    }
}
