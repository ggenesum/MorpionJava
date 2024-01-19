
import java.awt.*;
import javax.swing.*;

public class InterfaceMorpion extends JFrame {
    
    private final JPanel panneau = new JPanel();
    
    private Morpion morpion;
    private JButton[][] buttons;
    
    public InterfaceMorpion() {
        super("Morpion");
        this.setBounds(100, 100, 250, 200);
        
        buttons = new JButton[3][3];
        morpion = new Morpion();
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
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
        morpion = new Morpion();
        updateUI();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(InterfaceMorpion::new);
    }
}
