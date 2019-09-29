package iu.bmstu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class personFlight {
     JPanel flight;
    private JTextField from;
    private JTextField where;
    private JTextArea text;
    private JTextArea text2;

    public personFlight(){
        text.setText("| Route Flight | Number Flight |        Date       |     Departure Station    |     Departure TIME       |        Arrival Station    |        Arrival TIME    |     Travel TIME         |");
        where.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String getWhere = where.getText();
                String getfrom = from.getText();
                String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=RailwayTransportation;user=sa;password=<AdelinaZAGITOVA05051998>";
                try {
                    // Load SQL Server JDBC driver and establish connection.
                    System.out.print("Connecting to SQL Server ... ");
                    try (Connection connection = DriverManager.getConnection(connectionUrl)) {
                        System.out.println("Done.");

                        try (Statement statement = connection.createStatement();
                             ResultSet resultSet = statement.executeQuery("SELECT p.RouteFlight as RouteFlight, "+
                                     "  d.NumberFlight as NumberFlight, " +
                                     "  d.DateFlight as DateFlight, " +
                                     "  p.DepartureStation as DepartureStation, " +
                                     " p.DepartureTime as DepartureTime, " +
                                     " p.ArrivalStation as ArrivalStation, " +
                                     " p.ArrivalTime as ArrivalTime, " +
                                     "  p. TravelTime as TravelTime FROM transportation.Route as p,transportation.Flight as d " +
                                     "  WHERE p.RouteFlight = d.RouteFlight and " +
                                     " (DepartureStation = N'"+getfrom+"') and (ArrivalStation = N'"+getWhere+"') ")) {
                            while (resultSet.next()) {
                                text2.append("\n" + resultSet.getString(1) + "                  " +
                                        + resultSet.getInt(2) + "                " +
                                        "     " + resultSet.getString(3) + "               " +
                                        "   " + resultSet.getString(4) +
                                        "           " + resultSet.getString(5) + "         " +
                                        "    " + resultSet.getString(6) + "    " +
                                        "         " + resultSet.getString(7) +
                                        "    " + resultSet.getString(8));
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
