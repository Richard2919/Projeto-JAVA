package view;

import dao.VendaDAO;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Venda;

import java.time.LocalDate;
import java.util.List;

public class RelatorioVendasView extends Application {
    @Override
    public void start(Stage ps) {
        VendaDAO dao = new VendaDAO();

        Label lblInicio = new Label("Data Início:");
        DatePicker dpI = new DatePicker();

        Label lblFim = new Label("Data Fim:");
        DatePicker dpF = new DatePicker();

        Button btn = new Button("Buscar");

        ListView<String> lv = new ListView<>();
        Label lb = new Label("Total: R$ 0.00");

        btn.setOnAction(e -> {
            LocalDate i = dpI.getValue();
            LocalDate f = dpF.getValue();

            if (i == null || f == null) {
                new Alert(Alert.AlertType.WARNING, "Por favor, selecione as duas datas.").showAndWait();
                return;
            }

            List<Venda> vs = dao.listarPorPeriodo(i, f);
            lv.getItems().clear();

            double tot = 0;
            for (Venda v : vs) {
                lv.getItems().add(v.getData() + " – R$ " +
                        String.format("%.2f", v.getValorTotal()) + " (" + v.getFormaPagamento() + ")");
                tot += v.getValorTotal();
            }

            lb.setText("Total: R$ " + String.format("%.2f", tot));
        });

        VBox vb = new VBox(10, lblInicio, dpI, lblFim, dpF, btn, lv, lb);
        vb.setStyle("-fx-padding: 20;");
        ps.setScene(new Scene(vb, 450, 500));
        ps.setTitle("Relatório de Vendas");
        ps.show();
    }
}
