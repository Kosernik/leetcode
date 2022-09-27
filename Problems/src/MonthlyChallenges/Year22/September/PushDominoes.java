package MonthlyChallenges.Year22.September;

import java.util.ArrayDeque;
import java.util.Deque;

public class PushDominoes {

    /**
     * LeetCode #838. Push Dominoes.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param dominoes - a string representing a row of dominoes.
     *                 dominoes[i] = 'L', if the i-th domino has been pushed to the left,
     *                 dominoes[i] = 'R', if the i-th domino has been pushed to the right, and
     *                 dominoes[i] = '.', if the i-th domino has not been pushed.
     * @return - a string representing the final state of a row of dominoes.
     */
    public String pushDominoes(String dominoes) {
        char[] dominoLetters = dominoes.toCharArray();

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);

        for (int i = 0; i < dominoLetters.length; i++) {
            if (dominoLetters[i] == 'R') {
                if (stack.peek() != -1 && dominoLetters[stack.peek()] == 'R') {
                    int rightFallIdx = stack.pop() + 1;
                    while (rightFallIdx < i) {
                        dominoLetters[rightFallIdx] = 'R';
                        rightFallIdx++;
                    }
                }
            } else if (dominoLetters[i] == 'L') {
                if (stack.peek() == -1 || dominoLetters[stack.peek()] == 'L') {
                    for (int idx = stack.pop() + 1; idx < i; idx++) {
                        dominoLetters[idx] = 'L';
                    }
                } else {
                    int rightFallIdx = stack.pop() + 1;
                    int leftFallIdx = i - 1;
                    while (rightFallIdx < leftFallIdx) {
                        dominoLetters[rightFallIdx] = 'R';
                        dominoLetters[leftFallIdx] = 'L';
                        rightFallIdx++;
                        leftFallIdx--;
                    }
                }
            } else {
                continue;
            }
            stack.push(i);
        }
        // right fall
        if (stack.peek() != -1 && dominoLetters[stack.peek()] == 'R') {
            int rightFallIdx = stack.pop() + 1;
            while (rightFallIdx < dominoLetters.length) {
                dominoLetters[rightFallIdx] = 'R';
                rightFallIdx++;
            }
        }

        return new String(dominoLetters);
    }
}
