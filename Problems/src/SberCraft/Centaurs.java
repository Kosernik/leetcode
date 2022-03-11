package SberCraft;

import java.util.List;
import java.util.PriorityQueue;

public class Centaurs {

    /**
     * Implement function getTotalTime
     */
    public static int getTotalTime(List<Integer> heroes, int n) {
        // Write your code here...
        if (n == 1) return getSum(heroes);
        if (heroes.size() <= n) return  getMax(heroes);

        PriorityQueue<Integer> centaurses = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            centaurses.offer(heroes.get(i));
        }

        for (int i = n; i < heroes.size(); i++) {
            int smallest = centaurses.poll();
            smallest = smallest + heroes.get(i);
            centaurses.offer(smallest);
        }

        int res = centaurses.peek();
        while (!centaurses.isEmpty()) res = centaurses.poll();
        return res;
    }

    private static int getSum(List<Integer> heroes) {
        int sum = 0;
        for (int val : heroes) {
            sum += val;
        }
        return sum;
    }
    private static int getMax(List<Integer> heroes) {
        int max = Integer.MIN_VALUE;
        for (int val : heroes) {
            max = Math.max(max, val);
        }
        return max;
    }

    public static void runCode() {
        // Entrypoint to debug your function
    }
}
