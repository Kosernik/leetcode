package MonthlyChallenges.Year22.May;

import java.util.*;

public class NetworkDelayTime {
    public static void main(String[] args) {
        NetworkDelayTime solution = new NetworkDelayTime();

        int[][] times0 = {{2,1,1},{2,3,1},{3,4,1}};
        int n0 = 4;
        int k0 = 2;

        System.out.println(solution.networkDelayTime(times0, n0, k0));

        int[][] times1 = {{1,2,1}};
        int n1 = 2;
        int k1 = 1;

        System.out.println(solution.networkDelayTime(times1, n1, k1));

        int[][] times2 = {{1,2,1}};
        int n2 = 2;
        int k2 = 2;

        System.out.println(solution.networkDelayTime(times2, n2, k2));
    }

    /**
     * LeetCode #743. Network Delay Time.
     *
     * @param times - an array of edges in a graph.
     *              times[i][0] - source node,
     *              times[i][1] - target node,
     *              times[i][2] - the time for a signal to travel from source tot target.
     * @param n - the total number of nodes.
     * @param k - starting node.
     * @return - the minimum time it takes for all the 'n' nodes to receive the signal. If it is impossible for all
     *           the 'n' nodes to receive the signal, returns -1.
     */
    public int networkDelayTime(int[][] times, int n, int k) {
        int result = 0;
        Map<Integer, List<Pair>> nodesToNeighbours = new HashMap<>();
        List<Pair> emptyList = new ArrayList<>();
        int[] totalTimes = new int[n+1];
        Arrays.fill(totalTimes, Integer.MAX_VALUE);
        totalTimes[k] = 0;

        for (int[] time : times) {
            List<Pair> curNeighbours = nodesToNeighbours.getOrDefault(time[0], new ArrayList<>());
            Pair pair = new Pair(time[1], time[2]);
            curNeighbours.add(pair);
            nodesToNeighbours.put(time[0], curNeighbours);
        }

        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(k);

        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            int curTime = totalTimes[node];

            List<Pair> neighbours = nodesToNeighbours.getOrDefault(node, emptyList);
            for (Pair neighbour : neighbours) {
                int prevTime = totalTimes[neighbour.target];
                int candidateTime = curTime + neighbour.time;
                if (prevTime > candidateTime) {
                    totalTimes[neighbour.target] = candidateTime;
                    queue.offer(neighbour.target);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (totalTimes[i] == Integer.MAX_VALUE) return -1;
            else if (i == k) {
                continue;
            }
            result = Math.max(result, totalTimes[i]);
        }
        return result;
    }

    class Pair {
        int target;
        int time;

        Pair (int target, int time) {
            this.target = target;
            this.time = time;
        }
    }
}
