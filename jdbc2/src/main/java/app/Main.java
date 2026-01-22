package app;

import db.DBConnection;
import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Connection conn = DBConnection.getConnection();
        System.out.println("Conexão realizada com sucesso!");
    }
}
