package Problems;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class OpenTheLock {

    /**
     * LeetCode #752. Open the Lock.
     *
     *
     * @param deadends - an array of forbidden combinations.
     * @param target - target combination.
     * @return - True if it is possible to open a lock. False - otherwise.
     */
    public int openLock(String[] deadends, String target) {
        if (target.equals("0000")) return 0;

        Set<String> deadEnds = new HashSet<>(Arrays.asList(deadends));
        if (deadEnds.contains(target) || deadEnds.contains("0000")) return -1;

        int steps = 0;
        ArrayDeque<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        queue.offerLast("0000");
        visited.add("0000");

        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                String currentCode = queue.removeFirst();
                if (target.equals(currentCode)) return steps;

                char[] digits = currentCode.toCharArray();
                for (int j = 0; j < target.length(); j++) {
                    char curChar = digits[j];
                    char back = (curChar - '0') == 0 ? '9' : (char) (curChar - 1);
                    digits[j] = back;
                    String candidate = new String(digits);

                    if (!visited.contains(candidate) && !deadEnds.contains(candidate)) {
                        visited.add(candidate);
                        queue.offerLast(candidate);
                    }

                    char forward = (curChar - '0') == 9 ? '0' : (char) (curChar + 1);
                    digits[j] = forward;
                    String candidateForward = new String(digits);

                    if (!visited.contains(candidateForward) && !deadEnds.contains(candidateForward)) {
                        visited.add(candidateForward);
                        queue.offerLast(candidateForward);
                    }

                    digits[j] = curChar;
                }
            }
            steps++;
        }

        return -1;
    }
}
