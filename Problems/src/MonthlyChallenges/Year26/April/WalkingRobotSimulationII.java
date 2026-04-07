package MonthlyChallenges.Year26.April;

public class WalkingRobotSimulationII {

    /**
     * LeetCode №2069. Walking Robot Simulation II.
     */
    class Robot {
        private final String[] directions = {"North", "East", "South", "West"};

        private int currentDirection = 2;
        private final int[] currentCoordinates = {0, 0};

        private final int width;
        private final int height;
        private final int fullCircleLength;

        private boolean robotMoved = false;

        public Robot(int width, int height) {
            this.width = width;
            this.height = height;
            this.fullCircleLength = width + width + height + height - 4;
        }

        public void step(int num) {
            if (num == 0) return;
            robotMoved = true;
            num %= fullCircleLength;

            if (currentDirection == 0) {        //  North
                int verticalCoordinate = currentCoordinates[1];

                if ((verticalCoordinate + num) >= height) {
                    int stepsRemaining = num - (height - verticalCoordinate - 1);
                    currentCoordinates[1] = height - 1;

                    changeDirection();
                    step(stepsRemaining);
                } else {
                    currentCoordinates[1] += num;
                }
            } else if (currentDirection == 1) { //  East
                int horizontalCoordinate = currentCoordinates[0];

                if ((horizontalCoordinate + num) >= width) {
                    int stepsRemaining = num - (width - horizontalCoordinate - 1);
                    currentCoordinates[0] = width - 1;

                    changeDirection();
                    step(stepsRemaining);
                } else {
                    currentCoordinates[0] += num;
                }
            } else if (currentDirection == 2) { //  South
                int verticalCoordinate = currentCoordinates[1];

                if ((verticalCoordinate - num) < 0) {
                    int stepsRemaining = num - verticalCoordinate;
                    currentCoordinates[1] = 0;

                    changeDirection();
                    step(stepsRemaining);
                } else {
                    currentCoordinates[1] -= num;
                }
            } else {                            //  West
                int horizontalCoordinate = currentCoordinates[0];

                if ((horizontalCoordinate - num) < 0) {
                    int stepsRemaining = num - horizontalCoordinate;
                    currentCoordinates[0] = 0;

                    changeDirection();
                    step(stepsRemaining);
                } else {
                    currentCoordinates[0] -= num;
                }
            }
        }

        private void changeDirection() {
            currentDirection = (currentDirection + 3) % directions.length;
        }

        public int[] getPos() {
            return currentCoordinates;
        }

        public String getDir() {
            if (robotMoved) return directions[currentDirection];
            else return directions[1];
        }
    }
}
