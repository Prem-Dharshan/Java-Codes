/*
    1. Develop a AWT & Swings program to draw different shapes and filled with colors as well
 */

package WS09;

import javax.swing.*;
import java.awt.*;


class Shapes {
    public static void main(String[] args) {

        Frame awtFrame = new Frame("AWT Shapes");
        awtFrame.setSize(400, 400);
        awtFrame.setLayout(null);
        awtFrame.setVisible(true);

        AwtShapes awtShapes = new AwtShapes();
        awtShapes.setBounds(0, 0, 400, 400);
        awtFrame.add(awtShapes);

        awtFrame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                System.exit(0);
            }
        });

        JFrame swingFrame = new JFrame("Swing Shapes");
        swingFrame.setSize(400, 400);
        swingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SwingShapes swingShapes = new SwingShapes();
        swingFrame.add(swingShapes);

        swingFrame.setVisible(true);
    }
}


class AwtShapes extends Canvas {
    @Override
    public void paint(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;

        graphics2D.drawRect(10, 10, 50, 100);
        graphics2D.drawRect(80, 10, 50, 50);
        graphics2D.drawOval(150, 10, 50, 50);
        graphics2D.drawOval(220, 10, 50, 100);
        graphics2D.drawPolygon(
                new int[]{300, 330, 360},
                new int[]{100, 10, 100},
                3
        );

        graphics2D.setColor(Color.BLUE);
        graphics2D.fillRect(10, 130, 50, 100);

        graphics2D.setColor(Color.RED);
        graphics2D.fillRect(80, 130, 50, 50);

        graphics2D.setColor(Color.GREEN);
        graphics2D.fillOval(150, 130, 50, 50);

        graphics2D.setColor(Color.ORANGE);
        graphics2D.fillOval(220, 130, 50, 100);

        graphics2D.setColor(Color.YELLOW);
        graphics2D.fillPolygon(
                new int[]{300, 330, 360},
                new int[]{230, 130, 230},
                3
        );

        graphics2D.setColor(Color.GRAY);
        graphics2D.draw3DRect(10, 250, 100, 100, false);
    }
}


class SwingShapes extends JComponent {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;


        graphics2D.drawRect(10, 10, 50, 100);
        graphics2D.drawRect(80, 10, 50, 50);
        graphics2D.drawOval(150, 10, 50, 50);
        graphics2D.drawOval(220, 10, 50, 100);
        graphics2D.drawPolygon(
                new int[]{300, 330, 360},
                new int[]{100, 10, 100},
                3
        );

        graphics2D.setColor(Color.BLUE);
        graphics2D.fillRect(10, 130, 50, 100);

        graphics2D.setColor(Color.RED);
        graphics2D.fillRect(80, 130, 50, 50);

        graphics2D.setColor(Color.GREEN);
        graphics2D.fillOval(150, 130, 50, 50);

        graphics2D.setColor(Color.ORANGE);
        graphics2D.fillOval(220, 130, 50, 100);

        graphics2D.setColor(Color.YELLOW);
        graphics2D.fillPolygon(
                new int[]{300, 330, 360},
                new int[]{230, 130, 230},
                3
        );

        graphics2D.setColor(Color.GRAY);
        graphics2D.draw3DRect(10, 250, 100, 100, false);
    }
}
