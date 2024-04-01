import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MailLayout {
    public static void main(String[] args) {
        String title = "New Message";
        MyWindow myWindow = new MyWindow(title);
        myWindow.setVisible(true);

    }

}

class MyWindow extends JFrame {

    // private static final int WIDTH = 500, HEIGHT = 400;

    private JPanel myPanel1 = new JPanel();
    private JPanel myPanel11 = new JPanel();
    private JPanel myPanel12 = new JPanel();
    private JPanel myPanel3 = new JPanel();

    private JPanel myPanel2 = new JPanel();

    // private JPanel myPanel3= new JPanel();
    // private JPanel myPanel31= new JPanel();

    private JLabel label1 = new JLabel("To:");
    private JLabel label2 = new JLabel("Cc:");
    private JLabel label3 = new JLabel("Bcc:");
    private JLabel label4 = new JLabel("Subject:");
    private JLabel label5 = new JLabel("From:");
    private JButton button = new JButton("Send");

    private JTextField textfield1 = new JTextField("");
    private JTextField textfield2 = new JTextField("");
    private JTextField textfield3 = new JTextField("");
    private JTextField textfield4 = new JTextField("");

    private JTextArea area = new JTextArea();
    String names[] = { "Koshi Raicar <koshiraicar@gmail.com>", "Kathy Raicar <kathyraicar@gmail.com",
            "Mantra Raicar <mantrasyda@gmail.com>" };

    JComboBox<String> cb = new JComboBox<>(names);

    Font f = new Font("SansSerif", Font.PLAIN, 15);

    public MyWindow(String title) {

        super(title);

        myPanel3.setLayout(new BoxLayout(myPanel3, BoxLayout.Y_AXIS));
        myPanel3.add(button);

        myPanel1.setLayout(new BoxLayout(myPanel1, BoxLayout.Y_AXIS));
        myPanel1.add(label1);
        label1.setFont(f);
        myPanel1.add(label2);
        label2.setFont(f);
        myPanel1.add(label3);
        label3.setFont(f);
        myPanel1.add(label4);
        label4.setFont(f);
        myPanel1.add(label5);
        label5.setFont(f);

        myPanel11.setLayout(new BorderLayout());

        myPanel2.setLayout(new BoxLayout(myPanel2, BoxLayout.Y_AXIS));
        myPanel2.add(textfield1);
        myPanel2.add(textfield2);
        myPanel2.add(textfield3);
        myPanel2.add(textfield4);
        myPanel2.add(cb);

        Dimension textFieldSize = new Dimension(150, 10); // Adjust the height here
        textfield1.setPreferredSize(textFieldSize);
        textfield2.setPreferredSize(textFieldSize);
        textfield3.setPreferredSize(textFieldSize);
        textfield4.setPreferredSize(textFieldSize);
        cb.setPreferredSize(new Dimension(150, 20));

        myPanel12.setLayout(new BorderLayout());

        myPanel11.add(myPanel1, BorderLayout.WEST);
        myPanel11.add(myPanel3, BorderLayout.NORTH);
        myPanel11.add(myPanel2, BorderLayout.CENTER);

        // myPanel11.add(myPanel2);
        this.add(myPanel11, BorderLayout.NORTH);
        // myPanel4.add(area);
        this.add(area, BorderLayout.CENTER);

        this.setSize(500, 400);
        this.setLocationRelativeTo(null);

        // Tell jvm to kill program when window closes.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}