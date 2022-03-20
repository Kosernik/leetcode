package Problems;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MinimumGeneticMutation {

    /**
     * LeetCode #433. Minimum Genetic Mutation.
     *
     *
     * @param start - starting gene.
     * @param end - target gene.
     * @param bank - an array of valid genes.
     * @return - True - if mutation from start to end is possible. False - otherwise.
     */
    public int minMutation(String start, String end, String[] bank) {
        if (start.equals(end)) return 0;

        Set<String> validGenes = new HashSet<>(Arrays.asList(bank));
        if (!validGenes.contains(end)) return -1;

        char[] parts = {'A', 'C', 'G', 'T'};

        ArrayDeque<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        queue.offerLast(start);
        visited.add(start);

        int numberOfMutations = 0;

        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                String currentGene = queue.removeFirst();
                if (currentGene.equals(end)) return numberOfMutations;

                char[] letters = currentGene.toCharArray();

                for (int j = 0; j < letters.length; j++) {
                    char curLetter = letters[j];
                    for (char part : parts) {
                        letters[j] = part;
                        String candidate = new String(letters);

                        if (!visited.contains(candidate) && validGenes.contains(candidate)) {
                            visited.add(candidate);
                            queue.offerLast(candidate);
                        }
                    }
                    letters[j] = curLetter;
                }
            }
            numberOfMutations++;
        }

        return -1;
    }
}
