package GUI;

import javax.swing.*;
import java.awt.*;

public class AppletLifeCycle extends JPanel {

    // Initialization method
    public void init() {
        System.out.println("init(): Application is being initialized.");
    }

    // Start method
    public void start() {
        System.out.println("start(): Application has started.");
    }

    // Paint method
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);  // Call superclass paint
        System.out.println("paint(): Application is being redrawn.");
        g.drawString("Applet Lifecycle Demo (Swing)", 20, 20);
    }

    @Override
    public void update(Graphics g) {
        System.out.println("update(): Application is being updated.");
        paintComponent(g);
        g.drawString("Applet Lifecycle Demo (Swing)", 20, 20);
    }

    // Stop method
    public void stop() {
        System.out.println("stop(): Application is stopping.");
    }

    // Destroy method
    public void destroy() {
        System.out.println("destroy(): Application is being destroyed.");
    }

    public static void main(String[] args) {
        // Create a JFrame to hold the applet
        JFrame frame = new JFrame("Applet Lifecycle Demo (Swing)");
        AppletLifeCycle app = new AppletLifeCycle();

        // Initialize the applet
        app.init();

        // Setup the frame layout and properties
        frame.setLayout(new BorderLayout());
        frame.setBounds(100, 100, 400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create and add UI components
        createUIComponents(frame, app);

        // Add the applet to the frame
        frame.add(app, BorderLayout.CENTER);
        frame.setVisible(true);

        // Start the applet
        app.start();
        app.update(app.getGraphics());  // Call update method

        // Set background and foreground colors
        app.setBackground(new Color(0x00FF00 ^ Color.WHITE.getRGB()));  // Set background color to green
        app.setForeground(Color.WHITE);
        app.paintComponent(app.getGraphics());  // Call paint method

        // Add a shutdown hook to simulate the stop() and destroy() methods on close
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            app.stop();  // Simulate stop method
            app.destroy();  // Simulate destroy method
        }));
    }

    // Method to create and add UI components to the frame
    private static void createUIComponents(JFrame frame, AppletLifeCycle app) {
        // Create a panel for UI components with BoxLayout
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Vertical BoxLayout

        // Create and add components
        TextArea textArea = new TextArea("Status: ", 5, 30, TextArea.SCROLLBARS_NONE);
        textArea.append("Hello, World!");

        // Create CheckboxGroup and checkboxes
        CheckboxGroup checkboxGroup = new CheckboxGroup();
        Checkbox checkbox1 = new Checkbox("Option 1", checkboxGroup, true);
        Checkbox checkbox2 = new Checkbox("Option 2", checkboxGroup, false);
        Checkbox checkbox3 = new Checkbox("Option 3", checkboxGroup, false);

        // Add labels for checkboxes
        panel.add(new Label("Choose one option:"));
        panel.add(checkbox1);
        panel.add(Box.createRigidArea(new Dimension(0, 5))); // Spacer
        panel.add(checkbox2);
        panel.add(Box.createRigidArea(new Dimension(0, 5))); // Spacer
        panel.add(checkbox3);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Spacer

        // Check if the first checkbox is selected
        boolean isOption1Selected = checkboxGroup.getSelectedCheckbox().getLabel().equals("Option 1");
        textArea.append("\nOption 1 selected: " + isOption1Selected);

        // Add label and choice dropdown
        panel.add(new Label("Select an option:"));
        Choice choice = new Choice();
        choice.add("Option 1");
        choice.add("Option 2");
        choice.add("Option 3");
        panel.add(choice);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Spacer

        // Add multiple choice list
        panel.add(new Label("Select multiple options:"));
        List list = new List(3, true);
        list.add("Option 1");
        list.add("Option 2");
        list.add("Option 3");
        panel.add(list);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Spacer

        // Add text area to the panel
        panel.add(textArea);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Spacer

        // Add a label for scrollbar
        panel.add(new Label("Adjust the scrollbar:"));
        Scrollbar scrollbar = new Scrollbar(Scrollbar.HORIZONTAL, 0, 1, 0, 100);
        panel.add(scrollbar);

        // Add panel to the frame
        frame.add(panel, BorderLayout.WEST);
    }
}
