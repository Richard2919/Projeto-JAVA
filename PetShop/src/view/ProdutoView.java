package view;

import dao.ProdutoDAO;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Produto;

public class ProdutoView extends Application {
    @Override
    public void start(Stage stage) {
        ProdutoDAO dao = new ProdutoDAO();
        dao.criarTabela();

        // GridPane com espaçamento e padding
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setVgap(15);
        grid.setHgap(10);
        grid.setAlignment(Pos.CENTER);

        // Labels e campos
        Label lblNome = new Label("Nome:");
        TextField tfNome = new TextField();

        Label lblCategoria = new Label("Categoria:");
        TextField tfCategoria = new TextField();

        Label lblQtd = new Label("Quantidade:");
        TextField tfQuantidade = new TextField();

        Label lblPrecoCompra = new Label("Preço Compra:");
        TextField tfPrecoCompra = new TextField();

        Label lblPrecoVenda = new Label("Preço Venda:");
        TextField tfPrecoVenda = new TextField();

        Label lblFornecedor = new Label("Fornecedor:");
        TextField tfFornecedor = new TextField();

        Button btnSalvar = new Button("Salvar");

        // Posicionar no grid
        grid.add(lblNome, 0, 0);
        grid.add(tfNome, 1, 0);

        grid.add(lblCategoria, 0, 1);
        grid.add(tfCategoria, 1, 1);

        grid.add(lblQtd, 0, 2);
        grid.add(tfQuantidade, 1, 2);

        grid.add(lblPrecoCompra, 0, 3);
        grid.add(tfPrecoCompra, 1, 3);

        grid.add(lblPrecoVenda, 0, 4);
        grid.add(tfPrecoVenda, 1, 4);

        grid.add(lblFornecedor, 0, 5);
        grid.add(tfFornecedor, 1, 5);

        grid.add(btnSalvar, 1, 6);

        btnSalvar.setOnAction(e -> {
            try {
                Produto p = new Produto();
                p.setNome(tfNome.getText());
                p.setCategoria(tfCategoria.getText());
                p.setQuantidade(Integer.parseInt(tfQuantidade.getText()));
                p.setPrecoCompra(Double.parseDouble(tfPrecoCompra.getText()));
                p.setPrecoVenda(Double.parseDouble(tfPrecoVenda.getText()));
                p.setFornecedor(tfFornecedor.getText());

                dao.inserir(p);
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Produto salvo com sucesso!");
                alert.showAndWait();

                // Limpar campos
                tfNome.clear();
                tfCategoria.clear();
                tfQuantidade.clear();
                tfPrecoCompra.clear();
                tfPrecoVenda.clear();
                tfFornecedor.clear();

            } catch (NumberFormatException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Preencha os campos numéricos corretamente!");
                alert.showAndWait();
            } catch (Exception ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Erro ao salvar: " + ex.getMessage());
                alert.showAndWait();
            }
        });

        Scene scene = new Scene(grid, 400, 400);

        // Debug para ver se o CSS está sendo encontrado
        System.out.println(getClass().getResource("/resources/style.css"));

        // Carregar o CSS (ajuste para o caminho correto dentro do .jar)
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());

        stage.setScene(scene);
        stage.setTitle("Cadastro de Produto");
        stage.show();
    }
}
