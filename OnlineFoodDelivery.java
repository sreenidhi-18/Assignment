import java.sql.*;
class OnlineFoodDelivery {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/food_delivery";
        String user = "root";
        String password = "Shrideviha@7s";

        try {


            Class.forName("com.mysql.cj.jdbc.Driver");


            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt = con.createStatement();

            System.out.println("Database Connected\n");


            System.out.println("All Food Items:");
            ResultSet rs1 = stmt.executeQuery("SELECT * FROM Food_Items");
            while (rs1.next()) {
                System.out.println(rs1.getInt("food_id") + " "
                        + rs1.getString("food_name") + " "
                        + rs1.getInt("price"));
            }


            System.out.println("\nFood items costing more than 200:");
            ResultSet rs2 = stmt.executeQuery(
                    "SELECT * FROM Food_Items WHERE price > 200");

            while (rs2.next()) {
                System.out.println(rs2.getString("food_name") + " "
                        + rs2.getInt("price"));
            }

            System.out.println("\nFood items price >150 AND restaurant_id =2:");
            ResultSet rs3 = stmt.executeQuery(
                    "SELECT * FROM Food_Items WHERE price >150 AND restaurant_id =2");

            while (rs3.next()) {
                System.out.println(rs3.getString("food_name"));
            }


            System.out.println("\nRestaurants in Chennai OR Bangalore:");
            ResultSet rs4 = stmt.executeQuery(
                    "SELECT * FROM Restaurants WHERE city='Chennai' OR city='Bangalore'");

            while (rs4.next()) {
                System.out.println(rs4.getString("restaurant_name"));
            }

            System.out.println("\nCustomers starting with A:");
            ResultSet rs5 = stmt.executeQuery(
                    "SELECT * FROM Customers WHERE name LIKE 'A%'");

            while (rs5.next()) {
                System.out.println(rs5.getString("name"));
            }

            System.out.println("\nFood items containing Pizza:");
            ResultSet rs6 = stmt.executeQuery(
                    "SELECT * FROM Food_Items WHERE food_name LIKE '%Pizza%'");

            while (rs6.next()) {
                System.out.println(rs6.getString("food_name"));
            }

            // Task 5 – BETWEEN
            System.out.println("\nFood items between 100 and 300:");
            ResultSet rs7 = stmt.executeQuery(
                    "SELECT * FROM Food_Items WHERE price BETWEEN 100 AND 300");

            while (rs7.next()) {
                System.out.println(rs7.getString("food_name") + " "
                        + rs7.getInt("price"));
            }


            System.out.println("\nFood items sorted by price (High to Low):");
            ResultSet rs8 = stmt.executeQuery(
                    "SELECT * FROM Food_Items ORDER BY price DESC");

            while (rs8.next()) {
                System.out.println(rs8.getString("food_name") + " "
                        + rs8.getInt("price"));
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
