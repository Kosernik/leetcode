package MonthlyChallenges.Year25.November;

import java.util.*;

public class PowerGridMaintenance {

    private int[] parents;

    /**
     * LeetCode №3607. Power Grid Maintenance.
     *
     * @param c           - the number of stations.
     * @param connections - an array of connections between stations (1‑based indexing).
     * @param queries     - an array of queries. If queries[i] = [1,c] the answer should return an index of a station
     *                    that will perform maintenance, if the station c is online the answer is c, otherwise the
     *                    answer is the station with the smallest id. If no operational station exists the answer is -1.
     *                    If queries[i] = [2,c] the station c goes offline.
     * @return - an array of integers representing the results of each query of type [1, x] in the order they appear.
     */
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        this.parents = new int[c + 1];
        for (int i = 0; i < parents.length; i++) parents[i] = i;

        for (int[] connection : connections) {
            union(connection[0], connection[1]);
        }

        Map<Integer, NavigableSet<Integer>> stations = getStations();
        NavigableSet<Integer> empty = new TreeSet<>();

        List<Integer> result = new ArrayList<>();

        for (int[] query : queries) {
            int station = query[1];

            int parent = find(station);

            if (query[0] == 1) {
                NavigableSet<Integer> workingStations = stations.getOrDefault(parent, empty);
                if (!workingStations.isEmpty()) {
                    if (workingStations.contains(station)) {
                        result.add(station);
                    } else {
                        result.add(workingStations.first());
                    }
                } else {
                    result.add(-1);
                }
            } else { // query[0] == 2
                if (stations.containsKey(parent)) {
                    stations.get(parent).remove(station);
                }
            }
        }

        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) resultArray[i] = result.get(i);
        return resultArray;
    }

    private Map<Integer, NavigableSet<Integer>> getStations() {
        Map<Integer, NavigableSet<Integer>> stations = new HashMap<>();

        for (int station = 1; station < parents.length; station++) {
            int parent = find(station);

            if (!stations.containsKey(parent)) {
                stations.put(parent, new TreeSet<>());
            }
            stations.get(parent).add(station);
        }

        return stations;
    }

    private int find(int target) {
        if (parents[target] != target) {
            parents[target] = find(parents[target]);
        }

        return parents[target];
    }

    private void union(int first, int second) {
        int parentFirst = find(first);
        int parentSecond = find(second);

        if (parentFirst == parentSecond) return;

        parents[parentFirst] = parentSecond;
    }
}
