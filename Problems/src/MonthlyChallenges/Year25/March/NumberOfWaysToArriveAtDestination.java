package MonthlyChallenges.Year25.March;

import java.util.*;

public class NumberOfWaysToArriveAtDestination {

    /**
     * LeetCode №1976. Number of Ways to Arrive at Destination.
     *
     * @param n     - the total number of nodes in a graph.
     * @param roads - an array of edges in a graph. roads[i][0] and roads[i][1] are two nodes connected with an edge,
     *              roads[i][2] is the length in time between two nodes, roads[i][2] > 0.
     * @return - the number of ways you can arrive from node 0 to node n-1 in the shortest amount of time.
     * Result is modulo 1_000_000_007.
     */
    public int countPaths(int n, int[][] roads) {
        int MODULO = 1_000_000_007;

        List<List<int[]>> graph = buildGraph(n, roads);
        int[] pathCounts = new int[n];
        pathCounts[0] = 1;

        long[] bestTimeToNode = new long[n];
        Arrays.fill(bestTimeToNode, Long.MAX_VALUE);
        bestTimeToNode[0] = 0L;

        //  { node, time }
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        pq.offer(new long[]{0, 0});

        while (!pq.isEmpty()) {
            long[] curPair = pq.poll();
            int node = (int) curPair[0];
            long time = curPair[1];

            if (time > bestTimeToNode[node]) continue;

            for (int[] neighbourPair : graph.get(node)) {
                int neighbour = neighbourPair[0];
                int timeToNeighbour = neighbourPair[1];

                if ((time + timeToNeighbour) < bestTimeToNode[neighbour]) {
                    bestTimeToNode[neighbour] = time + timeToNeighbour;
                    pathCounts[neighbour] = pathCounts[node];

                    pq.offer(new long[]{neighbour, bestTimeToNode[neighbour]});
                } else if ((time + timeToNeighbour) == bestTimeToNode[neighbour]) {
                    pathCounts[neighbour] = (pathCounts[neighbour] + pathCounts[node]) % MODULO;
                }
            }
        }

        return pathCounts[n - 1];
    }

    private List<List<int[]>> buildGraph(int n, int[][] roads) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int nodeA = road[0];
            int nodeB = road[1];
            int time = road[2];

            graph.get(nodeA).add(new int[]{nodeB, time});
            graph.get(nodeB).add(new int[]{nodeA, time});
        }

        return graph;
    }
}
