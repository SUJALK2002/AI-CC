public class NQueens {

    static int N = 4;

    // Function to print board
    public static void printBoard(char board[][]) {

        System.out.println("Solution:");

        for (int i = 0; i < N; i++) {

            for (int j = 0; j < N; j++) {

                System.out.print(board[i][j] + " ");
            }

            System.out.println();
        }
    }

    // Check if position is safe
    public static boolean isSafe(char board[][], int row, int col) {

        // Check column
        for (int i = 0; i < row; i++) {

            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Upper left diagonal
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0;
             i--, j--) {

            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Upper right diagonal
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < N;
             i--, j++) {

            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    // Backtracking function
    public static boolean solve(char board[][], int row) {

        // Base case
        if (row == N) {
            printBoard(board);
            return true;
        }

        // Try every column
        for (int j = 0; j < N; j++) {

            if (isSafe(board, row, j)) {

                // Place queen
                board[row][j] = 'Q';

                // Recursive call
                if (solve(board, row + 1)) {
                    return true;
                }

                // Backtrack
                board[row][j] = 'X';
            }
        }

        return false;
    }

    public static void main(String[] args) {

        char board[][] = new char[N][N];

        // Initialize board
        for (int i = 0; i < N; i++) {

            for (int j = 0; j < N; j++) {

                board[i][j] = 'X';
            }
        }

        solve(board, 0);
    }
}