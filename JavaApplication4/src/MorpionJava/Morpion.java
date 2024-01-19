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
    public static final int SIZE = 3; // Assuming a 3x3 board

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
        if ((row < SIZE && col < SIZE) && board[row][col] == ' ')
        {
             board[row][col] = currentPlayer;
             return true;
        }
        // Implementation to make a move
       
        return false;
    }

    public int whoFinished() {
      // -1: game continues, 1: player 1 ('X') won, 2: player 2 ('O') won, 3: draw

      // Check rows
      for (int r = 0; r < SIZE; r++) {
          if (board[r][0] != ' ' && checkRowCol(board[r][0], board[r][1], board[r][2])) {
              return board[r][0] == 'X' ? 1 : 2;
          }
      }

      // Check columns
      for (int c = 0; c < SIZE; c++) {
          if (board[0][c] != ' ' && checkRowCol(board[0][c], board[1][c], board[2][c])) {
              return board[0][c] == 'X' ? 1 : 2;
          }
      }

      // Check diagonals
      if (board[0][0] != ' ' && checkRowCol(board[0][0], board[1][1], board[2][2])) {
          return board[0][0] == 'X' ? 1 : 2;
      }
      if (board[0][2] != ' ' && checkRowCol(board[0][2], board[1][1], board[2][0])) {
          return board[0][2] == 'X' ? 1 : 2;
      }

      // Check for draw
      if (isBoardFull()) {
          return 3;
      }

      // Game continues
      return -1;
  }

  // Helper method to check if three cells are the same
  private boolean checkRowCol(char c1, char c2, char c3) {
      return ((c1 != ' ') && (c1 == c2) && (c2 == c3));
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

