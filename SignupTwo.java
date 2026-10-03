package bank_management_system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.util.*;

public class SignupTwo extends JFrame implements ActionListener {
    String formno;

    JComboBox religion,exisbox;

    JTextField incomeT, eduT,occupationT,nidT,panT;
    JButton next;
    SignupTwo(String formno){
        this.formno=formno;
        setLayout(null);

        setTitle("New Account Application form-Page 2");

        JLabel additionaldetails = new JLabel("Page 2: Additional details");
        additionaldetails.setBounds(290,80,400,30);
        additionaldetails.setFont(new Font("Raleway",Font.BOLD,22));
        add(additionaldetails);

       

        String [] valReligion = {"Muslim","Hindu","Christian","Buddhist","Other"};
        religion= new JComboBox(valReligion);
        religion.setBounds(300,190,200,30);
        add(religion);
        JLabel fname = new JLabel("Religion: ");
        fname.setBounds(100,190,200,30);
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        add(fname);

 

         JLabel income = new JLabel("Income:  ");
        income.setBounds(100,240,200,30);
        income.setFont(new Font("Raleway",Font.BOLD,20));
        add(income);

        incomeT = new JTextField();
        incomeT.setBounds(300,240,200,30);
        add(incomeT);

        JLabel education = new JLabel("Education:  ");
        education.setBounds(100,290,200,30);
        education.setFont(new Font("Raleway",Font.BOLD,20));
        add(education);

         eduT = new JTextField();
        eduT.setBounds(300,290,400,30);
        add(eduT);


         JLabel occupation = new JLabel("Occupation:  ");
        occupation.setBounds(100,340,200,30);
        occupation.setFont(new Font("Raleway",Font.BOLD,20));
        add(occupation);

        occupationT = new JTextField();
        occupationT.setBounds(300,340,400,30);
        add(occupationT);



         JLabel nid = new JLabel("Nid card: ");
        nid.setBounds(100,390,200,30);
        nid.setFont(new Font("Raleway",Font.BOLD,20));
        add(nid);

        nidT= new JTextField();
        nidT.setFont(new Font("Raleway",Font.BOLD,14));
        nidT.setBounds(300,390,400,30);
        add(nidT);


        JLabel pan = new JLabel("Pan number: ");
        pan.setBounds(100,440,200,30);
        pan.setFont(new Font("Raleway",Font.BOLD,20));
        add(pan);

        panT = new JTextField();
        panT.setFont(new Font("Raleway",Font.BOLD,14));
        panT.setBounds(300,440,400,30);
        add(panT);

        

        JLabel exisAcc = new JLabel("Existing Account : ");
        exisAcc.setBounds(100,490 ,200,30);
        exisAcc.setFont(new Font("Raleway",Font.BOLD,20));
        add(exisAcc);


        String [] isExist = {"Yes","No"};
        exisbox = new JComboBox(isExist);    
        exisbox.setBounds(300,490,400,30);
        add(exisbox);


        JButton next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);


        





        

        getContentPane().setBackground(Color.white);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }

    @Override 
    
   public void actionPerformed(ActionEvent ae) {

    
    String religionSS = (String)religion.getSelectedItem();

    String incomes = incomeT.getText();

    String educations = eduT.getText();

    String occup = occupationT.getText();

    String nids = nidT.getText();

    String pan = panT.getText();

    String exists = (String)exisbox.getSelectedItem();


    try {

        if (religion.equals("")) {

            JOptionPane.showMessageDialog(null, "Name is required");

        } else {

            conn c = new conn();

            String query =
                "INSERT INTO signuptwo VALUES('" +
                formno + "','"+
                religionSS + "','" +
                 incomes+ "','" +
                educations+ "','" +
                occup + "','" +
                nids + "','" +
                pan + "','" +
                exists + "')";

            System.out.println("Running query:");
            System.out.println(query);

            int result = c.s.executeUpdate(query);

            System.out.println("Rows inserted: " + result);

            JOptionPane.showMessageDialog(null, "Data inserted successfully!");
            setVisible(false);
            new Signupthree(formno).setVisible(true);

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
            new SignupTwo("");
        }
    }



