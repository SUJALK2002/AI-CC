import java.util.Scanner;

public class TicTacToeAStar {

    static char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };

    // Print Board
    static void printBoard() {

        System.out.println("\n-------------");

        for (int i = 0; i < 3; i++) {

            System.out.print("| ");

            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }

            System.out.println("\n-------------");
        }
    }

    // Check Winner
    static boolean checkWinner(char player) {

        // Rows and Columns
        for (int i = 0; i < 3; i++) {

            if ((board[i][0] == player &&
                    board[i][1] == player &&
                    board[i][2] == player)

                    ||

                    (board[0][i] == player &&
                            board[1][i] == player &&
                            board[2][i] == player)) {

                return true;
            }
        }

        // Diagonals
        if ((board[0][0] == player &&
                board[1][1] == player &&
                board[2][2] == player)

                ||

                (board[0][2] == player &&
                        board[1][1] == player &&
                        board[2][0] == player)) {

            return true;
        }

        return false;
    }

    // Check Draw
    static boolean isBoardFull() {

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                if (board[i][j] == ' ')
                    return false;
            }
        }

        return true;
    }

    // A* Style Best Move (Simple Heuristic)
    static void computerMove() {

        int bestRow = -1;
        int bestCol = -1;

        // First try winning move
        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                if (board[i][j] == ' ') {

                    board[i][j] = 'O';

                    if (checkWinner('O')) {
                        return;
                    }

                    board[i][j] = ' ';
                }
            }
        }

        // Block player's winning move
        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                if (board[i][j] == ' ') {

                    board[i][j] = 'X';

                    if (checkWinner('X')) {

                        board[i][j] = 'O';
                        return;
                    }

                    board[i][j] = ' ';
                }
            }
        }

        // Otherwise choose first empty cell
        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                if (board[i][j] == ' ') {

                    bestRow = i;
                    bestCol = j;

                    break;
                }
            }
        }

        board[bestRow][bestCol] = 'O';
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("TIC TAC TOE");
        System.out.println("Player = X");
        System.out.println("Computer = O");

        while (true) {

            printBoard();

            // Player Move
            System.out.print("Enter row and column (0-2): ");

            int row = sc.nextInt();
            int col = sc.nextInt();

            if (board[row][col] != ' ') {

                System.out.println("Invalid Move!");
                continue;
            }

            board[row][col] = 'X';

            // Check Player Win
            if (checkWinner('X')) {

                printBoard();
                System.out.println("Player Wins!");
                break;
            }

            // Check Draw
            if (isBoardFull()) {

                printBoard();
                System.out.println("Match Draw!");
                break;
            }

            // Computer Move
            computerMove();

            // Check Computer Win
            if (checkWinner('O')) {

                printBoard();
                System.out.println("Computer Wins!");
                break;
            }

            // Check Draw
            if (isBoardFull()) {

                printBoard();
                System.out.println("Match Draw!");
                break;
            }
        }

        sc.close();
    }
}