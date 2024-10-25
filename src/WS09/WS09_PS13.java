package WS09;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class WS09_PS13 extends Application {

    private final int orderId = 1; // Order ID
    private TextArea outputArea;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Bistro Pizza Hut Calculator");

        // Main layout
        BorderPane mainLayout = new BorderPane();

        // Left Pane
        GridPane leftPane = new GridPane();
        leftPane.setPadding(new Insets(10));
        leftPane.setVgap(10);
        leftPane.setHgap(10);
        leftPane.setAlignment(Pos.TOP_LEFT);

        // Customer Details
        Label lblOrderNo = new Label("Order No:");
        TextField txtOrderNo = new TextField(String.valueOf(orderId));
        txtOrderNo.setEditable(false);

        Label lblCustomerName = new Label("Customer Name:");
        TextField txtCustomerName = new TextField();

        Label lblQuantity = new Label("Quantity:");
        TextField txtQuantity = new TextField();

        // Pizza Type Checkboxes
        Label lblPizzaType = new Label("Pizza Type:");
        CheckBox chkPanPizza = new CheckBox("Pan Pizza");
        CheckBox chkStuffedCrust = new CheckBox("Stuffed Crust");
        CheckBox chkRegular = new CheckBox("Regular");

        // Add components to left pane
        leftPane.add(lblOrderNo, 0, 0);
        leftPane.add(txtOrderNo, 1, 0);
        leftPane.add(lblCustomerName, 0, 1);
        leftPane.add(txtCustomerName, 1, 1);
        leftPane.add(lblQuantity, 0, 2);
        leftPane.add(txtQuantity, 1, 2);
        leftPane.add(lblPizzaType, 0, 3);
        leftPane.add(chkPanPizza, 0, 4);
        leftPane.add(chkStuffedCrust, 0, 5);
        leftPane.add(chkRegular, 0, 6);

        // Right Pane with GridPane for labels and text fields
        GridPane rightPane = new GridPane();
        rightPane.setPadding(new Insets(10));
        rightPane.setVgap(10);
        rightPane.setHgap(10);
        rightPane.setAlignment(Pos.TOP_LEFT);

        // Rate
        Label lblRate = new Label("Rate:");
        TextField txtRate = new TextField();

        // Amount
        Label lblAmount = new Label("Amount:");
        TextField txtAmount = new TextField();

        // Cost of Toppings
        Label lblToppingsCost = new Label("Cost of Toppings:");
        TextField txtToppingsCost = new TextField();

        // Toppings Checkboxes
        CheckBox chkOnion = new CheckBox("Onion");
        CheckBox chkCheese = new CheckBox("Cheese");
        CheckBox chkTomato = new CheckBox("Tomato");
        CheckBox chkBabyCorn = new CheckBox("Baby Corn");

        // Add components to right pane
        rightPane.add(lblRate, 0, 0);
        rightPane.add(txtRate, 1, 0);
        rightPane.add(lblAmount, 0, 1);
        rightPane.add(txtAmount, 1, 1);
        rightPane.add(lblToppingsCost, 0, 2);
        rightPane.add(txtToppingsCost, 1, 2);
        rightPane.add(chkOnion, 0, 3);
        rightPane.add(chkCheese, 0, 4);
        rightPane.add(chkTomato, 0, 5);
        rightPane.add(chkBabyCorn, 0, 6);

        // Buttons
        Button btnClear = new Button("Clear");
        btnClear.setOnAction(_ -> clearFields(txtCustomerName, txtQuantity, txtRate, txtAmount, txtToppingsCost));

        Button btnGenerateBill = new Button("Generate Bill");
        btnGenerateBill.setOnAction(_ -> generateBill(txtCustomerName, txtQuantity, txtRate, txtToppingsCost, chkPanPizza, chkStuffedCrust, chkRegular));

        rightPane.add(btnClear, 0, 7);

        leftPane.add(btnGenerateBill, 1, 7);

        // Output area
        outputArea = new TextArea();
        outputArea.setEditable(false);
        outputArea.setPrefHeight(100);
        outputArea.setPrefWidth(200);
        outputArea.maxHeight(100);
        outputArea.maxWidth(200);
        outputArea.setWrapText(true);
        outputArea.setPromptText("Hello, your order ID is: " + orderId);

        // Add panes and output area to main layout
        mainLayout.setLeft(leftPane);
        mainLayout.setRight(rightPane);
        mainLayout.setBottom(outputArea);

        Scene scene = new Scene(mainLayout, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void clearFields(TextField txtCustomerName, TextField txtQuantity, TextField txtRate, TextField txtAmount, TextField txtToppingsCost) {
        txtCustomerName.clear();
        txtQuantity.clear();
        txtRate.clear();
        txtAmount.clear();
        txtToppingsCost.clear();
        outputArea.clear();
        outputArea.setPromptText("Hello, your order ID is: " + orderId);
    }

    private void generateBill(TextField txtCustomerName, TextField txtQuantity, TextField txtRate, TextField txtToppingsCost,
                              CheckBox chkPanPizza, CheckBox chkStuffedCrust, CheckBox chkRegular) {
        String customerName = txtCustomerName.getText();
        String quantityStr = txtQuantity.getText();
        String rateStr = txtRate.getText();
        String toppingsCostStr = txtToppingsCost.getText();

        double quantity = quantityStr.isEmpty() ? 0 : Double.parseDouble(quantityStr);
        double toppingsCost = toppingsCostStr.isEmpty() ? 0 : Double.parseDouble(toppingsCostStr);

        double pizzaRate = 0;
        if (chkPanPizza.isSelected()) pizzaRate = 200;
        if (chkStuffedCrust.isSelected()) pizzaRate = 300;
        if (chkRegular.isSelected()) pizzaRate = 150;

        double totalAmount = (pizzaRate * quantity) + toppingsCost;

        outputArea.setText("Hello, your order ID is: " + orderId + "\n" +
                "Name: " + customerName + "\n" +
                "Amount Payable: $" + totalAmount);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
