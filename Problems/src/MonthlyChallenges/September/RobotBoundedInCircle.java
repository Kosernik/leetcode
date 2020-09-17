package MonthlyChallenges.September;

public class RobotBoundedInCircle {
    public static void main(String[] args) {
        RobotBoundedInCircle solution = new RobotBoundedInCircle();
        solution.testIsRobotBounded();
    }

    /**
     * Checking if a robot stays in a circle on a plane, and never leaves it.
     *
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param instructions - a string of instructions for a robot. 'L' - robot turns left, 'R' - robot turns right,
     *                     'G' - robot moves one step in a direction it looks at.
     * @return - True - if there is a circle on a plane such that the robot never leaves the circle, False - otherwise.
     */
    public boolean isRobotBounded(String instructions) {
        if (instructions == null || instructions.length() == 1) return true;

        String[] directions = {"NORTH", "EAST", "SOUTH", "WEST"};
        int direction = 0;
        byte[] position = {0,0};

        char[] commands = instructions.toCharArray();

        for (char command : commands) {
            if (command == 'L') {
                direction = (direction + 3) % 4;
            } else if (command == 'R') {
                direction = (direction + 1) % 4;
            } else {
                if (direction == 0) {
                    position[1]++;
                } else if (direction == 1) {
                    position[0]++;
                } else if (direction == 2) {
                    position[1]--;
                } else {
                    position[0]--;
                }
            }
        }

        return (position[0] == 0 && position[1] == 0) || direction != 0;
    }

    private void testIsRobotBounded() {
        String[] tests = {
                "GGLLGG",
                "GG",
                "GL",
                "GLGL",
                "GLGLGLGL",
                "GLGLGLGR",
                "GLG",
                "GLGG"
        };
        boolean[] results = {
                true,
                false,
                true,
                true,
                true,
                true,
                true,
                true
        };

        int failed = 0;
        for (int i = 0; i < results.length; i++) {
            if (isRobotBounded(tests[i]) != results[i]) {
                failed++;
                System.out.println("Wrong result for test: " + tests[i]);
                System.out.println("Got: " + !results[i] + ", instead of: " + results[i]);
            }
        }

        System.out.println("Success rate: " + (tests.length - failed) * 100.0 / tests.length);
    }
}
