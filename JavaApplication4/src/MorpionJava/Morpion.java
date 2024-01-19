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
    private static final int SIZE = 3; // Assuming a 3x3 board

    public Morpion() {
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
        // Implementation to make a move
        return false;
    }

    // Checks if the game is finished
    public int whoFinished() {
        // I-1 : game continues, 1 player 1 won, 2 player 2 won, 3 draw
        
        return -1;
    }


    // Checks if the board is full
    private boolean isBoardFull() {
        // Implementation to check if the board is full
        return false;
    }

    // Switches the current player
    private void switchPlayer() {
        // Implementation to switch the current player
        
    }

    // Optional: Display the board
    public char[][] getBoard() {
        return null;
    }
    
    }
        // Implementation to display the board

