package MonthlyChallenges.Year24.July;

import java.util.*;

public class FindCityWithSmallestNumberOfNeighborsAtThresholdDistance {
    public static void main(String[] args) {
        FindCityWithSmallestNumberOfNeighborsAtThresholdDistance solution = new FindCityWithSmallestNumberOfNeighborsAtThresholdDistance();

        int testN = 6;
        int[][] testEdges = {
                {0, 1, 10}, {0, 2, 1}, {2, 3, 1}, {1, 3, 1}, {1, 4, 1}, {4, 5, 10}
        };
        int testDist = 20;
        System.out.println(solution.findTheCity(testN, testEdges, testDist) == 5);
    }


    /**
     * LeetCode №1334. Find the City With the Smallest Number of Neighbors at a Threshold Distance.
     *
     * @param n                 - the total number of cities.
     * @param edges             - an array of distances between cities. edges[i] = [first_city, second_city, distance].
     * @param distanceThreshold - maximum distance of a path.
     * @return - the city with the smallest number of cities that are reachable through some path and whose distance is
     * at most distanceThreshold.  If there are multiple such cities, returns the city with the greatest number.
     */
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<int[]>[] graph = new List[n];
        int[][] distances = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(distances[i], Integer.MAX_VALUE);
            distances[i][i] = 0;

            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int first = edge[0];
            int second = edge[1];
            int distance = edge[2];

            graph[first].add(new int[]{second, distance});
            graph[second].add(new int[]{first, distance});
        }

        for (int i = 0; i < n; i++) {
            dijkstra(i, graph, distances[i], n);
        }

        return cityWithMinReachable(n, distances, distanceThreshold);
    }

    private void dijkstra(int city, List<int[]>[] graph, int[] distances, int n) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{city, 0});

        while (!pq.isEmpty()) {
            int[] curPair = pq.poll();
            int curCity = curPair[0];
            int curDist = curPair[1];
            if (curDist > distances[curCity]) continue;

            for (int[] neighbourPair : graph[curCity]) {
                int neighbour = neighbourPair[0];
                int neighbourDistance = neighbourPair[1];
                if (distances[neighbour] > curDist + neighbourDistance) {
                    distances[neighbour] = curDist + neighbourDistance;
                    pq.offer(new int[]{neighbour, distances[neighbour]});
                }
            }
        }
    }

    private int cityWithMinReachable(int n, int[][] distances, int distanceThreshold) {
        int minReachable = n;
        int bestCity = -1;

        for (int i = 0; i < n; i++) {
            int curReachable = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (distances[i][j] <= distanceThreshold) {
                    curReachable++;
                }
            }

            if (curReachable <= minReachable) {
                minReachable = curReachable;
                bestCity = i;
            }
        }

        return bestCity;
    }
}
