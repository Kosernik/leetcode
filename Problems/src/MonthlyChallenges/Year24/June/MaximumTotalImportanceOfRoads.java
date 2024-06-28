package MonthlyChallenges.Year24.June;

import java.util.Arrays;

public class MaximumTotalImportanceOfRoads {
    public static void main(String[] args) {
        MaximumTotalImportanceOfRoads solution = new MaximumTotalImportanceOfRoads();

        int testN0 = 5;
        int[][] testRoads0 = {{0, 1}, {1, 2}, {2, 3}, {0, 2}, {1, 3}, {2, 4}};
        System.out.println(solution.maximumImportance(testN0, testRoads0));

    }


    /**
     * LeetCode №2285. Maximum Total Importance of Roads.
     * <p>
     * Complexity - O(NlogN + N + M), N = n, M = roads.length.
     * Memory - O(N)
     *
     * @param n     - the total number of cities.
     * @param roads - an array of roads, where roads[i] = [ai, bi] denotes that there exists a bidirectional road
     *              connecting cities ai and bi.
     * @return - the maximum total importance of all roads possible after assigning the values optimally.
     */
    public long maximumImportance(int n, int[][] roads) {
        long maxImportance = 0;

        int[][] inDegree = new int[n][2];
        for (int i = 0; i < n; i++) {
            inDegree[i][0] = i;
        }
        for (int[] road : roads) {
            inDegree[road[0]][1]++;
            inDegree[road[1]][1]++;
        }

        Arrays.sort(inDegree, (a, b) -> Integer.compare(b[1], a[1]));

        int[] values = new int[n];
        int val = n;
        for (int[] city : inDegree) {
            values[city[0]] = val;
            val--;
        }

        for (int[] road : roads) {
            maxImportance += values[road[0]] + values[road[1]];
        }

        return maxImportance;
    }
}
