package bank_management_system;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener{
    String pin;
    JButton back;
    BalanceEnquiry(String pinchange){
        this.pin=pinchange;

        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance( 900, 900, Image.SCALE_DEFAULT );
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3); 
        img.setBounds(0, 0, 900, 900);
        add(img);


        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        img.add(back);
        conn c = new conn();
        int balance = 0;
        try {
        ResultSet rs = c.s.executeQuery(
            "select * from bank where pin = '"+pin+"'"
        );

        

        while(rs.next()){
            if(rs.getString("type").equals("deposit")){
                balance += Integer.parseInt(rs.getString("amount"));
            }else{
                balance -= Integer.parseInt(rs.getString("amount"));
            }
        }
    }catch(Exception e){
            System.out.println(e);
        }

        

        JLabel txt = new JLabel("Your Current Account Balance is Tk " + balance );
        txt.setForeground(Color.white);
        txt.setBounds(170,300,400,30);
        img.add(txt);


        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transactions(pin).setVisible(true);
    }
    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}
