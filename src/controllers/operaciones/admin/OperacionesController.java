package controllers.operaciones.admin;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import utils.ControladorEscenas;

public class OperacionesController implements Initializable {

    @FXML
    private Label lblNombre;

    @FXML
    private Button btnClientes;

    @FXML
    private Button btnNuevo;

    @FXML
    private Button btnRegresar;

    @FXML
    void handleClientes(ActionEvent event) {
        ControladorEscenas.nuevaEscena(getClass().getResource("/views/operaciones/ClientesListaView.fxml"));
    }

    @FXML
    void handleNuevo(ActionEvent event) {
        ControladorEscenas.nuevaEscena(getClass().getResource("/views/nuevos/NuevoProductoView.fxml"));
    }

    @FXML
    void handleRegresar(ActionEvent event) {
        ControladorEscenas.nuevaEscena(getClass().getResource("/views/InicioView.fxml"));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Instancias de la interfaz
        lblNombre.setText("Administrador");
    }

}
