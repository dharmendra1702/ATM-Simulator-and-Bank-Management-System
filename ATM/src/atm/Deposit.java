package atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener{
    
    // declared here to use in both insde Constructor and outside Constructor.
    JTextField amount;
    JButton deposit, back;
    String pinnumber;
    
    // created a Balance Constructor
    Deposit(String pinnumber) {
        
        //taking pinnumber from another class.
        this.pinnumber = pinnumber;
        
        // Setting layout null, for making flexible changes in layout.
        setLayout(null);
        
        // Importing atm background to class
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.png"));
        Image i2 = i1.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,700,700);
        add(image);
        
        // adding text using label for amount to deposit.
        JLabel text = new JLabel("Enter the amount you want to deposit");
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(150, 180, 300, 50);
        text.setForeground(Color.WHITE);
        image.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(150, 230, 290, 30);
        image.add(amount);
        
        //Setting Deposit button with action.
        deposit = new JButton("Deposit");
        deposit.setBounds(350, 337, 100, 30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        //Setting Back button with action.
        back = new JButton("Back");
        back.setBounds(350, 375, 100, 30);
        back.addActionListener(this);
        image.add(back);
        
        // setting application Size, location and its visibility.
        setSize(700,700);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        // Setting action for deposit Button.
        if (ae.getSource() == deposit) {
            String number = amount.getText();
            Date date = new Date();
            if (number.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
            } else {
                try {
                    // establishing connection from connection class. 
                    connection conn = new connection();
                    
                    // condition for matching account details using pinnumber.
                    String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'Deposit', '"+number+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs " + number + " Deposited Successfully");
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                } catch (Exception e){
                    System.out.println(e);
                }
            }
            // Setting action for back Button.
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        new Deposit("");
    }
}
