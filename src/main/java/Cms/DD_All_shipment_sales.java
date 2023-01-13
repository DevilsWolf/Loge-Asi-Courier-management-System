/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cms;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class DD_All_shipment_sales {

    public static void main(String[] args) {
        Runnable r = new Runnable() {

            public void run() {
                new DD_All_shipment_sales().createUI();
            }
        };

        EventQueue.invokeLater(r);
    }

    public void createUI() {

        try {
            JFrame frame = new JFrame();
            frame.setLayout(new BorderLayout());

            JTable table = new JTable();

            String readLine = null;

            StudentTableModel tableModel = new StudentTableModel();
            File file = new File("bill2.txt"/*Give your File Path here*/);

            FileReader reader = new FileReader(file);
            BufferedReader bufReader = new BufferedReader(reader);

            List<Student> studentList = new ArrayList<Student>();
            while ((readLine = bufReader.readLine()) != null) {
                String[] splitData = readLine.split(",");

                Student student = new Student();
                student.setName(splitData[0]);
                student.setproduct_type(splitData[4]);
                student.setamount(splitData[8]);

                studentList.add(student);
            }

            tableModel.setList(studentList);
            table.setModel(tableModel);

            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.add(new JScrollPane(table));
            frame.setTitle("Total Sales details");
            frame.pack();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);

        } catch (IOException ex) {
        }
    }

    class Student {

        private String name;
        private String product_type;
        private String amount;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getproduct_type() {
            return product_type;
        }

        public void setproduct_type(String number) {
            this.product_type = number;
        }

        public String getamount() {
            return amount;
        }

        public void setamount(String amount) {
            this.amount = amount;
        }
    }

    class StudentTableModel extends AbstractTableModel {

        private List<Student> list = new ArrayList<>();
        private String[] columnNames = {"Name", "Product Type", "Total Amount"};

        public void setList(List<Student> list) {
            this.list = list;
            fireTableDataChanged();
        }

        @Override
        public String getColumnName(int column) {
            return columnNames[column];
        }

        public int getRowCount() {
            return list.size();
        }

        public int getColumnCount() {
            return columnNames.length;
        }

        public Object getValueAt(int rowIndex, int columnIndex) {
            switch (columnIndex) {
                case 0:
                    return list.get(rowIndex).getName();
                case 1:
                    return list.get(rowIndex).getproduct_type();
                case 2:
                    return list.get(rowIndex).getamount();
                default:
                    return null;
            }
        }
    }
}
