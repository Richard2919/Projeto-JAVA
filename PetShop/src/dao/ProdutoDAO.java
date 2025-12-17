package dao;

import model.Produto;
import util.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ProdutoDAO {
    public void criarTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS produto (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nome TEXT NOT NULL," +
                "categoria TEXT," +
                "quantidade INTEGER," +
                "precoCompra REAL," +
                "precoVenda REAL," +
                "fornecedor TEXT" +
                ");";

        try (Connection conn = Conexao.conectar();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void inserir(Produto p) {
        String sql = "INSERT INTO produto (nome, categoria, quantidade, precoCompra, precoVenda, fornecedor) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getCategoria());
            stmt.setInt(3, p.getQuantidade());
            stmt.setDouble(4, p.getPrecoCompra());
            stmt.setDouble(5, p.getPrecoVenda());
            stmt.setString(6, p.getFornecedor());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Produto> listar() {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM produto";

        try (Connection conn = Conexao.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Produto p = new Produto();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setCategoria(rs.getString("categoria"));
                p.setQuantidade(rs.getInt("quantidade"));
                p.setPrecoCompra(rs.getDouble("precoCompra"));
                p.setPrecoVenda(rs.getDouble("precoVenda"));
                p.setFornecedor(rs.getString("fornecedor"));
                produtos.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return produtos;
    }
}
