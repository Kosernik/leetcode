package MonthlyChallenges.Year23.March;

import java.util.*;

public class MinimumScoreOfPathBetweenTwoCities {

    /**
     * LeetCode #2492. Minimum Score of a Path Between Two Cities.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param n     - the number of cities.
     * @param roads - an array of distances of roads.
     * @return - the minimum score in a path between city 1 and city N.
     */
    public int minScore(int n, int[][] roads) {
        int result = Integer.MAX_VALUE;

        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] road : roads) {
            if (!graph.containsKey(road[0])) {
                graph.put(road[0], new HashMap<>());
            }
            graph.get(road[0]).put(road[1], road[2]);

            if (!graph.containsKey(road[1])) {
                graph.put(road[1], new HashMap<>());
            }
            graph.get(road[1]).put(road[0], road[2]);
        }

        Deque<Integer> deque = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        deque.offer(1);

        while (!deque.isEmpty()) {
            int city = deque.poll();
            if (visited.contains(city)) {
                continue;
            }
            visited.add(city);

            Map<Integer, Integer> neighbours = graph.get(city);
            for (Map.Entry<Integer, Integer> entry : neighbours.entrySet()) {
                result = Math.min(result, entry.getValue());
                deque.offer(entry.getKey());
            }
        }

        return result;
    }


    private int[][] unionFind;

    /**
     * LeetCode #2492. Minimum Score of a Path Between Two Cities.
     * <p>
     * Complexity - O(NlogN)
     * Memory - O(N)
     *
     * @param n     - the number of cities.
     * @param roads - an array of distances of roads.
     * @return - the minimum score in a path between city 1 and city N.
     */
    public int minScoreSlow(int n, int[][] roads) {
        unionFind = new int[n + 1][2];
        for (int i = 0; i <= n; i++) {
            unionFind[i][0] = i;
            unionFind[i][1] = Integer.MAX_VALUE;
        }

        for (int[] road : roads) {
            int parentA = find(road[0]);
            int parentB = find(road[1]);

            unionFind[parentA][0] = parentB;
            unionFind[parentB][1] = Math.min(road[2], Math.min(unionFind[parentA][1], unionFind[parentB][1]));
        }

        return unionFind[find(n)][1];
    }

    private int find(int cityID) {
        if (this.unionFind[cityID][0] == cityID) {
            return cityID;
        }
        return find(this.unionFind[cityID][0]);
    }
}
