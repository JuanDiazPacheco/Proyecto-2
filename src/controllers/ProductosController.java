package controllers;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

import components.ItemComponent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;

public class ProductosController implements Initializable {

    @FXML
    private FlowPane productosFP;

    @FXML
    private BorderPane borderPane;

    private LinkedList<ItemComponent> productos;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        productos = new LinkedList<>();
        productos.add(new ItemComponent("Coca", 10, null));
        productos.add(new ItemComponent("Pepsi", 12, null));

        productosFP.getStyleClass().add("flow-pane");
        borderPane.getStyleClass().add("border-pane");

        for (ItemComponent nodo : productos)
            productosFP.getChildren().add(nodo);

    }
}