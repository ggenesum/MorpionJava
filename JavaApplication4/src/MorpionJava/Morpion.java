/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MorpionJava;

/**
 *
 * @author lesei
 */
public class Morpion {
    private char[][] board; // 2D array for the game board
    private char currentPlayer; // 'X' or 'O'
    public static int SIZE = 3; // Assuming a 3x3 board

    public Morpion(int size) {
        SIZE = size;
        board = new char[SIZE][SIZE];
        currentPlayer = 'X'; // X starts by default
        initializeBoard();
    }

    // Initializes the board with empty spaces
    private void initializeBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = ' ';
            }
        }
    }

    // Marks the specified cell with the current player's symbol
    public boolean makeMove(int row, int col) {
        if ((row < SIZE && col < SIZE) && board[row][col] == ' ')
        {
             board[row][col] = currentPlayer;
             return true;
        }
        // Implementation to make a move
       
        return false;
    }

    public int whoFinished() {
    // Check rows and columns
    for (int i = 0; i < SIZE; i++) {
        if (checkLine(board[i][0], i, 0, 0, 1) || checkLine(board[0][i], 0, i, 1, 0)) {
            char winner = board[i][0] != ' ' ? board[i][0] : board[0][i];
            return winner == 'X' ? 1 : 2;
        }
    }

    // Check diagonals
    if (checkLine(board[0][0], 0, 0, 1, 1) || checkLine(board[0][SIZE - 1], 0, SIZE - 1, 1, -1)) {
        char winner = board[0][0] != ' ' ? board[0][0] : board[0][SIZE - 1];
        return winner == 'X' ? 1 : 2;
    }

    // Check for draw
    if (isBoardFull()) {
        return 3;
    }

    // Game continues
    return -1;
    }

    // Helper method to check if a line (row, column, or diagonal) is all the same symbol
    private boolean checkLine(char symbol, int startRow, int startCol, int rowInc, int colInc) {
        if (symbol == ' ') {
            return false;
        }
        for (int i = 0; i < SIZE; i++) {
            if (board[startRow + i * rowInc][startCol + i * colInc] != symbol) {
                return false;
            }
        }
        return true;
    }



    // Checks if the board is full
    private boolean isBoardFull() {
        // Implementation to check if the board is full
        for (int r = 0; r < this.board.length; r++)
            for (int c = 0; c < this.board[r].length; c++)
            {
                if (board[r][c] == ' ')
                {
                    return false;
                }
            }
        return true;
    }

    // Switches the current player
    public void switchPlayer() {
        // Implementation to switch the current player
        if (currentPlayer == 'X')
        {
            currentPlayer = 'O';
        }
        else {
            currentPlayer = 'X';
        }
    }

    // Optional: Display the board
    public char[][] getBoard() {
        return board;
    }
    
    }
        // Implementation to display the board

