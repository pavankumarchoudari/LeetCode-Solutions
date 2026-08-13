class Solution {

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> ans = new ArrayList<>();

        // Create the chess board
        char[][] board = new char[n][n];

        // Fill board with '.'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        // Start from row 0
        solve(0, board, ans, n);

        return ans;
    }

    private void solve(
        int row,
        char[][] board,
        List<List<String>> ans,
        int n
    ) {

        // All rows are completed
        if (row == n) {

            List<String> current = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                current.add(new String(board[i]));
            }

            ans.add(current);

            return;
        }

        // Try every column in the current row
        for (int col = 0; col < n; col++) {

            // Check whether we can place queen
            if (isSafe(board, row, col, n)) {

                // CHOOSE
                board[row][col] = 'Q';

                // EXPLORE
                solve(row + 1, board, ans, n);

                // UNDO / BACKTRACK
                board[row][col] = '.';
            }
        }
    }

    private boolean isSafe(
        char[][] board,
        int row,
        int col,
        int n
    ) {

        // Check every cell for an already placed queen
        for (int r = 0; r < n; r++) {

            for (int c = 0; c < n; c++) {

                if (board[r][c] == 'Q') {

                    // Same row
                    if (r == row) {
                        return false;
                    }

                    // Same column
                    if (c == col) {
                        return false;
                    }

                    // Same diagonal
                    if (Math.abs(r - row) == Math.abs(c - col)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}