import javax.swing.*;
import java.awt.*;

public class MailLayout {
    public static void main(String[] args) {
        String title = "New Message";
        MyWindow myWindow = new MyWindow(title);
        myWindow.setVisible(true);

    }

}

class MyWindow extends JFrame {

    //private static final int WIDTH = 500, HEIGHT = 400;
  
    private JPanel myPanel1 = new JPanel();
    private JPanel myPanel11 = new JPanel();

    private JPanel myPanel2 = new JPanel();
    private JPanel myPanel21 = new JPanel();

    private JPanel myPanel3= new JPanel();
    private JPanel myPanel31= new JPanel();
 


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
   

    public MyWindow(String title) {

        super(title);
        
        myPanel1.setLayout(new BoxLayout(myPanel1, BoxLayout.Y_AXIS));
        myPanel1.add(button);
        myPanel1.add(label1);
        myPanel1.add(label2);
        myPanel1.add(label3);
        myPanel1.add(label4);
        myPanel1.add(label5);
        // myPanel1.setLayout(new BoxLayout(myPanel21, BoxLayout.Y_AXIS));
        myPanel11.setLayout(new BorderLayout());
        myPanel11.add(myPanel1,BorderLayout.WEST);
       
     
       // myPanel11.add(myPanel2);
        this.add(myPanel11,BorderLayout.NORTH);

        //this.add(myPanel3);


       // myPanel4.add(area);
        this.add(area,BorderLayout.CENTER);
      
        this.setSize(500,400);
        this.setLocationRelativeTo(null);
        // Tell jvm to kill program when window closes.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}