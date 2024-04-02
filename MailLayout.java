/*
 * @author Arundhati Raicar
 * @version Last modified 01_April_2024
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;    

/*
 *The class demonstrates creating a Maillayout using GUI.
 */
public class MailLayout {
    //The main method instantiates an instance of a class that extends JFrame.
    public static void main(String[] args) {
        String title = "New Message";
        MyWindow myWindow = new MyWindow(title);
        myWindow.setVisible(true);
    }
}

/*
 *The class's constructor handles the layout and logic of the program
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
    String names[] = { "Koshi Raicar <koshiraicar@gmail.com>", "Kathy Raicar <kathyraicar@gmail.com",
            "Mantra Raicar <mantrasyda@gmail.com>" };
    JComboBox<String> cb = new JComboBox<>(names);
  
    Font f = new Font("SansSerif", Font.PLAIN, 15);
    Dimension textFieldSize = new Dimension(150, 18);
   
    public MyWindow() {}
     public MyWindow(String title) {
        super(title);
        layoutComponents(title);
        addListeners();
    }

     private void layoutComponents(String title) {
      
        

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
    
      private void addListeners() {
         String fileName ="outbox.txt";
         JTextArea areaMsg = this.area;
        
        textfield4.addFocusListener(new FocusListener() {
        public void focusGained(FocusEvent e) {
            // Implement if needed
        }

        public void focusLost(FocusEvent e) {
            String subject = textfield4.getText();
            setTitle(subject.isEmpty() ? "New Message" : subject);
        }
    });

        button.addActionListener(new ActionListener(){
                 public void actionPerformed(ActionEvent e){
            sendOperation(e,fileName,areaMsg);
                 }

        });

      }

      /*   private void updateTitle(ActionEvent e) {
             focusGained(e);
             focusLost(e);
         
            
        }*/
       //  private void focusGained(FocusEvent e) {}

        //When focus is lost the title is updated using submethod.
       /*  private void focusLost(FocusEvent e) {
        String subject = textfield4.getText();
        setTitle(subject.isEmpty() ? "New Message" :  subject); 
        }*/

        private void sendOperation(ActionEvent e,String file,JTextArea aj){
             try
        {
            PrintWriter outStream =  new PrintWriter (new File (file));
            outStream.print (aj.getText());
            outStream.close ();

            setTitle("New Message");
            textfield1.setText("");
            textfield2.setText("");
            textfield3.setText("");
            textfield4.setText("");
            area.setText("");
        }
        catch (IOException o)
        {
            aj.setText("IOERROR: " + o.getMessage() + "\n");
            o.printStackTrace();
        }

        }
        
        
    

}
/*
  void focusGained(FocusEvent e) {}

        //When focus is lost the title is updated using submethod.
         void focusLost(FocusEvent e) {
            String subject = textfield4.getText();
            setTitle(subject.isEmpty() ? "New Message" :  subject);   
        }
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

        textfield1.setPreferredSize(textFieldSize);
        textfield2.setPreferredSize(textFieldSize);
        textfield3.setPreferredSize(textFieldSize);
        textfield4.setPreferredSize(textFieldSize);
        
        myPanel12.setLayout(new BorderLayout());

        myPanel11.add(myPanel1, BorderLayout.WEST);
        myPanel11.add(myPanel3, BorderLayout.NORTH);
        myPanel11.add(myPanel2, BorderLayout.CENTER);

        textfield4.addFocusListener(new fListner());
        button.addActionListener(new SendEvent());

        this.add(myPanel11, BorderLayout.NORTH);
        this.add(area, BorderLayout.CENTER);
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //The class's constructor is carrying out the operation of reading the Subject Textfield and setting it to the JFrames title 
    class fListner implements FocusListener{

        //The method Does nothing when focus is gained   
        public void focusGained(FocusEvent e) {}

        //When focus is lost the title is updated using submethod.
        public void focusLost(FocusEvent e) {
            updateTitle();   
        }
    }

    //The class provides functionality for handling action events.
    class SendEvent implements ActionListener{

        //The method resets the textfields after performing the operation of sending the mail.
        public void actionPerformed(ActionEvent event){
            writeTextFile (area, "outbox.txt");
            setTitle("New Message");
            textfield1.setText("");
            textfield2.setText("");
            textfield3.setText("");
            textfield4.setText("");
            area.setText("");
        }
    }

    //The method writes the text from textarea to the mentioned file.
    private void writeTextFile (JTextArea display, String fileName)
    {
        try
        {
            PrintWriter outStream =  new PrintWriter (new File (fileName));
            outStream.print (display.getText());
            outStream.close ();
        }
        catch (IOException e)
        {
            display.setText("IOERROR: " + e.getMessage() + "\n");
            e.printStackTrace();
        }
    } 

    //The method updates the frames title based on the condition.
    private void updateTitle() {

         public void focusGained(FocusEvent e) {}

        //When focus is lost the title is updated using submethod.
        public void focusLost(FocusEvent e) {
            updateTitle();   
        }
        String subject = textfield4.getText();
        setTitle(subject.isEmpty() ? "New Message" :  subject);
    }

 */