package com.example.homework6;

import java.io.*;
import java.net.*;
import java.text.DecimalFormat;

public class TipServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8000);
            System.out.println("Server started at " + new java.util.Date());

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                ClientHandler clientHandler = new ClientHandler(socket);
                Thread thread = new Thread(clientHandler);
                thread.start();
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    private static class ClientHandler implements Runnable {
        //socket
        private Socket socket;
        private DecimalFormat df = new DecimalFormat("0.00");

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
                DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());

                //read input
                double subtotal = inputFromClient.readDouble();
                double tipRate = inputFromClient.readDouble();

                double tipAmount = subtotal * tipRate / 100;
                double total = subtotal + tipAmount;

                outputToClient.writeDouble(tipAmount);
                outputToClient.writeDouble(total);

                //print totals from the client
                System.out.println("Received from client: Subtotal " + df.format(subtotal) + " Tip rate " + df.format(tipRate));
                System.out.println("Sent to client: Tip amount " + df.format(tipAmount) + " Total " + df.format(total));

                socket.close();
                System.out.println("Client disconnected");
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
    }
}
