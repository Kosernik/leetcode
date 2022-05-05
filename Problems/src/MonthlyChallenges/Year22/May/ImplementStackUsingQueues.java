package MonthlyChallenges.Year22.May;

import java.util.ArrayDeque;
import java.util.Queue;

public class ImplementStackUsingQueues {

    /**
     * LeetCode #225. Implement Stack using Queues.
     */
    class MyStack {
        Queue<Integer> queue;
        Queue<Integer> tempQueue;

        public MyStack() {
            queue = new ArrayDeque<>();
            tempQueue = new ArrayDeque<>();
        }

        public void push(int x) {
            while (!queue.isEmpty()) {
                tempQueue.offer(queue.poll());
            }

            queue.offer(x);

            while (!tempQueue.isEmpty()) {
                queue.offer(tempQueue.poll());
            }
        }

        public int pop() {
            return queue.remove();
        }

        public int top() {
            return queue.element();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
