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

    /**
     * @param event
     */
    @FXML
    void handleClientes(ActionEvent event) {
        ControladorEscenas.nuevaEscena(getClass().getResource("/views/operaciones/ClientesListaView.fxml"));
    }

    /**
     * @param event
     */
    @FXML
    void handleNuevo(ActionEvent event) {
        ControladorEscenas.nuevaEscena(getClass().getResource("/views/nuevos/NuevoProductoView.fxml"));
    }

    /**
     * @param event
     */
    @FXML
    void handleRegresar(ActionEvent event) {
        ControladorEscenas.nuevaEscena(getClass().getResource("/views/InicioView.fxml"));
    }

    /**
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Instancias de la interfaz
        lblNombre.setText("Administrador");
    }

}
