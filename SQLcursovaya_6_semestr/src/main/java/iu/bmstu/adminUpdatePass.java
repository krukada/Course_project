package iu.bmstu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class adminUpdatePass {
     JPanel adminUpdatePass;
    private JTextField fullName;
    private JSpinner age;
    private JTextField phone;
    private JTextField id;
    private JTextArea text;
    String password;
     public adminUpdatePass(){
         phone.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {

                 String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=RailwayTransportation;user=sa;password=<AdelinaZAGITOVA05051998>";
                 try {
                     // Load SQL Server JDBC driver and establish connection.
                     System.out.print("Connecting to SQL Server ... ");
                     try (Connection connection = DriverManager.getConnection(connectionUrl)) {
                         System.out.println("Done.");
                         String sql = "UPDATE transportation.Passenger set FullName  = ? , Age = ?, Phone = ?  where IDPassport = N'"+id.getText()+"';";

                         try (PreparedStatement statement = connection.prepareStatement(sql)) {
                             statement.setString(1, fullName.getText());
                             statement.setInt(2, (int)age.getValue());
                             statement.setString(3, phone.getText());

                             int rowsAffected = statement.executeUpdate();
                             System.out.println(password);
                             System.out.println(rowsAffected + " row(s) updated");
                         }
                         try (Statement statement = connection.createStatement();){
                             ResultSet resultSet = statement.executeQuery("SELECT IDPassport , FullName , DateOfBirth, Age," +
                                     " CityOfBirth,Phone FROM transportation.Passenger WHERE (IDPassport = '"+ id.getText() +"');");
                             resultSet.next();
                             text.setText( " |Паспорт: "+ resultSet.getString(1)
                                     + "\n |ФИО: " + resultSet.getString(2)
                                     + "\n |День и год рождения: " + resultSet.getString(3)
                                     + "\n |Возраст: " + resultSet.getInt(4)
                                     + "\n |Город рождения:  " + resultSet.getString(5)
                                     + "\n |Номер телефона:  " + resultSet.getString(6));
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
