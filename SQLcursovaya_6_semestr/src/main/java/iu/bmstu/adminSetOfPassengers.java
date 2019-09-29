package iu.bmstu;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class adminSetOfPassengers {
     JPanel set;
    private JSpinner flight;
    private JTextArea text;

    public adminSetOfPassengers(){
        flight.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=RailwayTransportation;user=sa;password=<AdelinaZAGITOVA05051998>";
                try {
                    // Load SQL Server JDBC driver and establish connection.
                    System.out.print("Connecting to SQL Server ... ");
                    try (Connection connection = DriverManager.getConnection(connectionUrl)) {
                        System.out.println("Done.");

                        try (Statement statement = connection.createStatement();
                             ResultSet resultSet = statement.executeQuery("SELECT NumberTicket,NumberFlight,IDPassport,FullName,PriceTicket,PassengerSeat " +
                                     "FROM transportation.Ticket where   NumberFlight = "+(int)flight.getValue()+"; ")) {
                            while (resultSet.next()) {
                                text.append(" \nNumberTicket: "+ resultSet.getString(1)
                                        + " |NumberFlight: " + resultSet.getInt(2)
                                        + " |IDPassport: " + resultSet.getString(3)
                                        + " |FullName: " + resultSet.getString(4)
                                        + " |PriceTicket:  " + resultSet.getString(5)
                                        + " |PassengerSeat:  " + resultSet.getInt(6));
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
