package atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    // Declaring variable outside the constructors. so that we can use any where in program.
    JButton Login, Clear, Signup;
    JTextField cardTextField;
    JPasswordField pinTextField;
    
    // created a Login Constructor.
    Login() {
        //Title of the Application.
        setTitle("ATM");
        
        //Setting layout as null for default.
        setLayout(null);

        // importing and loading image using imageicon.
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.png"));
        Image i2 = i1.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,700,700);
        add(image);

        // Adding text using labels
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setForeground(Color.WHITE);
        text.setBounds(150, 170, 400, 100);
        image.add(text);
        
        // adding text using labels for Card No.
        JLabel cardno = new JLabel("Card No:- ");
        cardno.setFont(new Font("RaieWay", Font.BOLD, 24));
        cardno.setForeground(Color.WHITE);
        cardno.setBounds(130, 250, 200, 50);
        image.add(cardno);

        // adding text box using TextFields for Card No.
        cardTextField = new JTextField();
        cardTextField.setBounds(260, 260, 200, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        image.add(cardTextField);
        
        // adding text using labels for Pin.
        JLabel pin = new JLabel("Pin:- ");
        pin.setFont(new Font("RaieWay", Font.BOLD, 24));
        pin.setForeground(Color.WHITE);
        pin.setBounds(130, 290, 200, 50);
        image.add(pin);
        
        // adding text box using PasswordField for Pin.
        pinTextField = new JPasswordField();
        pinTextField.setBounds(260, 300, 200, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        image.add(pinTextField);

        // adding buttons using button for Sign in.
        Login = new JButton("SIGN IN");
        Login.setBounds(260, 350, 90, 30);
        Login.setBackground(Color.BLACK);
        Login.setForeground(Color.WHITE);
        Login.addActionListener(this);
        image.add(Login);

        // adding button using button for Clear.
        Clear = new JButton("Clear");
        Clear.setBounds(370, 350, 90, 30);
        Clear.setBackground(Color.BLACK);
        Clear.setForeground(Color.WHITE);
        Clear.addActionListener(this);
        image.add(Clear);

        // adding button using button for Sign up.
        Signup = new JButton("SIGN UP");
        Signup.setBounds(260, 400, 200, 30);
        Signup.setBackground(Color.BLACK);
        Signup.setForeground(Color.WHITE);
        Signup.addActionListener(this);
        image.add(Signup);

        // setting application background color
        getContentPane().setBackground(Color.white);

        // setting application Size, location and its visibility.
        setSize(700,700);
        setUndecorated(true);
        setVisible(true);
        setLocationRelativeTo(null);
        //setLocation(250, 10);
    }

    // implementing actionPerformed method.
    public void actionPerformed(ActionEvent ae) {
        // Setting action for Clear Button
        if (ae.getSource() == Clear) {
            cardTextField.setText("");
            pinTextField.setText("");
            // Setting action for Login Button
        } else if (ae.getSource() == Login) {
            
            // establishing connection from connection class. 
            connection conn = new connection();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query = "select * from login where carnumber = '"+cardnumber+"' and Pinnumber + '"+pinnumber+"'";
            try {
                ResultSet rs = conn.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin");
                }
            }catch (Exception e) {
                System.out.println(e);
            }
            // Setting action for Signup Button
        } else if (ae.getSource() == Signup) {
            JOptionPane.showMessageDialog(null, "Redirecting to New Account Application Form");
            setVisible(false);
            new Signup1().setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        new Login();
    }
}
