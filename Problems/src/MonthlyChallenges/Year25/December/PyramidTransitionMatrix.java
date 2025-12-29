package MonthlyChallenges.Year25.December;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PyramidTransitionMatrix {

    /**
     * LeetCode №756. Pyramid Transition Matrix.
     *
     * @param bottom  - the bottom row of a pyramid.
     * @param allowed - a list of allowed triangles. allowed[i].length = 3.
     * @return - true - if it is possible to build the pyramid all the way to the top such that every triangular pattern
     * in the pyramid is in allowed, or false otherwise.
     */
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<Character>> convertedAllowed = convertAllowed(allowed);

        return backtrack(bottom, convertedAllowed, new HashMap<>());
    }

    private boolean backtrack(String row, Map<String, List<Character>> allowed, Map<String, Boolean> computed) {
        if (row.length() == 1) return true;

        if (computed.containsKey(row)) return computed.get(row);

        int topRowLength = row.length() - 1;

        List<List<Character>> topRowCandidates = new ArrayList<>();
        for (int i = 0; i < topRowLength; i++) topRowCandidates.add(new ArrayList<>());

        for (int i = 0; i < topRowLength; i++) {
            String twoChars = row.substring(i, i + 2);

            if (!allowed.containsKey(twoChars)) {
                computed.put(row, false);
                return false;
            }

            topRowCandidates.get(i).addAll(allowed.get(twoChars));
        }

        List<String> candidates = new ArrayList<>();
        getCandidates(new char[topRowLength], 0, topRowCandidates, candidates);

        for (String candidate : candidates) {
            boolean result = backtrack(candidate, allowed, computed);
            if (result) {
                computed.put(row, true);
                return true;
            }
        }

        computed.put(row, false);
        return false;
    }

    private void getCandidates(char[] word, int idx, List<List<Character>> topRowCandidates, List<String> result) {
        if (idx >= word.length) {
            result.add(new String(word));
            return;
        }

        for (char letter : topRowCandidates.get(idx)) {
            char prev = word[idx];
            word[idx] = letter;

            getCandidates(word, idx + 1, topRowCandidates, result);

            word[idx] = prev;
        }
    }

    private Map<String, List<Character>> convertAllowed(List<String> allowed) {
        Map<String, List<Character>> converted = new HashMap<>();

        for (String combination : allowed) {
            String bottom = combination.substring(0, 2);

            if (!converted.containsKey(bottom)) {
                converted.put(bottom, new ArrayList<>());
            }

            converted.get(bottom).add(combination.charAt(2));
        }

        return converted;
    }
}
