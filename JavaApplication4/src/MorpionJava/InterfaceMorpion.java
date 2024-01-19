package MorpionJava;

import java.awt.*;
import javax.swing.*;

public class InterfaceMorpion extends JFrame {
    
    
    private Morpion morpion;
    private JButton[][] buttons;
    private final JPanel panneau;

    public InterfaceMorpion(int size) {
        super("Morpion");
        this.setBounds(100, 100, 250, 250);
        panneau = new JPanel(new GridLayout(size, size));
        buttons = new JButton[size][size];
        morpion = new Morpion(size);
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 40));
                buttons[i][j].setFocusPainted(false);
        
                final int row = i;
                final int col = j;

                buttons[i][j].addActionListener(e -> onButtonClick(row, col));

                panneau.add(buttons[i][j]);
            }
        }
        
        this.getContentPane().add(this.panneau);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
    
    
    private void onButtonClick(int row, int col) {
        
        if (morpion.makeMove(row, col)) {

            updateUI();
            int result = morpion.whoFinished();
            if (result == 1) {
                JOptionPane.showMessageDialog(this, "Player 1 won!");
                resetGame();
            } else if (result == 2) {
                JOptionPane.showMessageDialog(this, "Player 2 won!");
                resetGame();
            } else if (result == 3) {
                JOptionPane.showMessageDialog(this, "It's a draw!");
                resetGame();
            } else {
                morpion.switchPlayer();
            }
        }
    }

    private void updateUI() {
        char[][] board = morpion.getBoard();
        for (int i = 0; i < Morpion.SIZE; i++) {
            for (int j = 0; j < Morpion.SIZE; j++) {
                buttons[i][j].setText(String.valueOf(board[i][j]));
            }
        }
    }

    private void resetGame() {
        morpion = new Morpion(morpion.SIZE);
        updateUI();
    }


}
