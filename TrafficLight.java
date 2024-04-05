
/*
 *@author: Henry Leitner
 * @version: Last modified on April 04, 2024
 */
import javax.swing.*;
import java.awt.*;

//The class demonstrates the drawing of traffic lights using graphics in java.
public class TrafficLight {
    // The main method constructs a drawing object.
    public static void main(String[] args) {
        Drawing lights = new Drawing();
        lights.setSize(127, 400);
        lights.setTitle("Traffic Lights");
        lights.setVisible(true);
        lights.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

// The class extends JFrame.
class Drawing extends JFrame {
    final int WIDTH = 120, HEIGHT = 120;
    private Color redShade = new Color(239, 1, 0);
    private Color yellowShade = new Color(181, 163, 0);
    private Color greenShade = new Color(76, 177, 23);

    private MyDrawingPanel drawingPanel = new MyDrawingPanel(WIDTH, HEIGHT, redShade, yellowShade, greenShade);

    // Adds MyDrawingPanel to Drawing
    public Drawing() {
        add(drawingPanel);
    };

    // The class extends JPanel to draw on.
    private class MyDrawingPanel extends JPanel {
        private int width, height;
        private Color red;
        private Color yellow;
        private Color green;

        public MyDrawingPanel() {
        };

        public MyDrawingPanel(int width, int height, Color red, Color yellow, Color green) {
            this.width = width;
            this.height = height;
            this.red = red;
            this.yellow = yellow;
            this.green = green;
        }

        // The paintComponenet method is called by Java to produce graphical output.
        public void paintComponent(Graphics g) {

            g.setColor(this.red);
            g.drawOval(5, 5, this.width, this.height);
            g.fillOval(5, 5, this.width, this.height);
            g.setColor(this.yellow);
            g.drawOval(5, 127, this.width, this.height);
            g.fillOval(5, 127, this.width, this.height);
            g.setColor(this.green);
            g.drawOval(5, 249, this.width, this.height);
            g.fillOval(5, 249, this.width, this.height);

        }  
    }   
}