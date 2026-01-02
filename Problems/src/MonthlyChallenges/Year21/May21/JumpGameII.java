package MonthlyChallenges.Year21.May21;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class JumpGameII {
    public static void main(String[] args) {
        JumpGameII solution = new JumpGameII();
        int[] test0 = {2, 3, 1, 1, 4};
        System.out.println(solution.jump(test0));

        int[] test1 = {7, 1};
        System.out.println(solution.jump(test1));
    }

    /**
     * LeetCode #45.
     *
     * @param nums - array of integers.
     * @return - minimum number of jumps to reach the last index.
     */
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int[] jumps = new int[nums.length];
        Arrays.fill(jumps, nums.length + 1);
        jumps[0] = 0;

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);

        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                int currCell = queue.poll();
                int currJumps = jumps[currCell];

                if (currJumps == (nums.length + 1)) continue;
                else currJumps++;

                for (int step = currCell + 1; step < (Math.min((currCell + nums[currCell] + 1), jumps.length)); step++) {
                    if (jumps[step] > currJumps) {
                        jumps[step] = currJumps;
                        queue.offer(step);
                    }
                }
            }
        }

        return jumps[nums.length - 1];
    }
}
