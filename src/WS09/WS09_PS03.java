/*
    3. Develop a GUI (AWT, Swings & JavaFX) application that calculates the future value of an
investment at a given interest rate for a specified number of years. The formula for the
calculation is:
futureValue = investmentAmount * (1 + monthlyInterestRate)years*12
Use text fields for the investment amount, number of years, and annual interest rate. Display
the future amount in a text field when the user clicks the Calculate button.
 */

package WS09;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class InterestCalculator {
    public static void main(String[] args) {
        // AWT Frame
        Frame awtFrame = new Frame("AWT Interest Calculator");
        awtFrame.setSize(400, 400);
        awtFrame.setLayout(null);
        awtFrame.setVisible(true);

        AwtInterestCalculator awtInterestCalculator = new AwtInterestCalculator();
        awtInterestCalculator.setBounds(0, 0, 400, 400);
        awtFrame.add(awtInterestCalculator);

        awtFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });

        // Swing Frame
        JFrame swingFrame = new JFrame("Swing Interest Calculator");
        swingFrame.setSize(400, 400);
        swingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SwingInterestCalculator swingInterestCalculator = new SwingInterestCalculator();
        swingFrame.add(swingInterestCalculator);

        swingFrame.setVisible(true);
    }
}

class AwtInterestCalculator extends Panel {
    @Override
    public void paint(Graphics g) {
        setLayout(null);

        Label investmentAmountLabel = new Label("Investment Amount");
        investmentAmountLabel.setBounds(50, 50, 150, 20);
        add(investmentAmountLabel);

        TextField investmentAmountTextField = new TextField();
        investmentAmountTextField.setBounds(200, 50, 150, 20);
        add(investmentAmountTextField);

        Label numberOfYearsLabel = new java.awt.Label("Number of Years");
        numberOfYearsLabel.setBounds(50, 100, 150, 20);
        add(numberOfYearsLabel);

        TextField numberOfYearsTextField = new TextField();
        numberOfYearsTextField.setBounds(200, 100, 150, 20);
        add(numberOfYearsTextField);

        Label annualInterestRateLabel = new Label("Annual Interest Rate");
        annualInterestRateLabel.setBounds(50, 150, 150, 20);
        add(annualInterestRateLabel);

        TextField annualInterestRateTextField = new TextField();
        annualInterestRateTextField.setBounds(200, 150, 150, 20);
        add(annualInterestRateTextField);

        Button calculateButton = new Button("Calculate");
        calculateButton.setBounds(50, 200, 300, 30);
        add(calculateButton);

        Label futureValueLabel = new Label("Future Value");
        futureValueLabel.setBounds(50, 250, 150, 20);
        add(futureValueLabel);

        TextField futureValueTextField = new TextField();
        futureValueTextField.setBounds(200, 250, 150, 20);
        futureValueTextField.setEditable(false);
        add(futureValueTextField);

        calculateButton.addActionListener(e -> {
            double investmentAmount = Double.parseDouble(investmentAmountTextField.getText());
            double numberOfYears = Double.parseDouble(numberOfYearsTextField.getText());
            double annualInterestRate = Double.parseDouble(annualInterestRateTextField.getText());

            double futureValue = investmentAmount * Math.pow(1 + annualInterestRate / 100 / 12, numberOfYears * 12);
            futureValueTextField.setText(String.valueOf(futureValue));
        });
    }
}

class SwingInterestCalculator extends JPanel {
    public SwingInterestCalculator() {
        setLayout(null);

        JLabel investmentAmountLabel = new JLabel("Investment Amount");
        investmentAmountLabel.setBounds(50, 50, 150, 20);
        add(investmentAmountLabel);

        JTextField investmentAmountTextField = new JTextField();
        investmentAmountTextField.setBounds(200, 50, 150, 20);
        add(investmentAmountTextField);

        JLabel numberOfYearsLabel = new JLabel("Number of Years");
        numberOfYearsLabel.setBounds(50, 100, 150, 20);
        add(numberOfYearsLabel);

        JTextField numberOfYearsTextField = new JTextField();
        numberOfYearsTextField.setBounds(200, 100, 150, 20);
        add(numberOfYearsTextField);

        JLabel annualInterestRateLabel = new JLabel("Annual Interest Rate");
        annualInterestRateLabel.setBounds(50, 150, 150, 20);
        add(annualInterestRateLabel);

        JTextField annualInterestRateTextField = new JTextField();
        annualInterestRateTextField.setBounds(200, 150, 150, 20);
        add(annualInterestRateTextField);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.setBounds(50, 200, 300, 30);
        add(calculateButton);

        JLabel futureValueLabel = new JLabel("Future Value");
        futureValueLabel.setBounds(50, 250, 150, 20);
        add(futureValueLabel);

        JTextField futureValueTextField = new JTextField();
        futureValueTextField.setBounds(200, 250, 150, 20);
        futureValueTextField.setEditable(false);
        add(futureValueTextField);

        calculateButton.addActionListener(e -> {
            double investmentAmount = Double.parseDouble(investmentAmountTextField.getText());
            double numberOfYears = Double.parseDouble(numberOfYearsTextField.getText());
            double annualInterestRate = Double.parseDouble(annualInterestRateTextField.getText());

            double futureValue = investmentAmount * Math.pow(1 + annualInterestRate / 100 / 12, numberOfYears * 12);
            futureValueTextField.setText(String.valueOf(futureValue));
        });
    }
}
