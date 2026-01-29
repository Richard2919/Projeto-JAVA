import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MySqlTest {
    public static void main(String[] args) throws SQLException {
        Connection mySqlConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/infinitytech_suporte", "root", "123456");
        PreparedStatement ps = mySqlConnection.prepareStatement("sele");
    }
}
