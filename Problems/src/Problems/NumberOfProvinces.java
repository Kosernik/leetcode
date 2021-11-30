package Problems;

public class NumberOfProvinces {
//[[1,1,1,0,0,0,0,0,0,0],
//[1,1,0,1,0,0,0,0,0,0],
//[1,0,1,0,0,0,0,0,0,0],
//[0,1,0,1,0,0,0,0,0,0],
//[0,0,0,0,1,0,0,0,0,0],
//[0,0,0,0,0,1,1,0,0,0],
//[0,0,0,0,0,1,1,0,0,0],
//[0,0,0,0,0,0,0,1,0,0],
//[0,0,0,0,0,0,0,0,1,1],
//[0,0,0,0,0,0,0,0,1,1]]

    private int[] unionSet;
    /**
     * LeetCode #547. Number of Provinces.
     *
     * @param isConnected - an adjacency matrix of connections in a graph. isConnected[i][j] = 1 means nodes are
     *                    connected, 0 - means there is no connection between this two nodes.
     * @return - the number of connected provinces in a graph.
     */
    public int findCircleNum(int[][] isConnected) {
        if (isConnected.length == 1) return 1;

        int length = isConnected.length;
        unionSet = new int[length];
        for (int i = 0; i < length; i++) unionSet[i] = i;

        for (int i = 0; i < length-1; i++) {
            for (int j = i+1; j < length; j++) {
                if (isConnected[i][j] == 1) {
                    union(i, j);
                }
            }
        }

        int numberOfProvinces = 0;
        for (int i = 0; i < length; i++) if (unionSet[i] == i) numberOfProvinces++;
        return numberOfProvinces;
    }

    private void union(int first, int second) {
        int idFirst = find(first);
        int idSecond = find(second);

        if (idFirst == idSecond) return;

        unionSet[idFirst] = idSecond;
    }

    private int find(int id) {
        if (unionSet[id] != id) {
            unionSet[id] = find(unionSet[id]);
        }
        return unionSet[id];
    }
}