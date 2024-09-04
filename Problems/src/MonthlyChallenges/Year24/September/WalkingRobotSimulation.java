package MonthlyChallenges.Year24.September;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class WalkingRobotSimulation {
    public static void main(String[] args) {
        WalkingRobotSimulation solution = new WalkingRobotSimulation();

        int[] test1Commands = {4, -1, 4, -2, 4};
        int[][] test1Obstacles = {{2, 4}};
        System.out.println(solution.robotSim(test1Commands, test1Obstacles));
    }


    private final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};  // North, East, South, West
    private final int NUMBER_OF_DIRECTIONS = directions.length;

    /**
     * LeetCode №874. Walking Robot Simulation.
     *
     * @param commands  - array of commands.
     * @param obstacles - array of obstacles.
     * @return - the maximum Euclidean distance that the robot ever gets from the origin squared.
     */
    public int robotSim(int[] commands, int[][] obstacles) {
        int result = 0;

        Map<Integer, TreeSet<Integer>> xxx = new HashMap<>();
        Map<Integer, TreeSet<Integer>> yyy = new HashMap<>();

        for (int[] obstacle : obstacles) {
            int x = obstacle[0];
            int y = obstacle[1];

            if (!xxx.containsKey(x)) {
                xxx.put(x, new TreeSet<>());
            }
            if (!yyy.containsKey(y)) {
                yyy.put(y, new TreeSet<>());
            }

            xxx.get(x).add(y);
            yyy.get(y).add(x);
        }

        int X = 0;
        int Y = 0;
        int direction = 0;

        for (int command : commands) {
            if (command == -2) {    //  turning 90 degrees left
                direction = (direction - 1 + NUMBER_OF_DIRECTIONS) % NUMBER_OF_DIRECTIONS;
                continue;
            }
            if (command == -1) {    //  turning 90 degrees right
                direction = (direction + 1) % NUMBER_OF_DIRECTIONS;
                continue;
            }

            if (direction % 2 == 0) {   //  Vertical movement
                if (!xxx.containsKey(X)) {
                    if (direction == 0) {
                        Y += command;
                    } else {
                        Y -= command;
                    }
                } else {
                    if (direction == 0) {   //  Move North
                        Integer obstacle = xxx.get(X).higher(Y);

                        int nextY = Y + command;
                        if (obstacle == null || obstacle > nextY) {
                            Y = nextY;
                        } else {
                            Y = (obstacle - 1);
                        }
                    } else {    //  Move South
                        Integer obstacle = xxx.get(X).lower(Y);

                        int prevY = Y - command;
                        if (obstacle == null || obstacle < prevY) {
                            Y = prevY;
                        } else {
                            Y = (obstacle + 1);
                        }
                    }
                }
            } else {    //  Horizontal movement
                if (!yyy.containsKey(Y)) {
                    if (direction == 1) {
                        X += command;
                    } else {
                        X -= command;
                    }
                } else {
                    if (direction == 1) {   //  Move East
                        Integer obstacle = yyy.get(Y).higher(X);

                        int nextX = X + command;
                        if (obstacle == null || obstacle > nextX) {
                            X = nextX;
                        } else {
                            X = (obstacle - 1);
                        }
                    } else {    //  Move West
                        Integer obstacle = yyy.get(Y).lower(X);

                        int prevX = X - command;
                        if (obstacle == null || obstacle < prevX) {
                            X = prevX;
                        } else {
                            X = (obstacle + 1);
                        }
                    }
                }
            }

            result = Math.max(result, X * X + Y * Y);
        }

        return result;
    }
}
