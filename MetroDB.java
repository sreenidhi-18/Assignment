import java.sql.*;

class MetroManagement {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/metrodb";
        String user = "root";
        String password = "Nidhi@1514";

        try {

            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt = con.createStatement();

            // Disable foreign key checks
            stmt.executeUpdate("SET FOREIGN_KEY_CHECKS=0");

            // Drop tables if they exist
            stmt.executeUpdate("DROP TABLE IF EXISTS Metro_Trains");
            stmt.executeUpdate("DROP TABLE IF EXISTS Stations");

            // Enable foreign key checks again
            stmt.executeUpdate("SET FOREIGN_KEY_CHECKS=1");

            // Create Stations table
            stmt.executeUpdate(
                    "CREATE TABLE Stations (" +
                            "station_id INT PRIMARY KEY," +
                            "station_name VARCHAR(50)," +
                            "location VARCHAR(50)," +
                            "platforms INT," +
                            "opening_year INT)"
            );

            // Create Metro_Trains table
            stmt.executeUpdate(
                    "CREATE TABLE Metro_Trains (" +
                            "train_id INT PRIMARY KEY," +
                            "train_name VARCHAR(50)," +
                            "capacity INT," +
                            "station_id INT," +
                            "FOREIGN KEY (station_id) REFERENCES Stations(station_id))"
            );

            // Insert Stations
            stmt.executeUpdate("INSERT INTO Stations VALUES (1,'Majestic','Bangalore',6,2011)");
            stmt.executeUpdate("INSERT INTO Stations VALUES (2,'Indiranagar','Bangalore',4,2012)");
            stmt.executeUpdate("INSERT INTO Stations VALUES (3,'MG Road','Bangalore',5,2011)");
            stmt.executeUpdate("INSERT INTO Stations VALUES (4,'Whitefield','Bangalore',3,2023)");
            stmt.executeUpdate("INSERT INTO Stations VALUES (5,'Yelahanka','Bangalore',2,2020)");

            // Insert Trains
            stmt.executeUpdate("INSERT INTO Metro_Trains VALUES (101,'Metro Express',1200,1)");
            stmt.executeUpdate("INSERT INTO Metro_Trains VALUES (102,'City Rider',1000,2)");
            stmt.executeUpdate("INSERT INTO Metro_Trains VALUES (103,'Rapid Metro',1100,3)");

            // Update capacity
            stmt.executeUpdate("UPDATE Metro_Trains SET capacity=1300 WHERE train_id=101");

            // Delete one station
            stmt.executeUpdate("DELETE FROM Stations WHERE station_id=5");

            // Display Stations
            System.out.println("Stations Table:");
            ResultSet rs = stmt.executeQuery("SELECT * FROM Stations");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("station_id") + " " +
                                rs.getString("station_name") + " " +
                                rs.getString("location") + " " +
                                rs.getInt("platforms") + " " +
                                rs.getInt("opening_year"));
            }

            // Display Trains
            System.out.println("\nTrains Table:");
            rs = stmt.executeQuery("SELECT * FROM Metro_Trains");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("train_id") + " " +
                                rs.getString("train_name") + " " +
                                rs.getInt("capacity") + " " +
                                rs.getInt("station_id"));
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
