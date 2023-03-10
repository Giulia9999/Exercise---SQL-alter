import java.sql.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Connection connection;
        Statement statement = null;
        ResultSet resultSet;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/newdb?" +
                    "user='root'&password=c620918fazuKl420");
            statement = connection.createStatement();
            String query = "ALTER TABLE students ADD COLUMN country VARCHAR(30) AFTER last_name";
            String query2 = "UPDATE students SET country='Italy' WHERE student_pk=1 OR student_pk=2";
            String query3 = "UPDATE students SET country='Germany' WHERE student_pk=3 OR student_pk=4;";
            String query4 = "SELECT * FROM students";

            statement.executeQuery(query4);
            if (statement.execute(query4)) {
                resultSet = statement.getResultSet();
                while (resultSet.next()) {
                    String countries = resultSet.getString(4);
                    System.out.println(countries);
                }
            }




        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
