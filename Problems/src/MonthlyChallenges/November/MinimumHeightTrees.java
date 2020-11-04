package MonthlyChallenges.November;

import java.util.*;

public class MinimumHeightTrees {
    /**
     * Returns a list of roots of shortest trees.
     *
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param n - number of vertices in a tree.
     * @param edges - array of edges of a tree.
     * @return - a list of roots of shortest trees.
     */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();

        if (n == 0) return result;
        else if (n == 1) {
            result.add(0);
            return result;
        } else if (n == 2) {
            result.add(0);
            result.add(1);
            return result;
        }

        List<Queue<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayDeque<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).offer(edge[1]);
            graph.get(edge[1]).offer(edge[0]);
        }

        List<Integer> nodesToDelete = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (graph.get(i).size() == 1) {
                nodesToDelete.add(i);
            }
        }
        int vertices = n;

        while (vertices > 2) {
            vertices -= nodesToDelete.size();
            List<Integer> tempToDel = new ArrayList<>();

            for (int i : nodesToDelete) {
                int node = graph.get(i).poll();
                graph.get(node).remove(i);
                if (graph.get(node).size() == 1) {
                    tempToDel.add(node);
                }
            }

            nodesToDelete = tempToDel;
        }

        result.addAll(nodesToDelete);
        return result;
    }

    // TLE
    public List<Integer> findMinHeightTreesTLE(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();

        if (n == 0) return result;
        else if (n == 1) {
            result.add(0);
            return result;
        } else if (n == 2) {
            result.add(0);
            result.add(1);
            return result;
        }

        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) { graph[i] = new ArrayList<Integer>(); }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        int minHeight = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (graph[i].size() > 1) {
                int currHeight = getHeight(graph, i);
                if (currHeight == minHeight) {
                    result.add(i);
                } else if (currHeight < minHeight) {
                    minHeight = currHeight;
                    result.clear();
                    result.add(i);
                }
            }
        }
        return result;
    }

    private int getHeight(ArrayList<Integer>[] graph, int vertice) {
        int height = -1;

        ArrayDeque<Pair> deque = new ArrayDeque<>();
        deque.offer(new Pair(-1, vertice));

        Pair pair;
        while (!deque.isEmpty()) {
            height++;
            for (int i = 0, length = deque.size(); i < length; i++) {
                pair = deque.pollFirst();

                for (Integer neighbor : graph[pair.child]) {
                    if (neighbor != pair.parent) {
                        deque.offerLast(new Pair(pair.child, neighbor));
                    }
                }
            }
        }

        return height;
    }
    class Pair {
        int parent;
        int child;

        public Pair(int parent, int child) {
            this.parent = parent;
            this.child = child;
        }
    }
}
