package MonthlyChallenges.Year24.November;

import java.util.*;

public class ShortestDistanceAfterRoadAdditionQueriesI {

    /**
     * LeetCode №3243. Shortest Distance After Road Addition Queries I.
     * <p>
     * Complexity - O(N*M)
     * Memory - O(N)
     *
     * @param n       - the total number of cities.
     * @param queries - a 2d array of queries, each query adds a new road between query[i][0] and query[i][1].
     * @return - an array of length queries.length. result[i] is the shortest path from city 0 to city n - 1 after
     * processing the first i + 1 queries.
     */
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int[] result = new int[queries.length];

        Map<Integer, City> cities = new HashMap<>();

        City destination = new City(n - 1);
        cities.put(n - 1, destination);

        City prevCity = destination;

        for (int i = n - 2; i >= 0; i--) {
            City city = new City(i);
            city.addNeighbour(prevCity);
            cities.put(i, city);

            prevCity = city;
        }

        for (int i = 0; i < queries.length; i++) {
            if (destination.distance == 1) {
                result[i] = destination.distance;
                continue;
            }

            int[] query = queries[i];
            City from = cities.get(query[0]);
            City to = cities.get(query[1]);

            from.addNeighbour(to);

            Deque<City> queue = new ArrayDeque<>();
            queue.offer(from);

            while (!queue.isEmpty()) {
                City city = queue.poll();
                int newDistance = city.distance + 1;

                for (City neighbour : city.neighbours) {
                    if (neighbour.distance > newDistance) {
                        neighbour.distance = newDistance;

                        queue.offer(neighbour);
                    }
                }
            }

            result[i] = destination.distance;
        }

        return result;
    }

    class City {
        int distance;
        List<City> neighbours = new ArrayList<>();

        public City(int distance) {
            this.distance = distance;
        }

        public void addNeighbour(City city) {
            neighbours.add(city);
        }
    }
}
