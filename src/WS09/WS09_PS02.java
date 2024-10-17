/*
   2. Develop a AWT & Swings program to draw different smileys
*/

package WS09;

import javax.swing.*;
import java.awt.*;

class Smiley {
   public static void main(String[] args) {

       Frame awtFrame = new Frame("AWT Smiley");
       awtFrame.setSize(400, 400);
       awtFrame.setLayout(null);
       awtFrame.setVisible(true);

       AwtSmiley awtSmiley = new AwtSmiley();
       awtSmiley.setBounds(0, 0, 400, 400);
       awtFrame.add(awtSmiley);

       awtFrame.addWindowListener(new java.awt.event.WindowAdapter() {
           public void windowClosing(java.awt.event.WindowEvent windowEvent) {
               System.exit(0);
           }
       });

       JFrame swingFrame = new JFrame("Swing Smiley");
       swingFrame.setSize(400, 400);
       swingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       SwingSmiley swingSmiley = new SwingSmiley();
       swingFrame.add(swingSmiley);

       swingFrame.setVisible(true);
   }
}


class AwtSmiley extends Canvas {
   @Override
   public void paint(Graphics g) {
       Graphics2D graphics2D = (Graphics2D) g;

       int xCenter = 100, yCenter = 100, diameter = 200;

       graphics2D.setColor(Color.YELLOW);
       graphics2D.fillOval(xCenter, yCenter, diameter, diameter);

       graphics2D.setColor(Color.BLACK);
       graphics2D.fillOval(xCenter + 50, yCenter + 50, 30, 30);
       graphics2D.fillOval(xCenter + 120, yCenter + 50, 30, 30);

       graphics2D.setColor(Color.BLACK);
       graphics2D.drawArc(xCenter + 50, yCenter + 100, 100, 50, 0, -180);
   }
}


class SwingSmiley extends JComponent {
   @Override
   protected void paintComponent(Graphics g) {
       super.paintComponent(g);
       Graphics2D graphics2D = (Graphics2D) g;

       int xCenter = 100, yCenter = 100, diameter = 200;

       graphics2D.setColor(Color.YELLOW);
       graphics2D.fillOval(xCenter, yCenter, diameter, diameter);

       graphics2D.setColor(Color.BLACK);
       graphics2D.fillOval(xCenter + 50, yCenter + 50, 30, 30);
       graphics2D.fillOval(xCenter + 120, yCenter + 50, 30, 30);

       graphics2D.setColor(Color.BLACK);
       graphics2D.drawArc(xCenter + 50, yCenter + 100, 100, 50, 0, -180);
   }
}
