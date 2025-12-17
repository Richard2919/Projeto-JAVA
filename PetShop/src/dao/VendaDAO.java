package dao;

import model.Venda;
import util.Conexao;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VendaDAO {

    public void criarTabelas() {
        String sql = "CREATE TABLE IF NOT EXISTS venda (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "data TEXT NOT NULL," +
                "valorTotal REAL NOT NULL)";
        try (Connection conn = Conexao.conectar();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void inserir(Venda venda) {
        String sql = "INSERT INTO venda (data, valorTotal) VALUES (?, ?)";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, venda.getData().toString());
            stmt.setDouble(2, venda.getValorTotal());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Venda> listarPorPeriodo(LocalDate inicio, LocalDate fim) {
        List<Venda> vendas = new ArrayList<>();
        String sql = "SELECT * FROM venda WHERE data BETWEEN ? AND ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, inicio.toString());
            stmt.setString(2, fim.toString());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Venda v = new Venda();
                v.setId(rs.getInt("id"));
                v.setData(LocalDate.parse(rs.getString("data")));
                v.setValorTotal(rs.getDouble("valorTotal"));
                vendas.add(v);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vendas;
    }
}
