/* 5. Write a program that moves a ball in a pane with buttons for "Up," "Down," "Left," and "Right" to control movement. Ensure the ball does not move out of bounds. */

package WS09;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

class SwingBallApp extends JFrame {
    private final BallPanel ballPanel;

    public SwingBallApp() {
        ballPanel = new BallPanel(200, 200, 30);  // Initial center coordinates and radius for the ball

        JButton btnUp = new JButton("Up"), btnDown = new JButton("Down"),
                btnLeft = new JButton("Left"), btnRight = new JButton("Right");

        btnUp.addActionListener((ActionEvent _) -> ballPanel.moveUp());
        btnDown.addActionListener((ActionEvent _) -> ballPanel.moveDown());
        btnLeft.addActionListener((ActionEvent _) -> ballPanel.moveLeft());
        btnRight.addActionListener((ActionEvent _) -> ballPanel.moveRight());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnUp);
        buttonPanel.add(btnDown);
        buttonPanel.add(btnLeft);
        buttonPanel.add(btnRight);

        setLayout(new BorderLayout());
        add(ballPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setTitle("Ball Control");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private static class BallPanel extends JPanel {
        private int x;
        private int y;
        private final int radius;

        public BallPanel(int centerX, int centerY, int radius) {
            this.x = centerX;
            this.y = centerY;
            this.radius = radius;
        }

        public void moveUp() {
            if (y - radius - 10 >= 0) y -= 10;
            repaint();
        }

        public void moveDown() {
            if (y + radius + 10 <= getHeight()) y += 10;
            repaint();
        }

        public void moveRight() {
            if (x + radius + 10 <= getWidth()) x += 10;
            repaint();
        }

        public void moveLeft() {
            if (x - radius - 10 >= 0) x -= 10;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawOval(x - radius, y - radius, radius, radius);
        }
    }

    public static void main() {
        SwingUtilities.invokeLater(SwingBallApp::new);
    }
}
