package MonthlyChallenges.Year23.February;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumFuelCostToReportToCapital {
    public static void main(String[] args) {
        MinimumFuelCostToReportToCapital solution = new MinimumFuelCostToReportToCapital();

        int[][] test1 = {
                {3, 1}, {3, 2}, {1, 0}, {0, 4}, {0, 5}, {4, 6}
        };
        int seats = 2;

        long res = solution.minimumFuelCost(test1, seats);
        System.out.println(res);
    }


    private long totalCost = 0;
    private int seats;
    private final int CAPITAL = 0;

    /**
     * LeetCode #2477. Minimum Fuel Cost to Report to the Capital.
     *
     * @param roads - an array of roads between cities.
     * @param seats - the maximum number of seats in each car.
     * @return - the minimum number of liters of fuel to reach the capital city.
     */
    public long minimumFuelCost(int[][] roads, int seats) {
        this.seats = seats;
        Map<Integer, List<Integer>> graph = getGraph(roads);

        dfs(0, 0, graph);
        return totalCost;
    }

    private long dfs(int node, int parentNode, Map<Integer, List<Integer>> graph) {
        int seatsTaken = 1;
        for (int neighbour : graph.get(node)) {
            if (neighbour == parentNode) continue;
            seatsTaken += dfs(neighbour, node, graph);
        }
        if (node != CAPITAL) {
            totalCost += (seatsTaken + this.seats - 1) / this.seats;
        }
        return seatsTaken;
    }

    private Map<Integer, List<Integer>> getGraph(int[][] roads) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i <= roads.length; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] road : roads) {
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }

        return graph;
    }
}
