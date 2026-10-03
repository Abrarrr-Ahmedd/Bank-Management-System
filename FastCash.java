package bank_management_system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;

import javax.swing.*;
public class FastCash extends JFrame implements ActionListener {
    String pinnumber;
    JButton deposit,withdrawal,ministate,fastcash,pinchange,balancechk,exit;
    FastCash(String pin){
        this.pinnumber=pin;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Select Withdrawal Amount");
        text.setBounds(200,300,700,35);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        text.setForeground(Color.white);
        image.add(text);

        deposit = new JButton("Tk 100");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

         withdrawal = new JButton("Tk 500");
        withdrawal.setBounds(355,415,150,30);
        withdrawal.addActionListener(this);
        image.add(withdrawal);

        fastcash = new JButton("Tk 1000");
        fastcash.setBounds(170,450,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministate = new JButton("Tk 2000");
        ministate.setBounds(355,450,150,30);
        ministate.addActionListener(this);
        image.add(ministate);

        pinchange = new JButton("Tk 5000");
        pinchange.setBounds(170,485,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balancechk = new JButton("Tk 10000");
        balancechk.setBounds(355,485,150,30);
        balancechk.addActionListener(this);
        image.add(balancechk);

        exit = new JButton("Back");
        exit.setBounds(355,520,150,30);
        exit.addActionListener(this);
        image.add(exit);

        

        

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        


    }

    @Override 
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }else{
    String amount = ((JButton)ae.getSource()).getText().substring(3);

    conn c = new conn();

    try {
        ResultSet rs = c.s.executeQuery(
            "select * from bank where pin = '"+pinnumber+"'"
        );

        int balance = 0;

        while(rs.next()){
            if(rs.getString("type").equals("deposit")){
                balance += Integer.parseInt(rs.getString("amount"));
            }else{
                balance -= Integer.parseInt(rs.getString("amount"));
            }
        }

        if(balance < Integer.parseInt(amount)){
            JOptionPane.showMessageDialog(null, "Insufficient Balance");
            return;
        }

        Date date = new Date();

        String query =
            "INSERT INTO bank values('"+pinnumber+"','"+date+"','withdrawal','"+amount+"')";

        c.s.executeUpdate(query);

        JOptionPane.showMessageDialog(
            null,
            "Tk " + amount + " Debited Successfully"
        );

        setVisible(false);
        new Transactions(pinnumber).setVisible(true);

    } catch (Exception e) {
        System.out.println(e);
    }
}
    }
    public static void main(String[] args) {
        new FastCash("");
    }
}

