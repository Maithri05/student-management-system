import java.sql.*;
import java.util.*;

public class StudentDAO {

    public static void addStudent(Student s) {
        try {
            Connection con = DBConnection.getConnection();
            String query = "INSERT INTO students(name, age, course) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, s.name);
            ps.setInt(2, s.age);
            ps.setString(3, s.course);
            ps.executeUpdate();
            System.out.println("Student Added Successfully");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void viewStudents() {
        try {
            Connection con = DBConnection.getConnection();
            String query = "SELECT * FROM students";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getInt("age") + " | " +
                        rs.getString("course")
                );
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void updateStudent(int id, String name, int age, String course) {
        try {
            Connection con = DBConnection.getConnection();
            String query = "UPDATE students SET name=?, age=?, course=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, course);
            ps.setInt(4, id);
            ps.executeUpdate();
            System.out.println("Student Updated Successfully");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void deleteStudent(int id) {
        try {
            Connection con = DBConnection.getConnection();
            String query = "DELETE FROM students WHERE id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Student Deleted Successfully");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}