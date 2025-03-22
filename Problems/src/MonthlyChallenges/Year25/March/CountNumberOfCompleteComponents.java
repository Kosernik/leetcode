package MonthlyChallenges.Year25.March;

public class CountNumberOfCompleteComponents {
    public static void main(String[] args) {
        CountNumberOfCompleteComponents solution = new CountNumberOfCompleteComponents();

        int n0 = 5;
        int[][] edges0 = {{1, 2}, {3, 4}, {1, 4}, {2, 3}, {1, 3}, {2, 4}};
        int result0 = 2;
        System.out.println(solution.countCompleteComponents(n0, edges0) == result0);
    }


    private int[] parents;
    private int[] nodes;
    private int[] edgesCount;

    /**
     * LeetCode №2685. Count the Number of Complete Components.
     *
     * @param n     - the total number of nodes in a graph.
     * @param edges - an array of edges in a graph. edges[i][0] and edges[i][1] are connected with an edge.
     * @return - the number of complete connected components of the graph.
     */
    public int countCompleteComponents(int n, int[][] edges) {
        this.parents = new int[n];
        this.nodes = new int[n];
        this.edgesCount = new int[n];

        for (int i = 0; i < n; i++) {
            parents[i] = i;
            nodes[i] = 1;
        }

        for (int[] edge : edges) {
            union(edge[0], edge[1]);
        }

        int completeComponents = 0;

        for (int i = 0; i < n; i++) {
            if (parents[i] == i) {
                int curNodes = nodes[i];
                int edgesNeeded = curNodes * (curNodes - 1) / 2;
                if (edgesCount[i] == edgesNeeded) {
                    completeComponents++;
                }
            }
        }

        return completeComponents;
    }

    private int find(int node) {
        if (parents[node] != node) {
            parents[node] = find(parents[node]);
        }

        return parents[node];
    }

    private void union(int first, int second) {
        int parentFirst = find(first);
        int parentSecond = find(second);

        if (parentFirst != parentSecond) {
            parents[parentSecond] = parentFirst;
            nodes[parentFirst] += nodes[parentSecond];
            edgesCount[parentFirst] += edgesCount[parentSecond];
        }

        edgesCount[parentFirst]++;
    }
}
