package Cms;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Print_Billing_Statements {

    public static void main(String[] args) {
        //create and set up the window
        JFrame frame = new JFrame("Invoice");

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(620, 400);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Color.white);

        //create a panel to hold the data
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.white);

        //create a label that says "Here is your generated invoice"
        JLabel titleLabel = new JLabel("Here is your generated invoice");

        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(titleLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 30)));

        //read the data from the file
        try {
            BufferedReader reader = new BufferedReader(new FileReader("bill2.txt"));
            String line;
            String lastLine = null;
            while ((line = reader.readLine()) != null) {
                //keep the last line in a variable
                lastLine = line;
            }
            if (lastLine != null) {
                //split the last line by comma
                String[] data = lastLine.split(",");
                //loop through the data and add each element to the panel
                for (String element : data) {

                    //JLabel label = new label = new JLabel(element);
                    JLabel label;
                    label = new JLabel(element);

                    label.setFont(new Font("Arial", Font.PLAIN, 18));
                    label.setAlignmentX(Component.CENTER_ALIGNMENT);
                    panel.add(label);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //add the panel to the frame
        frame.add(panel);

        //display the window
        frame.setVisible(true);
    }

}
