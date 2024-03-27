import javax.swing.*;

public class FtoM {
    public static void main(String[] args) {
        final double FEET_TO_METERS = 0.3048;
        String questionText = JOptionPane.showInputDialog(null, "How many feet to convert to meter");
        double question = Double.parseDouble(questionText);
        double answer = question * FEET_TO_METERS;
        JOptionPane.showMessageDialog(null,questionText+" feet equals to  " + answer + "meters!!!!!");
    }
}