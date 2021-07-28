package controllers.operacionesControllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import models.perfiles.Cliente;
import utils.Archivador;
import utils.ControladorEscenas;

public class OperacionesController implements Initializable {

    @FXML
    private Button btnRegresar;

    @FXML
    private Label lblNombre;

    @FXML
    private Label lblSaldo;

    @FXML
    private Button btnCarrito;

    @FXML
    private Button btnDeposito;

    private Archivador archivador;
    private Cliente cliente;
    private ControladorEscenas controlador;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        String numeroCuenta;

        // Instancianso objetos esenciales
        archivador = new Archivador();
        controlador = new ControladorEscenas();

        // Instancacias del cliente
        numeroCuenta = (String) controlador.recibirDatos();
        cliente = archivador.cargarCliente(numeroCuenta);

        // Instancias de la interfaz
        lblNombre.setText(cliente.getNombreCompleto());
        lblSaldo.setText(cliente.getSaldoAhorro() + "$");
    }

    @FXML
    void handleDepositoAction(ActionEvent event) {
        ControladorEscenas.nuevaEscena(getClass().getResource("/views/DepositoView.fxml"));
    }

    @FXML
    void handleCarritoAction(ActionEvent event) {
        // ControladorEscenas.nuevaEscena(getClass().getResource("/views/CarritoView.fxml"));
    }

    @FXML
    void handleRegresarAction(ActionEvent event) {
        ControladorEscenas.nuevaEscena(getClass().getResource("/views/InicioView.fxml"));
    }

}
