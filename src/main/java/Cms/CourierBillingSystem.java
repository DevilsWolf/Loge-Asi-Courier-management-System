package Cms;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class CourierBillingSystem extends JFrame implements ActionListener {

    private JLabel lblFullName, lblEmail, lblPhone, lblPickupLocation, lblDeliveryLocation, lblProductType, lblWeight, lblTotal, lblModeOfTransport;
    private JTextField txtFullName, txtEmail, txtPhone, txtPickupLocation, txtDeliveryLocation, txtWeight, txtTotal;
    private JCheckBox cbxDocument, cbxFood, cbxClothing, cbxElectronicDevice, cbxFurnisher;
    private JButton btnGenerate, btnReset;
    private String fullName, email, phone, pickupLocation, deliveryLocation, productType, weight, modeOfTransport;
    private double total;
    private JRadioButton rdbAir, rdbBike, rdbBus, rdbVan;

    /**
     *
     */
    public CourierBillingSystem() {
        setTitle("Courier Billing System");
        setSize(1000, 600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        lblFullName = new JLabel("Full Name:");
        lblFullName.setBounds(50, 30, 100, 30);
        add(lblFullName);

        txtFullName = new JTextField();
        txtFullName.setBounds(150, 30, 200, 30);
        add(txtFullName);

        lblEmail = new JLabel("Email:");
        lblEmail.setBounds(50, 70, 100, 30);
        add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(150, 70, 200, 30);
        add(txtEmail);

        lblPhone = new JLabel("Phone:");
        lblPhone.setBounds(50, 110, 100, 30);
        add(lblPhone);

        txtPhone = new JTextField();
        txtPhone.setBounds(150, 110, 200, 30);
        add(txtPhone);

        lblPickupLocation = new JLabel("Pickup Location:");
        lblPickupLocation.setBounds(50, 150, 100, 30);
        add(lblPickupLocation);

        txtPickupLocation = new JTextField();
        txtPickupLocation.setBounds(150, 150, 200, 30);
        add(txtPickupLocation);

        lblDeliveryLocation = new JLabel("Delivery Location:");
        lblDeliveryLocation.setBounds(50, 190, 100, 30);
        add(lblDeliveryLocation);

        txtDeliveryLocation = new JTextField();
        txtDeliveryLocation.setBounds(150, 190, 200, 30);
        add(txtDeliveryLocation);

        lblProductType = new JLabel("Product Type:");
        lblProductType.setBounds(50, 230, 100, 30);
        add(lblProductType);

        cbxDocument = new JCheckBox("Document/Files");
        cbxDocument.setBounds(150, 230, 200, 30);
        add(cbxDocument);

        cbxFood = new JCheckBox("Food/Fruits");
        cbxFood.setBounds(150, 260, 200, 30);
        add(cbxFood);

        cbxClothing = new JCheckBox("Clothing");
        cbxClothing.setBounds(150, 290, 200, 30);
        add(cbxClothing);

        cbxElectronicDevice = new JCheckBox("Electronic Device");
        cbxElectronicDevice.setBounds(150, 320, 200, 30);
        add(cbxElectronicDevice);

        cbxFurnisher = new JCheckBox("Furnisher");
        cbxFurnisher.setBounds(150, 350, 200, 30);
        add(cbxFurnisher);

        lblWeight = new JLabel("Weight /kg:");
        lblWeight.setBounds(400, 230, 100, 30);
        add(lblWeight);

        txtWeight = new JTextField();
        txtWeight.setBounds(500, 230, 50, 30);
        add(txtWeight);

        lblTotal = new JLabel("Total:");
        lblTotal.setBounds(400, 270, 100, 30);
        add(lblTotal);

        txtTotal = new JTextField();
        txtTotal.setBounds(500, 270, 50, 30);
        txtTotal.setEditable(false);
        add(txtTotal);

        lblModeOfTransport = new JLabel("Mode of Transport:");
        lblModeOfTransport.setBounds(400, 310, 100, 30);
        add(lblModeOfTransport);

        rdbAir = new JRadioButton("Air");
        rdbAir.setBounds(500, 310, 50, 30);
        add(rdbAir);

        rdbBike = new JRadioButton("Bike");
        rdbBike.setBounds(550, 310, 50, 30);
        add(rdbBike);

        rdbBus = new JRadioButton("Bus");
        rdbBus.setBounds(500, 340, 50, 30);
        add(rdbBus);

        rdbVan = new JRadioButton("Van");
        rdbVan.setBounds(550, 340, 50, 30);
        add(rdbVan);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rdbAir);
        bg.add(rdbBike);
        bg.add(rdbBus);
        bg.add(rdbVan);

        btnGenerate = new JButton("Generate");
        btnGenerate.setBounds(400, 380, 100, 30);
        btnGenerate.addActionListener(this);
        add(btnGenerate);

        btnReset = new JButton("Reset");
        btnReset.setBounds(500, 380, 100, 30);
        btnReset.addActionListener(this);
        add(btnReset);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnGenerate) {
            fullName = txtFullName.getText();
            email = txtEmail.getText();
            phone = txtPhone.getText();
            pickupLocation = txtPickupLocation.getText();
            deliveryLocation = txtDeliveryLocation.getText();
            weight = txtWeight.getText();
            total = 0;
            productType = "";
            modeOfTransport = "";

            if (cbxDocument.isSelected()) {
                productType += cbxDocument.getText() + ",";
                total += 40;
            }
            if (cbxFood.isSelected()) {
                productType += cbxFood.getText() + ",";
                total += Double.parseDouble(weight) * 60;
            }
            if (cbxClothing.isSelected()) {
                productType += cbxClothing.getText() + ",";
                total += 60;
            }
            if (cbxElectronicDevice.isSelected()) {
                productType += cbxElectronicDevice.getText() + ",";
                total += 80;
            }
            if (cbxFurnisher.isSelected()) {
                productType += cbxFurnisher.getText() + ",";
                total += Double.parseDouble(weight) * 200;
            }

            if (rdbAir.isSelected()) {
                modeOfTransport = rdbAir.getText();
            } else if (rdbBike.isSelected()) {
                modeOfTransport = rdbBike.getText();
            } else if (rdbBus.isSelected()) {
                modeOfTransport = rdbBus.getText();
            } else if (rdbVan.isSelected()) {
                modeOfTransport = rdbVan.getText();
            }

            txtTotal.setText(Double.toString(total));

            try {
                FileWriter fw = new FileWriter("Bill.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write("Full Name: " + fullName);
                bw.newLine();
                bw.write("Email: " + email);
                bw.newLine();
                bw.write("Phone: " + phone);
                bw.newLine();
                bw.write("Pickup Location: " + pickupLocation);
                bw.newLine();
                bw.write("Delivery Location: " + deliveryLocation);
                bw.newLine();
                bw.write("Product Type: " + productType);
                bw.newLine();
                bw.write("Weight: " + weight + "Kg");
                bw.newLine();
                bw.write("Mode Of Transport: " + modeOfTransport);
                bw.newLine();
                bw.write("Total: " + total + "Taka");
                bw.newLine();
                int var1 = generateRandomTrackingNumber();
                bw.write("Pickup Driver Name: " + generateRandomName());
                bw.newLine();
                //bw.write("Tracking Number: " + generateRandomTrackingNumber());
                bw.write("Tracking Number: " + var1);
                bw.newLine();
                //Ading space 
                bw.write("\n\n");
                bw.close();
                fw.close();
                FileWriter fw2 = new FileWriter("bill2.txt", true);
                BufferedWriter bw2 = new BufferedWriter(fw2);
                bw2.write("\n" + fullName + "," + email + "," + pickupLocation + "," + deliveryLocation + "," + productType + "," + weight + "," + modeOfTransport + "," + total + "," + var1);
                bw2.close();
                fw2.close();

                //Experimental Code ahead
                //FileWriter fw3 = new FileWriter("BillType.txt", true);
                //BufferedWriter bw3 = new BufferedWriter(fw3);
                //bw3.write("\n" + fullName + "/" + email + "/" + pickupLocation + "/" + deliveryLocation + "/" + productType + "/" + weight + "/" + modeOfTransport + "/" + total + "/" + var1);
                //bw3.close();
                //fw3.close();
                //Experimental Code finished
                JOptionPane.showMessageDialog(null, "Generated Successfully");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == btnReset) {
            txtFullName.setText("");
            txtEmail.setText("");
            txtPhone.setText("");
            txtPickupLocation.setText("");
            txtDeliveryLocation.setText("");
            cbxDocument.setSelected(false);
            cbxFood.setSelected(false);
            cbxClothing.setSelected(false);
            cbxElectronicDevice.setSelected(false);
            cbxFurnisher.setSelected(false);
            txtWeight.setText("");
            txtTotal.setText("");
            rdbAir.setSelected(false);
            rdbBike.setSelected(false);
            rdbBus.setSelected(false);
            rdbVan.setSelected(false);
        }
    }

    public static void main(String[] args) {
        CourierBillingSystem frame = new CourierBillingSystem();
        frame.setVisible(true);
    }

    public static String generateRandomName() {
        Random rand = new Random();
        String name = "";
        int randomNumber = rand.nextInt(10);
        switch (randomNumber) {
            case 0:
                name = "Rafiq Mia";
                break;
            case 1:
                name = "Abbas Ali";
                break;
            case 2:
                name = "Kuddus Mia";
                break;
            case 3:
                name = "Abdul Aziz";
                break;
            case 4:
                name = "Shafiqul Islam";
                break;
            //case 5:
            //name = "Steven";
            //break;
            //case 6:
            //name = "Tom";
            //break;
            //case 7:
            //name = "Michael";
            //break;
            //case 8:
            //name = "Joseph";
            //break;
            //case 9:
            //name = "Richard";
            //break;
        }
        return name;
    }

    public static int generateRandomTrackingNumber() {
        Random rand = new Random();
        return rand.nextInt(10000);

    }
}
