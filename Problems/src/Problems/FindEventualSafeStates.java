package Problems;

import java.util.*;

public class FindEventualSafeStates {

    /**
     * LeetCode #802. Find Eventual Safe States.
     *
     *
     * @param graph - a directed graph. graph[i] represent an edge from graph[i][0] vertex to graph[i][1] vertex.
     * @return - a list of safe vertices.
     */
    public List<Integer> eventualSafeNodes(int[][] graph) {
        Set<Integer> safeNodes = new HashSet<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int node = 0; node < graph.length; node++) {
            if (graph[node].length == 0) safeNodes.add(node);
            else queue.offerLast(node);
        }

        while (true) {
            int size = queue.size();
            for (int i = 0; i < queue.size(); i++) {
                int node = queue.removeFirst();
                boolean safe = true;
                for (int neighbour : graph[node]) {
                    if (!safeNodes.contains(neighbour)) {
                        safe = false;
                        break;
                    }
                }

                if (safe) safeNodes.add(node);
                else queue.offerLast(node);
            }
            if (queue.size() == size) break;
        }

        List<Integer> result = new ArrayList<>(safeNodes);
        Collections.sort(result);
        return result;
    }

    public List<Integer> eventualSafeNodesTLE(int[][] graph) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> unsafeNodes = new HashSet<>();

        for (int node = 0; node < graph.length; node++) {
            if (!unsafeNodes.contains(node)) {
                Set<Integer> visited = new HashSet<>();
                visited.add(node);
                isInCycle(node, graph, visited, unsafeNodes);
            }
        }

        for (int node = 0; node < graph.length; node++) {
            if (!unsafeNodes.contains(node)) result.add(node);
        }
        return result;
    }

    private void isInCycle(int node, int[][] graph, Set<Integer> visited, Set<Integer> unsafeNodes) {
        for (int neighbour : graph[node]) {
            if (visited.contains(neighbour) || unsafeNodes.contains(neighbour)) {
                unsafeNodes.addAll(visited);
            } else {
                visited.add(neighbour);
                isInCycle(neighbour, graph, visited, unsafeNodes);
                visited.remove(neighbour);
            }
        }
    }
}
