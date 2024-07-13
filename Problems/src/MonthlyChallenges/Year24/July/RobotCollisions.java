package MonthlyChallenges.Year24.July;

import java.util.*;

public class RobotCollisions {

    /**
     * LeetCode №2751. Robot Collisions.
     * <p>
     * Complexity - O(NlogN + N)
     * Memory - O(sorting memory + N)
     *
     * @param positions  - an array of positions of each robot.
     * @param healths    - an array of healths of each robot.
     * @param directions - a string representing the direction of movement of each robot.
     * @return - the healths of survived robots (in the order they were given in the input).
     */
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        Integer[] indices = new Integer[positions.length];
        for (int i = 0; i < indices.length; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, Comparator.comparingInt(a -> positions[a]));
        Deque<Integer> stack = new ArrayDeque<>();

        for (int idx : indices) {
            if (directions.charAt(idx) == 'R') {
                stack.push(idx);
            } else {
                while (!stack.isEmpty() && healths[idx] > 0) {
                    int prevRobot = stack.pop();

                    if (healths[prevRobot] > healths[idx]) {
                        healths[prevRobot]--;
                        healths[idx] = 0;
                        stack.push(prevRobot);
                    } else if (healths[prevRobot] == healths[idx]) {
                        healths[prevRobot] = 0;
                        healths[idx] = 0;
                    } else {
                        healths[prevRobot] = 0;
                        healths[idx]--;
                    }
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int health : healths) {
            if (health > 0) result.add(health);
        }
        return result;
    }
}
