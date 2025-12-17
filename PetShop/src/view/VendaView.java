package view;

import dao.ProdutoDAO;
import dao.VendaDAO;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VendaView extends Application {
    @Override
    public void start(Stage ps) {
        ProdutoDAO pdao = new ProdutoDAO();
        VendaDAO vdao = new VendaDAO();
        vdao.criarTabelas();

        // Campos e componentes
        ComboBox<Produto> cb = new ComboBox<>();
        cb.getItems().addAll(pdao.listar());
        cb.setPromptText("Selecione um produto");

        TextField tfQtd = new TextField();
        tfQtd.setPromptText("Quantidade");

        TextField tfFp = new TextField();
        tfFp.setPromptText("Forma de Pagamento");

        List<ItemVenda> carrinho = new ArrayList<>();
        ListView<String> lv = new ListView<>();

        Button btnAdd = new Button("Adicionar");
        Button btnFin = new Button("Finalizar Venda");

        // Ação: Adicionar item ao carrinho
        btnAdd.setOnAction(e -> {
            try {
                Produto p = cb.getValue();
                if (p == null) {
                    new Alert(Alert.AlertType.WARNING, "Selecione um produto!").showAndWait();
                    return;
                }

                int q = Integer.parseInt(tfQtd.getText());
                if (q <= 0) {
                    new Alert(Alert.AlertType.WARNING, "Quantidade deve ser maior que 0.").showAndWait();
                    return;
                }

                ItemVenda it = new ItemVenda();
                it.setProduto(p);
                it.setQuantidade(q);
                it.setPrecoUnitario(p.getPrecoVenda());
                carrinho.add(it);

                lv.getItems().add(p.getNome() + " x " + q + " = R$ " + String.format("%.2f", p.getPrecoVenda() * q));

                tfQtd.clear();
            } catch (NumberFormatException ex) {
                new Alert(Alert.AlertType.ERROR, "Quantidade inválida!").showAndWait();
            }
        });

        // Ação: Finalizar a venda
        btnFin.setOnAction(e -> {
            if (carrinho.isEmpty()) {
                new Alert(Alert.AlertType.WARNING, "Adicione pelo menos um item.").showAndWait();
                return;
            }

            if (tfFp.getText().trim().isEmpty()) {
                new Alert(Alert.AlertType.WARNING, "Informe a forma de pagamento.").showAndWait();
                return;
            }

            double total = carrinho.stream()
                    .mapToDouble(i -> i.getPrecoUnitario() * i.getQuantidade())
                    .sum();

            Venda v = new Venda();
            v.setData(LocalDate.now());
            v.setFormaPagamento(tfFp.getText());
            v.setItens(carrinho);
            v.setValorTotal(total);

            vdao.inserir(v);

            new Alert(Alert.AlertType.INFORMATION, "Venda finalizada!\nTotal: R$ " + String.format("%.2f", total)).showAndWait();

            carrinho.clear();
            lv.getItems().clear();
            tfQtd.clear();
            tfFp.clear();
        });

        VBox vb = new VBox(10,
                new Label("Produto:"),
                cb,
                new Label("Quantidade:"),
                tfQtd,
                btnAdd,
                new Label("Carrinho:"),
                lv,
                new Label("Forma de Pagamento:"),
                tfFp,
                btnFin
        );

        vb.setStyle("-fx-padding: 20;");
        ps.setScene(new Scene(vb, 450, 550));
        ps.setTitle("Tela de Vendas");
        ps.show();
    }
}
