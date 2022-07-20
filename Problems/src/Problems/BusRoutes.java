package Problems;

import java.util.*;

public class BusRoutes {
    public static void main(String[] args) {
        BusRoutes solution = new BusRoutes();

        int[][] test0 = {
                {1, 2, 7},
                {3, 6, 7}
        };

        System.out.println(solution.numBusesToDestination(test0, 1, 6));
    }

    /**
     * LeetCode #815. Bus Routes.
     *
     * Complexity - O(M*(N+M)), N = routes.length, M = routes[i].length
     * Memory - O(N*M*M)
     *
     * @param routes - an array of bus routes.
     * @param source - Starting station.
     * @param target - Destination station.
     * @return - the least number of buses you must take to travel from source to target.
     */
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;
        Map<Integer, List<Set<Integer>>> bussesToRoutes = new HashMap<>();
        for (int[] route : routes) {
            Set<Integer> stations = new HashSet<>();
            for (int station : route) {
                stations.add(station);
            }

            for (int station : route) {
                List<Set<Integer>> list = bussesToRoutes.getOrDefault(station, new ArrayList<>());
                list.add(stations);
                bussesToRoutes.put(station, list);
            }
        }
        if (!bussesToRoutes.containsKey(source) || !bussesToRoutes.containsKey(target)) return -1;

        int numberOfBusses = 0;
        Deque<Set<Integer>> queue = new ArrayDeque<>();
        for (Set<Integer> busRoute : bussesToRoutes.get(source)) {
            queue.offerLast(busRoute);
        }
        Set<Set<Integer>> visited = new HashSet<>();

        while (!queue.isEmpty()) {
            numberOfBusses++;
            for (int i = queue.size(); i > 0; i--) {
                Set<Integer> curBus = queue.removeFirst();
                if (curBus.contains(target)) return numberOfBusses;

                for (Integer station : curBus) {
                    List<Set<Integer>> neighbours = bussesToRoutes.get(station);
                    for (Set<Integer> bus : neighbours) {
                        if (!visited.contains(bus)) {
                            queue.offerLast(bus);
                            visited.add(bus);
                        }
                    }
                }

            }

        }

        return -1;
    }
}
