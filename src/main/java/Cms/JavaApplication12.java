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

public class JavaApplication12 {

    public static void main(String[] args) {
        Runnable r = new Runnable() {

            public void run() {
                new JavaApplication12().createUI();
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
            File file = new File("D:\\user2.txt"/*Give your File Path here*/);

            FileReader reader = new FileReader(file);
            BufferedReader bufReader = new BufferedReader(reader);

            List<Student> studentList = new ArrayList<Student>();
            while ((readLine = bufReader.readLine()) != null) {
                String[] splitData = readLine.split(",");

                Student student = new Student();
                student.setName(splitData[0]);
                student.setNumber(splitData[1]);

                studentList.add(student);
            }

            tableModel.setList(studentList);
            table.setModel(tableModel);

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new JScrollPane(table));
            frame.setTitle("File to JTable");
            frame.pack();
            frame.setVisible(true);

        } catch (IOException ex) {
        }
    }

    class Student {

        private String name;
        private String number;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }
    }

    class StudentTableModel extends AbstractTableModel {

        private List<Student> list = new ArrayList<Student>();
        private String[] columnNames = {"Name", "Number"};

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
                    return list.get(rowIndex).getNumber();
                default:
                    return null;
            }
        }
    }
}
