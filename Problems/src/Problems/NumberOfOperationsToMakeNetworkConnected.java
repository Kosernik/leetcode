package Problems;

public class NumberOfOperationsToMakeNetworkConnected {

    //  parents[i][0] - parent, parents[i][1] - number of connections, parents[i][2] - the size of a union.
    private int[][] parents;

    /**
     * LeetCode #1319. Number of Operations to Make Network Connected.
     *
     * Complexity - O(MlogM + N), M = connections.length, N = n.
     * Memory - O(N)
     *
     * @param n - the number of vertices in a graph.
     * @param connections - an array of connections between vertices.
     * @return - the number of reconnections needed to make all vertices to be connected, or -1 if there are not enough
     *           unnecessary connections in a graph.
     */
    public int makeConnected(int n, int[][] connections) {
        this.parents = new int[n][3];

        fillParents(connections);

        int numberOfUnions = 0;
        int numberOfUnnecessaryConnections = 0;

        for (int i = 0; i < parents.length; i++) {
            if (parents[i][0] == i) {
                numberOfUnions++;
                numberOfUnnecessaryConnections += parents[i][1] - (parents[i][2] - 1);
            }
        }

        int requiredExtraConnections = numberOfUnions - 1;
        if (numberOfUnnecessaryConnections < requiredExtraConnections) return -1;
        else return requiredExtraConnections;
    }

    private void fillParents(int[][] connections) {
        for (int i = 0; i < parents.length; i++) {
            parents[i][0] = i;
            parents[i][2] = 1;
        }

        for (int[] connection : connections) {
            union(connection[0], connection[1]);
        }
    }

    private void union(int first, int second) {
        int firstParent = find(first);
        int secondParent = find(second);

        parents[firstParent][1]++;

        if (firstParent != secondParent) {
            parents[secondParent][0] = firstParent;
            parents[firstParent][1] += parents[secondParent][1];
            parents[firstParent][2] += parents[secondParent][2];
        }
    }

    private int find(int node) {
        if (parents[node][0] == node) return node;
        else return find(parents[node][0]);
    }
}
