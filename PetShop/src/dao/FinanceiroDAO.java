package dao;

import model.MovimentoFinanceiro;
import util.Conexao;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FinanceiroDAO {

    public void inserir(MovimentoFinanceiro mov) {
        String sql = "CREATE TABLE IF NOT EXISTS financeiro (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "data TEXT NOT NULL, " +
                "descricao TEXT, " +
                "tipo TEXT, " +
                "valor REAL)";
        String insert = "INSERT INTO financeiro (data, descricao, tipo, valor) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar()) {
            // Cria a tabela se não existir
            try (Statement stmt = conn.createStatement()) {
                stmt.execute(sql);
            }

            // Insere os dados
            try (PreparedStatement stmt = conn.prepareStatement(insert)) {
                stmt.setString(1, mov.getData().toString());
                stmt.setString(2, mov.getDescricao());
                stmt.setString(3, mov.getTipo());
                stmt.setDouble(4, mov.getValor());
                stmt.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<MovimentoFinanceiro> listarPorPeriodo(LocalDate inicio, LocalDate fim) {
        List<MovimentoFinanceiro> lista = new ArrayList<>();
        String sql = "SELECT * FROM financeiro WHERE data BETWEEN ? AND ? ORDER BY data";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, inicio.toString());
            stmt.setString(2, fim.toString());

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                MovimentoFinanceiro m = new MovimentoFinanceiro();
                m.setId(rs.getInt("id"));
                m.setData(LocalDate.parse(rs.getString("data")));
                m.setDescricao(rs.getString("descricao"));
                m.setTipo(rs.getString("tipo"));
                m.setValor(rs.getDouble("valor"));
                lista.add(m);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}
