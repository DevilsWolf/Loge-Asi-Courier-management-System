/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cms;

import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author USER
 */
public class JavaApplication {

    public static void main(String[] args) {
        FileReader reader = null;

        JFrame f = new JFrame("Password Field Example");
        JFrame f2 = new JFrame("Page 2");
        final JLabel label = new JLabel();
        label.setBounds(20, 150, 200, 50);
        final JPasswordField value = new JPasswordField();
        value.setBounds(100, 75, 100, 30);
        JLabel l1 = new JLabel("Username:");
        l1.setBounds(20, 20, 80, 30);
        JLabel l2 = new JLabel("Password:");
        l2.setBounds(20, 75, 80, 30);
        JButton b = new JButton("Login");
        b.setBounds(100, 120, 80, 30);
        final JTextField text = new JTextField();
        text.setBounds(100, 20, 100, 30);
        JButton b1 = new JButton("Back");
        b1.setBounds(100, 120, 80, 30);
        f.add(value);
        f.add(l1);
        f.add(label);
        f.add(l2);
        f.add(b);
        f.add(text);
        f2.add(b1);
        f.setSize(300, 300);
        f.setLayout(null);
        f.setVisible(true);
        f2.setSize(300, 300);
        f2.setLayout(null);
        f2.setVisible(false);
        f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                File file = new File("D:\\user.txt");
                try {
                    String userName = text.getText();
                    String password = new String(value.getPassword());
                    Scanner input = new Scanner(file);
                    String user = input.nextLine();
                    String pass = input.nextLine();

                    if (userName.equals(user) && password.equals(pass)) {
                        f.setVisible(false);
                        f2.setVisible(true);
                    } else {
                        label.setText("Incorrect Password or Username");
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(JavaApplication10.class.getName()).log(Level.SEVERE, null, ex);
                }

                // label.setText(data);
            }
        });
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                f2.setVisible(false);
                f.setVisible(true);
            }
        });

    }

}
