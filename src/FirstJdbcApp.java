package src;
import java.sql.*;

public class FirstJdbcApp {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/practice";
        String user = "root";
        String password = "Aditya@2002";

        try (Connection con = DriverManager.getConnection(url,user,password)) {
            Statement st = con.createStatement();
            
            // CREATE - Insert 3 rows
            // st.executeUpdate("INSERT INTO students VALUES (1, 'Aditya', 95)");
            // st.executeUpdate("INSERT INTO students VALUES (2, 'Rahul', 88)");
            // st.executeUpdate("INSERT INTO students VALUES (3, 'Priya', 92)");
            // System.out.println("--- Inserted 3 rows ---");
            
            // READ - Select all
            // ResultSet rs = st.executeQuery("SELECT * FROM students");
            // while (rs.next()) {
            //     System.out.println("ID: " + rs.getInt("id") +
            //                        " | Name: " + rs.getString("name") +
            //                        " | Marks: " + rs.getInt("marks"));
            // }
            
            // UPDATE - Change Rahul's marks
            st.executeUpdate("UPDATE students SET marks = 100 WHERE id = 1");
            System.out.println("--- Updated Aditya's marks ---");
            
            // // DELETE - Remove Priya
            // st.executeUpdate("DELETE FROM students WHERE id = 3");
            // System.out.println("--- Deleted Priya ---");
            
            // READ again to verify
            System.out.println("--- Final table state ---");
            ResultSet rs = st.executeQuery("SELECT * FROM students");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        " | Name: " + rs.getString("name") +
                        " | Marks: " + rs.getInt("marks"));
            }
        }
    }
}