package iu.bmstu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class UPDATERout {
    JPanel route;
    private JTextField departureStation;
    private JTextField travelTime;
    private JTextField dTime;
    private JTextField aTime;
    private JTextField arStation;
    private JTextArea text;
    private JTextField textField6;
    public UPDATERout(){
        travelTime.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=RailwayTransportation;user=sa;password=<AdelinaZAGITOVA05051998>";
                try {
                    // Load SQL Server JDBC driver and establish connection.
                    System.out.print("Connecting to SQL Server ... ");
                    try (Connection connection = DriverManager.getConnection(connectionUrl)) {
                        System.out.println("Done.");
                        String sql = "UPDATE transportation.Route set DepartureStation  = ?, DepartureTime = ?," +
                                "  ArrivalStation = ?, ArrivalTime = ?, TravelTime = ? where RouteFlight  = N'"+textField6.getText()+"';";

                        try (PreparedStatement statement = connection.prepareStatement(sql)) {
                            statement.setString(1, departureStation.getText());
                            statement.setString(2, dTime.getText());
                            statement.setString(3, arStation.getText());
                            statement.setString(4, aTime.getText());
                            statement.setString(5, travelTime.getText());


                            int rowsAffected = statement.executeUpdate();
                            System.out.println(rowsAffected + " row(s) updated");
                        }
                        try (Statement statement = connection.createStatement();){
                            ResultSet resultSet = statement.executeQuery("SELECT DepartureStation, DepartureTime,ArrivalStation," +
                                    " ArrivalTime , TravelTime  " +
                                    "  FROM transportation.Route where RouteFlight = N'"+textField6.getText()+"';");
                            resultSet.next();
                            text.setText( " |DepartureStation: "+ resultSet.getString(1)
                                    + "\n |DepartureTime: " + resultSet.getString(2)
                                    + "\n |ArrivalStation: " + resultSet.getString(3)
                                    + "\n |ArrivalTime: " + resultSet.getString(4)
                                    + "\n |TravelTime: " + resultSet.getString(5));
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
