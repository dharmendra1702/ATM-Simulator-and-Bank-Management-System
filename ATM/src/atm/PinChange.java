package atm;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class PinChange extends JFrame implements ActionListener {
    
    // declared here to use in both insde Constructor and outside Constructor.
    JPasswordField pin,conpin;
    JButton change, back;
    String pinnumber;
    
    // created a Balance Constructor
    PinChange(String pinnumber) {
        
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
        
        // adding text using label for changing of pin.
        JLabel text = new JLabel("Change Your Pin");
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(230, 190, 500, 50);
        text.setForeground(Color.WHITE);
        image.add(text);
        
        // adding text using label for new pin.
        JLabel pintext = new JLabel("New Pin: ");
        pintext.setFont(new Font("System", Font.BOLD, 16));
        pintext.setBounds(120, 240, 150, 50);
        pintext.setForeground(Color.WHITE);
        image.add(pintext);
        
        // adding text box using PasswordField for new Pin.
        pin = new JPasswordField();
        pin.setFont(new Font("System", Font.BOLD, 16));
        pin.setBounds(270, 250, 180, 30);
        image.add(pin);

        // adding text using label for confirm new pin.
        JLabel Context = new JLabel("Confirm New Pin: ");
        Context.setFont(new Font("System", Font.BOLD, 16));
        Context.setBounds(120, 280, 150, 50);
        Context.setForeground(Color.WHITE);
        image.add(Context);
        
        // adding text box using PasswordField for confirm pin.
        conpin = new JPasswordField();
        conpin.setFont(new Font("System", Font.BOLD, 16));
        conpin.setBounds(270, 290, 180, 30);
        image.add(conpin);
        
        //Setting change button with action.
        change = new JButton("Change");
        change.setBounds(370, 356, 100, 30);
        change.addActionListener(this);
        image.add(change);
               
        //Setting back button with action.
        back = new JButton("Back");
        back.setBounds(370, 394, 100, 30);
        back.addActionListener(this);
        image.add(back);
        
        // setting application Size, location and its visibility.
        setSize(700,700);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        // Setting action for Change Button
        if (ae.getSource() == change) {
            try {
                String npin = pin.getText();
                String cpin = conpin.getText();
                
                if (!npin.equals(cpin)) {
                    JOptionPane.showMessageDialog(null, "Entered Pin does not match");
                    return;
                }
                
                if (npin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Enter New Pin");
                    return;
                }
                
                if (cpin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Enter Confirm New Pin");
                    return;
                }
                
                // establishing connection from connection class. 
                connection conn = new connection();
                
                // condition for matching pin number from all tables using pinnumber.
                String Query1 = "update bank set pinnumber = '"+cpin+"' where pinnumber = '"+pinnumber+"'";
                String Query2 = "update login set pinnumber = '"+cpin+"' where pinnumber = '"+pinnumber+"'";
                String Query3 = "update signup3 set pinnumber = '"+cpin+"' where pinnumber = '"+pinnumber+"'";
                
                conn.s.executeUpdate(Query1);
                conn.s.executeUpdate(Query2);
                conn.s.executeUpdate(Query3);
                
                JOptionPane.showMessageDialog(null, "PIN Changed Successfully" + "\n Redirecting to Login Page ");
                setVisible(false);
                new Login().setVisible(true);
                
            } catch (Exception e) {
                System.out.println(e);
            }
            // Setting action for Back Button.
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        } 
    }
    
    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }
}
