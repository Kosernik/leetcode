package MonthlyChallenges.Year23.January;

import java.util.Arrays;

public class NumberOfGoodPaths {
    private int[] parents;
    private int[] nodesRank;
    private int[] vals;

    private int result = 0;

    /**
     * LeetCode #2421. Number of Good Paths.
     * <p>
     * Complexity - O(NlogN)
     * Memory - O(N)
     *
     * @param vals  - an array of values of each node.
     * @param edges - an array of edges between nodes.
     * @return - the number of distinct good paths.
     */
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        initiateUF(vals);
        this.result = vals.length;

        Arrays.sort(edges,
                (o1, o2) -> Integer.compare(
                        Math.max(this.vals[o1[0]], this.vals[o1[1]]),
                        Math.max(this.vals[o2[0]], this.vals[o2[1]])
                )
        );

        for (int[] edge : edges) {
            union(edge[0], edge[1]);
        }

        return this.result;
    }

    private void initiateUF(int[] vals) {
        this.vals = vals;
        this.parents = new int[vals.length];
        this.nodesRank = new int[vals.length];
        Arrays.fill(nodesRank, 1);

        for (int i = 0; i < vals.length; i++) {
            this.parents[i] = i;
        }
    }

    private void union(int first, int second) {
        int firstParent = find(first);
        int secondParent = find(second);

        if (firstParent == secondParent) return;

        if (vals[firstParent] == vals[secondParent]) {
            this.result += (nodesRank[firstParent] * nodesRank[secondParent]);
            nodesRank[firstParent] += nodesRank[secondParent];
            parents[secondParent] = firstParent;
        } else if (vals[firstParent] > vals[secondParent]) {
            parents[secondParent] = firstParent;
        } else {
            parents[firstParent] = secondParent;
        }
    }

    private int find(int node) {
        if (parents[node] == node) {
            return node;
        } else {
            return find(parents[node]);
        }
    }
}
