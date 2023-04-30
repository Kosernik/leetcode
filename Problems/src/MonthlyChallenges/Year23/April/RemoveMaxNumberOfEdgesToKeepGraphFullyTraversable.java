package MonthlyChallenges.Year23.April;

import java.util.Arrays;

public class RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable {

    /**
     * LeetCode #1579. Remove Max Number of Edges to Keep Graph Fully Traversable.
     * <p>
     * Complexity - O(NlogN)
     * Memory - O(N)
     *
     * @param n     - the total number of nodes in a graph.
     * @param edges - an array of edges. edges[i] = {edge type, first node, second node}.
     *              edge type 1 - the edge is only for Alice.
     *              edge type 2 - the edge is only for Bob.
     *              edge type3 - the edge is for both Alice and Bob.
     * @return - the maximum number of edges it is possible to remove so Alice and Bob can traverse a graph.
     * If Alice and Bob cannot fully traverse the graph returns -1.
     */
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        Arrays.sort(edges, (a, b) -> Integer.compare(b[0], a[0]));

        UnionFind alice = new UnionFind(n + 1);
        UnionFind bob = new UnionFind(n + 1);

        int removed = 0;
        int totalEdges = 0;

        for (int[] edge : edges) {
            int type = edge[0];
            int firstNode = edge[1];
            int secondNode = edge[2];

            if (type == 3) { //  Both Alice and Bob
                boolean validForAlice = alice.union(firstNode, secondNode);
                boolean validForBob = bob.union(firstNode, secondNode);

                if (validForAlice) totalEdges++;
                if (validForBob) totalEdges++;

                if (!validForAlice || !validForBob) removed++;
            } else if (type == 1) {  //  Only Alice
                boolean validForAlice = alice.union(firstNode, secondNode);
                if (validForAlice) {
                    totalEdges++;
                } else {
                    removed++;
                }
            } else {    //  Only Bob
                boolean validForBob = bob.union(firstNode, secondNode);
                if (validForBob) {
                    totalEdges++;
                } else {
                    removed++;
                }
            }
        }

        if (totalEdges != 2 * n - 2) return -1;
        else return removed;
    }


    class UnionFind {
        int[] parens;

        UnionFind(int size) {
            this.parens = new int[size];
            for (int i = 0; i < size; i++) {
                parens[i] = i;
            }
        }

        boolean union(int first, int second) {
            int firstParent = find(first);
            int secondParent = find(second);

            if (firstParent != secondParent) {
                parens[firstParent] = secondParent;
                return true;
            } else {
                return false;
            }
        }

        int find(int node) {
            if (parens[node] != node) {
                parens[node] = find(parens[node]);
            }
            return parens[node];
        }
    }
}
