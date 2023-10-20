/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Rafael
 */
public class Frame extends JPanel {
    //what an bug
    String[][] data = new Countires().getCountries();
    String[][] checkData = new Countires().getCountries();
    String stringCheck;
    int onClick = 0;

    private Frame() {
        setLayout(null);
        swap_order();
        buttons();
    }

    private void swap_order() {
        Random random = new Random();
        String temp[][] = new String[1][2];
        String tempPair;
        int j;
        for (int i = 0; i < 20; i++) {
            j = random.nextInt(20);
            String temp0 = data[i][0];
            String temp1 = data[i][1];
            
            data[i][0] = data[j][0];
            data[i][1] = data[j][1];
            checkData[i][0] = data[j][0];
            checkData[i][1] = data[j][1];
            
            data[j][0] = temp0;
            data[j][1] = temp1;
            checkData[j][0] = temp0;
            checkData[j][1] = temp1;
        }
        
        for (int i = 0; i < 10; i++) {
            j = random.nextInt(10);
            tempPair = data[i][0];
            data[i][0] = data[j][0];
            data[j][0] = tempPair;

            j = random.nextInt(10);
            tempPair = data[i][1];
            data[i][1] = data[j][1];
            data[j][1] = tempPair;
        }
    }

    private void buttons() {

        int num = 0;
        int numOfPair = 0;
        int zeroORone = 0;
        for (int i = 0; i < 20; i++) {
            if (i != 0 && i % 5 == 0) {num++;}
            if (i != 0 && i % 2 == 0 ) {zeroORone = 0;numOfPair++;}
            else {if (i!=0){zeroORone = 1;}}
            JButton button = new JButton(data[numOfPair][zeroORone]);
            button.setBounds(i % 5 * 120 + 10, num * 70 + 10, 100, 50);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    button.setBackground(Color.red);
                    onClick++;
                    if (onClick % 2 == 0) {
                        int guessed = 0;
                        for (int i = 0; i < 10 ; i++) {
                            System.out.println("MIXED Data " + data[i][1] + " and " + data[i][0]);}
                        for (int i = 0; i < 10 ; i++) {
                            System.out.println("Data " + checkData[i][1] + " and " + checkData[i][0]);
                            if (stringCheck.equals(checkData[i][0]) || stringCheck.equals(checkData[i][1])) {
                               // System.out.println("the button is" + button.getText());
                               // System.out.println("the string is " + stringCheck);
                              //  System.out.println("check data 1:" + checkData[i][1]);
                              //  System.out.println("check data 0:" + checkData[i][0]);
                                if (button.getText().equals(checkData[i][1]) || button.getText().equals(checkData[i][0])) {
                                    JOptionPane.showMessageDialog(button, "You guessed");
                                    guessed = 1;
                                    break;
                                }
                            }
                        }if(guessed==0){JOptionPane.showMessageDialog(button, "Wrong answer");}
                    } else {
                        stringCheck = button.getText();
                        //System.out.print(button.getText());
                        JOptionPane.showMessageDialog(button, "Gess the pair");
                    }

                }
            });
            add(button);
        }
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Pair Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Frame()); // Add the Frame instance to the JFrame

        frame.setSize(620, 320); // Set the initial size of the frame
        frame.setResizable(false);
        frame.setVisible(true);

    }
}
