package Problems;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode #1146. Snapshot Array.
 *
 * Memory - O(N), N = length.
 * Complexity init - O(N).
 * Complexity set - O(1).
 * Complexity snap - O(1).
 * Complexity get - O(logM), M - current number of snaps.
 */
public class SnapshotArray {

    private int snapID = 0;
    private final List<List<int[]>> snapArray;

    public SnapshotArray(int length) {
        snapArray = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            List<int[]> curList = new ArrayList<>();
            curList.add(new int[] {snapID, 0});
            snapArray.add(curList);
        }
    }

    public void set(int index, int val) {
        List<int[]> list = snapArray.get(index);
        if (list.get(list.size()-1)[0] == snapID) {
            list.get(list.size()-1)[1] = val;
        } else {
            list.add(new int[] {snapID, val});
        }
    }

    public int snap() {
        return snapID++;
    }

    public int get(int index, int snap_id) {
        List<int[]> list = snapArray.get(index);
        return binSearch(list, snap_id)[1];
    }

    private int[] binSearch(List<int[]> list, int snap_id) {
        int left = 0, right = list.size()-1, middle;

        while (left < right) {
            middle = right - (right - left) / 2;

            int[] midEntry = list.get(middle);

            if (midEntry[0] > snap_id) {
                right = middle - 1;
            } else {
                left = middle;
            }
        }

        return list.get(left);
    }
}
