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
  
    private JPanel myPanel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel myPanel2 = new JPanel();
    private JPanel myPanel21 = new JPanel();
    private JPanel myPanel3= new JPanel();
    private JPanel myPanel31= new JPanel();
   // private JPanel myPanel22 = new JPanel();
    //private JPanel myPanel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
   // private JPanel myPanel31 = new JPanel(new GridLayout);

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
   

    public MyWindow(String title) {

        super(title);
        
        myPanel1.add(button);
        this.add(myPanel1,BorderLayout.NORTH);
        //myPanel1.setBorder(BorderFactory.createLineBorder(Color.black));

        myPanel21.setLayout(new BoxLayout(myPanel21, BoxLayout.Y_AXIS));
         //label1.setBorder(BorderFactory.createLineBorder(Color.black));
        myPanel21.add(label1);
        

        //label2.setBorder(BorderFactory.createLineBorder(Color.black));
        myPanel21.add(label2);

        //label3.setBorder(BorderFactory.createLineBorder(Color.black));
        myPanel21.add(label3);

        //label4.setBorder(BorderFactory.createLineBorder(Color.black));
        myPanel21.add(label4);

       // label5.setBorder(BorderFactory.createLineBorder(Color.black));
        myPanel21.add(label5);
        myPanel2.add(myPanel21);

        this.add(myPanel2,BorderLayout.WEST);



        myPanel3.add(textfield1);
        myPanel3.add(textfield2);
        myPanel3.add(textfield3);
        myPanel3.add(textfield4);

        
       
        //myPanel3.add(myPanel31);

        this.add(myPanel3,BorderLayout.CENTER);
        

        

      
        
    
        this.setSize(500,400);
        this.setLocationRelativeTo(null);
        // Tell jvm to kill program when window closes.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
