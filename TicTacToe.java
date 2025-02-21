import java.util.Scanner;


public class TicTacToe {


    static char[][] board = new char[3][3];
    static char currentPlayer = 'X';


    public static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }


    public static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }


    public static boolean makeMove(int row, int col) {
        if (board[row][col] != ' ') {
            System.out.println("Cell is already taken! Try again.");
            return false;
        } else {
            board[row][col] = currentPlayer;
            return true;
        }
    }


    public static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }


    public static boolean checkWinner() {

        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return true;
            }
        }

        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            return true;
        }

        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            return true;
        }

        return false;
    }


    public static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initializeBoard();
        printBoard();

        while (true) {
            System.out.println("Player " + currentPlayer + ", enter your move (row [0-2] and column [0-2]): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();


            if (row < 0 || row > 2 || col < 0 || col > 2 || !makeMove(row, col)) {
                continue;
            }

            printBoard();


            if (checkWinner()) {
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            }


            if (isBoardFull()) {
                System.out.println("It's a draw!");
                break;
            }

            switchPlayer();  
        }
    }
}
