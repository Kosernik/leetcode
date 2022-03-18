package Problems;

import java.util.*;

public class MinimumJumpsToReachHome {

    /**
     * LeetCode #1654. Minimum Jumps to Reach Home.
     *
     *
     * @param forbidden - an array of forbidden cells.
     * @param a - the length of a front jump.
     * @param b - the length of a backward jump.
     * @param x - the target cell.
     * @return - the minimum number of jumps to get from cell 0 to target cell.
     */
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        if (x == 0) return 0;
        int maxRightPos = 40000;

        Set<Integer> forbiddenCells = new HashSet<>();
        for (int cell : forbidden) {
            forbiddenCells.add(cell);
        }

        int jumps = 0;
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {0, -1});
        Set<String> visited = new HashSet<>();

        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                int[] cell = queue.removeFirst();
                if (cell[0] == x) return jumps;
                if (forbiddenCells.contains(cell[0])) continue;

                int backJumpCell = cell[0] - b;
                int forwardJumpCell = cell[0] + a;

                if (backJumpCell > 0 && cell[1] != -1) {
                    if (cell[1] == 1) {
                        if (!visited.contains(backJumpCell + "*" + 0)) {
                            visited.add(backJumpCell + "*" + 0);
                            queue.offerLast(new int[] {backJumpCell, 0});
                        }
                    } else {
                        if (!visited.contains(backJumpCell + "*" + (-1))) {
                            visited.add(backJumpCell + "*" + (-1));
                            queue.offerLast(new int[] {backJumpCell, -1});
                        }
                    }
                }
                if (forwardJumpCell > 0 && forwardJumpCell <= maxRightPos && !visited.contains(forwardJumpCell + "*" + 0)) {
                    visited.add(forwardJumpCell + "*" + 0);
                    queue.offerLast(new int[] {forwardJumpCell, 0});
                }
            }
            jumps++;
        }

        return -1;
    }
}
