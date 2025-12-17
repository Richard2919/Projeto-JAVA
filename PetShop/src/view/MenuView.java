package view;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MenuView extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Layout vertical para os botões
        VBox menuBox = new VBox(20);
        menuBox.setAlignment(Pos.CENTER);

        // Criando botões com ícones
        Button btnProdutos = new Button("🐾 Gerenciar Produtos");
        Button btnVendas = new Button("🛒 Registrar Venda");
        Button btnRelatorio = new Button("📊 Relatório de Vendas");
        Button btnCaixa = new Button("💰 Fluxo de Caixa");

        // Adiciona classe CSS
        btnProdutos.getStyleClass().add("menu-button");
        btnVendas.getStyleClass().add("menu-button");
        btnRelatorio.getStyleClass().add("menu-button");
        btnCaixa.getStyleClass().add("menu-button");

        // Ações dos botões (abrir outras telas)
        btnProdutos.setOnAction(e -> new ProdutoView().start(new Stage()));
        btnVendas.setOnAction(e -> new VendaView().start(new Stage()));
        btnRelatorio.setOnAction(e -> new RelatorioVendasView().start(new Stage()));
        btnCaixa.setOnAction(e -> new FluxoCaixaView().start(new Stage()));

        menuBox.getChildren().addAll(btnProdutos, btnVendas, btnRelatorio, btnCaixa);

        // Container principal com imagem de fundo
        StackPane root = new StackPane();
        root.getChildren().add(menuBox);

        Scene scene = new Scene(root, 1200, 800, Color.BLACK);
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());

        primaryStage.setTitle("PetShop System - Menu");
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}