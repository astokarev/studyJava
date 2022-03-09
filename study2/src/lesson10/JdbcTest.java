package lesson10;

import java.sql.*;

public class JdbcTest {
    private static Connection connection;
    private static Statement statement;

    private static void readEx() throws SQLException {
        try (ResultSet rs = statement.executeQuery("SELECT * FROM students1")) {
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString("name") + " " + rs.getInt(3));
            }
        }
    }

    public static void main(String[] args) throws SQLException {

        try{
            connect();
            connection.setAutoCommit(false);
            System.out.println(connection.isClosed());
            createTableEx();
            System.out.println("Таблица успешно создана");
            insertEx();
            connection.commit();
            readEx();

            dropTableEx();

        } catch (Exception e){
            e.printStackTrace();
            connection.rollback();
        } finally {
            disconnect();
        }
    }

    private static void connect() throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:src/lesson10/My1stSQLdatabase.db");
        statement = connection.createStatement();
    }

    private static void disconnect(){
        try {
            if(statement!=null)
                statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try{
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertEx() throws SQLException{
        statement.executeUpdate("INSERT INTO students1 (name, score) VALUES ('Bob4', 60);");
    }

    private static void createTableEx() throws SQLException {
        System.out.println(statement.executeUpdate("CREATE TABLE IF NOT EXISTS students1 (\n" +
                "        id    INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "        name  TEXT,\n" +
                "        score INTEGER\n" +
                "    );"));
    }

    private static void dropTableEx() throws SQLException {
        statement.executeUpdate("DROP TABLE IF EXISTS students;");
    }
}
