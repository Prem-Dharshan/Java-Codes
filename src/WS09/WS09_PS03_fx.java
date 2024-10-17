package WS09;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

class FxInterestCalculator extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX Interest Calculator");

        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setAlignment(Pos.CENTER);

        Label investmentAmountLabel = new Label("Investment Amount:");
        grid.add(investmentAmountLabel, 0, 0);
        TextField investmentAmountTextField = new TextField();
        grid.add(investmentAmountTextField, 1, 0);

        Label numberOfYearsLabel = new Label("Number of Years:");
        grid.add(numberOfYearsLabel, 0, 1);
        TextField numberOfYearsTextField = new TextField();
        grid.add(numberOfYearsTextField, 1, 1);

        Label annualInterestRateLabel = new Label("Annual Interest Rate:");
        grid.add(annualInterestRateLabel, 0, 2);
        TextField annualInterestRateTextField = new TextField();
        grid.add(annualInterestRateTextField, 1, 2);

        Button calculateButton = new Button("Calculate");
        grid.add(calculateButton, 0, 3, 2, 1);

        Label futureValueLabel = new Label("Future Value:");
        grid.add(futureValueLabel, 0, 4);
        TextField futureValueTextField = new TextField();
        futureValueTextField.setEditable(false);
        grid.add(futureValueTextField, 1, 4);

        calculateButton.setOnAction(e -> {
            double investmentAmount = Double.parseDouble(investmentAmountTextField.getText());
            double numberOfYears = Double.parseDouble(numberOfYearsTextField.getText());
            double annualInterestRate = Double.parseDouble(annualInterestRateTextField.getText());

            double futureValue = investmentAmount * Math.pow(1 + annualInterestRate / 100 / 12, numberOfYears * 12);
            futureValueTextField.setText(String.valueOf(futureValue));
        });

        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
