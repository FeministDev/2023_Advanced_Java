package com.example.midterm2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
//You will need to add the necessary imports.

public class Midterm2 extends Application {

    @Override

    public void start(Stage primaryStage) {

        HBox pane = new HBox();

        pane.setAlignment(Pos.CENTER);

        TextField tfNumber1 = new TextField();

        TextField tfNumber2 = new TextField();

        TextField tfResult = new TextField();

        tfResult.setEditable(false);

        tfNumber1.setPrefColumnCount(3);

        tfNumber2.setPrefColumnCount(3);

        tfResult.setPrefColumnCount(3);



        pane.getChildren().addAll(new Label("Number 1: "), tfNumber1,

                new Label("Number 2: "), tfNumber2, new Label("Result: "), tfResult);



        // Create four buttons

        HBox hBox = new HBox(5);

        Button btAdd = new Button("Add");

        Button btSubtract = new Button("Subtract");

        Button btMultiply = new Button("Multiply");

        Button btDivide = new Button("Divide");

        hBox.setAlignment(Pos.CENTER);

        hBox.getChildren().addAll(btAdd, btSubtract, btMultiply, btDivide);



        BorderPane borderPane = new BorderPane();

        borderPane.setCenter(pane);

        borderPane.setBottom(hBox);

        BorderPane.setAlignment(hBox, Pos.TOP_CENTER);



        // Create a scene and place it in the stage

        Scene scene = new Scene(borderPane, 250, 150);

        primaryStage.setTitle("Calculator"); // Set the stage title

        primaryStage.setScene(scene); // Place the scene in the stage

        primaryStage.show(); // Display the stage



        //put button handling code here. Anonymous inner classes work nicely!
        btAdd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Get nums
                double num1 = Double.parseDouble(tfNumber1.getText());
                double num2 = Double.parseDouble(tfNumber2.getText());

                // Calculate
                double result = num1 + num2;

                // Display result
                tfResult.setText(Double.toString(result));
            }
        });

        btSubtract.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Get nums
                double num1 = Double.parseDouble(tfNumber1.getText());
                double num2 = Double.parseDouble(tfNumber2.getText());

                // Calculate
                double result = num1 - num2;

                // Display
                tfResult.setText(Double.toString(result));
            }
        });

        btMultiply.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //get nums
                double num1 = Double.parseDouble(tfNumber1.getText());
                double num2 = Double.parseDouble(tfNumber2.getText());

                //calculate
                double result = num1 * num2;

                // Display
                tfResult.setText(Double.toString(result));
            }
        });

        btDivide.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    //get nums
                    double num1 = Double.parseDouble(tfNumber1.getText());
                    double num2 = Double.parseDouble(tfNumber2.getText());

                    //calculate
                    double result = num1 / num2;

                    // Display
                    tfResult.setText(Double.toString(result));
                } catch (ArithmeticException e) {
                    //catch error
                    tfResult.setText("You can't divide by zero!");
                }
            }
        });


    }//end start



    public static void main(String[] args) {

        launch(args);

    }

}