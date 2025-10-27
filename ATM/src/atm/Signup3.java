package atm;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Signup3 extends JFrame implements ActionListener{
    
    // declared here to use in both insde Constructor and outside Constructor.
    JRadioButton savings, fd, current, deposit;
    JCheckBox c1, c2, c3, c4, c5, c6 ,c7;
    JButton Submit, cancel;
    String formno;
    
    // created a signup3 Constructor
    Signup3(String formno) {
        //taking formno from another class.
        this.formno = formno;
        
        //Setting layout as null for default.
        setLayout(null);
        
        //Title of the Application.
        setTitle("New Account Application Form - Page 3");
        
        // Adding text using label
        JLabel accDetails = new JLabel("Page 3: Account Details");
        accDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        accDetails.setBounds(290, 50, 500, 50);
        add(accDetails);
        
        // Adding text using labels for account type.
        JLabel AccType = new JLabel("Account Type ");
        AccType.setFont(new Font("Raleway", Font.BOLD, 22));
        AccType.setBounds(100, 130, 500, 50);
        add(AccType);
        
        // Adding Radio Button for savings using RadioButton.
        savings = new JRadioButton("Savings Account");
        savings.setFont(new Font("Raleway", Font.BOLD, 16));
        savings.setBounds(100, 180, 200, 30);
        savings.setBackground(Color.WHITE);
        add(savings);
        
        // Adding Radio Button for fixed depost account using RadioButton.
        fd = new JRadioButton("Fixed Deposit Account");
        fd.setFont(new Font("Raleway", Font.BOLD, 16));
        fd.setBounds(350, 180, 250, 30);
        fd.setBackground(Color.WHITE);
        add(fd);
        
        // Adding Radio Button for current account using RadioButton.
        current = new JRadioButton("Current Account");
        current.setFont(new Font("Raleway", Font.BOLD, 16));
        current.setBounds(100, 210, 250, 30);
        current.setBackground(Color.WHITE);
        add(current);
        
        // Adding Radio Button for Recuring Deposit Account using RadioButton.
        deposit = new JRadioButton("Recuring Deposit Account");
        deposit.setFont(new Font("Raleway", Font.BOLD, 16));
        deposit.setBounds(350, 210, 250, 30);
        deposit.setBackground(Color.WHITE);
        add(deposit);
        
        // Grouping all Radio Buttons of Account Type to avoid multiple selctions using ButtonGroup.
        ButtonGroup groupaccount = new ButtonGroup();
        groupaccount.add(savings);
        groupaccount.add(fd);
        groupaccount.add(current);
        groupaccount.add(deposit);
        
        // Adding text using labels for card Number text.
        JLabel Card = new JLabel("Card Number");
        Card.setFont(new Font("Raleway", Font.BOLD, 22));
        Card.setBounds(100, 250, 500, 50);
        add(Card);
        
        // Adding text using labels for card number information.
        JLabel Cardnumber2 = new JLabel("Your 16 Digit Card Number");
        Cardnumber2.setFont(new Font("Raleway", Font.BOLD, 11));
        Cardnumber2.setBounds(100, 270, 500, 50);
        add(Cardnumber2);
        
        // Adding text using labels for card number.
        JLabel Cardnumber = new JLabel("XXXX-XXXX-XXXX-4184");
        Cardnumber.setFont(new Font("Raleway", Font.BOLD, 22));
        Cardnumber.setBounds(350, 260, 500, 50);
        add(Cardnumber);
        
        // Adding text using labels for pin.
        JLabel Pin = new JLabel("Pin");
        Pin.setFont(new Font("Raleway", Font.BOLD, 22));
        Pin.setBounds(100, 320, 500, 50);
        add(Pin);
        
        // Adding text using labels for pin details.
        JLabel pin2 = new JLabel("Your 4 Digit Password");
        pin2.setFont(new Font("Raleway", Font.BOLD, 11));
        pin2.setBounds(100, 340, 500, 50);
        add(pin2);
        
        // Adding text using labels for pin.
        JLabel Pinno = new JLabel("XXXX");
        Pinno.setFont(new Font("Raleway", Font.BOLD, 22));
        Pinno.setBounds(350, 330, 500, 50);
        add(Pinno);
        
        // Adding text using labels for Services Required.
        JLabel Servicesrequired = new JLabel("Services Required");
        Servicesrequired.setFont(new Font("Raleway", Font.BOLD, 22));
        Servicesrequired.setBounds(100, 380, 500, 50);
        add(Servicesrequired);
        
        c1 = new JCheckBox("ATM CARD");
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        c1.setBounds(100, 420, 200, 30);
        c1.setBackground(Color.WHITE);
        add(c1);
        
        c2 = new JCheckBox("Internet Banking");
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        c2.setBounds(400, 420, 200, 30);
        c2.setBackground(Color.WHITE);
        add(c2);
        
        c3 = new JCheckBox("Mobile Banking");
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        c3.setBounds(100, 460, 200, 30);
        c3.setBackground(Color.WHITE);
        add(c3);
        
        c4 = new JCheckBox("Email & SMS Alerts");
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        c4.setBounds(400, 460, 200, 30);
        c4.setBackground(Color.WHITE);
        add(c4);
        
        c5 = new JCheckBox("Cheque Book");
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        c5.setBounds(100, 500, 200, 30);
        c5.setBackground(Color.WHITE);
        add(c5);
        
        c6 = new JCheckBox("E-Statement");
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        c6.setBounds(400, 500, 200, 30);
        c6.setBackground(Color.WHITE);
        add(c6);
        
        c7 = new JCheckBox("I hereby declares that the above entered details are correct to the best of my knowledge");
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
        c7.setBounds(100, 550, 800, 30);
        c7.setBackground(Color.WHITE);
        add(c7);
        
        //Setting Submit button with action.
        Submit = new JButton("Submit");
        Submit.setBackground(Color.BLACK);
        Submit.setForeground(Color.WHITE);
        Submit.setFont(new Font("Raleway", Font.BOLD, 14));
        Submit.setBounds(200, 600, 100, 30);
        Submit.addActionListener(this);
        add(Submit);
        
        //Setting Cancel button with action.
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBounds(400, 600, 100, 30);
        cancel.addActionListener(this);
        add(cancel);
        // setting application background color
        getContentPane().setBackground(Color.WHITE);
        
        // setting application Size, location and its visibility.
        setSize(800,700);
        setVisible(true);
        setLocationRelativeTo(null);
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        // Setting action as for submit button.
        if (ae.getSource() == Submit) {
            String accountType = null;
            if (savings.isSelected()) {
                accountType = "Savings Account";
            } else if (fd.isSelected()) {
                accountType = "Fixed Deposit Account";
            } else if (current.isSelected()) {
                accountType = "Current Account";
            } else if (deposit.isSelected()) {
                accountType = "Recuring Deposit Account";
            }
            
            Random random = new Random();
            String cardnumber = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
            
            String Pinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
            
            String facility = "";
            if (c1.isSelected()) {
                facility = facility + " Atm Card";
            } else if (c2.isSelected()) {
                facility = facility + " Internet Banking";
            } else if (c3.isSelected()) {
                facility = facility + " Mobile Banking";
            } else if (c4.isSelected()) {
                facility = facility + " Email & SMS Alerts";
            } else if (c5.isSelected()) {
                facility = facility + " Cheque Book";
            } else if (c6.isSelected()) {
                facility = facility + " E - Statement";
            }
            
            try {
                if (accountType.equals("")) {
                    JOptionPane.showMessageDialog(null, "Account Type is Required");
                }
                // establishing connection from connection class. 
                connection  c = new connection();
                String query = "insert into signup3 values ('"+formno+"','"+accountType+"', '"+cardnumber+"', '"+Pinnumber+"', '"+facility+"')";
                String query1 = "insert into login values ('"+formno+"', '"+cardnumber+"', '"+Pinnumber+"')";
                c.s.executeUpdate(query);
                c.s.executeUpdate(query1);
                
                JOptionPane.showMessageDialog(null,"Thank Your For Creating Account " + "\n Card Number: " + cardnumber + "\n Pin: " + Pinnumber);
                setVisible(false);
                new Deposit(Pinnumber).setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
            // Setting action as for cancel button.
        } else if (ae.getSource() == cancel) {
            setVisible(false);
            new Login().setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new Signup3("");
    }
}
