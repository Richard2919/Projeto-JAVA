package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String URL = "jdbc:sqlite:database/petshop.db";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}
