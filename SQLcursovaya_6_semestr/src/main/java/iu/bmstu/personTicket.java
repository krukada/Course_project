package iu.bmstu;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.math.BigDecimal;
import java.sql.Date;

public class personTicket {
    JPanel InformTicket;
    private JSpinner dataFlight;
    private JLabel flight;
    private JLabel password;
    private JTextArea dane;
    private JTextArea dane2;
    private JPasswordField passwordField1;

    public personTicket(){
       passwordField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent en) {
                        String getValue = passwordField1.getText();
                        int getFlight = (int)dataFlight.getValue();
                        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=RailwayTransportation;user=sa;password=<AdelinaZAGITOVA05051998>";
                        try {
                            // Load SQL Server JDBC driver and establish connection.
                            System.out.print("Connecting to SQL Server ... ");
                            try (Connection connection = DriverManager.getConnection(connectionUrl)) {
                                System.out.println("Done.");
                                //System.in.read();
                                try (Statement statement = connection.createStatement();){
                                    ResultSet resultSet = statement.executeQuery("SELECT NumberTicket , NumberFlight, IDPassport,FullName," +
                                            " PriceTicket,PassengerSeat FROM transportation.Ticket WHERE (IDPassport = '"+ getValue +"') and (NumberFlight = "+getFlight+")");
                                    resultSet.next();
                                    dane.setText( " |Номер билета: "+ resultSet.getString(1)
                                            + "\n |Номер рейса " + resultSet.getInt(2)
                                            + "\n |Паспорт: " + resultSet.getString(3)
                                            + "\n |ФИО: " + resultSet.getString(4)
                                            + "\n |Цена:  " + resultSet.getBigDecimal(5)
                                            + "\n |Место в поезде:  " + resultSet.getInt(6));
                                    resultSet = statement.executeQuery("SELECT  DateFlight,NumberTrain FROM transportation.Flight WHERE (NumberFlight = "+getFlight+")");
                                    resultSet.next();
                                    dane2.setText(" |Дата поезки: " + resultSet.getString(1)
                                            + "\n |Номер поезда: " +resultSet.getString(2));
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
