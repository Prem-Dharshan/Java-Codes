package GUI;

import javax.swing.*;
import java.awt.*;

public class Layout {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Layout Manager Demo");
        frame.setSize(600, 400); // Increased size for better visibility
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a main panel with BorderLayout
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem openMenuItem = new JMenuItem("Open");
        JMenuItem saveMenuItem = new JMenuItem("Save");
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);
        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);

        // Checkbox Menu item
        JMenu viewMenu = new JMenu("View");
        JCheckBoxMenuItem checkBoxMenuItem = new JCheckBoxMenuItem("Show Toolbar");
        viewMenu.add(checkBoxMenuItem);
        menuBar.add(viewMenu);

        // Radio Button Menu item
        JMenu helpMenu = new JMenu("Help");
        ButtonGroup buttonGroup = new ButtonGroup();
        JRadioButtonMenuItem radioButtonMenuItem1 = new JRadioButtonMenuItem("Option 1");
        JRadioButtonMenuItem radioButtonMenuItem2 = new JRadioButtonMenuItem("Option 2");
        buttonGroup.add(radioButtonMenuItem1);
        buttonGroup.add(radioButtonMenuItem2);
        helpMenu.add(radioButtonMenuItem1);
        helpMenu.add(radioButtonMenuItem2);
        menuBar.add(helpMenu);



        // Create a FlowLayout panel and add buttons
//        JPanel flowPanel = new JPanel();
//        flowPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10)); // Center alignment with gaps
//        for (int i = 0; i < 10; i++) {
//            flowPanel.add(new JButton("Button " + i));
//        }
//        mainPanel.add(flowPanel, BorderLayout.NORTH); // Add FlowLayout panel to the north

        // Create a GridLayout panel
//        JPanel gridPanel = new JPanel();
//        gridPanel.setLayout(new GridLayout(2, 2, 10, 10)); // 2x2 grid with gaps
//        gridPanel.add(new JButton("Button 1"));
//        gridPanel.add(new JButton("Button 2"));
//        gridPanel.add(new JPanel());
//        gridPanel.add(new JButton("Button 4"));
//        gridPanel.setBackground(Color.CYAN);
//        mainPanel.add(gridPanel, BorderLayout.CENTER); // Add GridLayout panel to the center

        // Create a BorderLayout panel
//        JPanel borderPanel = new JPanel();
//        borderPanel.setLayout(new BorderLayout());
//        borderPanel.setBackground(Color.PINK);
//        borderPanel.add(new JButton("North"), BorderLayout.NORTH);
//        borderPanel.add(new JButton("South"), BorderLayout.SOUTH);
//        borderPanel.add(new JButton("East"), BorderLayout.EAST);
//        borderPanel.add(new JButton("West"), BorderLayout.WEST);
//        borderPanel.add(new JButton("Center"), BorderLayout.CENTER);
//        mainPanel.add(borderPanel, BorderLayout.SOUTH); // Add BorderLayout panel to the south

        // Card Layout
        JPanel cardPanel = new JPanel();
        cardPanel.setLayout(new CardLayout());
        cardPanel.add(new JButton("Card 1"), "Card 1");

        // Add buttons to switch between cards
        JButton card1Button = new JButton("Card 1");
        card1Button.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) cardPanel.getLayout();
            cardLayout.show(cardPanel, "Card 1");
        });

        JButton card2Button = new JButton("Card 2");
        card2Button.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) cardPanel.getLayout();
            cardLayout.show(cardPanel, "Card 2");
        });

        JButton card3Button = new JButton("Card 3");
        card3Button.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) cardPanel.getLayout();
            cardLayout.show(cardPanel, "Card 3");
        });

        cardPanel.add(new JButton("Card 2"), "Card 2");
        cardPanel.add(new JButton("Card 3"), "Card 3");
        mainPanel.add(cardPanel, BorderLayout.WEST); // Add CardLayout panel to the west

        // Add the main panel to the frame
        frame.add(mainPanel);
        frame.setVisible(true);
    }
}
