package atm;

import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class statement extends JFrame {

    String pinnumber;

    statement(String pinnumber) {
        this.pinnumber = pinnumber;

        setLayout(null);
        setTitle("Mini Statement");

        // --- Create JTextArea ---
        JTextArea mini = new JTextArea();
        mini.setEditable(false);
        mini.setFont(new Font("Consolas", Font.PLAIN, 14));
        mini.setBackground(Color.WHITE);
        mini.setMargin(new Insets(15, 20, 15, 20));
        mini.setLineWrap(true);        // prevents horizontal scroll
        mini.setWrapStyleWord(true);   // wraps at word boundaries

        // --- Wrap JTextArea inside JScrollPane ---
        JScrollPane scrollPane = new JScrollPane(mini);
        scrollPane.setBounds(20, 100, 350, 400);
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        // Only vertical scroll, no horizontal scroll
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // --- Decrease scrollbar width ---
        JScrollBar verticalBar = scrollPane.getVerticalScrollBar();
        verticalBar.setPreferredSize(new Dimension(8, Integer.MAX_VALUE)); // smaller width
        verticalBar.setUnitIncrement(10); // smooth scrolling speed

        // Add scrollPane to frame
        add(scrollPane);

        JLabel card = new JLabel();
        card.setBounds(20, 70, 300, 20);
        add(card);

        try {
            connection conn = new connection();
            int bal = 0;

            // Fetch card number
            ResultSet rsCard = conn.s.executeQuery("SELECT * FROM login WHERE Pinnumber = '" + pinnumber + "'");
            String cardNumber = "";
            if (rsCard.next()) {
                cardNumber = rsCard.getString("carnumber");
                cardNumber = cardNumber.substring(0, 4) + "XXXXXXXX" + cardNumber.substring(12);
            }

            // Fetch transactions
            ResultSet rs = conn.s.executeQuery("SELECT * FROM bank WHERE pinnumber = '" + pinnumber + "'");

            // Build receipt
            mini.append("           XYZ BANK ATM RECEIPT\n");
            mini.append("=====================================\n");
            mini.append("Card Number: " + cardNumber + "\n");
            mini.append("-------------------------------------\n");
            mini.append(" Date           Type          Amount\n");
            mini.append("-------------------------------------\n");

            while (rs.next()) {
                String fullDate = rs.getString("date");
                String[] parts = fullDate.split(" ");
                String date = parts[2] + " " + parts[1] + " " + parts[5];
                String type = rs.getString("type");
                String amount = rs.getString("amount");

                mini.append(String.format(" %-13s %-12s %8s\n", date, type, amount));

                if (type.equalsIgnoreCase("Deposit")) {
                    bal += Integer.parseInt(amount);
                } else {
                    bal -= Integer.parseInt(amount);
                }
            }

            mini.append("-------------------------------------\n");
            mini.append(String.format(" Current Balance: Rs %d\n", bal));
            mini.append("=====================================\n");
            mini.append("   Thank you for using XYZ Bank ATM\n");

        } catch (Exception e) {
            System.out.println(e);
        }

        // Frame setup
        setSize(400, 600);
        setLocation(20, 20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new statement("");
    }
}
