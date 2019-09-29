package iu.bmstu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class UPDATEFlight {
   JPanel flight;
   private JSpinner spinner;
   private JTextField DateFlight;
   private JTextArea textArea1;
    private JTextField textField1;

    public UPDATEFlight(){
      DateFlight.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=RailwayTransportation;user=sa;password=<AdelinaZAGITOVA05051998>";
            try {
               // Load SQL Server JDBC driver and establish connection.
               System.out.print("Connecting to SQL Server ... ");
               try (Connection connection = DriverManager.getConnection(connectionUrl)) {
                  System.out.println("Done.");
                  String sql = "UPDATE transportation.Flight set DateFlight = ?, NumberTrain = ?  where NumberFlight = "+(int)spinner.getValue()+";";

                  try (PreparedStatement statement = connection.prepareStatement(sql)) {
                     statement.setString(1, DateFlight.getText());
                      statement.setString(2, textField1.getText());

                     int rowsAffected = statement.executeUpdate();
                     System.out.println(rowsAffected + " row(s) updated");
                  }
                  try (Statement statement = connection.createStatement();){
                     ResultSet resultSet = statement.executeQuery("SELECT NumberFlight , DateFlight, RouteFlight, NumberTrain " +
                             "  FROM transportation.Flight where NumberFlight = "+(int)spinner.getValue()+";");
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
