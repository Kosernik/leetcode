package MonthlyChallenges.Year26.November;

import Utils.TextInputParser;

import java.util.*;

public class FindSubtreeSizesAfterChanges {
    public static void main(String[] args) {
        FindSubtreeSizesAfterChanges solution = new FindSubtreeSizesAfterChanges();

        int[] parent0 = {-1, 0, 0, 1, 1, 1};
        String s0 = "abaabc";
        int[] answer0 = {6, 3, 1, 1, 1, 1};
        int[] result0 = solution.findSubtreeSizes(parent0, s0);
        System.out.println(Arrays.toString(answer0));
        System.out.println(Arrays.toString(result0));

        System.out.println("---");
        int[] parent1 = {-1, 0, 4, 0, 1};
        String s1 = "abbba";
        int[] answer1 = {5, 2, 1, 1, 1};
        int[] result1 = solution.findSubtreeSizes(parent1, s1);
        System.out.println(Arrays.toString(answer1));
        System.out.println(Arrays.toString(result1));

        System.out.println("---");
        int[] parent630 = TextInputParser.parseText("FindSubtreeSizesAfterChanges630Parent.txt");
        String s630 = TextInputParser.parseStringLine("FindSubtreeSizesAfterChanges630S.txt");
        int[] answer630 = TextInputParser.parseText("FindSubtreeSizesAfterChanges630Answer.txt");
        int[] result630 = solution.findSubtreeSizes(parent630, s630);
        System.out.println(parent630.length + ", " + s630.length() + ", " + answer630.length + ", " + result630.length);
        if (answer630.length != result630.length) {
            System.out.println("Wrong sizes");
        } else {
            int fails = 0;
            for (int i = 0; i < answer630.length; i++) {
                if (answer630[i] != result630[i]) {
                    fails++;
                }
            }
            if (fails == 0) {
                System.out.println("Correct");
            } else {
                System.out.println("Wrong results: " + fails);
            }
        }
    }

    public int[] findSubtreeSizes(int[] parent, String s) {
        int length = parent.length;
        int[] sizes = new int[length];

        List<List<Integer>> graph = buildGraph(parent);
        Map<Character, Integer> prevIdx = new HashMap<>();

        dfsParents(0, graph, s.toCharArray(), prevIdx, parent);
        List<List<Integer>> updatedGraph = buildGraph(parent);

        dfsSizes(0, updatedGraph, sizes);
        return sizes;
    }

    private void dfsParents(int node, List<List<Integer>> graph, char[] letters, Map<Character, Integer> prevIdx, int[] parents) {
        char currentChar = letters[node];

        Integer prev = prevIdx.get(currentChar);
        if (prev != null && prev != parents[node]) {
            parents[node] = prev;
        }

        Integer originalParent = prevIdx.get(currentChar);
        prevIdx.put(currentChar, node);

        for (int child : graph.get(node)) {
            dfsParents(child, graph, letters, prevIdx, parents);
        }

        if (originalParent != null) {
            prevIdx.put(currentChar, originalParent);
        } else {
            prevIdx.remove(currentChar);
        }
    }

    private int dfsSizes(int node, List<List<Integer>> graph, int[] sizes) {
        int size = 1;

        for (int child : graph.get(node)) {
            size += dfsSizes(child, graph, sizes);
        }


        sizes[node] = size;
        return size;
    }

    private List<List<Integer>> buildGraph(int[] parent) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < parent.length; i++) graph.add(new ArrayList<>());

        for (int i = 1; i < parent.length; i++) {
            graph.get(parent[i]).add(i);
        }

        return graph;
    }

    public int[] findSubtreeSizesTLE(int[] parent, String s) {
        int[] updatedParents = updateTree(parent, s.toCharArray());

        return getSizes(updatedParents);
    }

    private int[] updateTree(int[] parent, char[] letters) {
        int[] updatedParents = new int[parent.length];
        updatedParents[0] = -1;

        for (int i = 1; i < parent.length; i++) {
            updatedParents[i] = parent[i];

            char current = letters[i];

            int prev = parent[i];

            while (prev != -1) {
                if (letters[prev] == current) {
                    updatedParents[i] = prev;

                    break;
                }
                prev = parent[prev];
            }
        }

        return updatedParents;
    }

    private int[] getSizes(int[] parents) {
        int[] result = new int[parents.length];

        for (int i = 0; i < parents.length; i++) {
            int cur = i;
            while (cur != -1) {
                result[cur]++;
                cur = parents[cur];
            }
        }

        return result;
    }
}
