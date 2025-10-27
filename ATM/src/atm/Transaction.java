package atm;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Transaction extends JFrame implements ActionListener {
    
    // declared here to use in both insde Constructor and outside Constructor.
    JButton deposit, Fc, Pc, cw, ms, be, exit;
    String pinnumber;
    
    // created a Balance Constructor
    Transaction(String pinnumber) {
        
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
        
        // adding text using label for Selection of transaction.
        JLabel text = new JLabel("Please select your Transaction");
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(180, 200, 500, 50);
        text.setForeground(Color.WHITE);
        image.add(text);
        
        //Setting deposit button with action.
        deposit = new JButton("Deposit");
        deposit.setBounds(120, 280, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        //Setting Cash Withdrawl button with action.
        cw = new JButton("Cash Withdrawl");
        cw.setBounds(320, 280, 150, 30);
        cw.addActionListener(this);
        image.add(cw);
        
        //Setting Fast Cash button with action.
        Fc = new JButton("Fast Cash");
        Fc.setBounds(120, 318, 150, 30);
        Fc.addActionListener(this);
        image.add(Fc);
        
        //Setting Mini Statement button with action.
        ms = new JButton("Mini Statement");
        ms.setBounds(320, 318, 150, 30);
        ms.addActionListener(this);
        image.add(ms);
        
        //Setting Pin Change button with action.
        Pc = new JButton("Pin Change");
        Pc.setBounds(120, 356, 150, 30);
        Pc.addActionListener(this);
        image.add(Pc);
          
        //Setting Balance Enquiry button with action.
        be = new JButton("Balance Enquiry");
        be.setBounds(320, 356, 150, 30);
        be.addActionListener(this);
        image.add(be);
        
        //Setting exit button with action.
        exit = new JButton("Exit");
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
            JOptionPane.showMessageDialog(null, "Thank You");
            System.exit(0);
            // Setting action for deposit Button
        } else if (ae.getSource() == deposit) {
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
            // Setting action for cash withdrawl Button
        } else if (ae.getSource() == cw) {
            setVisible(false);
            new withdraw(pinnumber).setVisible(true);
            // Setting action for fast cash Button
        } else if (ae.getSource() == Fc) {
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
            // Setting action for pin change Button
        } else if (ae.getSource() == Pc) {
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
            // Setting action for balance enquiry Button
        } else if (ae.getSource() == be) {
            setVisible(false);
            new Balance(pinnumber).setVisible(true);
            // Setting action for mini statement Button
        } else if (ae.getSource() == ms) {
            new statement(pinnumber).setVisible(true);
        }
    }
    
    
    public static void main(String [] args) {
        new Transaction("");
    }
}
