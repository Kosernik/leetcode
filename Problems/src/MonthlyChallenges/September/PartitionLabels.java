package MonthlyChallenges.September;

import java.util.*;

public class PartitionLabels {
    public static void main(String[] args) {
        PartitionLabels solution = new PartitionLabels();
        String test0 = "ababcbacadefegdehijhklij";
//        String test0 = "abab";
        System.out.println(solution.partitionLabels(test0).toString());
    }

    /**
     * Partitions a string of english lower case characters into parts as many parts, as possible, where each letter
     * appears only in one partition. Returns a list of sizes of all parts.
     *
     * @param S - none empty string of english lowercase characters.
     * @return - ArrayList of sizes of parts.
     */
    public List<Integer> partitionLabels(String S) {
        List<Integer> partitions = new ArrayList<>();
        if (S == null || S.length() == 0) return partitions;

        Map<Character, Integer> indexes = new HashMap<>();

        char[] letters = S.toCharArray();
        int[] startIndexes = new int[letters.length];
        Arrays.fill(startIndexes, -1);

        for (int i = 0; i < letters.length; i++) {
            if (indexes.containsKey(letters[i])) {
                int start = indexes.get(letters[i]);

                int idx = i;
                while (idx >= 0) {
                    if (startIndexes[idx] == start) break;
                    startIndexes[idx] = start;
                    indexes.put(letters[idx], start);
                    idx--;
                }
            } else {
                startIndexes[i] = i;
                indexes.put(letters[i], i);
            }
        }

        int prev = 0;
        for (int i = 1; i < startIndexes.length; i++) {
            if (startIndexes[i] != prev) {
                partitions.add(startIndexes[i] - prev);
                prev = startIndexes[i];
            }
        }
        partitions.add(startIndexes.length - prev);

        return partitions;
    }
}
