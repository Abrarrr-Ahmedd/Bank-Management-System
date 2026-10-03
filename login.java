package bank_management_system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;

public class login extends JFrame implements ActionListener {

    JButton login,signup,clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    login(){

        setLayout(null);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/brac.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);

        JLabel text = new JLabel("Welcome to Brac");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);


        JLabel cardno = new JLabel("Card No: ");
        cardno.setFont(new Font("Osward",Font.BOLD,28));
        cardno.setBounds(120,150,150,30);
        add(cardno);

        cardTextField = new JTextField();
        cardTextField.setBounds(300,150,230,30);
        add(cardTextField);


        JLabel pin = new JLabel("Pin: ");
        pin.setFont(new Font("Osward",Font.BOLD,28));
        pin.setBounds(120,220,250,30);
        add(pin);

         pinTextField = new JPasswordField();
         pinTextField.setBounds(300,220,230,30);
        add(pinTextField);


        login = new JButton("Sign in");
        login.setBounds(300,300,100,30);
        add(login);
        login.addActionListener(this);


        clear = new JButton("Clear");
        clear.setBounds(430,300,100,30);
        add(clear);
        clear.addActionListener(this);

        signup= new JButton("SIGN Up");
        signup.setBounds(300,350,230,30);
        add(signup);
        signup.addActionListener(this);


        getContentPane().setBackground(Color.white);


        setTitle("Bank Management System");
        setSize(800, 500);
        setVisible(true);
        setLocation(350,200);


    }
    @Override
   
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==clear){
            cardTextField.setText("");
            pinTextField.setText("");

        }else if(ae.getSource()==login){
            conn c = new conn();
            String cardnum = cardTextField.getText();
            String pinnum = pinTextField.getText();
            String query = "select*from login where cardnumber= '"+cardnum+"'and pin = '"+pinnum+"'";
            
            try {
               ResultSet rs=c.s.executeQuery(query);

               if(rs.next()){
                setVisible(false);
                new Transactions(pinnum).setVisible(true);
               }else{
                JOptionPane.showMessageDialog(null, "Incorrect Card number or Pin");
               }
            } catch (Exception e) {
               System.out.println(e);
            }

        }else if(ae.getSource()==signup){
            new SignUpOne();

        }

    }
    public static void main(String[] args) {
        new login();
    }
}
