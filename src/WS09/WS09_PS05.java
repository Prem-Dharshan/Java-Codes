/* 5. Write a Software Phone App using (AWT, Swings & JavaFX) as illustrated in the figure. The
user enters the phone number and pushes the "CALL" button to start a phone call. Once the
call is started, the label of the "CALL" button changes to "HANG UP". When the user hangs
up, the display is cleared. */

package WS09;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class SwingPhoneApp extends JFrame {
    private final JButton btnCall;
    private final JTextField tfDisplay;
    private String strPhoneNumber = "";
    private boolean isCalling = false;

    public SwingPhoneApp() {
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        JPanel pnlDisplay = new JPanel(new FlowLayout());
        cp.add(pnlDisplay, BorderLayout.NORTH);

        tfDisplay = new JTextField(30);
        tfDisplay.setEditable(false);
        tfDisplay.setHorizontalAlignment(JTextField.RIGHT);
        pnlDisplay.add(tfDisplay);

        JPanel pnlButtons = new JPanel(new GridLayout(4, 3, 3, 3));
        cp.add(pnlButtons, BorderLayout.CENTER);

        MyNumberButtonListener lis = new MyNumberButtonListener();
        JButton[] btnNumbers = new JButton[10];

        for (int i = 0; i < btnNumbers.length; ++i) {
            btnNumbers[i] = new JButton(i + "");
            btnNumbers[i].addActionListener(lis);
        }

        for (int i = 1; i <= 9; ++i) {
            pnlButtons.add(btnNumbers[i]);
        }

        JButton btnClear = new JButton("CLEAR");
        pnlButtons.add(btnClear);
        btnClear.addActionListener(_ -> clearDisplay());

        pnlButtons.add(btnNumbers[0]);

        btnCall = new JButton("CALL");
        pnlButtons.add(btnCall);
        btnCall.addActionListener(_ -> toggleCallState());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 250);
        setTitle("Swing Phone App - Frame 1");
        setVisible(true);
    }

    private void clearDisplay() {
        strPhoneNumber = "";
        tfDisplay.setText(strPhoneNumber);
    }

    private void toggleCallState() {
        if (isCalling) {
            isCalling = false;
            btnCall.setText("CALL");
            new HangUpFrame();
        } else {
            isCalling = true;
            btnCall.setText("HANG UP");
        }
    }

    private class MyNumberButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            strPhoneNumber += e.getActionCommand();
            tfDisplay.setText(strPhoneNumber);
        }
    }

    public static void main() {
        SwingUtilities.invokeLater(SwingPhoneApp::new);
    }
}

class HangUpFrame extends JFrame {
    private final JButton btnClear;
    private final JTextField tfDisplay;
    private String strPhoneNumber = "";

    public HangUpFrame() {
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        JPanel pnlDisplay = new JPanel(new FlowLayout());
        cp.add(pnlDisplay, BorderLayout.NORTH);

        tfDisplay = new JTextField(30);
        tfDisplay.setEditable(false);
        tfDisplay.setHorizontalAlignment(JTextField.RIGHT);
        pnlDisplay.add(tfDisplay);

        JPanel pnlButtons = new JPanel(new GridLayout(4, 3, 3, 3));
        cp.add(pnlButtons, BorderLayout.CENTER);

        MyNumberButtonListener lis = new MyNumberButtonListener();
        JButton[] btnNumbers = new JButton[10];

        for (int i = 0; i < btnNumbers.length; ++i) {
            btnNumbers[i] = new JButton(i + "");
            btnNumbers[i].addActionListener(lis);
        }

        for (int i = 1; i <= 9; ++i) {
            pnlButtons.add(btnNumbers[i]);
        }

        btnClear = new JButton("CLEAR");
        pnlButtons.add(btnClear);
        btnClear.addActionListener(_ -> clearDisplay());

        pnlButtons.add(btnNumbers[0]);

        JButton btnHangUp = new JButton("HANG UP");
        pnlButtons.add(btnHangUp);
        btnHangUp.addActionListener(_ -> hangUp());

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 250);
        setTitle("Swing Phone App - Frame 2");
        setVisible(true);
    }

    private void clearDisplay() {
        strPhoneNumber = "";
        tfDisplay.setText(strPhoneNumber);
    }

    private void hangUp() {
        clearDisplay();
        dispose();
    }

    private class MyNumberButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            strPhoneNumber += e.getActionCommand();
            tfDisplay.setText(strPhoneNumber);
        }
    }
}
