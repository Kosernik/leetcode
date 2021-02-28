package MonthlyChallenges.February21;

import java.util.*;

public class MaximumFrequencyStack {
    public static void main(String[] args) {
        MaximumFrequencyStack solution = new MaximumFrequencyStack();

//        System.out.println("Pushing 5");
//        solution.push(5);
//
//        System.out.println("Pushing 7");
//        solution.push(7);
//
//        System.out.println("Pushing 5");
//        solution.push(5);
//
//        System.out.println("Pushing 7");
//        solution.push(7);
//
//        System.out.println("Pushing 4");
//        solution.push(4);
//
//        System.out.println("Pushing 5");
//        solution.push(5);
//
//        System.out.println("Popping");
//        System.out.println("Popped : " + solution.pop());
//        System.out.println("Popped : " + solution.pop());
//        System.out.println("Popped : " + solution.pop());
//        System.out.println("Popped : " + solution.pop());

        System.out.println("Pushing 4");
        solution.push(4);

        System.out.println("Pushing 0");
        solution.push(0);

        System.out.println("Pushing 9");
        solution.push(9);

        System.out.println("Pushing 3");
        solution.push(3);

        System.out.println("Pushing 4");
        solution.push(4);

        System.out.println("Pushing 2");
        solution.push(2);

        System.out.println("Popped : " + solution.pop());

        System.out.println("Pushing 6");
        solution.push(6);

        System.out.println("Popped : " + solution.pop());

        System.out.println("Pushing 1");
        solution.push(1);

        System.out.println("Popped : " + solution.pop());

        System.out.println("Pushing 1");
        solution.push(1);

        System.out.println("Popped : " + solution.pop());

        System.out.println("Pushing 4");
        solution.push(4);

        System.out.println("Popped : " + solution.pop());
        System.out.println("Popped : " + solution.pop());
        System.out.println("Popped : " + solution.pop());
        System.out.println("Popped : " + solution.pop());
        System.out.println("Popped : " + solution.pop());
        System.out.println("Popped : " + solution.pop());
    }


    private Map<Integer, Deque<Integer>> groups;
    private Map<Integer, Integer> frequencies;
    private int maxFrequency;

    /**
     * LeetCode #895.
     */
    public MaximumFrequencyStack() {
        this.groups = new HashMap<>();
        this.frequencies = new HashMap<>();
        this.maxFrequency = 0;
    }

    public void push(int x) {
        int frequency = this.frequencies.getOrDefault(x, 0) + 1;
        this.frequencies.put(x, frequency);

        this.maxFrequency = Math.max(this.maxFrequency, frequency);

        this.groups.computeIfAbsent(frequency, stack -> new ArrayDeque<>()).offerLast(x);
    }

    public int pop() {
        int result = this.groups.get(maxFrequency).removeLast();

        this.frequencies.put(result, this.frequencies.get(result) - 1);
        if (this.groups.get(this.maxFrequency).size() == 0) {
            this.maxFrequency--;
        }

        return result;
    }
}
