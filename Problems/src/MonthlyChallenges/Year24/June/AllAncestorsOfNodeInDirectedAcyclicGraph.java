package MonthlyChallenges.Year24.June;

import java.util.*;

public class AllAncestorsOfNodeInDirectedAcyclicGraph {

    /**
     * LeetCode №2192. All Ancestors of a Node in a Directed Acyclic Graph.
     *
     * @param n     - the total number of nodes in a directed acyclic graph.
     * @param edges - a list of edges of a graph. edges[i][0] - start of an edge, edges[i][1] - end of an edge.
     * @return - a list result, where result[i] is the list of ancestors of the i-th node, sorted in ascending order.
     */
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<Set<Integer>> ancestors = new ArrayList<>();

        Map<Integer, List<Integer>> parents = getParents(n, edges);

        for (int i = 0; i < n; i++) {
            ancestors.add(new HashSet<>());
        }
        for (int i = 0; i < n; i++) {
            helper(i, parents, ancestors);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (Set<Integer> nodeAncestors : ancestors) {
            List<Integer> curList = new ArrayList<>(nodeAncestors.stream().toList());
            Collections.sort(curList);
            result.add(curList);
        }

        return result;
    }

    private Set<Integer> helper(int node, Map<Integer, List<Integer>> parents, List<Set<Integer>> ancestors) {
        if (!ancestors.get(node).isEmpty()) return ancestors.get(node);

        Set<Integer> currentAncestors = ancestors.get(node);

        for (int parent : parents.get(node)) {
            currentAncestors.add(parent);
            currentAncestors.addAll(helper(parent, parents, ancestors));
        }

        return currentAncestors;
    }

    private Map<Integer, List<Integer>> getParents(int n, int[][] edges) {
        Map<Integer, List<Integer>> parents = new HashMap<>();

        for (int i = 0; i < n; i++) {
            parents.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            parents.get(edge[1]).add(edge[0]);
        }

        return parents;
    }
}
