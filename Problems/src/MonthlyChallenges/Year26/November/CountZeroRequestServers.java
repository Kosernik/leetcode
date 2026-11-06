package MonthlyChallenges.Year26.November;

import java.util.Arrays;

public class CountZeroRequestServers {
    public static void main(String[] args) {
        CountZeroRequestServers solution = new CountZeroRequestServers();

        int n0 = 3;
        int[][] logs0 = {{1, 3}, {2, 6}, {1, 5}};
        int x0 = 5;
        int[] queries0 = {10, 11};
        int[] answer0 = {1, 2};
        int[] result0 = solution.countServers(n0, logs0, x0, queries0);
        System.out.println(Arrays.toString(answer0));
        System.out.println(Arrays.toString(result0));

        System.out.println("--------------");
        int n1 = 3;
        int[][] logs1 = {{2, 4}, {2, 1}, {1, 2}, {3, 1}};
        int x1 = 2;
        int[] queries1 = {3, 4};
        int[] answer1 = {0, 1};
        int[] result1 = solution.countServers(n1, logs1, x1, queries1);
        System.out.println(Arrays.toString(answer1));
        System.out.println(Arrays.toString(result1));
    }

    /**
     * LeetCode №2747. Count Zero Request Servers.
     *
     * @param n       - the total number of servers.
     * @param logs    - a 2d array representing requests to servers. logs[i][0] = server id, logs[i][1] = time of a request.
     * @param x       - time delta.
     * @param queries - an array of queries.
     * @return - an array result for queries, where result[i] represents the number of servers that did not receive any
     * requests during the time interval [queries[i] - x, queries[i]], the time intervals are inclusive.
     */
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs, (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));

        int maxTime = logs[0][1];
        for (int[] log : logs) {
            maxTime = Math.max(maxTime, log[1]);
        }
        int maxEndTime = maxTime + x;

        int[] balance = new int[maxEndTime + 2];

        int idx = 0, length = logs.length;
        while (idx < length) {
            int[] log = logs[idx];
            int id = log[0];
            int start = log[1];
            int end = start + x;

            while ((idx + 1) < length && logs[idx + 1][0] == id && logs[idx + 1][1] <= end) {
                idx++;
                end = logs[idx][1] + x;
            }

            balance[start]++;
            balance[end + 1]--;

            idx++;
        }

        int prev = balance[0];
        for (int i = 1; i < balance.length; i++) {
            balance[i] += prev;
            prev = balance[i];
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (queries[i] > maxEndTime) {
                result[i] = n;
                continue;
            }
            result[i] = n - balance[queries[i]];
        }

        return result;
    }
}
