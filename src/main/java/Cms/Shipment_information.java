package Cms;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.io.*;

public class Shipment_information extends JFrame {

    public Shipment_information() {
        String[] columnNames = {"Shipment Info"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        JTable table = new JTable(model);
        JScrollPane scrollpane = new JScrollPane(table);
        getContentPane().add(scrollpane);

        try {
            File file = new File("bill.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                model.addRow(data);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 550);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Shipment_information();
    }

}
