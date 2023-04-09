package MonthlyChallenges.Year23.April;

import java.util.*;

public class LargestColorValueInDirectedGraph {
    public static void main(String[] args) {
        LargestColorValueInDirectedGraph solution = new LargestColorValueInDirectedGraph();

        String colors2 = "hhqhuqhqff";
        int[][] edges2 = {
                {0, 1}, {0, 2}, {2, 3}, {3, 4}, {3, 5}, {5, 6}, {2, 7}, {6, 7}, {7, 8}, {3, 8}, {5, 8}, {8, 9}, {3, 9}, {6, 9}
        };

        System.out.println(solution.largestPathValue(colors2, edges2));

        String colors3 = "qddqqqddqqdqddddddqdqqddddqdqdqqdddqddqdqqdqqqqqddqddqqddqqqdqqqqdqdddddqdq";
        int[][] edges3 = {
                {0, 1}, {1, 2}, {2, 3}, {3, 4}, {3, 5}, {4, 5}, {3, 6}, {5, 6}, {6, 7}, {5, 7}, {3, 7}, {6, 8}, {5, 8},
                {4, 8}, {8, 9}, {9, 10}, {10, 11}, {9, 11}, {9, 12}, {11, 12}, {6, 12}, {11, 13}, {9, 13}, {13, 14},
                {12, 14}, {10, 14}, {11, 14}, {13, 15}, {14, 15}, {12, 16}, {9, 16}, {7, 16}, {15, 17}, {13, 17},
                {17, 18}, {11, 18}, {17, 19}, {18, 19}, {13, 19}, {17, 20}, {18, 20}, {19, 21}, {17, 21}, {12, 22},
                {21, 22}, {16, 22}, {22, 23}, {21, 23}, {16, 24}, {22, 24}, {15, 25}, {24, 25}, {20, 25}, {12, 25},
                {23, 26}, {26, 27}, {13, 27}, {27, 28}, {21, 28}, {26, 28}, {28, 29}, {15, 30}, {27, 30}, {24, 30},
                {21, 30}, {27, 31}, {30, 31}, {25, 32}, {29, 32}, {17, 33}, {31, 33}, {32, 33}, {25, 34}, {33, 35},
                {31, 35}, {34, 35}, {30, 36}, {35, 37}, {36, 37}, {26, 38}, {36, 38}, {34, 38}, {37, 38}, {38, 39},
                {22, 39}, {39, 40}, {40, 41}, {38, 41}, {20, 41}, {41, 42}, {37, 42}, {40, 43}, {42, 43}, {43, 44},
                {41, 44}, {32, 44}, {38, 44}, {39, 44}, {43, 45}, {44, 45}, {44, 46}, {45, 46}, {45, 47}, {42, 47},
                {43, 48}, {45, 49}, {45, 50}, {48, 51}, {30, 51}, {46, 52}, {48, 52}, {38, 52}, {51, 52}, {47, 53},
                {45, 53}, {53, 54}, {48, 54}, {30, 54}, {50, 55}, {30, 55}, {36, 55}, {55, 56}, {39, 56}, {54, 56},
                {50, 57}, {56, 58}, {32, 58}, {57, 59}, {49, 59}, {38, 60}, {60, 61}, {35, 61}, {54, 61}, {53, 61},
                {54, 62}, {58, 62}, {62, 63}, {40, 63}, {58, 63}, {49, 64}, {63, 64}, {47, 64}, {39, 64}, {45, 64},
                {62, 65}, {64, 65}, {54, 65}, {52, 66}, {61, 66}, {60, 66}, {55, 67}, {65, 67}, {45, 68}, {56, 68},
                {36, 68}, {67, 69}, {66, 69}, {27, 70}, {60, 70}, {67, 70}, {48, 71}, {70, 71}, {53, 71}, {62, 72},
                {72, 73}, {73, 74}

        };

        System.out.println(solution.largestPathValue(colors3, edges3));
        System.out.println(solution.largestPathValueTLE(colors3, edges3));
    }


