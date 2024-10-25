package WS09;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.SwingUtilities;

class BinaryEditor {
    public static void main() {
        SwingUtilities.invokeLater(() -> new BinaryEditorComponent().setVisible(true));
    }
}


class BinaryEditorComponent extends JFrame {
    private final JTextField fileNameField;
    private final JTextArea binaryTextArea;

    public BinaryEditorComponent() {
        setTitle("Binary Editor");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        fileNameField = new JTextField(20);
        binaryTextArea = new JTextArea();
        binaryTextArea.setEditable(true);
        binaryTextArea.setLineWrap(true);
        binaryTextArea.setWrapStyleWord(true);

        binaryTextArea.setPreferredSize(new Dimension(400, 250));

        JButton loadButton = new JButton("Load");
        JButton saveButton = new JButton("Save");

        loadButton.addActionListener(_ -> loadFile());

        saveButton.addActionListener(_ -> saveFile());

        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.add(new JLabel("File Name:"));
        topPanel.add(fileNameField);
        topPanel.add(loadButton);
        topPanel.add(saveButton);

        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(binaryTextArea), BorderLayout.CENTER);
    }

    private void loadFile() {
        String fileName = fileNameField.getText();
        try {
            Path filePath = Paths.get(fileName);
            byte[] fileBytes = Files.readAllBytes(filePath);
            String binaryRepresentation = bytesToBinary(fileBytes);
            binaryTextArea.setText(binaryRepresentation);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error loading file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void saveFile() {
        String fileName = fileNameField.getText();
        String binaryCode = binaryTextArea.getText();
        try {
            byte[] modifiedBytes = binaryToBytes(binaryCode);
            Path filePath = Paths.get(fileName);
            Files.write(filePath, modifiedBytes);
            JOptionPane.showMessageDialog(this, "File saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private String bytesToBinary(byte[] bytes) {
        StringBuilder binaryStringBuilder = new StringBuilder();
        for (byte b : bytes) {
            String binaryString = String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0');
            binaryStringBuilder.append(binaryString);
        }
        return binaryStringBuilder.toString();
    }

    private byte[] binaryToBytes(String binary) {
        String[] binaryArray = binary.split("\n");
        byte[] result = new byte[binaryArray.length];
        for (int i = 0; i < binaryArray.length; i++) {
            String byteStr = binaryArray[i].replace("(", "").replace(")", "").trim();
            result[i] = (byte) Integer.parseInt(byteStr, 2);
        }
        return result;
    }
}
