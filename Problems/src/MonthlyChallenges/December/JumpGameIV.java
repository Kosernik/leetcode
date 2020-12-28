package MonthlyChallenges.December;

import java.util.*;

public class JumpGameIV {
    public static void main(String[] args) {
        JumpGameIV solution = new JumpGameIV();
        int[] arr = {100,-23,-23,404,100,23,23,23,3,404};
        System.out.println(solution.minJumps(arr));
    }

    /**
     * LeetCode #1345.
     *
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param arr - array of integers.
     * @return - minimum number of jumps needed to get to last cell.
     */
    public int minJumps(int[] arr) {
        if (arr == null || arr.length <= 1) return 0;
        int length = arr.length;
        int target = length-1;

        Map<Integer, List<Integer>> neighbours = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!neighbours.containsKey(arr[i])) neighbours.put(arr[i], new ArrayList<>());
            neighbours.get(arr[i]).add(i);
        }

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(0);
        visited.add(0);

        int jumps = 0;
        while (!queue.isEmpty()) {

            for (int i = queue.size(); i > 0; i--) {
                Integer currNode = queue.removeFirst();
                if (currNode == target) return jumps;

                if (currNode > 0 && !visited.contains(currNode-1)) {
                    queue.offerLast(currNode-1);
                    visited.add(currNode-1);
                }
                if (currNode < target && !visited.contains(currNode+1)) {
                    queue.offerLast(currNode+1);
                    visited.add(currNode+1);
                }

                List<Integer> neighs = neighbours.get(arr[currNode]);

                for (int n : neighs) {
                    if (!visited.contains(n)) {
                        queue.offerLast(n);
                        visited.add(n);
                    }
                }

                neighs.clear();
            }

            jumps++;
        }


        return length-1;
    }
}
