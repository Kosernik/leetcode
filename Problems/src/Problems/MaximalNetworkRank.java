package Problems;

import java.util.*;

public class MaximalNetworkRank {

    /**
     * LeetCode #1615. Maximal Network Rank.
     *
     * Complexity - O(N + NlogN), N = n, M = roads.length
     * Memory - O(N + M)
     *
     * @param n - the number of cities.
     * @param roads - an array of roads in a city. roads[i] != roads[j]
     * @return - the maximum network rank in a city.
     */
    public int maximalNetworkRank(int n, int[][] roads) {
        int[][] numberOfRoads = new int[n][2];
        Set<String> roadSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            numberOfRoads[i][0] = i;
        }

        for (int[] road : roads) {
            int firstCity = road[0];
            int secondCity = road[1];

            numberOfRoads[firstCity][1]++;
            numberOfRoads[secondCity][1]++;

            roadSet.add(firstCity + "*" + secondCity);
            roadSet.add(secondCity + "*" + firstCity);
        }

        Arrays.sort(numberOfRoads, (a, b) -> a[1] == b[1] ? Integer.compare(a[0], b[0]) : Integer.compare(b[1], a[1]));

        int maxNetworkRank = 0;

        for (int i = 0; i < numberOfRoads.length-1; i++) {
            if (numberOfRoads[i][1] + numberOfRoads[i+1][1] < maxNetworkRank) break;
            for (int j = i+1; j < numberOfRoads.length; j++) {
                if (numberOfRoads[i][1] + numberOfRoads[j][1] < maxNetworkRank) break;
                int curRank = numberOfRoads[i][1] + numberOfRoads[j][1];

                if (roadSet.contains(numberOfRoads[i][0] + "*" + numberOfRoads[j][0])) {
                    curRank -= 1;
                }

                maxNetworkRank = Math.max(maxNetworkRank, curRank);
            }

        }

        return maxNetworkRank;
    }
}
