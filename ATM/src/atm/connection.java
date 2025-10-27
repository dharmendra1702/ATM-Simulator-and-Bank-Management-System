package atm;

import java.sql.*;

public class connection {
    
    // declared here to use in both insde Constructor and outside Constructor.
    Connection c;
    Statement s;
    public connection() {
        try { 
            // establishing connection with my default root address.
            c = DriverManager.getConnection("jdbc:mysql:///Atm", "root", "Dharmu@17");
            s = c.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
