import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button btnProduto = new Button("Gerenciar Produtos");
        Button btnVenda = new Button("Registrar Venda");
        Button btnRelatorio = new Button("Relatório de Vendas");
        Button btnFluxoCaixa = new Button("Fluxo de Caixa");

        btnProduto.setOnAction(e -> {
            try {
                new view.ProdutoView().start(new Stage());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        btnVenda.setOnAction(e -> {
            try {
                new view.VendaView().start(new Stage());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        btnRelatorio.setOnAction(e -> {
            try {
                new view.RelatorioVendasView().start(new Stage());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        btnFluxoCaixa.setOnAction(e -> {
            try {
                new view.FluxoCaixaView().start(new Stage());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        VBox root = new VBox(15, btnProduto, btnVenda, btnRelatorio, btnFluxoCaixa);
        root.setStyle("-fx-padding: 20;");

        Scene scene = new Scene(root, 300, 200);

        // ✅ Aplica o style.css externo (que está em src/resources/style.css)
        String css = getClass().getResource("/style.css").toExternalForm();
        scene.getStylesheets().add(css);

        primaryStage.setScene(scene);
        primaryStage.setTitle("PetShop System - Menu Principal");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
