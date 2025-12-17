package view;

import dao.FinanceiroDAO;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.MovimentoFinanceiro;

import java.time.LocalDate;
import java.util.List;

public class FluxoCaixaView extends Application {
    @Override
    public void start(Stage ps) {
        FinanceiroDAO dao = new FinanceiroDAO();

        Label lblDesc = new Label("Descrição:");
        TextField tfDesc = new TextField();

        Label lblVal = new Label("Valor:");
        TextField tfVal = new TextField();

        Label lblTipo = new Label("Tipo:");
        ComboBox<String> cb = new ComboBox<>();
        cb.getItems().addAll("entrada", "saida");

        Button btnAdd = new Button("Registrar");

        Label lblPeriodo = new Label("Período:");
        DatePicker d1 = new DatePicker();
        DatePicker d2 = new DatePicker();

        Button btnBus = new Button("Ver Fluxo");

        ListView<String> lv = new ListView<>();
        Label lb = new Label("Saldo: R$ 0.00");

        btnAdd.setOnAction(e -> {
            try {
                String descricao = tfDesc.getText().trim();
                String tipo = cb.getValue();
                String valorStr = tfVal.getText().trim();

                if (descricao.isEmpty() || tipo == null || valorStr.isEmpty()) {
                    new Alert(Alert.AlertType.WARNING, "Preencha todos os campos para registrar.").showAndWait();
                    return;
                }

                double valor = Double.parseDouble(valorStr);

                MovimentoFinanceiro m = new MovimentoFinanceiro();
                m.setData(LocalDate.now());
                m.setDescricao(descricao);
                m.setTipo(tipo);
                m.setValor(valor);

                dao.inserir(m);

                new Alert(Alert.AlertType.INFORMATION, "Movimento registrado com sucesso!").showAndWait();

                tfDesc.clear();
                tfVal.clear();
                cb.setValue(null);
            } catch (NumberFormatException ex) {
                new Alert(Alert.AlertType.ERROR, "Valor inválido. Use apenas números.").showAndWait();
            } catch (Exception ex) {
                new Alert(Alert.AlertType.ERROR, "Erro ao registrar: " + ex.getMessage()).showAndWait();
            }
        });

        btnBus.setOnAction(e -> {
            LocalDate inicio = d1.getValue();
            LocalDate fim = d2.getValue();

            if (inicio == null || fim == null) {
                new Alert(Alert.AlertType.WARNING, "Selecione as duas datas para buscar o fluxo.").showAndWait();
                return;
            }

            List<MovimentoFinanceiro> ms = dao.listarPorPeriodo(inicio, fim);
            lv.getItems().clear();
            double saldo = 0;

            for (MovimentoFinanceiro m : ms) {
                lv.getItems().add(m.getData() + " - " + m.getDescricao() + " - R$ " +
                        String.format("%.2f", m.getValor()) + " (" + m.getTipo() + ")");
                saldo += m.getTipo().equalsIgnoreCase("entrada") ? m.getValor() : -m.getValor();
            }

            lb.setText("Saldo: R$ " + String.format("%.2f", saldo));
        });

        VBox vb = new VBox(10,
                lblDesc, tfDesc,
                lblVal, tfVal,
                lblTipo, cb,
                btnAdd,
                lblPeriodo, d1, d2,
                btnBus,
                lv,
                lb);
        vb.setStyle("-fx-padding: 20;");

        ps.setScene(new Scene(vb, 450, 600));
        ps.setTitle("Fluxo de Caixa");
        ps.show();
    }
}
