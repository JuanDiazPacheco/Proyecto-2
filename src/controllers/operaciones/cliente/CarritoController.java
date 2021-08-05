package controllers.operaciones.cliente;

import java.net.URL;
import java.util.ResourceBundle;

import components.Carrito.CarritoItem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import utils.ControladorEscenas;

public class CarritoController implements Initializable {

    @FXML
    private VBox carritoLista;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO usar logica carrito model para cargar itemcarrito
        carritoLista.getChildren().add(new CarritoItem("Ejemplo", 100.0, null));
        carritoLista.getChildren().add(new CarritoItem("Ejemplo 2", 100.0, null));
    }

    @FXML
    void handleComprarAction(ActionEvent event) {
        // TODO proceder crear la logica de carrito model para comprar

    }

    @FXML
    void handleRegresarAction(ActionEvent event) {
        ControladorEscenas.nuevaEscena(getClass().getResource("/views/operaciones/DepartamentoView.fxml"));
    }

}
