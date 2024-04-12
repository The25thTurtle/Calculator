package com.example.lab12;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MegaCalc extends Application {

    private TextField number1Field;
    private TextField number2Field;
    private Label resultLabel;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        GridPane myGrid = new GridPane();
        Scene myScene = new Scene(myGrid, 400, 300);

        number1Field = new TextField();
        number1Field.setPrefWidth(80);
        number2Field = new TextField();
        number2Field.setPrefWidth(80);
        Button add = new Button("+");
        Button clear = new Button("Clear");
        resultLabel = new Label("");

        GridPane.setConstraints(number1Field, 0, 0);
        GridPane.setConstraints(add, 1, 0);
        GridPane.setConstraints(number2Field, 2, 0);
        GridPane.setConstraints(clear, 1, 2,1,1);
        GridPane.setConstraints(resultLabel, 0, 1,1,1);

        add.setOnAction(e -> performAddition());
        clear.setOnAction(e -> clearFields());

        myGrid.getChildren().addAll(number1Field, add, number2Field, clear, resultLabel);

        stage.setScene(myScene);
        stage.setTitle("MegaCalc");
        stage.show();
    }

    private void performAddition() {
        try {
            int num1 = Integer.parseInt(number1Field.getText());
            int num2 = Integer.parseInt(number2Field.getText());
            int result = num1 + num2;
            resultLabel.setText("" + result);
        } catch (NumberFormatException ignored) {

        }
    }

    private void clearFields() {
        number1Field.clear();
        number2Field.clear();
        resultLabel.setText("");
    }
}