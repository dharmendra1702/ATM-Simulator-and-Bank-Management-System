package atm;

import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class ds extends JFrame {

    String pinnumber;

    ds(String pinnumber) {
        this.pinnumber = pinnumber;

        setLayout(null);
        setTitle("Deposit Statement");

        // --- Create JTextArea ---
        JTextArea mini = new JTextArea();
        mini.setEditable(false);
        mini.setFont(new Font("Consolas", Font.PLAIN, 14));
        mini.setBackground(Color.WHITE);
        mini.setMargin(new Insets(15, 20, 15, 20));
        mini.setLineWrap(true);
        mini.setWrapStyleWord(true);

        // --- Wrap JTextArea inside JScrollPane ---
        JScrollPane scrollPane = new JScrollPane(mini);
        scrollPane.setBounds(20, 100, 350, 400);
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        JScrollBar verticalBar = scrollPane.getVerticalScrollBar();
        verticalBar.setPreferredSize(new Dimension(8, Integer.MAX_VALUE));
        verticalBar.setUnitIncrement(10);

        add(scrollPane);

        JLabel card = new JLabel();
        card.setBounds(20, 70, 300, 20);
        add(card);

        try {
            connection conn = new connection();

            // Fetch card number
            ResultSet rsCard = conn.s.executeQuery("SELECT * FROM login WHERE Pinnumber = '" + pinnumber + "'");
            String cardNumber = "";
            if (rsCard.next()) {
                cardNumber = rsCard.getString("carnumber");
                cardNumber = cardNumber.substring(0, 4) + "XXXXXXXX" + cardNumber.substring(12);
            }

            // Fetch latest deposit transaction
            ResultSet rsDeposit = conn.s.executeQuery(
                "SELECT * FROM bank WHERE pinnumber = '" + pinnumber + "' AND type = 'Deposit' ORDER BY date DESC LIMIT 1"
            );

            String latestDate = null, latestAmount = null;
            if (rsDeposit.next()) {
                latestDate = rsDeposit.getString("date");
                latestAmount = rsDeposit.getString("amount");
            }

            // Calculate total balance
            int balance = 0;
            ResultSet rsAll = conn.s.executeQuery("SELECT * FROM bank WHERE pinnumber = '" + pinnumber + "'");
            while (rsAll.next()) {
                String type = rsAll.getString("type");
                int amt = Integer.parseInt(rsAll.getString("amount"));
                if (type.equals("Deposit")) balance += amt;
                else balance -= amt;
            }

            // Build receipt
            mini.append("       XYZ BANK DEPOSIT RECEIPT\n");
            mini.append("=====================================\n");
            mini.append("Card Number: " + cardNumber + "\n");
            mini.append("-------------------------------------\n");

            if (latestAmount != null) {
                // Format date (optional)
                String[] parts = latestDate.split(" ");
                String date = (parts.length >= 6) ? parts[2] + " " + parts[1] + " " + parts[5] : latestDate;

                mini.append("Date: " + date + "\n");
                mini.append("Transaction Type: Deposit\n");
                mini.append("Amount Deposited: Rs " + latestAmount + "\n");
            } else {
                mini.append("No recent deposit found.\n");
            }

            mini.append("-------------------------------------\n");
            mini.append("Current Balance: Rs " + balance + "\n");
            mini.append("=====================================\n");
            mini.append("Thank you for banking with XYZ Bank\n");

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Frame setup
        setSize(400, 600);
        setLocation(20, 20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                setVisible(false);
                new Transaction(pinnumber);
            }
        });
    }

    public static void main(String[] args) {
        new ds(""); // test manually with a valid pin number in DB
    }
}
