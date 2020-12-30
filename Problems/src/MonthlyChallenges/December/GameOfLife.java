package MonthlyChallenges.December;

public class GameOfLife {
    /**
     * LeetCode #289.
     * Updates the grid of Game of Live
     *
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param board - the grid of Game of Live. Cell with "1" is alive, cell with "0" is dead.
     */
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                board[row][col] = getStatus(board, row, col);
            }
        }

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == 2 || board[row][col] == 4) {
                    board[row][col] = 0;
                } else {
                    board[row][col] = 1;
                }
            }
        }
    }

    private int getStatus(int[][] board, int row, int col) {
        // 0 - dead, unchecked
        // 1 - live, unchecked
        // 2 - dead, marked as dead
        // 3 - dead, marked as live
        // 4 - live, marked as dead
        // 5 - live, marked as live

        int numberOfLiveNeighbours = 0;

        //  ? * *
        //  * X *
        //  * * *
        if (row > 0 && col > 0 && (board[row-1][col-1] == 1 || board[row-1][col-1] == 4 || board[row-1][col-1] == 5)) {
            numberOfLiveNeighbours++;
        }

        //  * ? *
        //  * X *
        //  * * *
        if (row > 0 && (board[row-1][col] == 1 || board[row-1][col] == 4 || board[row-1][col] == 5)) {
            numberOfLiveNeighbours++;
        }

        //  * * ?
        //  * X *
        //  * * *
        if (row > 0 && col+1 < board[0].length && (board[row-1][col+1] == 1 || board[row-1][col+1] == 4 || board[row-1][col+1] == 5)) {
            numberOfLiveNeighbours++;
        }

        //  * * *
        //  ? X *
        //  * * *
        if (col > 0 && (board[row][col-1] == 1 || board[row][col-1] == 4 || board[row][col-1] == 5)) {
            numberOfLiveNeighbours++;
        }

        //  * * *
        //  * X ?
        //  * * *
        if (col+1 < board[0].length && (board[row][col+1] == 1 || board[row][col+1] == 4 || board[row][col+1] == 5)) {
            numberOfLiveNeighbours++;
        }

        //  * * *
        //  * X *
        //  ? * *
        if (row+1 < board.length && col > 0 && (board[row+1][col-1] == 1 || board[row+1][col-1] == 4 || board[row+1][col-1] == 5)) {
            numberOfLiveNeighbours++;
        }

        //  * * *
        //  * X *
        //  * * *
        if (row+1 < board.length && (board[row+1][col] == 1 || board[row+1][col] == 4 || board[row+1][col] == 5)) {
            numberOfLiveNeighbours++;
        }

        //  * * *
        //  * X *
        //  * * *
        if (row+1 < board.length && col+1 < board[0].length && (board[row+1][col+1] == 1 || board[row+1][col+1] == 4 || board[row+1][col+1] == 5)) {
            numberOfLiveNeighbours++;
        }

        // the cell was alive
        if (board[row][col] == 1) {
            if (numberOfLiveNeighbours == 2 || numberOfLiveNeighbours == 3) {
                // the cell stays alive
                return 5;
            } else {
                // the cell dies
                return 4;
            }
        }
        // the cell was dead
        else {
            if (numberOfLiveNeighbours == 3) {
                // the cell becomes alive
                return 3;
            } else {
                // the cell stays dead
                return 2;
            }
        }
    }
}
