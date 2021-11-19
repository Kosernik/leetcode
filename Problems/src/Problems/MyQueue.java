package Problems;

import java.util.LinkedList;

public class MyQueue {

    private LinkedList<Integer> stack;

    /**
     * LeetCode #232. Implement Queue using Stacks.
     */
    public MyQueue() {
        stack = new LinkedList<>();
    }

    public void push(int x) {
        LinkedList<Integer> tempStack = new LinkedList<>();

        while (!stack.isEmpty()) {
            tempStack.push(stack.pop());
        }

        stack.push(x);

        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }

    public int pop() {
        return stack.pop();
    }

    public int peek() {
        return stack.peek();
    }

    public boolean empty() {
        return stack.isEmpty();
    }
}
