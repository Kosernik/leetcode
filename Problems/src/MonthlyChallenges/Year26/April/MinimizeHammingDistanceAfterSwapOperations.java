package MonthlyChallenges.Year26.April;

import java.util.HashMap;
import java.util.Map;

public class MinimizeHammingDistanceAfterSwapOperations {

    private int[] parents;

    /**
     * LeetCode №1722. Minimize Hamming Distance After Swap Operations.
     *
     * @param source       - an array of integers.
     * @param target       - an array of integers. source.length = target.length.
     * @param allowedSwaps - an array of pairs of indices where each allowedSwaps[i] = [aᵢ, bᵢ] indicates that you are
     *                     allowed to swap the elements at index aᵢ and index bᵢ (0-indexed) of array source.
     * @return - the minimum Hamming distance of source and target after performing any amount of swap operations on
     * array source.
     */
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        this.parents = new int[source.length];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }

        fillUF(allowedSwaps);

        //  parentIdx -> Map of (values -> count of value)
        Map<Integer, Map<Integer, Integer>> connectedComponents = getConnectedComponents(source);

        int hammingDistance = 0;

        for (int i = 0; i < target.length; i++) {
            int targetValue = target[i];

            int sourceParent = parents[i];

            if (connectedComponents.get(sourceParent).containsKey(targetValue)) {
                int count = connectedComponents.get(sourceParent).get(targetValue) - 1;

                if (count == 0) {
                    connectedComponents.get(sourceParent).remove(targetValue);
                } else {
                    connectedComponents.get(sourceParent).put(targetValue, count);
                }
            } else {
                hammingDistance++;
            }
        }

        return hammingDistance;
    }

    private Map<Integer, Map<Integer, Integer>> getConnectedComponents(int[] source) {
        Map<Integer, Map<Integer, Integer>> connectedComponents = new HashMap<>();

        for (int i = 0; i < parents.length; i++) {
            int sourceValue = source[i];

            int parent = find(i);

            if (!connectedComponents.containsKey(parent)) {
                connectedComponents.put(parent, new HashMap<>());
            }

            Map<Integer, Integer> count = connectedComponents.get(parent);
            count.put(sourceValue, count.getOrDefault(sourceValue, 0) + 1);
        }

        return connectedComponents;
    }

    private void fillUF(int[][] allowedSwaps) {
        for (int[] pair : allowedSwaps) {
            union(pair[0], pair[1]);
        }
    }

    private int find(int node) {
        if (parents[node] != node) {
            parents[node] = find(parents[node]);
        }

        return parents[node];
    }

    private void union(int first, int second) {
        int firstParent = find(first);
        int secondParent = find(second);

        parents[firstParent] = secondParent;
    }
}
