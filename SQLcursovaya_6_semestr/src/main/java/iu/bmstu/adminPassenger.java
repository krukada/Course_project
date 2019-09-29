package iu.bmstu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class adminPassenger {
       JPanel passenger;
    private JTextField pasport;
    private JButton deletPass;
    private JButton updatePas;
    private JButton addTicket;
    private JButton createPass;
    private JButton setPass;
    private JButton delete;
    private JTextField del;

    public adminPassenger(){
        deletPass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pas = pasport.getText();
                String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=RailwayTransportation;user=sa;password=<AdelinaZAGITOVA05051998>";
                try {
                    // Load SQL Server JDBC driver and establish connection.
                    System.out.print("Connecting to SQL Server ... ");
                    try (Connection connection = DriverManager.getConnection(connectionUrl)) {
                        System.out.println("Done.");
                        String sql = "DELETE from transportation.Passenger where IDPassport = ?;";

                        try (PreparedStatement statement = connection.prepareStatement(sql)) {
                            statement.setString(1, pas);
                            int rowsAffected = statement.executeUpdate();
                            System.out.println(pas);
                            System.out.println(rowsAffected + " row(s) deleted");
                        }
                        connection.close();
                        System.out.println("All done.");
                    }
                } catch (Exception ex) {
                    System.out.println();
                    ex.printStackTrace();
                }
            }
        });
        updatePas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pas = new adminUpdatePass().password;
                pas = pasport.getText();
                JPanel person = new adminUpdatePass().adminUpdatePass;
                JFrame frame = new JFrame("Admin Update Pass");
                frame.setContentPane(new adminUpdatePass().adminUpdatePass);
                frame.pack();
                frame.setVisible(true);

            }
        });
        addTicket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel add = new adminAddTicket().addTicket;
                JFrame frame = new JFrame("Admin Add Ticket");
                frame.setContentPane(new adminAddTicket().addTicket);
                frame.pack();
                frame.setVisible(true);

            }
        });
        setPass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel set = new adminSetOfPassengers().set;
                JFrame frame = new JFrame("List of Passengers");
                frame.setContentPane(new adminSetOfPassengers().set);
                frame.pack();
                frame.setVisible(true);

            }
        });
        createPass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel pas = new adminCreatePass().create;
                JFrame frame = new JFrame("Create Passenger");
                frame.setContentPane(new adminCreatePass().create);
                frame.pack();
                frame.setVisible(true);
            }
        });
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=RailwayTransportation;user=sa;password=<AdelinaZAGITOVA05051998>";
                try {
                    // Load SQL Server JDBC driver and establish connection.
                    System.out.print("Connecting to SQL Server ... ");
                    try (Connection connection = DriverManager.getConnection(connectionUrl)) {
                        System.out.println("Done.");
                        String sql = "DELETE from transportation.Ticket where NumberTicket  = ?;";

                        try (PreparedStatement statement = connection.prepareStatement(sql)) {
                            statement.setString(1, del.getText());
                            int rowsAffected = statement.executeUpdate();
                            System.out.println(rowsAffected + " row(s) deleted");
                        }
                        connection.close();
                        System.out.println("All done.");
                    }
                } catch (Exception ex) {
                    System.out.println();
                    ex.printStackTrace();
                }


            }
        });
    }

}
