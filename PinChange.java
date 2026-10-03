 package bank_management_system;

import java.awt.Color; import java.awt.Font; 
import java.awt.Image; import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import javax.swing.*;

public class PinChange extends JFrame implements ActionListener{
    String oldpin;
    JPasswordField pinField, repinT;
    JButton change,back;
    PinChange(String newPin){
        this.oldpin=newPin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance( 900, 900, Image.SCALE_DEFAULT );
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3); 
        img.setBounds(0, 0, 900, 900);
        add(img);


        JLabel text = new JLabel("Chane your pin"); 
        text.setBounds(250, 280, 300, 30);
         text.setFont(new Font("Raleway", Font.BOLD, 20)); 
         text.setForeground(Color.WHITE); 
         img.add(text);



         JLabel newText = new JLabel("Enter New PIN:");
          newText.setBounds(165, 320, 180, 25); 
          newText.setFont(new Font("Raleway", Font.BOLD, 16)); 
          newText.setForeground(Color.WHITE); 
          img.add(newText);


            pinField = new JPasswordField();
            pinField.setBounds(330, 320, 180, 25);
            pinField.setFont(new Font("Raleway", Font.BOLD, 22));
            img.add(pinField);

           JLabel repin= new JLabel("Enter Pin Again:");
          repin.setBounds(165, 360, 180, 25); 
          repin.setFont(new Font("Raleway", Font.BOLD, 16)); 
          repin.setForeground(Color.WHITE); 
          img.add(repin);


           repinT = new JPasswordField();
            repinT.setBounds(330, 360, 180, 25);
            repinT.setFont(new Font("Raleway", Font.BOLD, 22));
            img.add(repinT);

             change = new JButton("CHANGE");
            change.setBounds(355,485,150,30);
            change.addActionListener(this);
            img.add(change);
            

             back = new JButton("back");
            back.setBounds(355,520,150,30);
            back.addActionListener(this);
            img.add(back);





        setSize(900, 900); setLocation(300, 0); 
        setUndecorated(true); setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==change){
        try {
            String npin=pinField.getText();
            String rpin = repinT.getText();

            if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null, "Pin does not match");
                return ;
            }

            if(npin.equals("")){
                JOptionPane.showMessageDialog(null, "Please Enter Pin");
                return;
            }

             if(rpin.equals("")){
                JOptionPane.showMessageDialog(null, "Please re-Enter Pin");
                return;
            }

            conn c = new conn();
            String query1 = "update bank set pin='"+rpin+"'where pin = '"+oldpin+"' ";
            String query2 = "update login set pin='"+rpin+"'where pin = '"+oldpin+"' ";
            String query3 = "update signupthree set pin='"+rpin+"'where pin = '"+oldpin+"' ";

            c.s.executeUpdate(query1);
            c.s.executeUpdate(query2);
            c.s.executeUpdate(query3);

            JOptionPane.showMessageDialog(null, "Pin Changed Succesfully");

            setVisible(false);
            new Transactions(rpin).setVisible(true);




        } catch (Exception e) {
            System.out.println(e);
        }
    }else{
        setVisible(false);
        new Transactions(oldpin).setVisible(true);
    }
}
    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }
    
}