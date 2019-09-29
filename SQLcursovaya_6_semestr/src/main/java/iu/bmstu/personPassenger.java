package iu.bmstu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class personPassenger {
    JPanel InformPassenger;
    private JPasswordField password;
    private JLabel pas;
    private JTextArea text;
    private JTextArea text2;

    public personPassenger(){
        password.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String getValue = password.getText();
                String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=RailwayTransportation;user=sa;password=<AdelinaZAGITOVA05051998>";
                try {
                    // Load SQL Server JDBC driver and establish connection.
                    System.out.print("Connecting to SQL Server ... ");
                    try (Connection connection = DriverManager.getConnection(connectionUrl)) {
                        System.out.println("Done.");
                        try (Statement statement = connection.createStatement();
                             ResultSet resultSet = statement.executeQuery("SELECT IDPassport,FullName," +
                                     "DateOfBirth,Age,CityOfBirth,Phone FROM transportation.Passenger WHERE (IDPassport = '"+ getValue +"') ")) {
                            while (resultSet.next()) {
                                text.setText( " |Паспорт: "+ resultSet.getString(1)
                                        + "\n |ФИО: " + resultSet.getString(2)
                                        + "\n |День и год рождения: " + resultSet.getString(3)
                                        + "\n |Возраст:  " + resultSet.getInt(4)
                                        + "\n |Город рождения:  " + resultSet.getString(5)
                                        + "\n |Номер телефона:  " + resultSet.getString(6));
                            }

                        }
                        try (Statement statement = connection.createStatement();
                               ResultSet resultSet = statement.executeQuery("SELECT NumberTicket , NumberFlight " +
                                " FROM transportation.Ticket WHERE (IDPassport = '"+ getValue +"')")) {
                            while (resultSet.next()) {
                                text2.setText( " |Номер билета: "+ resultSet.getString(1)
                                        + "|Номер рейса " + resultSet.getInt(2));
                            }
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
