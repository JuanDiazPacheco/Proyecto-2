package controllers.operaciones.cliente;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import components.Carrito.CarritoItem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import models.carrito.Carrito;
import models.carrito.ICarrito;
import utils.ControladorEscenas;

public class CarritoController implements Initializable {

    @FXML
    private AnchorPane carritoContainer;

    private static VBox carritoLista;

    private static List<CarritoItem> items;

    private ICarrito cart;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        carritoLista = new VBox();

        cart = Carrito.getInstance();
        items = cart.loadItems();
        carritoLista.getChildren().addAll(items);

        carritoContainer.getChildren().add(carritoLista);

    }

    /**
     * @param event
     */
    @FXML
    void handleComprarAction(ActionEvent event) {
        // TODO proceder crear la logica de carrito model para comprar
        cart.calcularTotal();
    }

    /**
     * @param event
     */
    @FXML
    void handleRegresarAction(ActionEvent event) {
        ControladorEscenas.nuevaEscena(getClass().getResource("/views/operaciones/DepartamentoView.fxml"));
    }

    public static void update() {
        carritoLista.getChildren().clear();
        carritoLista.getChildren().addAll(items);
    }

}
