package Problems;

import java.util.HashMap;
import java.util.Map;

public class MostStonesRemovedWithSameRowOrColumn {

    private int[] unionFindGraph;

    /**
     * LeetCode #947. Most Stones Removed with Same Row or Column.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param stones - an array of coordinates of stones.
     * @return - the largest possible number of stones that can be removed.
     */
    public int removeStones(int[][] stones) {
        this.unionFindGraph = new int[stones.length];
        for (int i = 0; i < unionFindGraph.length; i++) this.unionFindGraph[i] = i;
        Map<Integer, Integer> rowParent = new HashMap<>();
        Map<Integer, Integer> colParent = new HashMap<>();

        for (int i = 0; i < stones.length; i++) {
            int[] stone = stones[i];
            int parent = i;

            if (rowParent.containsKey(stone[0])) {
                parent = union(rowParent.get(stone[0]), i);
            }
            if (colParent.containsKey(stone[1])) {
                parent = union(colParent.get(stone[1]), i);
            }
            rowParent.put(stone[0], parent);
            colParent.put(stone[1], parent);
        }

        return stones.length - getNumberOfUnions();
    }

    private int getNumberOfUnions() {
        int result = 0;
        for (int i = 0; i < unionFindGraph.length; i++) {
            if (this.unionFindGraph[i] == i) result++;
        }
        return result;
    }

    private int find(int node) {
        if (this.unionFindGraph[node] == node) return node;
        return find(this.unionFindGraph[node]);
    }

    private int union(int first, int second) {
        int parentFirst = find(first);
        int parentSecond = find(second);

        if (parentFirst != parentSecond) {
            this.unionFindGraph[parentSecond] = parentFirst;
        }

        return parentFirst;
    }
}
