package bank_management_system;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.sql.*;

public class MiniStatement extends JFrame{
    String pin;
    MiniStatement(String pin){
        this.pin=pin;
        setLayout(null);
       setTitle("Mini Statement");

        JLabel text = new JLabel();
        add(text);

        JLabel bnk = new JLabel("Brac Bank");
        bnk.setBounds(150,20,100,20);
        add(bnk);

        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);

        try {
            conn c = new conn();
            ResultSet rs=c.s.executeQuery("select * from login where pin= '"+pin+"'");
             while(rs.next()){
                card.setText("Card Number: " + rs.getString("cardnumber").substring(0,4)+"XXXXXXXX"+ rs.getString("cardnumber").substring(12,16) );

             }
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pin+"'");
            while(rs.next()){
               text.setText(text.getText()+"<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp&nbsp&nbsp&nbsp;"+rs.getString("amount")+"<br><br> <html>");
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        text.setBounds(20,140,400,200);


        
        setSize(400, 600);
        setLocation(350,200);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }
    public static void main(String[] args) {
        new MiniStatement("");
    }
}
