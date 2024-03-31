import javax.swing.*;
import java.awt.*;

class Demo{
    public static void main(String[] args){
        JFrame frame = new JFrame("Demo");
        JPanel one = new JPanel();

        JPanel two = new JPanel();
        JButton two1 = new JButton("Center");
         two.setBackground (Color.PINK.darker());
         two1.setBackground (Color.PINK.darker());

        JPanel three = new JPanel();
        JPanel four = new JPanel();

        JLabel three1 = new JLabel("SouthWest");
        JLabel three2 = new JLabel("SouthEast");

        JButton button1= new JButton("Button1");
        JButton button2 = new JButton("Button2");

        one.add(button1);
        one.add(button2);
        frame.add(one,BorderLayout.NORTH);
        
        //two.setLayout(new FlowLayout());
        //two.add(two1);
        frame.add(two1,BorderLayout.CENTER);

        four.setLayout(new BorderLayout());
        four.add(three1,BorderLayout.WEST);
        four.add(three2,BorderLayout.EAST);
        frame.add(four,BorderLayout.SOUTH);

       
        frame.setVisible(true);
        frame.setSize(400,300);
        
    }
}