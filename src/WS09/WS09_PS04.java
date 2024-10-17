///*
//    4. Develop a GUI (AWT, Swings & JavaFX) application that lets the user enter a file name in the
//text field and press the Enter key to display its binary representation in a text area. The user
//can also modify the binary code and save it back to the file, as shown in below Figure.
// */
//
//package WS09;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//import java.io.*;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.Arrays;
//import java.util.stream.Collectors;
//import javafx.application.Application;
//import javafx.scene.Scene;
//import javafx.scene.control.*;
//import javafx.scene.layout.*;
//import javafx.stage.Stage;
//
//class FileBinaryViewer {
//    public static void main(String[] args) {
//        // Launch Swing GUI
//        SwingUtilities.invokeLater(SwingFileViewer::new);
//
//    }
//}
//
//// Swing Implementation
//class SwingFileViewer {
//
//    JFrame frame;
//
//    public SwingFileViewer() {
//        frame = new JFrame("Swing File Binary Viewer");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(600, 400);
//        frame.setLayout(new BorderLayout());
//
//        JPanel panel = new JPanel();
//        panel.setLayout(new FlowLayout());
//
//        JTextField fileNameField = new JTextField(20);
//        JTextArea binaryTextArea = new JTextArea(15, 50);
//        binaryTextArea.setEditable(true);
//        JScrollPane scrollPane = new JScrollPane(binaryTextArea);
//
//        JButton loadButton = new JButton("Load");
//        JButton saveButton = new JButton("Save");
//
//        panel.add(new JLabel("File Name:"));
//        panel.add(fileNameField);
//        panel.add(loadButton);
//        panel.add(saveButton);
//        frame.add(panel, BorderLayout.NORTH);
//        frame.add(scrollPane, BorderLayout.CENTER);
//
//        loadButton.addActionListener(e -> loadBinaryFile(fileNameField.getText(), binaryTextArea));
//        saveButton.addActionListener(e -> saveBinaryFile(fileNameField.getText(), binaryTextArea.getText()));
//
//        fileNameField.addActionListener(e -> loadBinaryFile(fileNameField.getText(), binaryTextArea));
//
//        frame.setVisible(true);
//    }
//
//    private void loadBinaryFile(String fileName, JTextArea binaryTextArea) {
//        try {
//            byte[] fileBytes = Files.readAllBytes(Paths.get(fileName));
//            String binaryRepresentation = Arrays.stream(fileBytes)
//                    .mapToObj(b -> String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0'))
//                    .collect(Collectors.joining(" "));
//            binaryTextArea.setText(binaryRepresentation);
//        } catch (IOException e) {
//            JOptionPane.showMessageDialog(frame, "File not found or could not be read.", "Error", JOptionPane.ERROR_MESSAGE);
//        }
//    }
//
//    private void saveBinaryFile(String fileName, String binaryData) {
//        String[] binaryStrings = binaryData.split(" ");
//        byte[] bytes = new byte[binaryStrings.length];
//
//        for (int i = 0; i < binaryStrings.length; i++) {
//            bytes[i] = (byte) Integer.parseInt(binaryStrings[i], 2);
//        }
//
//        try (FileOutputStream fos = new FileOutputStream(fileName)) {
//            fos.write(bytes);
//        } catch (IOException e) {
//            JOptionPane.showMessageDialog(frame, "Failed to save the file.", "Error", JOptionPane.ERROR_MESSAGE);
//        }
//    }
//}