package src;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class UsingSwitch {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/config.properties"));
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = prop.getProperty("db.url");
        String user = prop.getProperty("db.user");
        String password = prop.getProperty("db.password");
        try(Scanner sc  = new Scanner(System.in);
        Connection con = DriverManager.getConnection(url, user, password)) {
            System.out.println("1. Insert\n2. Read by ID\n3. Update Marks\n4. Delete\n5. Show All");
            System.out.print("enter your choice : ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                        System.out.print("How many students to insert? ");
                        int count = sc.nextInt();

                        con.setAutoCommit(false);
                        PreparedStatement ps = con.prepareStatement("INSERT INTO students VALUES (?, ?, ?)");

                        for (int i = 0; i < count; i++) {
                                System.out.println("--- Student " + (i + 1) + " ---");
                                System.out.print("ID: ");    int id = sc.nextInt();
                                System.out.print("Name: ");  String name = sc.next();
                                System.out.print("Marks: "); int marks = sc.nextInt();

                                ps.setInt(1, id);
                                ps.setString(2, name);
                                ps.setInt(3, marks);
                                ps.addBatch();
                        }

                        try {
                                int[] results = ps.executeBatch();
                                con.commit();
                                System.out.println(" Inserted " + results.length + " students!");
                        } catch (SQLException e) {
                                con.rollback();
                                System.out.println(" Duplicate ID found! Nothing inserted. " + e.getMessage());
                        }
                        }
                case 2 -> {
                        System.out.print("Enter ID to read: ");
                        int id = sc.nextInt();
                        PreparedStatement ps = con.prepareStatement("SELECT * FROM students WHERE id = ?");
                        ps.setInt(1, id);
                        var rs = ps.executeQuery();
                        while (rs.next()) {
                            System.out.println("ID: " + rs.getInt("id") +
                                    " | Name: " + rs.getString("name") +
                                    " | Marks: " + rs.getInt("marks"));
                        }
                }
                case 3 -> {
                        System.out.print("Enter ID to update marks: ");
                        int id = sc.nextInt();
                        System.out.print("Enter new marks: ");
                        int newMarks = sc.nextInt();
                        PreparedStatement ps = con.prepareStatement("UPDATE students SET marks = ? WHERE id = ?");
                        ps.setInt(1, newMarks); ps.setInt(2, id);
                        ps.executeUpdate();
                        System.out.println("Updated successfully!");
                }
                case 4 -> {
                        System.out.print("Enter ID to delete: ");
                        int id = sc.nextInt();
                        PreparedStatement ps = con.prepareStatement("DELETE FROM students WHERE id = ?");
                        ps.setInt(1, id);
                        ps.executeUpdate();
                        System.out.println("Deleted successfully!");
                }
                case 5 -> {
                        PreparedStatement ps = con.prepareStatement("SELECT * FROM students");
                        var rs = ps.executeQuery();
                        while (rs.next()) {
                            System.out.println("ID: " + rs.getInt("id") +
                                    " | Name: " + rs.getString("name") +
                                    " | Marks: " + rs.getInt("marks"));
                        }
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
