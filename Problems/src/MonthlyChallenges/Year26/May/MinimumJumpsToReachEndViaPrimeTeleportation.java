package MonthlyChallenges.Year26.May;

import java.util.*;

public class MinimumJumpsToReachEndViaPrimeTeleportation {

    private static final int MaxNumber = 1_000_001;
    private static final List<Integer>[] factors = new ArrayList[MaxNumber];

    static {
        for (int i = 0; i < MaxNumber; i++) factors[i] = new ArrayList<>();
        for (int i = 2; i < MaxNumber; i++) {
            if (factors[i].isEmpty()) {
                for (int j = i; j < MaxNumber; j += i) factors[j].add(i);
            }
        }
    }

    /**
     * LeetCode №3629. Minimum Jumps to Reach End via Prime Teleportation.
     *
     * @param nums - an array of positive integers. 1 <= nums[i] <= 10⁶
     * @return - the minimum number of jumps required to reach index n - 1.
     */
    public int minJumps(int[] nums) {
        int length = nums.length;
        int target = length - 1;

        List<Integer> empty = new ArrayList<>();

        Map<Integer, List<Integer>> primeToIndices = new HashMap<>();

        for (int i = 0; i < length; i++) {
            int number = nums[i];

            for (int prime : factors[number]) {
                primeToIndices.putIfAbsent(prime, new ArrayList<>());
                primeToIndices.get(prime).add(i);
            }
        }

        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(0);

        int steps = 0;
        boolean[] visited = new boolean[length];

        while (!queue.isEmpty()) {
            for (int j = queue.size(); j > 0; j--) {
                int index = queue.poll();

                if (index == target) return steps;

                // Jump left
                if (index > 0 && !visited[index - 1]) {
                    queue.offer(index - 1);
                    visited[index - 1] = true;
                }

                // Jump right
                if (!visited[index + 1]) {
                    queue.offer(index + 1);
                    visited[index + 1] = true;
                }

                // Prime jumps
                for (int primeIndex : primeToIndices.getOrDefault(nums[index], empty)) {
                    if (!visited[primeIndex]) {
                        queue.offer(primeIndex);
                        visited[primeIndex] = true;
                    }
                }
                primeToIndices.put(nums[index], empty);
            }

            steps++;
        }

        return -1;
    }
}
