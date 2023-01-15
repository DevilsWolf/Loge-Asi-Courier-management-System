package Cms;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;

public class CourierTrackingGUI extends JFrame {

    JLabel trackingNumLabel, statusLabel;
    JTextField trackingNumField;
    JButton trackButton;
    JTextArea statusArea;

    public CourierTrackingGUI() {
        super("Courier Tracking System");

        //create the labels
        trackingNumLabel = new JLabel("Tracking Number: ");
        statusLabel = new JLabel(" ");

        //create the text field and button
        trackingNumField = new JTextField(20);
        trackButton = new JButton("Track");

        //create the text area
        statusArea = new JTextArea(5, 20);
        statusArea.setEditable(false);

        //create the layout
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        //add the components to the frame
        c.insets = new Insets(5, 5, 5, 5);
        c.gridx = 0;
        c.gridy = 0;
        add(trackingNumLabel, c);

        c.gridx = 1;
        c.gridy = 0;
        add(trackingNumField, c);

        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 2;
        add(trackButton, c);

        c.gridx = 0;
        c.gridy = 2;
        add(statusLabel, c);

        c.gridx = 1;
        c.gridy = 2;
        add(statusArea, c);

        //add action listener to the button
        trackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String trackingNum = trackingNumField.getText();
                String status = getCourierStatus(trackingNum);
                statusArea.setText(status);
            }
        });

        //set the size and make the frame visible
        setSize(720, 480);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

    }

    public String getCourierStatus(String trackingNum) {
        // specify file name
        String fileName = "billformat.txt";
        // initialize status as not found
        String status = "Not Found";
        try {

            //create buffered reader
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            // read file line by line
            String line;
            while ((line = br.readLine()) != null) {
                // split line by comma
                String[] parts = line.split(",");
                // check if first part matches tracking number
                if (parts[9].equals(trackingNum)) {
                    // set status as second part
                    status = parts[10];
                    break;
                }
            }
            // close buffered reader
            br.close();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error: File not found.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading file.");
        }
        return status;
    }

    public static void main(String[] args) {
        new CourierTrackingGUI();
    }
}

            //
