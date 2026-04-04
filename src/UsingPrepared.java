package src;
import java.sql.*;
import java.util.Scanner;

public class UsingPrepared {
    public static void main(String[] args) throws Exception {
        try (Scanner sc = new Scanner(System.in)) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/practice";
            String user = "root";
            String password = "Aditya@2002";

            try (Connection con = DriverManager.getConnection(url, user, password)) {

                // ✅ CREATE - Insert a new student
                // String insertSql = "INSERT INTO students VALUES (?, ?, ?)";
                // PreparedStatement insertPs = con.prepareStatement(insertSql);
                // System.out.print("Enter ID :");
                // int id = sc.nextInt();
                // insertPs.setInt(1, id);
   
                // System.out.print("Enter Name :");
                // String name = sc.next();
                // insertPs.setString(2, name);
                
                // System.out.print("Enter Marks :");
                // int marks = sc.nextInt();
                // insertPs.setInt(3, marks);
                // insertPs.executeUpdate();
                // System.out.println("--- Inserted " + id + " ---");

                // ✅ READ - Select a student by ID
                // String selectSql = "SELECT * FROM students WHERE id = ?";
                // PreparedStatement selectPs = con.prepareStatement(selectSql);
                // selectPs.setInt(1, id);
                // ResultSet rs = selectPs.executeQuery();
                // while (rs.next()) {
                //     System.out.println("ID: " + rs.getInt("id") +
                //             " | Name: " + rs.getString("name") +
                //             " | Marks: " + rs.getInt("marks"));
                // }

                // ✅ UPDATE - Update marks by ID
                // String updateSql = "UPDATE students SET marks = ? WHERE id = ?";
                // PreparedStatement updatePs = con.prepareStatement(updateSql);
                // System.out.println("Enter student ID to update marks :");
                // int studentId = sc.nextInt();
                // System.out.print("Enter new marks for student " + studentId + " : ");
                // int newMarks = sc.nextInt();
                // updatePs.setInt(1, newMarks);
                // updatePs.setInt(2, studentId);
                // updatePs.executeUpdate();
                // System.out.println("--- Updated student " + studentId + "'s marks ---");

                // // ✅ DELETE - Delete a student by ID
                String deleteSql = "DELETE FROM students WHERE id = ?";
                PreparedStatement deletePs = con.prepareStatement(deleteSql);
                System.out.println("Enter student ID to delete :");
                int studentId1 = sc.nextInt();
                deletePs.setInt(1, studentId1);
                deletePs.executeUpdate();
                System.out.println("--- Deleted student " + studentId1 + " ---");

                // ✅ READ ALL - Verify final state
                System.out.println("--- Final table state ---");
                PreparedStatement allPs = con.prepareStatement("SELECT * FROM students");
                ResultSet allRs = allPs.executeQuery();
                while (allRs.next()) {
                    System.out.println("ID: " + allRs.getInt("id") +
                            " | Name: " + allRs.getString("name") +
                            " | Marks: " + allRs.getInt("marks"));
                }
            }
        }
    }
}