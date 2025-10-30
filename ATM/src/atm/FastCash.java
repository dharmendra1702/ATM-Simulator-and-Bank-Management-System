package atm;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    
    // declared here to use in both insde Constructor and outside Constructor.
    JButton rs100, rs500, rs1000, rs2000, rs5000, rs10000, exit;
    String pinnumber;
    
    // created a Balance Constructor
    FastCash(String pinnumber) {
        
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
        
        // adding text using label for amount withdrawl.
        JLabel text = new JLabel("Select Withdrawl Amount");
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(180, 200, 500, 50);
        text.setForeground(Color.WHITE);
        image.add(text);
        
        //Setting 100rs button with action.
        rs100 = new JButton("Rs 100");
        rs100.setBounds(120, 280, 150, 30);
        rs100.addActionListener(this);
        image.add(rs100);
        
        //Setting 500rs button with action.
        rs500 = new JButton("Rs 500");
        rs500.setBounds(320, 280, 150, 30);
        rs500.addActionListener(this);
        image.add(rs500);
        
        //Setting 1000rs button with action.
        rs1000 = new JButton("Rs 1000");
        rs1000.setBounds(120, 318, 150, 30);
        rs1000.addActionListener(this);
        image.add(rs1000);
        
        //Setting 2000rs button with action.
        rs2000 = new JButton("Rs 2000");
        rs2000.setBounds(320, 318, 150, 30);
        rs2000.addActionListener(this);
        image.add(rs2000);
        
        //Setting 5000rs button with action.
        rs5000 = new JButton("Rs 5000");
        rs5000.setBounds(120, 356, 150, 30);
        rs5000.addActionListener(this);
        image.add(rs5000);
                
        //Setting 10000rs button with action.
        rs10000 = new JButton("Rs 10000");
        rs10000.setBounds(320, 356, 150, 30);
        rs10000.addActionListener(this);
        image.add(rs10000);
        
        //Setting exit button with action.
        exit = new JButton("Back");
        exit.setBounds(320, 394, 150, 30);
        exit.addActionListener(this);
        image.add(exit);
        
        // setting application background color
        getContentPane().setBackground(Color.WHITE);
        
        // setting application Size, location and its visibility.
        setSize(700,700);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        // Setting action for exit Button
        if (ae.getSource() == exit) {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        } else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            
            // establishing connection from connection class. 
            connection conn = new connection();
            try {
                
                // condition for matching account details using pinnumber.
                ResultSet rs = conn.s.executeQuery("select * from bank where pinnumber = '"+pinnumber+"'");
                int balance = 0;
                
                // using while loop to find result by adding or subtarcting the amount from balance.
                while(rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                
                // Setting action as if balance is less than mentioned.
                if(ae.getSource() != exit && balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                
                Date date = new Date();
                String Query = "insert into bank values ('"+pinnumber+"', '"+date+"', 'withdrawl', '"+amount+"')";
                conn.s.executeUpdate(Query);
                JOptionPane.showMessageDialog(null, "Rs " + amount + " Debited Successfully");
                setVisible(false);
                new fs(pinnumber).setVisible(true);
            }catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    
    
    public static void main(String [] args) {
        new FastCash("");
    }
}
