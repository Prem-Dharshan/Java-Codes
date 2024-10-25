/* 9. Draw an Olympic symbol using AWT & Swings shown below Figure. */

package WS09;

import javax.swing.*;
import java.awt.*;

class OlympicRingPanel extends JComponent {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setStroke(new BasicStroke(5));
        g2.setColor(Color.BLUE);
        g2.drawOval(20, 20, 80, 80);

        g2.setColor(Color.BLACK);
        g2.drawOval(120, 20, 80, 80);

        g2.setColor(Color.RED);
        g2.drawOval(220, 20, 80, 80);

        g2.setColor(Color.YELLOW);
        g2.drawOval(70, 60, 80, 80);

        g2.setColor(Color.GREEN);
        g2.drawOval(170, 60, 80, 80);
    }
}

class OlympicRingViewer {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(400, 200);
        frame.setTitle("OlympicRingViewer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        OlympicRingPanel component = new OlympicRingPanel();
        frame.add(component);

        frame.setVisible(true);
    }
}