    /**
     * LeetCode #1857. Largest Color Value in a Directed Graph.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param colors - a string of colours for each node.
     * @param edges  - an array of directed edges in a graph.
     * @return - the largest color value of any valid path in the given graph, or -1 if the graph contains a cycle.
     */
    public int largestPathValue(String colors, int[][] edges) {
        int graphSize = colors.length();

        char[] colours = colors.toCharArray();

        int[] indegree = new int[graphSize];

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < graphSize; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            indegree[edge[1]]++;
            graph.get(edge[0]).add(edge[1]);
        }

        int[][] dp = new int[graphSize][26];

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < graphSize; i++) {
            if (indegree[i] == 0) {
                deque.add(i);
                dp[i][colours[i] - 'a'] = 1;
            }
        }

        int largestValue = 0;
        int visited = 0;

        while (!deque.isEmpty()) {
            int curNode = deque.remove();
            visited++;

            int maxVal = 0;
            for (int val : dp[curNode]) {
                maxVal = Math.max(maxVal, val);
            }
            largestValue = Math.max(largestValue, maxVal);

            for (int neighbour : graph.get(curNode)) {
                for (int c = 0; c < 26; c++) {
                    dp[neighbour][c] = Math.max(dp[neighbour][c], dp[curNode][c] + (colours[neighbour] - 'a' == c ? 1 : 0));
                }
                indegree[neighbour]--;
                if (indegree[neighbour] == 0) {
                    deque.add(neighbour);
                }
            }
        }

        return visited == graphSize ? largestValue : -1;
    }


    /**
     * TLE
     *
     * @param colors - a string of colours for each node.
     * @param edges  - an array of directed edges in a graph.
     * @return - the largest color value of any valid path in the given graph, or -1 if the graph contains a cycle.
     */
    public int largestPathValueTLE(String colors, int[][] edges) {
        char[] colours = colors.toCharArray();
        Map<Integer, List<Integer>> graph = getGraph(edges);
        Map<Integer, int[]> computed = new HashMap<>();

        int largestValue = -1;

        for (int i = 0; i < colours.length; i++) {
            if (checkIfHasCycle(i, graph)) {
                //System.out.println("Found cycle " + i);
                return -1;
            }
            if (computed.containsKey(i)) continue;

            int[] valuesCount = postOrder(i, graph, colours, computed);

            for (int value : valuesCount) {
                largestValue = Math.max(largestValue, value);
            }
        }

        return largestValue;
    }

    private Map<Integer, List<Integer>> getGraph(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] edge : edges) {
            if (!graph.containsKey(edge[0])) {
                graph.put(edge[0], new ArrayList<>());
            }
            graph.get(edge[0]).add(edge[1]);
        }

        return graph;
    }

    private boolean checkIfHasCycle(int node, Map<Integer, List<Integer>> graph) {
        for (int neighbour : graph.getOrDefault(node, new ArrayList<>())) {
            if (hasCycle(neighbour, graph, node)) return true;
        }
        return false;
    }

    private boolean hasCycle(int node, Map<Integer, List<Integer>> graph, int source) {
        if (source == node) return true;

        for (int neighbour : graph.getOrDefault(node, new ArrayList<>())) {
            if (hasCycle(neighbour, graph, source)) {
                return true;
            }
        }
        return false;
    }

    private int[] postOrder(int node, Map<Integer, List<Integer>> graph, char[] colours, Map<Integer, int[]> computed) {
        if (computed.containsKey(node)) {
            return computed.get(node);
        }

        int[] countValues = new int[26];

        for (int neighbour : graph.getOrDefault(node, new ArrayList<>())) {
            int[] neighValues = postOrder(neighbour, graph, colours, computed);
            if (neighValues == null) {
                return null;
            }

            for (int i = 0; i < countValues.length; i++) {
                countValues[i] = Math.max(countValues[i], neighValues[i]);
            }
        }

        int curColourIdx = colours[node] - 'a';
        countValues[curColourIdx]++;
        computed.put(node, countValues);
        return countValues;
    }
}
