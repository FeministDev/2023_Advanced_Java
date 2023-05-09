package com.example.hw6;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.io.*;
import java.net.*;


public class TipCalculatorClient extends JFrame implements ActionListener {
    //make Textfields
    private JTextField subtotalField;
    private JTextField tipRateField;
    private JLabel tipAmountLabel;
    private JLabel totalLabel;
    private JButton calculateButton;

    public TipCalculatorClient() {
        super("Tip Calculator");

        // create UI components
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        panel.add(new JLabel("Subtotal:"));
        subtotalField = new JTextField(10);
        panel.add(subtotalField);
        panel.add(new JLabel("Tip rate (%):"));
        tipRateField = new JTextField(10);
        panel.add(tipRateField);
        panel.add(new JLabel("Tip amount:"));
        tipAmountLabel = new JLabel("0.00");
        panel.add(tipAmountLabel);
        panel.add(new JLabel("Total:"));
        totalLabel = new JLabel("0.00");
        panel.add(totalLabel);

        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(this);

        // add components to the frame
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(calculateButton, BorderLayout.SOUTH);

        // configure the frame
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            // get user inputs
            double subtotal = Double.parseDouble(subtotalField.getText());
            double tipRate = Double.parseDouble(tipRateField.getText());

            // create a socket to connect to the server
            Socket socket = new Socket("localhost", 8000);

            // create input and output streams for the socket
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            // send the user inputs to the server
            output.writeDouble(subtotal);
            output.writeDouble(tipRate);

            // receive the tip amount and total from the server
            double tipAmount = input.readDouble();
            double total = input.readDouble();

            // update the UI with the results
            tipAmountLabel.setText(String.format("%.2f", tipAmount));
            totalLabel.setText(String.format("%.2f", total));

            // close the socket
            socket.close();
        } catch (NumberFormatException | IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new TipCalculatorClient();
    }
}