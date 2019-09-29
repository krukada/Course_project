package iu.bmstu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class AddRoute {
  JPanel route;
    private JTextField routF;
    private JTextField dSt;
    private JTextField dT;
    private JTextField aST;
    private JTextField aT;
    private JTextField time;
    private JTextArea textArea1;
    public AddRoute(){
      time.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=RailwayTransportation;user=sa;password=<AdelinaZAGITOVA05051998>";
          try {
            // Load SQL Server JDBC driver and establish connection.
            System.out.print("Connecting to SQL Server ... ");
            try (Connection connection = DriverManager.getConnection(connectionUrl)) {
              System.out.println("Done.");
              String sql = "INSERT transportation.Route (RouteFlight,DepartureStation, DepartureTime,ArrivalStation, ArrivalTime ,TravelTime  ) VALUES " +
                      "(?,?,?,?,?,?)";

              try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, routF.getText());
                statement.setString(2, dSt.getText());
                statement.setString(3, dT.getText());
                statement.setString(4, aST.getText());
                statement.setString(5, aT.getText());
                statement.setString(6, time.getText());

                int rowsAffected = statement.executeUpdate();
                System.out.println(rowsAffected + " row(s) inserted");
              }
              try (Statement statement = connection.createStatement();){
                ResultSet resultSet = statement.executeQuery("SELECT RouteFlight,DepartureStation, DepartureTime,ArrivalStation, ArrivalTime ,TravelTime " +
                        " FROM transportation.Route WHERE (RouteFlight = N'"+ routF.getText() +"');");
                resultSet.next();
                textArea1.setText( " |RouteFlight: "+ resultSet.getString(1)
                        + "\n |DepartureStation: " + resultSet.getString(2)
                        + "\n |DepartureTime: " + resultSet.getString(3)
                        + "\n |ArrivalStation: " + resultSet.getString(4)
                        + "\n |ArrivalTime:  " + resultSet.getString(5)
                        + "\n |TravelTime:  " + resultSet.getString(6));
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
