package atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class withdraw extends JFrame implements ActionListener{
    
    // declared here to use in both insde Constructor and outside Constructor.
    JTextField amount;
    JButton withdraw, back;
    String pinnumber;
    
    // created a withdraw Constructor
    withdraw(String pinnumber) {
        
        //taking pinnumber from another class.
        this.pinnumber = pinnumber;
        
        // Importing atm background to class
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.png"));
        Image i2 = i1.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,700,700);
        add(image);
        
        JLabel text = new JLabel("Enter the amount you want to withdraw");
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(150, 180, 350, 50);
        text.setForeground(Color.WHITE);
        image.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(150, 230, 290, 30);
        image.add(amount);
        
        //Setting Withdraw button with action.
        withdraw = new JButton("Withdraw");
        withdraw.setBounds(350, 337, 100, 30);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
        //Setting back button with action.
        back = new JButton("Back");
        back.setBounds(350, 375, 100, 30);
        back.addActionListener(this);
        image.add(back);
        
        // setting application Size, location and its visibility.
        setLayout(null);
        setSize(700,700);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == withdraw) {
            String number = amount.getText();
            Date date = new Date();
            if (number.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");
            } else {
                try {
                    // establishing connection from connection class. 
                    connection conn = new connection();
                    String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'withdraw', '"+number+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs " + number + " Withdraw Successfully");
                    setVisible(false);
                    new ws(pinnumber).setVisible(true);
                } catch (Exception e){
                    System.out.println(e);
                }
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        new withdraw("");
    }
}
