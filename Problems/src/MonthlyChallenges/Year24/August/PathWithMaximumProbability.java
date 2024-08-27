package MonthlyChallenges.Year24.August;

import java.util.*;

public class PathWithMaximumProbability {

    /**
     * LeetCode №1514. Path with Maximum Probability.
     * <p>
     * Complexity - O(Dijkstra's Algorithm)
     * Memory - O(Dijkstra's Algorithm)
     *
     * @param n          - the total number of nodes in an undirected graph.
     * @param edges      - an array of edges between nodes.
     * @param succProb   - an array of probabilities of success of traversing edges in a graph.
     * @param start_node - the starting node.
     * @param end_node   - the finish node.
     * @return - maximum probability of a path between start and end nodes.
     * If there is no path from start to end, returns 0.
     */
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        Map<Integer, List<Pair<Integer, Double>>> graph = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {
            int first = edges[i][0];
            int second = edges[i][1];
            double probability = succProb[i];

            if (!graph.containsKey(first)) {
                graph.put(first, new ArrayList<>());
            }
            if (!graph.containsKey(second)) {
                graph.put(second, new ArrayList<>());
            }

            graph.get(first).add(new Pair<>(second, probability));
            graph.get(second).add(new Pair<>(first, probability));
        }

        double[] maxProbabilities = new double[n];
        maxProbabilities[start_node] = 1.0;

        PriorityQueue<Pair<Integer, Double>> pq = new PriorityQueue<>((a, b) -> Double.compare(b.getVal(), a.getVal()));
        pq.offer(new Pair<>(start_node, 1.0));

        while (!pq.isEmpty()) {
            Pair<Integer, Double> pair = pq.poll();

            int curNode = pair.getKey();
            double curProbability = pair.getVal();

            if (curNode == end_node) {
                return curProbability;
            }

            for (Pair<Integer, Double> neighbour : graph.getOrDefault(curNode, new ArrayList<>())) {
                int neighNode = neighbour.getKey();
                double neighProbability = neighbour.getVal();

                if (curProbability * neighProbability > maxProbabilities[neighNode]) {
                    maxProbabilities[neighNode] = curProbability * neighProbability;
                    pq.offer(new Pair<>(neighNode, maxProbabilities[neighNode]));
                }
            }
        }


        return 0.0;
    }


    class Pair<I extends Number, D extends Number> {
        Integer key;
        Double val;

        Pair(Integer key, Double val) {
            this.key = key;
            this.val = val;
        }

        Integer getKey() {
            return key;
        }

        Double getVal() {
            return val;
        }
    }
}
