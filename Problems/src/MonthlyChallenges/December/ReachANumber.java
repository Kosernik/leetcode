package MonthlyChallenges.December;

import java.util.ArrayDeque;

public class ReachANumber {
    public static void main(String[] args) {
        ReachANumber solution = new ReachANumber();
        int[] tests = {1, 3, 2, 0, -200, 200, 1337, -1337, -1000000000, 1000000000, 123456789, -123456789};
        int[] results = {1, 2, 3, 0, 20, 20, 53, 53, 44723, 44723, 15713, 15713};

        if (tests.length != results.length) System.out.println("Wrong test cases!!!");
        else {
            for (int i = 0; i < tests.length; i++) {
                System.out.println("Test #" + i);
                System.out.print("Solution is: \t");
                System.out.println(solution.reachNumber(tests[i]));
                System.out.print("Actual result is: \t");
                System.out.println(results[i]);
            }
        }
        System.out.println("Done!");
    }

    /**
     * LeetCode #754.
     *
     * Complexity - O(sqrt Target)
     * Memory - O(1)
     *
     * @param target - an integer in a range [-10^9;10^9]
     * @return - minimum number of steps.
     */
    public int reachNumber(int target) {
        if (target == 0) return 0;
        target = Math.abs(target);

        int steps = 0;
        int sum = 0;

        while (sum < target){
            steps++;
            sum += steps;
        }

        while ((sum - target) % 2 != 0) {
            steps++;
            sum += steps;
        }
        return steps;
    }

    public int reachNumberBrute(int target) {
        if (target == 0) return 0;

        int steps = 1;
        ArrayDeque<Long> queue = new ArrayDeque<>();
        queue.offer(0L);

        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                long currCell = queue.removeFirst();
                if (currCell == target) return steps-1;
                queue.offerLast(currCell+steps);
                queue.offerLast(currCell-steps);
            }

            steps++;
        }

        return steps;
    }
}
