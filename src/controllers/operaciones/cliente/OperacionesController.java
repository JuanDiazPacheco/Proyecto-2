package controllers.operaciones.cliente;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Label;
import models.perfiles.Cliente;
import utils.ControladorEscenas;
import utils.FileManager.ClientesFiles;

public class OperacionesController implements Initializable {

    @FXML
    private Label lblNombre;

    @FXML
    private Label lblSaldo;

    private ClientesFiles cFiles;
    private Cliente cliente;
    private ControladorEscenas controlador;

    /**
     * @param arg0
     * @param arg1
     */
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        String numeroCuenta;

        // Instancianso objetos esenciales
        cFiles = ClientesFiles.getInstance();
        controlador = ControladorEscenas.getInstance();

        // Instancacias del cliente
        numeroCuenta = (String) controlador.recibirDatos();
        cliente = cFiles.cargarCliente(numeroCuenta);

        // Instancias de la interfaz
        lblNombre.setText(cliente.getNombreCompleto());
        lblSaldo.setText(cliente.getCuentaAhorro().getDinero() + "$");
    }

    /**
     * @param event
     */
    @FXML
    void handleDepositoAction(ActionEvent event) {
        ControladorEscenas.nuevaEscena(getClass().getResource("/views/operaciones/DepositoView.fxml"));
    }

    /**
     * @param event
     */
    @FXML
    void handleCarritoAction(ActionEvent event) {
        ControladorEscenas.nuevaEscena(getClass().getResource("/views/operaciones/CarritoView.fxml"));
    }

    /**
     * @param event
     */
    @FXML
    void handleCerrarAction(ActionEvent event) {
        ControladorEscenas.nuevaEscena(getClass().getResource("/views/InicioView.fxml"));
    }

    /**
     * @param event
     */
    @FXML
    void handleVolverAction(ActionEvent event) {
        ControladorEscenas.nuevaEscena(getClass().getResource("/views/operaciones/DepartamentoView.fxml"));
    }

}
