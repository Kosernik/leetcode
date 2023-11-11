package MonthlyChallenges.Year23.November;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class DesignGraphWithShortestPathCalculator {
    // LeetCode №2642. Design Graph With Shortest Path Calculator.
    class Graph {
        private final int size;
        private final int[][] graph;


        public Graph(int n, int[][] edges) {
            this.size = n;
            this.graph = new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(graph[i], -1);
            }

            for (int[] edge : edges) {
                addEdge(edge);
            }
        }

        public void addEdge(int[] edge) {
            this.graph[edge[0]][edge[1]] = edge[2];
        }

        public int shortestPath(int node1, int node2) {
            PriorityQueue<int[]> dijkstra = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
            dijkstra.offer(new int[]{node1, 0});
            Set<Integer> visited = new HashSet<>();

            while (!dijkstra.isEmpty()) {
                int[] curEntry = dijkstra.poll();
                int node = curEntry[0];
                int distance = curEntry[1];
                if (node == node2) {
                    return distance;
                }
                visited.add(node);

                for (int i = 0; i < size; i++) {
                    if (graph[node][i] != -1 && !visited.contains(i)) {
                        dijkstra.offer(new int[]{i, distance + graph[node][i]});
                    }
                }
            }

            return -1;
        }
    }
}
