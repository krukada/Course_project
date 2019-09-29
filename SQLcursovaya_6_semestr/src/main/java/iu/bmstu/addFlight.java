package iu.bmstu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class addFlight {
  JPanel flight;
  private JTextField date;
  private JTextField rF;
  private JTextField train;
    private JTextArea textArea1;
    public addFlight(){
      train.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=RailwayTransportation;user=sa;password=<AdelinaZAGITOVA05051998>";
          try {
            // Load SQL Server JDBC driver and establish connection.
            System.out.print("Connecting to SQL Server ... ");
            try (Connection connection = DriverManager.getConnection(connectionUrl)) {
              System.out.println("Done.");
              String sql = "INSERT transportation.Flight (DateFlight,RouteFlight, NumberTrain) VALUES " +
                      "(?,?,?)";

              try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, date.getText());
                statement.setString(2, rF.getText());
                statement.setString(3, train.getText());

                int rowsAffected = statement.executeUpdate();
                System.out.println(rowsAffected + " row(s) inserted");
              }
              try (Statement statement = connection.createStatement();){
                ResultSet resultSet = statement.executeQuery("SELECT NumberFlight,DateFlight,RouteFlight, NumberTrain " +
                        " FROM transportation.Flight WHERE (DateFlight= N'"+ date.getText() +"') and (RouteFlight = N'"+ rF.getText() +"') and " +
                        " ( NumberTrain= N'"+ train.getText() +"') ;");
                resultSet.next();
                textArea1.setText( " |NumberFlight: "+ resultSet.getInt(1)
                        + "\n |DateFlight: " + resultSet.getString(2)
                        + "\n |RouteFlight: " + resultSet.getString(3)
                        + "\n |NumberTrain: " + resultSet.getString(4));
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
