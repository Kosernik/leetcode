package MonthlyChallenges.Year26.August;

import java.util.*;

public class RemoveMethodsFromProject {
    public static void main(String[] args) {
        RemoveMethodsFromProject solution = new RemoveMethodsFromProject();

        int n0 = 4, k0 = 1;
        int[][] invocations0 = {
                {1, 2}, {0, 1}, {3, 2}
        };
        List<Integer> result0 = solution.remainingMethods(n0, k0, invocations0);
        System.out.println(result0.toString());
    }

    /**
     * LeetCode №3310. Remove Methods From Project.
     * <p>
     * * A group of nodes can only be removed if no node outside the group connects to any node within it.
     *
     * @param n           - the total number of nodes.
     * @param k           - the suspicious node.
     * @param invocations - an array of directed edges in a graph.
     *                    invocations[i][0] - source, invocations[i][1] - destination.
     * @return - a list containing all the remaining nodes after removing all the suspicious nodes.
     */
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();

        int[] inDegree = new int[n];

        for (int[] invocation : invocations) {
            graph.putIfAbsent(invocation[0], new HashSet<>());

            graph.get(invocation[0]).add(invocation[1]);

            inDegree[invocation[1]]++;
        }

        List<Integer> suspicious = getSuspicious(k, graph, inDegree);

        boolean gotSusCycle = true;

        for (int node : suspicious) {
            if (inDegree[node] > 0) {
                gotSusCycle = false;
            }

            inDegree[node] = -1;
        }

        if (gotSusCycle) {
            return addWithoutSus(n, inDegree);
        } else {
            return addAll(n);
        }
    }

    private List<Integer> addWithoutSus(int n, int[] inDegree) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (inDegree[i] != -1) result.add(i);
        }

        return result;
    }

    private List<Integer> addAll(int n) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) result.add(i);

        return result;
    }

    private List<Integer> getSuspicious(int source, Map<Integer, Set<Integer>> graph, int[] inDegree) {
        List<Integer> suspicious = new ArrayList<>();

        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(source);

        boolean[] visited = new boolean[inDegree.length];
        visited[source] = true;

        Set<Integer> empty = new HashSet<>();

        while (!deque.isEmpty()) {
            int node = deque.removeFirst();
            suspicious.add(node);

            for (int child : graph.getOrDefault(node, empty)) {
                inDegree[child]--;

                if (!visited[child]) {
                    visited[child] = true;
                    deque.offer(child);
                }
            }
        }

        return suspicious;
    }
}
