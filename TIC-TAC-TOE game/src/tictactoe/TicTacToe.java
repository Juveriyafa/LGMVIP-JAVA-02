package tictactoe;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class TicTacToe {
    private JFrame frame;
    private JButton[] buttons = new JButton[9];
    private String currentPlayer = "X";

    public TicTacToe() {
        frame = new JFrame("Tic Tac Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(new GridLayout(3, 3));

        initializeButtons();
        addButtonsToFrame();

        frame.setVisible(true);
    }

    private void initializeButtons() {
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            buttons[i].setText("");
            buttons[i].addActionListener(new ButtonClickListener());
        }
    }

    private void addButtonsToFrame() {
        for (int i = 0; i < 9; i++) {
            frame.add(buttons[i]);
        }
    }

    private boolean checkWin() {
        String[] board = new String[9];
        for (int i = 0; i < 9; i++) {
            board[i] = buttons[i].getText();
        }
        for (int i = 0; i < 8; i++) {
            String line = null;
            switch (i) {
                case 0:
                    line = board[0] + board[1] + board[2];
                    break;
                case 1:
                    line = board[3] + board[4] + board[5];
                    break;
                case 2:
                    line = board[6] + board[7] + board[8];
                    break;
                case 3:
                    line = board[0] + board[3] + board[6];
                    break;
                case 4:
                    line = board[1] + board[4] + board[7];
                    break;
                case 5:
                    line = board[2] + board[5] + board[8];
                    break;
                case 6:
                    line = board[0] + board[4] + board[8];
                    break;
                case 7:
                    line = board[2] + board[4] + board[6];
                    break;
            }
            if (line.equals("XXX")) {
                JOptionPane.showMessageDialog(frame, "X wins!");
                return true;
            } else if (line.equals("OOO")) {
                JOptionPane.showMessageDialog(frame, "O wins!");
                return true;
            
        }
        for (int i1 = 0; i1 < 9; i1++) {
            if (buttons[i1].getText().equals("")) {
                return false;
            }
        }
        JOptionPane.showMessageDialog(frame, "It's a draw!");
        return true;
    }
   





        
        return false;
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton buttonClicked = (JButton) e.getSource();
            if (buttonClicked.getText().equals("")) {
                buttonClicked.setText(currentPlayer);
                if (checkWin()) {
                    resetBoard();
                } else if (currentPlayer.equals("X")) {
                    currentPlayer = "O";
                } else {
                    currentPlayer = "X";
                }
            }
        }
    }

    private void resetBoard() {
        for (int i = 0; i < 9; i++) {
            buttons[i].setText("");
        }
    }
}


