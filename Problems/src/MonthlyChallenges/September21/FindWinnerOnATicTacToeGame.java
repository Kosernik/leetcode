package MonthlyChallenges.September21;

public class FindWinnerOnATicTacToeGame {
    /**
     * LeetCode #1275. Find Winner on a Tic Tac Toe Game.
     *
     * @param moves - an array of moves of players.
     * @return - result of the game.
     */
    public String tictactoe(int[][] moves) {
        int[][] board = new int[3][3];

        boolean first = true;
        for (int[] move : moves) {
            if (first) {
                board[move[0]][move[1]] = 1;
            } else {
                board[move[0]][move[1]] = 2;
            }
            first = !first;
        }

        int res = getResult(board);
        if (res == 1) return "A";
        else if (res == 2) return "B";
        else return moves.length == 9 ? "Draw" : "Pending";
    }
    private int getResult (int[][] board) {
        for (int r = 0; r < 3; r++) {
            if (board[r][0] == board[r][1] && board[r][1] == board[r][2] && board[r][2] != 0) {
                return board[r][2];
            }
        }
        for (int c = 0; c < 3; c++) {
            if (board[0][c] == board[1][c] && board[1][c] == board[2][c] && board[2][c] != 0) {
                return board[2][c];
            }
        }
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[2][2] != 0) {
            return board[2][2];
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[2][0] != 0) {
            return board[2][0];
        }
        return 0;
    }
}
