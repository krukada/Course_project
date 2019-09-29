package iu.bmstu;

import java.sql.*;

public class App {

    public static void main(String[] args) {

        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=RailwayTransportation;user=sa;password=<AdelinaZAGITOVA05051998>";

        try {
            // Load SQL Server JDBC driver and establish connection.
            System.out.print("Connecting to SQL Server ... ");
            try (Connection connection = DriverManager.getConnection(connectionUrl)) {
                System.out.println("Done.");

                System.out.print("Reading data from table, press ENTER to continue...");
                System.in.read();
                /*String sql = new StringBuilder().append("USE RailwayTransportation; ")
                        .append("SELECT NumberTrain, NumberOfSeats, NamberOfWagons FROM transportation.NameTrain;")
                        .toString();
                try (Statement statement = connection.createStatement();
                     ResultSet resultSet = statement.executeQuery(sql)) {
                    while (resultSet.next()) {
                        System.out.println(
                                resultSet.getString(1) + " |  " + resultSet.getInt(2) + " |  " + resultSet.getInt(3));
                    }
                }
                try (Statement statement = connection.createStatement();){
                    ResultSet resultSet = statement.executeQuery("SELECT NumberTrain, NumberOfSeats, NamberOfWagons FROM transportation.NameTrain WHERE (NumberOfSeats = 90)");
                    resultSet.next();
                    System.out.println(
                            resultSet.getString(1) + " |  " + resultSet.getInt(2) + " |  " + resultSet.getInt(3));
                }*/
                connection.close();
                System.out.println("All done.");
            }
        } catch (Exception e) {
            System.out.println();
            e.printStackTrace();
        }
    }
}

