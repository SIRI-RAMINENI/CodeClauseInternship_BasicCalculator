/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject1;

/**
 *
 * @author sirir
 */

import java.awt.*;
import java.awt.event.*;

public class Mavenproject1 implements ActionListener {

    Frame frame;
    TextField result_textField;
    Button[] numberButtons = new Button[10];
    Button[] functionButtons = new Button[9];
    Button addButton, subButton, mulButton, divButton;
    Button decButton, equButton, delButton, clrButton, negButton;
    Panel panel;

    Font myFont = new Font("Arial", Font.BOLD, 30);

    double num1 = 0, num2 = 0, result = 0;
    char operator;

    Mavenproject1() {

        frame = new Frame("Calculator");
        frame.setBackground(Color.WHITE);
        frame.setBounds(700, 200, 400, 600);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });

        result_textField = new TextField();
        result_textField.setFont(myFont);
        result_textField.setEditable(false);
        result_textField.setBackground(Color.BLACK);
        result_textField.setForeground(Color.WHITE);
        result_textField.setText("0");
        frame.add(result_textField, BorderLayout.NORTH);

        panel = new Panel();
        panel.setBackground(Color.BLACK);
        panel.setLayout(new GridLayout(5, 4, 10, 10));

        addButton = new Button("+");
        subButton = new Button("-");
        mulButton = new Button("*");
        divButton = new Button("/");
        decButton = new Button(".");
        equButton = new Button("=");
        delButton = new Button("Del");
        clrButton = new Button("Clr");
        negButton = new Button("(-)");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;

        for (int i = 0; i < 9; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            panel.add(functionButtons[i]);
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new Button(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            panel.add(numberButtons[i]);
        }

        frame.add(panel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                result_textField.setText(result_textField.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decButton) {
            if (!result_textField.getText().contains(".")) {
                result_textField.setText(result_textField.getText().concat("."));
            }
        }
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(result_textField.getText());
            operator = '+';
            result_textField.setText("");
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(result_textField.getText());
            operator = '-';
            result_textField.setText("");
        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(result_textField.getText());
            operator = '*';
            result_textField.setText("");
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(result_textField.getText());
            operator = '/';
            result_textField.setText("");
        }
        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(result_textField.getText());

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        result_textField.setText("Error");
                        return;
                    }
                    break;
            }
            result_textField.setText(String.valueOf(result));
            num1 = result;
        }
        if (e.getSource() == clrButton) {
            result_textField.setText("");
        }
        if (e.getSource() == delButton) {
            String string = result_textField.getText();
            if (!string.isEmpty()) {
                result_textField.setText(string.substring(0, string.length() - 1));
            }
        }
        if (e.getSource() == negButton) {
            double temp = Double.parseDouble(result_textField.getText());
            temp *= -1;
            result_textField.setText(String.valueOf(temp));
        }
    }

    public static void main(String[] args) {
        new Mavenproject1();
    }
}
