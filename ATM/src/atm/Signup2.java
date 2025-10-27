package atm;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Signup2 extends JFrame implements ActionListener{
    
    // declared here to use in both insde Constructor and outside Constructor.
    JTextField Tpan, Taadhar;
    JComboBox dreligion, category, incomec, education, occupation;
    JRadioButton syes, sno, eyes, eno;
    JButton next;
    String formno;
    
    
    // Created a Signup Constructor.
    
    Signup2(String formno) {
        
        //taking formno from another class.
        this.formno = formno;
        
        //Setting layout as null for default.
        setLayout(null);
        
        //Title of the Application.
        setTitle("New Account Application Form - Page 2");
          
        // Adding text using label
        JLabel addDetails = new JLabel("Page 2: Additional Details");
        addDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        addDetails.setBounds(290, 80, 500, 50);
        add(addDetails);
        
        // Adding text using labels for Religion.
        JLabel religion = new JLabel("Religion: ");
        religion.setFont(new Font("Raleway", Font.BOLD, 22));
        religion.setBounds(100, 130, 500, 50);
        add(religion);
        
        // Adding Dropdown using Combobox for Religions.
        String valReligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        dreligion = new JComboBox(valReligion);
        dreligion.setBackground(Color.WHITE);
        dreligion.setBounds(300, 140, 400, 30);
        add(dreligion);
        
        // Adding text using labels for Category.
        JLabel cat = new JLabel("Category: ");
        cat.setFont(new Font("Raleway", Font.BOLD, 22));
        cat.setBounds(100, 180, 500, 50);
        add(cat);
        
        // Adding Dropdown using Combobox for Cateogory.
        String valcategory[] = {"General", "OBC", "SC", "ST", "Other"};
        category = new JComboBox(valcategory);
        category.setBackground(Color.WHITE);
        category.setBounds(300, 190, 400, 30);
        add(category);
        
        // Adding text using labels for income.
        JLabel income = new JLabel("Income: ");
        income.setFont(new Font("Raleway", Font.BOLD, 22));
        income.setBounds(100, 230, 500, 50);
        add(income);
        
        // Adding Dropdown using Combobox for income.
        String incomecategory[] = {"Null", "< 1,50,000", "< 2,50,000", "< 5,00,000", "upto 10,00,000"};
        incomec = new JComboBox(incomecategory);
        incomec.setBackground(Color.WHITE);
        incomec.setBounds(300, 240, 400, 30);
        add(incomec);
        
        // Adding text using labels for Education Qualification.
        JLabel edu = new JLabel("Educational");
        edu.setFont(new Font("Raleway", Font.BOLD, 22));
        edu.setBounds(100, 280, 500, 50);
        add(edu);
        JLabel qual = new JLabel("Qualification: ");
        qual.setFont(new Font("Raleway", Font.BOLD, 22));
        qual.setBounds(100, 305, 500, 50);
        add(qual);
        
        // Adding Dropdown using Combobox for education classification.
        String educategory[] = {"Non-Graduation", "Graduate", "Post-Graduation", "Doctrate", "Other"};
        education = new JComboBox(educategory);
        education.setBackground(Color.WHITE);
        education.setBounds(300, 305, 400, 30);
        add(education);
        
        // Adding text using labels for occupation.
        JLabel occ = new JLabel("Occupation: ");
        occ.setFont(new Font("Raleway", Font.BOLD, 22));
        occ.setBounds(100, 360, 500, 50);
        add(occ);
        
        // Adding Dropdown using Combobox for occupation.
        String occcategory[] = {"Salaried", "Self-Employed", "Bussiness", "Student", "Retired", "Others"};
        occupation = new JComboBox(occcategory);
        occupation.setBackground(Color.WHITE);
        occupation.setBounds(300, 370, 400, 30);
        add(occupation);
        
        // Adding text using labels for Pan number.
        JLabel pan = new JLabel("Pan Number: ");
        pan.setFont(new Font("Raleway", Font.BOLD, 22));
        pan.setBounds(100, 410, 500, 50);
        add(pan);
        
        // Adding text box using TextFields for Pan number.
        Tpan = new JTextField();
        Tpan.setFont(new Font("Raleway", Font.BOLD, 14));
        Tpan.setBounds(300, 420, 400, 30);
        add(Tpan);
        
        // Adding text using labels for Aadhar Number.
        JLabel aadhar = new JLabel("Aadhar Number: ");
        aadhar.setFont(new Font("Raleway", Font.BOLD, 22));
        aadhar.setBounds(100, 460, 500, 50);
        add(aadhar);
        
        // Adding text box using TextFields for Aadhar Number.
        Taadhar = new JTextField();
        Taadhar.setFont(new Font("Raleway", Font.BOLD, 14));
        Taadhar.setBounds(300, 470, 400, 30);
        add(Taadhar);
        
        // Adding text using labels for Senior Citizen.
        JLabel sc = new JLabel("Senior Citizen: ");
        sc.setFont(new Font("Raleway", Font.BOLD, 22));
        sc.setBounds(100, 510, 500, 50);
        add(sc);
        
        // Adding Radio Button for Senior Citizen (yes) using RadioButton.
        syes = new JRadioButton("Yes");
        syes.setBounds(300, 520, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        // Adding Radio Button for Senior Citizen (no) using RadioButton.
        sno = new JRadioButton("No");
        sno.setBounds(410, 520, 100, 30);
        sno.setBackground(Color.WHITE);
        add(sno);
                
        // Grouping all Radio Buttons of Senior Citizen to avoid multiple selctions using ButtonGroup.
        ButtonGroup scgroup = new ButtonGroup();
        scgroup.add(syes);
        scgroup.add(sno);
        
        // Adding text using labels for Exisiting Account.
        JLabel Ea = new JLabel("Exisiting Account: ");
        Ea.setFont(new Font("Raleway", Font.BOLD, 22));
        Ea.setBounds(100, 560, 500, 50);
        add(Ea);
        
        // Adding Radio Button for Exisiting Account (yes) using RadioButton.
        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 570, 100, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        // Adding Radio Button for Exisiting Account (no) using RadioButton.
        eno = new JRadioButton("No");
        eno.setBounds(410, 570, 100, 30);
        eno.setBackground(Color.WHITE);
        add(eno);
                
        // Grouping all Radio Buttons  of Exisiting Account to avoid multiple selctions using ButtonGroup.
        ButtonGroup Msgroup = new ButtonGroup();
        Msgroup.add(eyes);
        Msgroup.add(eno);
        
        
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
        String religion = (String) dreligion.getSelectedItem();
        String SCategory = (String) category.getSelectedItem();
        String Income = (String) incomec.getSelectedItem();
        String SEducation = (String) education.getSelectedItem();
        String Soccupation = (String) occupation.getSelectedItem();
        String pan = Tpan.getText();
        String aadhar = Taadhar.getText();
        String Scitizen = null;
        if (syes.isSelected()) {
            Scitizen = "Yes";
        } else if (sno.isSelected()) {
            Scitizen = "No";
        }
        String Eaccount = null;
        if (eyes.isSelected()) {
            Eaccount = "Yes";
        } else if (eno.isSelected()) {
            Eaccount = "No";
        }
        
        try {
            // establishing connection from connection class. 
                connection  c = new connection();
                String query = "insert into signup2 values ('"+formno+"','"+religion+"', '"+SCategory+"', '"+Income+"', '"+SEducation+"', '"+Soccupation+"', '"+pan+"', '"+aadhar+"', '"+Scitizen+"', '"+Eaccount+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new Signup3(formno).setVisible(true);
                
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
   
    public static void main(String[] args) {
        new Signup2("");
    }
}
