import java.sql.*;
import java.util.*;

public class DBHandler {
    private static final String URL = "jdbc:mysql://localhost:3306/Learning";
    private static final String USER = "root";
    private static final String PASSWORD = "jAy230403";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL Driver not found");
            e.printStackTrace();
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }


    public static void addStudent(Student student) {
        String sql = "INSERT INTO students (roll_no, name, marks1, marks2, marks3) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, student.getRollNo());
            stmt.setString(2, student.getName());
            stmt.setInt(3, student.getMarks()[0]);
            stmt.setInt(4, student.getMarks()[1]);
            stmt.setInt(5, student.getMarks()[2]);
            stmt.executeUpdate();
            System.out.println("Student added to database.");
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Roll number already exists.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int roll = rs.getInt("roll_no");
                String name = rs.getString("name");
                int[] marks = {
                    rs.getInt("marks1"),
                    rs.getInt("marks2"),
                    rs.getInt("marks3")
                };
                students.add(new Student(name, roll, marks));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }
}
