package MonthlyChallenges.Year24.November;

import java.util.*;

public class SlidingPuzzle {
    private final int BOARD_LENGTH = 6;
    private final int SOLUTION = 123450;

    /**
     * LeetCode №773. Sliding Puzzle.
     * <p>
     * Solved board: {{1,2,3},{4,5,0}}
     *
     * @param board - a 2*3 board, each cell has a unique value from 0 to 5.
     * @return - the least number of moves required so that the state of the board is solved. If it is impossible for
     * the state of the board to be solved, returns -1.
     */
    public int slidingPuzzle(int[][] board) {
        int[] flatBoard = getFlatBoard(board);

        int startNumber = getNumberRepresentation(flatBoard);
        if (startNumber == SOLUTION) return 0;

        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(flatBoard);

        Set<Integer> visited = new HashSet<>();
        visited.add(startNumber);

        int steps = 1;

        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                int[] curBoard = queue.removeFirst();

                int[][] boardsAfterMoving = moveTile(curBoard);
                for (int[] candidate : boardsAfterMoving) {
                    int number = getNumberRepresentation(candidate);
                    if (number == SOLUTION) {
                        return steps;
                    }

                    if (!visited.contains(number)) {
                        queue.offerLast(candidate);
                        visited.add(number);
                    }
                }
            }

            steps++;
        }

        return -1;
    }

    private int[][] moveTile(int[] flatBoard) {
        int[][] boardsAfterMoving;

        if (flatBoard[1] == 0 || flatBoard[4] == 0) {
            boardsAfterMoving = new int[3][BOARD_LENGTH];
            for (int i = 0; i < 3; i++) {
                boardsAfterMoving[i] = Arrays.copyOf(flatBoard, BOARD_LENGTH);
            }
            if (flatBoard[1] == 0) {
                //  *   0   *
                //  *   *   *
                boardsAfterMoving[0][1] = flatBoard[0];
                boardsAfterMoving[0][0] = 0;

                boardsAfterMoving[1][1] = flatBoard[2];
                boardsAfterMoving[1][2] = 0;

                boardsAfterMoving[2][1] = flatBoard[4];
                boardsAfterMoving[2][4] = 0;
            } else {    //flatBoard[4] == 0
                //  *   *   *
                //  *   0   *
                boardsAfterMoving[0][4] = flatBoard[1];
                boardsAfterMoving[0][1] = 0;

                boardsAfterMoving[1][4] = flatBoard[3];
                boardsAfterMoving[1][3] = 0;

                boardsAfterMoving[2][4] = flatBoard[5];
                boardsAfterMoving[2][5] = 0;
            }
        } else {
            boardsAfterMoving = new int[2][BOARD_LENGTH];
            for (int i = 0; i < 2; i++) {
                boardsAfterMoving[i] = Arrays.copyOf(flatBoard, BOARD_LENGTH);
            }
            if (flatBoard[0] == 0) {
                //  0   *   *
                //  *   *   *
                boardsAfterMoving[0][0] = flatBoard[1];
                boardsAfterMoving[0][1] = 0;

                boardsAfterMoving[1][0] = flatBoard[3];
                boardsAfterMoving[1][3] = 0;
            } else if (flatBoard[2] == 0) {
                //  *   *   0
                //  *   *   *
                boardsAfterMoving[0][2] = flatBoard[1];
                boardsAfterMoving[0][1] = 0;

                boardsAfterMoving[1][2] = flatBoard[5];
                boardsAfterMoving[1][5] = 0;
            } else if (flatBoard[3] == 0) {
                //  *   *   *
                //  0   *   *
                boardsAfterMoving[0][3] = flatBoard[0];
                boardsAfterMoving[0][0] = 0;

                boardsAfterMoving[1][3] = flatBoard[4];
                boardsAfterMoving[1][4] = 0;
            } else {    //flatBoard[5] == 0
                //  *   *   *
                //  *   *   0
                boardsAfterMoving[0][5] = flatBoard[2];
                boardsAfterMoving[0][2] = 0;

                boardsAfterMoving[1][5] = flatBoard[4];
                boardsAfterMoving[1][4] = 0;
            }
        }

        return boardsAfterMoving;
    }

    private int getNumberRepresentation(int[] flatBoard) {
        int number = 0;

        for (int j : flatBoard) {
            number = number * 10 + j;
        }

        return number;
    }

    private int[] getFlatBoard(int[][] board) {
        int[] flatBoard = new int[BOARD_LENGTH];

        flatBoard[0] = board[0][0];
        flatBoard[1] = board[0][1];
        flatBoard[2] = board[0][2];

        flatBoard[3] = board[1][0];
        flatBoard[4] = board[1][1];
        flatBoard[5] = board[1][2];

        return flatBoard;
    }
}
