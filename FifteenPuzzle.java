import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Arrays;

public class FifteenPuzzle {
    public static void main(String[] args) {
        String title = "Fifteen Puzzle Game";
        Window MyWindow = new MyWindow(title);
        MyWindow.setVisible(true);

    }
}

class MyWindow extends JFrame {

    private JPanel onePanel = new JPanel();
    private JPanel twoPanel = new JPanel();
    private JButton[][] btngrid = new JButton[1][16];
    private JButton shuffle = new JButton("Shuffle");
    private JButton exit = new JButton("Exit");

    public MyWindow() {
    };

    public MyWindow(String title) {
        super(title);
        layoutComponents();
    };

    private void layoutComponents() {
        onePanel.setLayout(new GridLayout(4, 4));

        for (int i = 0; i < 16; i++) {
            btngrid[0][i] = new JButton(String.valueOf(i + 1));
            onePanel.add(btngrid[0][i]);
        }
        btngrid[0][15].setText("");
        onePanel.add(btngrid[0][15]);

        twoPanel.add(shuffle);
        twoPanel.add(exit);
        this.add(onePanel);
        this.add(twoPanel, BorderLayout.SOUTH);
        this.setSize(500, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
