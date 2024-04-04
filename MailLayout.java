/*
 * @author Arundhati Raicar
 * @version Last modified 01_April_2024
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;    

/*
 *The class demonstrates creating a Mail layout using GUI.
 */
public class MailLayout {

    //The main method contructs a window.
    public static void main(String[] args) {
        String title = "New Message";
        MyWindow myWindow = new MyWindow(title);
        myWindow.setVisible(true);
    }
}

/*
 *The class extends Jframe.
 */
class MyWindow extends JFrame {

    private JPanel myPanel1 = new JPanel();
    private JPanel myPanel2 = new JPanel();
    private JPanel myPanel3 = new JPanel();
    private JPanel myPanel11 = new JPanel();
    private JPanel myPanel12 = new JPanel();
   
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
    String names[] = { "Koshi Raicar <koshiraicar@gmail.com>", "Kathy Raicar <kathyraicar@gmail.com", "Mantra Raicar <mantrasyda@gmail.com>" };
    JComboBox<String> cb = new JComboBox<>(names);
  
    Font f = new Font("SansSerif", Font.PLAIN, 15);
    Dimension textFieldSize = new Dimension(150, 18);
   
    // The actual creation of the window happens in the constructor
    public MyWindow() {}
    public MyWindow(String title) {
        super(title);

        layoutComponents();
        addListeners();
    }

    //The method sets up the windows appearance.
    private void layoutComponents() {
        
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

        textfield1.setPreferredSize(textFieldSize);
        textfield2.setPreferredSize(textFieldSize);
        textfield3.setPreferredSize(textFieldSize);
        textfield4.setPreferredSize(textFieldSize);
        
        myPanel12.setLayout(new BorderLayout());

        myPanel11.add(myPanel1, BorderLayout.WEST);
        myPanel11.add(myPanel3, BorderLayout.NORTH);
        myPanel11.add(myPanel2, BorderLayout.CENTER);

        this.add(myPanel11, BorderLayout.NORTH);
        this.add(area, BorderLayout.CENTER);
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    //The method set's up the window's plumbing(Listeners are connected to the widgets.)
    private void addListeners() {
        String fileName ="outbox.txt";
        JTextArea areaMsg = this.area;
        
        textfield4.addFocusListener(new FocusListener() {
            
            //No action takes place during focus Gain
            public void focusGained(FocusEvent e) {
            }

            //Title is updated to what user enters in subject textfield after focus is lost
            public void focusLost(FocusEvent e) {
                String subject = textfield4.getText();
                setTitle(subject.isEmpty() ? "New Message" : subject);
            }

        });

        button.addActionListener(new ActionListener(){

            //The method uses submethod to perform the certain operations.
            public void actionPerformed(ActionEvent e){
                sendOperation(e,fileName,areaMsg);
            }
        });
    }

    //The method writes the content of the text area to a file and clears the input fields.
    private void sendOperation(ActionEvent ae,String fileMentioned,JTextArea aj){
        try
        {
            PrintWriter outStream =  new PrintWriter (new File (fileMentioned));
            outStream.print(aj.getText());
            outStream.close ();

            setTitle("New Message");
            textfield1.setText("");
            textfield2.setText("");
            textfield3.setText("");
            textfield4.setText("");
            area.setText("");
        }
        catch (IOException e)
        {
            aj.setText("IOERROR: " + e.getMessage() + "\n");
            e.printStackTrace();
        }
    }
}
