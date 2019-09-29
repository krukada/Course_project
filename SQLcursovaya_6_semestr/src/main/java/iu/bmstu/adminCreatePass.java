package iu.bmstu;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class adminCreatePass {
    JPanel create;
    private JTextField id;
    private JTextField phone;
    private JTextField city;
    private JTextField fullname;
    private JTextField date;
    private JSpinner age;
    private JTextArea text;

    public adminCreatePass(){
        phone.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=RailwayTransportation;user=sa;password=<AdelinaZAGITOVA05051998>";
                try {
                    // Load SQL Server JDBC driver and establish connection.
                    System.out.print("Connecting to SQL Server ... ");
                    try (Connection connection = DriverManager.getConnection(connectionUrl)) {
                        System.out.println("Done.");
                        String sql = "INSERT transportation.Passenger(IDPassport , FullName , DateOfBirth, Age, CityOfBirth,Phone ) VALUES " +
                                "(?,?,?,?,?,?)";

                        try (PreparedStatement statement = connection.prepareStatement(sql)) {
                            statement.setString(1, id.getText());
                            statement.setString(2, fullname.getText());
                            statement.setString(3, date.getText());
                            statement.setInt(4, (int)age.getValue());
                            statement.setString(5, city.getText());
                            statement.setString(6, phone.getText());

                            int rowsAffected = statement.executeUpdate();
                            System.out.println(id);
                            System.out.println(rowsAffected + " row(s) inserted");
                        }
                        try (Statement statement = connection.createStatement();){
                            ResultSet resultSet = statement.executeQuery("SELECT IDPassport ,FullName , DateOfBirth, Age," +
                                    "CityOfBirth,Phone FROM transportation.Passenger WHERE (IDPassport = N'"+ id.getText() +"');");
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
