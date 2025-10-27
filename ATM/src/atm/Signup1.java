package atm;


import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class Signup1 extends JFrame implements ActionListener{
    
    // declared here to use in both insde Constructor and outside Constructor.
    long random;
    JTextField Tname, Fname, Temail, addr, tcity, tstate, pincode;
    JDateChooser dateChooser;
    JRadioButton male, female, married, Unmarried, Other;
    JButton next;
    
    
    // Created a Signup Constructor.
    
    Signup1() {
        //Setting layout as null for default.
        setLayout(null);
        
        //Title of the Application.
        setTitle("New Account Application Form - Page 1");
        
        // Created a variable to generate randum 4digit numbers.
        Random ran = new Random();
        random = (Math.abs((ran.nextLong() % 9000L) + 1000l));
        
        // Adding text using label
        JLabel formno = new JLabel("Application form No. " + random);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(140, 20, 600, 40);
        add(formno);
        
        // Adding text using label
        JLabel PersonDetails = new JLabel("Page 1: Personal Details");
        PersonDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        PersonDetails.setBounds(290, 80, 500, 50);
        add(PersonDetails);
        
        // Adding text using labels for Name.
        JLabel Name = new JLabel("Name: ");
        Name.setFont(new Font("Raleway", Font.BOLD, 22));
        Name.setBounds(100, 130, 500, 50);
        add(Name);
        
        // Adding text box using TextFields for Name.
        Tname = new JTextField();
        Tname.setFont(new Font("Raleway", Font.BOLD, 14));
        Tname.setBounds(300, 140, 400, 30);
        add(Tname);
        
        // Adding text using labels for Father Name.
        JLabel FName = new JLabel("Father's Name: ");
        FName.setFont(new Font("Raleway", Font.BOLD, 22));
        FName.setBounds(100, 180, 500, 50);
        add(FName);
        
        // Adding text box using TextFields for Father Name.
        Fname = new JTextField();
        Fname.setFont(new Font("Raleway", Font.BOLD, 14));
        Fname.setBounds(300, 190, 400, 30);
        add(Fname);
        
        // Adding text using labels for DOB.
        JLabel Dob = new JLabel("Date of Birth: ");
        Dob.setFont(new Font("Raleway", Font.BOLD, 22));
        Dob.setBounds(100, 230, 500, 50);
        add(Dob);
        
        // Adding text box using TextFields for DOB.
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 240, 400, 30);
        add(dateChooser);
        
        // Adding text using labels for Gender.
        JLabel Gender = new JLabel("Gender: ");
        Gender.setFont(new Font("Raleway", Font.BOLD, 22));
        Gender.setBounds(100, 280, 500, 50);
        add(Gender);
        
        // Adding Radio Button for male using RadioButton.
        male = new JRadioButton("Male");
        male.setBounds(300, 290, 60, 30);
        male.setBackground(Color.WHITE);
        add(male);
        
        // Adding Radio Button for Female using RadioButton.
        female = new JRadioButton("Female");
        female.setBounds(410, 290, 100, 30);
        female.setBackground(Color.WHITE);
        add(female);
        
        // Grouping all Radio Buttons to avoid multiple selctions using ButtonGroup.
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        // Adding text using labels for Email.
        JLabel Email = new JLabel("Email Address: ");
        Email.setFont(new Font("Raleway", Font.BOLD, 22));
        Email.setBounds(100, 330, 500, 50);
        add(Email);
        
        // Adding text box using TextFields for Email.
        Temail = new JTextField();
        Temail.setFont(new Font("Raleway", Font.BOLD, 14));
        Temail.setBounds(300, 340, 400, 30);
        add(Temail);
        
        // Adding text using labels for Marital Status.
        JLabel MS = new JLabel("Marital Status: ");
        MS.setFont(new Font("Raleway", Font.BOLD, 22));
        MS.setBounds(100, 380, 500, 50);
        add(MS);
        
        // Adding Radio Button for married using RadioButton.
        married = new JRadioButton("Married");
        married.setBounds(300, 390, 100, 30);
        married.setBackground(Color.WHITE);
        add(married);
        
        // Adding Radio Button for unmarried using RadioButton.
        Unmarried = new JRadioButton("Unmarried");
        Unmarried.setBounds(410, 390, 100, 30);
        Unmarried.setBackground(Color.WHITE);
        add(Unmarried);
        
        // Adding Radio Button for other using RadioButton.
        Other = new JRadioButton("Other");
        Other.setBounds(540, 390, 100, 30);
        Other.setBackground(Color.WHITE);
        add(Other);
        
        // Grouping all Radio Buttons to avoid multiple selctions using ButtonGroup.
        ButtonGroup Msgroup = new ButtonGroup();
        Msgroup.add(married);
        Msgroup.add(Unmarried);
        Msgroup.add(Other);
        
        // Adding text using labels for Address.
        JLabel Address = new JLabel("Address: ");
        Address.setFont(new Font("Raleway", Font.BOLD, 22));
        Address.setBounds(100, 430, 500, 50);
        add(Address);
        
        // Adding text box using TextFields for Address.
        addr = new JTextField();
        addr.setFont(new Font("Raleway", Font.BOLD, 14));
        addr.setBounds(300, 440, 400, 30);
        add(addr);
        
        // Adding text using labels for City.
        JLabel City = new JLabel("City: ");
        City.setFont(new Font("Raleway", Font.BOLD, 22));
        City.setBounds(100, 480, 500, 50);
        add(City);
        
        // Adding text box using TextFields for City.
        tcity = new JTextField();
        tcity.setFont(new Font("Raleway", Font.BOLD, 14));
        tcity.setBounds(300, 490, 400, 30);
        add(tcity);
        
        // Adding text using labels for State.
        JLabel State = new JLabel("State: ");
        State.setFont(new Font("Raleway", Font.BOLD, 22));
        State.setBounds(100, 530, 500, 50);
        add(State);
        
        // Adding text box using TextFields for State.
        tstate = new JTextField();
        tstate.setFont(new Font("Raleway", Font.BOLD, 14));
        tstate.setBounds(300, 540, 400, 30);
        add(tstate);
        
        // Adding text using labels for Pin code.
        JLabel Pin = new JLabel("Pin Code: ");
        Pin.setFont(new Font("Raleway", Font.BOLD, 22));
        Pin.setBounds(100, 580, 500, 50);
        add(Pin);
        
        // Adding text box using TextFields for Pin Code.
        pincode = new JTextField();
        pincode.setFont(new Font("Raleway", Font.BOLD, 14));
        pincode.setBounds(300, 590, 400, 30);
        add(pincode);
        
        // Adding Next Button using Button.
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(400, 640, 80, 30);
        next.addActionListener(this);
        add(next);
        
        // setting application background color
        getContentPane().setBackground(Color.WHITE);
        
        // setting application Size, location and its visibility.
        setSize(800,720);
        setVisible(true);
        setLocationRelativeTo(null);
    }
    
    public void actionPerformed(ActionEvent ae) {
        String formno = "" + random;
        String name = Tname.getText();
        String fname = Fname.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (male.isSelected()) {
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        }
        
        String email = Temail.getText();
        String marital = null;
        if (married.isSelected()) {
            marital = "Married";
        } else if (Unmarried.isSelected()) {
            marital = "Unmarried";
        } else if (Other.isSelected()) {
            marital = "Other";
        }
        String address = addr.getText();
        String city = tcity.getText();
        String state = tstate.getText();
        String pin = pincode.getText();
        
        try {
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name is Required.");
            } else if (fname.equals("")) {
                JOptionPane.showMessageDialog(null, "Father Name is Required.");
            } else if (dob.equals("")) {
                JOptionPane.showMessageDialog(null, "Dob is Required.");
            }else if (email.equals("")) {
                JOptionPane.showMessageDialog(null, "Dob is Required.");
            }else if (address.equals("")) {
                JOptionPane.showMessageDialog(null, "address is Required.");
            }else if (city.equals("")) {
                JOptionPane.showMessageDialog(null, "city is Required.");
            }else if (state.equals("")) {
                JOptionPane.showMessageDialog(null, "state is Required.");
            }else if (pin.equals("")) {
                JOptionPane.showMessageDialog(null, "pin is Required.");
            }else {
                connection  c = new connection();
                String query = "insert into signup values ('"+formno+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+marital+"', '"+address+"', '"+city+"','"+state+"', '"+pin+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new Signup2(formno).setVisible(true);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        // Setting action as for next button.
        if (ae.getSource() == next) {
            setVisible(false);
        }
    }
        
    public static void main(String[] args) {
        new Signup1();
    }
}
