package bank_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
public class Signupthree extends JFrame implements ActionListener{
    String formno;
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    Signupthree(String formno){
        this.formno=formno;

        setLayout(null);

        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(280,40,400,40);
        add(l1);

         JLabel type = new JLabel("Account Type");
        type.setFont(new Font("Raleway",Font.BOLD,22));
        type.setBounds(100,140,200,30);
        add(type);

        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100,180,250,20);
        add(r1);

        r2 = new JRadioButton("Fixed Deposit");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350,180,250,20);
        add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100,220,250,20);
        add(r3);

        r4 = new JRadioButton("Recurring Depost Account");
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350,220,250,20);
        add(r4);

        ButtonGroup groupAcc = new ButtonGroup();
        groupAcc.add(r1);
        groupAcc.add(r2);
        groupAcc.add(r3);
        groupAcc.add(r4);

        JLabel card = new JLabel("Card Number");
        card.setFont(new Font("Raleway",Font.BOLD,22));
        card.setBounds(100,300,300,30);
        add(card);

        JLabel number = new JLabel("XXXX-XXXX-XXXX-4184");
        number.setFont(new Font("Raleway",Font.BOLD,22));
        number.setBounds(330,300,300,30);
        add(number);

          JLabel details = new JLabel("Your 16 digit card number");
        details.setFont(new Font("Raleway",Font.BOLD,12));
        details.setBounds(100,330,300,20);
        add(details);


         JLabel pin = new JLabel("Pin Number");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,370,300,30);
        add(pin);

        JLabel pnum = new JLabel("XXXX");
        pnum.setFont(new Font("Raleway",Font.BOLD,22));
        pnum.setBounds(330,370,300,30);
        add(pnum);

         JLabel pindetails = new JLabel("Your 4 digit Pin");
        pindetails.setFont(new Font("Raleway",Font.BOLD,12));
        pindetails.setBounds(100,400,300,20);
        add(pindetails);


        JLabel service = new JLabel("Services Required:");
        service.setFont(new Font("Raleway",Font.BOLD,22));
        service.setBounds(100,450,300,30);
        add(service);

        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.white);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,500,200,30);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.white);
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(350,500,200,30);
        add(c2);


        c3 = new JCheckBox("Mobile banking");
        c3.setBackground(Color.white);
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100,550,200,30);
        add(c3);


        c4 = new JCheckBox("Email/SMS Alert");
        c4.setBackground(Color.white);
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(350,550,200,30);
        add(c4);


        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.white);
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(100,600,200,30);
        add(c5);


        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.white);
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(350,600,200,30);
        add(c6);


        c7 = new JCheckBox("I Herebt declare that the above details are correct");
        c7.setBackground(Color.white);
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBounds(100,680,600,30);
        add(c7);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setBounds(250,720,100,30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setBounds(420,720,100,30);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.WHITE);



        setSize(850,820);
        setLocation(350,0);
        setVisible(true);

    }

    @Override 
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String acc = null;
            if(r1.isSelected()){
                acc="Savings Account";
            }else if(r2.isSelected()){
                acc="Fixed Deposit Account";
            }else if(r3.isSelected()){
                acc="Current Account";
            }else if(r4.isSelected()){
                acc="Recurring Account";
            }

            Random random = new Random();
            String cardnum ="" + Math.abs((random.nextLong() % 90000000L) +5040936000000000L);

            String pinNum = ""+Math.abs((random.nextLong()%9000L)+1000L);

            String facility = "";
            if(c1.isSelected()){
                facility=facility+ " ATM Card";
            }if(c2.isSelected()){
                facility=facility+" Internet Banking";
            }if(c3.isSelected()){
                facility=facility+" Mobile banking";
            }if(c4.isSelected()){
                facility=facility+" Email/SMS Alert";
            }if (c5.isSelected()){
                facility=facility+" Checkbook";
            }if(c6.isSelected()){
                facility=facility+" E-statement";
            }

            try {
                if(acc==null){
                    JOptionPane.showMessageDialog(null, "Account Type is required");
                }else{
                    conn c = new conn();
                    

                String query1 = 
                "INSERT INTO signupthree VALUES('" +
                formno + "','" +
                acc + "','" +
                cardnum + "','" +
                pinNum + "','" +
                facility + "')";

                String query2 = 
                "INSERT INTO login VALUES('" +
                 formno + "','" +
                 cardnum + "','" +
                 pinNum + "')";

                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null,"Card Number: " + cardnum + "\n Pin: "+ pinNum);
                setVisible(false);
                new Deposit(pinNum).setVisible(false);
                       
                }
            } catch (Exception e) {
                System.out.println(e);
            }

           

        }else if(ae.getSource()==cancel){
            setVisible(false);
            new login().setVisible(true);
        }
    }
    public static void main(String[] args) {
         new Signupthree("");
    }
   
}
