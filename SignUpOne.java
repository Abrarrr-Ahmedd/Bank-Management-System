package bank_management_system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.util.*;

public class SignUpOne extends JFrame implements ActionListener {

    long random;
    JTextField nameT, fnameT, emailT, cityT, pincodeT, addressT;
    JButton next;
    JRadioButton male, female, married, unmarried;

    SignUpOne() {
        setLayout(null);

        Random ran = new Random();

        random = Math.abs((ran.nextLong() % 9000L) + 1000L);
        JLabel formno = new JLabel("APPLICATION FORM NO: " + " " + random);
        formno.setBounds(140, 20, 600, 40);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        add(formno);

        JLabel personaldetails = new JLabel("Page 1: Personal details");
        personaldetails.setBounds(290, 80, 400, 30);
        personaldetails.setFont(new Font("Raleway", Font.BOLD, 22));
        add(personaldetails);

        JLabel name = new JLabel("Name: ");
        name.setBounds(100, 140, 100, 30);
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        add(name);

        nameT = new JTextField();
        nameT.setFont(new Font("Raleway", Font.BOLD, 14));
        nameT.setBounds(300, 140, 400, 30);
        add(nameT);

        JLabel fname = new JLabel("Fathers Name: ");
        fname.setBounds(100, 190, 200, 30);
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        add(fname);

        fnameT = new JTextField();
        fnameT.setFont(new Font("Raleway", Font.BOLD, 14));
        fnameT.setBounds(300, 190, 400, 30);
        add(fnameT);

        JLabel gender = new JLabel("Gender:  ");
        gender.setBounds(100, 240, 200, 30);
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300, 240, 60, 30);
        male.setBackground(Color.white);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(450, 240, 120, 30);
        female.setBackground(Color.white);
        add(female);

        ButtonGroup gendeGroup = new ButtonGroup();
        gendeGroup.add(male);
        gendeGroup.add(female);

        JLabel email = new JLabel("Email:  ");
        email.setBounds(100, 290, 200, 30);
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        add(email);

        emailT = new JTextField();
        emailT.setFont(new Font("Raleway", Font.BOLD, 14));
        emailT.setBounds(300, 290, 400, 30);
        add(emailT);

        JLabel marital = new JLabel("Marital Status:  ");
        marital.setBounds(100, 340, 200, 30);
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        add(marital);

        married = new JRadioButton("Married");
        married.setBounds(300, 340, 100, 30);
        married.setBackground(Color.white);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450, 340, 100, 30);
        unmarried.setBackground(Color.white);
        add(unmarried);

        ButtonGroup marriedGroup = new ButtonGroup();
        marriedGroup.add(married);
        marriedGroup.add(unmarried);

        JLabel address = new JLabel("Address: ");
        address.setBounds(100, 390, 200, 30);
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        add(address);

        addressT = new JTextField();
        addressT.setFont(new Font("Raleway", Font.BOLD, 14));
        addressT.setBounds(300, 390, 400, 30);
        add(addressT);

        JLabel city = new JLabel("City: ");
        city.setBounds(100, 440, 200, 30);
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        add(city);

        cityT = new JTextField();
        cityT.setFont(new Font("Raleway", Font.BOLD, 14));
        cityT.setBounds(300, 440, 400, 30);
        add(cityT);

        JLabel pincode = new JLabel("Pin Code: ");
        pincode.setBounds(100, 490, 200, 30);
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        add(pincode);

        pincodeT = new JTextField();
        pincodeT.setFont(new Font("Raleway", Font.BOLD, 14));
        pincodeT.setBounds(300, 490, 400, 30);
        add(pincodeT);

        JButton next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 610, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.white);
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        String formno = "" + random;
        String name = nameT.getText();
        String fname = fnameT.getText();

        String gender = null;

        if (male.isSelected()) {
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        }

        String email = emailT.getText();

        String marital = null;

        if (married.isSelected()) {
            marital = "Married";
        } else if (unmarried.isSelected()) {
            marital = "Unmarried";
        }

        String adress = addressT.getText();
        String city = cityT.getText();
        String pincode = pincodeT.getText();

        try {

            if (name.equals("")) {

                JOptionPane.showMessageDialog(null, "Name is required");

            } else {

                conn c = new conn();

                String query =
                    "INSERT INTO signup VALUES('" +
                    formno + "','" +
                    name + "','" +
                    fname + "','" +
                    gender + "','" +
                    email + "','" +
                    adress + "','" +
                    city + "','" +
                    pincode + "')";

                System.out.println("Running query:");
                System.out.println(query);

                int result = c.s.executeUpdate(query);

                System.out.println("Rows inserted: " + result);

                JOptionPane.showMessageDialog(null, "Data inserted successfully!");

                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }

        } catch (Exception e) {

            e.printStackTrace();

            JOptionPane.showMessageDialog(
                null,
                "Database Error: " + e.getMessage()
            );
        }
    }

    public static void main(String[] args) {
        new SignUpOne();
    }
}