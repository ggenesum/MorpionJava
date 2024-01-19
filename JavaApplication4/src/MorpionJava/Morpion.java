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
        if (row < SIZE ||col > SIZE)
        {
            return false;
        }
        // Implementation to make a move
        board[row][col] = currentPlayer;
        return false;
    }

    // Checks if the game is finished
    public int whoFinished() {
        // I-1 : game continues, 1 player 1 won, 2 player 2 won, 3 draw
        
        //check rows
         for (int r = 0; r < this.board.length; r++)
         {
           boolean win = true;
           char player_symbol = this.board[r][0];
           for (int c = 1; c < this.board[r].length; c++)
           {
                if (board[r][c] != player_symbol)
                {
                   win = false;
                   break;
                }
           }
           if (win)
           {
               if (player_symbol == 'X')
               {
                    return 1;
               }
               else {
                   return 0;
               }
           }    
         }
        
         //check cols
        for (int c = 1; c < this.board[0].length; c++)
        {
           boolean win = true;
           char player_symbol = this.board[0][c];
           for (int r = 0; r < this.board.length; r++)
           {
                if (board[r][c] != player_symbol)
                {
                   win = false;
                   break;
                }
           }
           if (win)
           {
               if (player_symbol == 'X')
               {
                    return 1;
               }
               else {
                   return 0;
               }
           }    
         }
         
  
        //check cols
        for (int d = 1; d < this.board[0].length; d++)
        {
           boolean win_diag1 = true;
           boolean win_diag2 = true;

           char player_symbol_diag1 = this.board[0][0];
           char player_symbol_diag2 = this.board[SIZE-1][SIZE-1];
           {
                if (board[d][d] != player_symbol_diag1)
                {
                   win_diag1 = false;
                   break;
                }
                 if (board[d-1][SIZE-d-1] != player_symbol_diag2)
                {
                   win_diag2 = false;
                   break;
                }
           }
           if (win_diag1)
           {
               if (player_symbol_diag1 == 'X')
               {
                    return 1;
               }
               else {
                   return 0;
               }
           }    
           if (win_diag2)
           {
               if (player_symbol_diag2 == 'X')
               {
                    return 1;
               }
               else {
                   return 0;
               }
           }    
         }
        
        if (isBoardFull())
        {
            return 3;
        }
        return -1;
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
    private void switchPlayer() {
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

