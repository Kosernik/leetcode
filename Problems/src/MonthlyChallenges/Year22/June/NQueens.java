package MonthlyChallenges.Year22.June;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {

    private List<List<String>> boards;
    private final char QUEEN = 'Q';
    private final char EMPTY = '.';

    /**
     * LeetCode #51. N-Queens.
     *
     * @param n - the size of the board and the number of queens.
     * @return - the list of all distinct solutions to the n-queens puzzle.
     */
    public List<List<String>> solveNQueens(int n) {
        this.boards = new ArrayList<>();
        if (n == 1) {
            List<String> board = new ArrayList<>();
            board.add("Q");
            this.boards.add(board);
            return this.boards;
        } else if (n == 2 || n == 3) {
            return this.boards;
        } else if (n == 4) {
            List<String> board1 = new ArrayList<>(Arrays.asList(".Q..", "...Q", "Q...", "..Q."));
            List<String> board2 = new ArrayList<>(Arrays.asList("..Q.", "Q...", "...Q", ".Q.."));
            this.boards.add(board1);
            this.boards.add(board2);
            return this.boards;
        }

        char[][] chessboard = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(chessboard[i], EMPTY);
        }

        backtrack(n, chessboard, 0);

        return this.boards;
    }

    private void backtrack(int n, char[][] chessboard, int row){
        if (row == n) {
            List<String> board = boardToList(chessboard);
            this.boards.add(board);
        } else {
            for (int col = 0; col < n; col++) {
                if (isValidPosition(row, col, chessboard)) {
                    chessboard[row][col] = QUEEN;
                    backtrack(n, chessboard, row + 1);
                    chessboard[row][col] = EMPTY;
                }
            }
        }
    }

    private boolean isValidPosition(int row, int col, char[][] chessboard) {
        for (int r = 0; r < row; r++) {
            // Checking vertical neighbours
            if (chessboard[r][col] == QUEEN) return false;
        }

        int r = row-1;
        int c = col-1;

        while (r >= 0 && c >= 0) {
            if (chessboard[r][c] == QUEEN) return false;
            r--;
            c--;
        }
        r = row-1;
        c = col+1;
        while (r >= 0 && c < chessboard.length) {
            if (chessboard[r][c] == QUEEN) return false;
            r--;
            c++;
        }

        return true;
    }

    private List<String> boardToList(char[][] chessboard) {
        List<String> board = new ArrayList<>();
        for (char[] row : chessboard) {
            board.add(new String(row));
        }
        return board;
    }
}
