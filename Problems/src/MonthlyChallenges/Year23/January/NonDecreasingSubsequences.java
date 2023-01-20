package MonthlyChallenges.Year23.January;

import java.util.*;

public class NonDecreasingSubsequences {
    public static void main(String[] args) {
        NonDecreasingSubsequences solution = new NonDecreasingSubsequences();

        int[] test0 = {4, 6, 7, 7};
        System.out.println(solution.findSubsequences(test0));
    }

    /**
     * LeetCode #491. Non-decreasing Subsequences.
     * <p>
     * Complexity - O(NlogN)
     * Memory - O(N)
     *
     * @param nums - an array of integers.
     * @return - all the different possible non-decreasing subsequences of the given array with at least two elements.
     */
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Set<String> subSequences = new HashSet<>();
        NavigableMap<Integer, List<String>> computed = new TreeMap<>();

        for (int number : nums) {
            List<String> curResult = new ArrayList<>();
            if (subSequences.add(String.valueOf(number))) {
                curResult.add(String.valueOf(number));
            }

            for (int key : computed.navigableKeySet()) {
                if (key > number) break;
                List<String> seqs = computed.get(key);
                for (String candidate : seqs) {
                    String newSusSeq = candidate + "*" + number;
                    if (subSequences.add(newSusSeq)) {
                        curResult.add(newSusSeq);
                    }
                }
            }
            curResult.addAll(computed.getOrDefault(number, new ArrayList<>()));
            computed.put(number, curResult);
        }

        for (String subSequence : subSequences) {
            List<Integer> ssq = parseString(subSequence);
            if (ssq.size() > 1) {
                result.add(ssq);
            }
        }

        return result;
    }

    private List<Integer> parseString(String subSequence) {
        String[] splitted = subSequence.split("\\*");
        List<Integer> result = new ArrayList<>();
        for (String s : splitted) {
            result.add(Integer.parseInt(s));
        }
        return result;
    }
}
