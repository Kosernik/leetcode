package MonthlyChallenges.Year26.October;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class ShortestPathWithAtMostKConsecutiveIdenticalCharacters {
    public static void main(String[] args) throws IOException {
        ShortestPathWithAtMostKConsecutiveIdenticalCharacters solution = new ShortestPathWithAtMostKConsecutiveIdenticalCharacters();

        int n999 = 5000;
        int edgesCount999 = 50000;
        int[][] edges999 = solution.readFile("Problems/src/MonthlyChallenges/Year26/October/ShortestPathWithAtMostKConsecutiveIdenticalCharacters999.txt", edgesCount999);
        String labels999 = "abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababab";
        int k999 = 2;
        int result999 = 527;

        int answer999 = solution.shortestPath(n999, edges999, labels999, k999);
        System.out.println(answer999 == result999);

        int n0 = 4;
        int[][] edges0 = {{0, 1, 3}, {0, 2, 1}, {1, 2, 4}, {2, 3, 1}};
        String labels0 = "abaa";
        int k0 = 2;
        int result0 = 8;

        int answer0 = solution.shortestPath(n0, edges0, labels0, k0);
        System.out.println(answer0 == result0);

        int n1 = 6;
        int[][] edges1 = {{0, 1, 3}, {1, 3, 25}, {0, 2, 3}, {2, 3, 30}, {3, 4, 1}, {4, 5, 3}};
        String labels1 = "aabaaa";
        int k1 = 4;
        int result1 = 37;

        int answer1 = solution.shortestPath(n1, edges1, labels1, k1);
        System.out.println(answer1 == result1);
    }

    private int[][] readFile(String fileName, int edgesCount) throws IOException {
        int[][] result = new int[edgesCount][3];

        Scanner scanner = new Scanner(new File(fileName));
        scanner.useDelimiter("],\\[");

        int idx = 0;
        while (scanner.hasNext()) {
            String[] splited = scanner.next().stripTrailing().split(",");
            result[idx][0] = Integer.parseInt(splited[0]);
            result[idx][1] = Integer.parseInt(splited[1]);
            result[idx][2] = Integer.parseInt(splited[2]);
            idx++;
        }

        return result;
    }

    /**
     * LeetCode №3970. Shortest Path With At Most K Consecutive Identical Characters.
     *
     * @param n      - the total number of nodes in a directed weighted graph.
     * @param edges  - an array of edges, where edges[i] = [from, to, weight]
     * @param labels - a string representing values of each node, where labels[i] is a label of i-th node.
     * @param k      - the maximum allowed number of consecutive identical characters in a path.
     * @return - the minimum total edge weight of a path from node 0 to node n - 1 such that the concatenation of the
     * labels of the nodes along the path contains at most k consecutive identical characters.
     * If no valid path exists, returns -1.
     */
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        char[] nodeLabels = labels.toCharArray();
        Map<Integer, List<int[]>> graph = buildGraph(n, edges);

        long[][] distances = new long[n][k + 1];
        for (var row : distances) Arrays.fill(row, Integer.MAX_VALUE);
        distances[0][1] = 0;

        //  [node-idx, distance, char-count]
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        pq.offer(new long[]{0, 0, 1});

        int target = n - 1;
        while (!pq.isEmpty()) {
            long[] node = pq.poll();

            int nodeIdx = (int) node[0];
            long dist = node[1];
            int charCount = (int) node[2];

            if (dist > distances[nodeIdx][charCount]) continue;

            if (nodeIdx == target) return (int) dist;

            for (var neighbours : graph.get(nodeIdx)) {
                int nextCount = 1;
                if (nodeLabels[nodeIdx] == nodeLabels[neighbours[0]]) {
                    if (charCount == k) continue;
                    nextCount += charCount;
                }

                long nextDist = dist + neighbours[1];
                if (nextDist < distances[neighbours[0]][nextCount]) {
                    distances[neighbours[0]][nextCount] = nextDist;
                    pq.offer(new long[]{neighbours[0], nextDist, nextCount});
                }
            }
        }

        return -1;
    }

    private Map<Integer, List<int[]>> buildGraph(int n, int[][] edges) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) graph.put(i, new ArrayList<>());

        for (int[] edge : edges) {
            // [from, to, weight]
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }

        return graph;
    }
}
