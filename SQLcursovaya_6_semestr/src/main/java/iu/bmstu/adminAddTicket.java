package iu.bmstu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class adminAddTicket {
     JPanel addTicket;
    private JTextField id;
    private JTextArea text;
    private JTextField ticket;
    private JTextField price;
    private JSpinner seat;
    private JSpinner flight;

    public adminAddTicket(){
        ticket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=RailwayTransportation;user=sa;password=<AdelinaZAGITOVA05051998>";
                try {
                    // Load SQL Server JDBC driver and establish connection.
                    System.out.print("Connecting to SQL Server ... ");
                    try (Connection connection = DriverManager.getConnection(connectionUrl)) {
                        System.out.println("Done.");
                        String sql = "INSERT transportation.Ticket(NumberTicket,NumberFlight,IDPassport,FullName,PriceTicket,PassengerSeat) VALUES " +
                                "(?,?,?,(select FullName from transportation.Passenger where IDPassport = N'"+id.getText()+"'),?,?)";

                        try (PreparedStatement statement = connection.prepareStatement(sql)) {
                            statement.setString(1, ticket.getText());
                            statement.setInt(2, (int)flight.getValue());
                            statement.setString(3, id.getText());
                            statement.setString(4, price.getText());
                            statement.setInt(5, (int)seat.getValue());

                            int rowsAffected = statement.executeUpdate();
                            System.out.println(id);
                            System.out.println(rowsAffected + " row(s) inserted");
                        }
                        try (Statement statement = connection.createStatement();){
                            ResultSet resultSet = statement.executeQuery("SELECT NumberTicket,NumberFlight,IDPassport,FullName,PriceTicket,PassengerSeat" +
                                    "  FROM transportation.Ticket where IDPassport = N'"+id.getText()+"' and  NumberFlight = "+(int)flight.getValue()+";");
                            resultSet.next();
                            text.setText( " |NumberTicket: "+ resultSet.getString(1)
                                    + "\n |NumberFlight: " + resultSet.getInt(2)
                                    + "\n |IDPassport: " + resultSet.getString(3)
                                    + "\n |FullName: " + resultSet.getString(4)
                                    + "\n |PriceTicket:  " + resultSet.getString(5)
                                    + "\n |PassengerSeat:  " + resultSet.getInt(6));
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
