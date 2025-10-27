package atm;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

    
public class Balance extends JFrame implements ActionListener {
    
    // declared here to use in both insde Constructor and outside Constructor.
    String pinnumber;
    JButton back;
    
    // created a Balance Constructor
    Balance(String pinnumber) {
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
        
    //Setting Back button with action.
        back = new JButton("Back");
        back.setBounds(370, 394, 100, 30);
        back.addActionListener(this);
        image.add(back);
    
    // establishing connection from connection class. 
        connection conn = new connection();
        
    // declaring initial balance as 0;
        int balance = 0;
            try {
                // condition for matching account details using pinnumber.
                ResultSet rs = conn.s.executeQuery("select * from bank where pinnumber = '"+pinnumber+"'");
                
                // using while loop to find result by adding or subtarcting the amount from balance.
                while(rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
            } catch (Exception e) {
                        System.out.println(e);
                }
        
        // adding text using label for Current Balance.
        JLabel text = new JLabel("Your Current Account Balance is Rs " + balance + "/-");
        text.setBounds(150, 270, 500, 50);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        image.add(text);            
                
        // setting application Size, location and its visibility.
        setSize(700,700);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transaction(pinnumber).setVisible(true);
    }
    public static void main (String[] args) {
        new Balance("");
    }
}
