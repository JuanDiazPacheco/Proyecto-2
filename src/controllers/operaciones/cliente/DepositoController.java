package controllers.operaciones.cliente;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import models.perfiles.Cliente;
import models.perfiles.cuentas.CuentaSaldo;
import utils.ControladorEscenas;
import utils.FileManager.ClientesFiles;
import utils.Forms.FormsFields;

public class DepositoController extends FormsFields {

    @FXML
    private TextField txtMonto;

    private ClientesFiles cFiles;
    private Cliente cliente;
    private ControladorEscenas controlador;
    private CuentaSaldo cuentaAhorro;

    /**
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String numeroCuenta;

        // Instancianso objetos esenciales
        cFiles = ClientesFiles.getInstance();
        controlador = ControladorEscenas.getInstance();

        // Instancacias del cliente
        numeroCuenta = (String) controlador.recibirDatos();
        cliente = cFiles.cargarCliente(numeroCuenta);
        cuentaAhorro = cliente.getCuentaAhorro();
    }

    /**
     * @param event
     */
    @FXML
    void AceptarAction(ActionEvent event) {
        double deposito;
        System.out.println("Ingrese el monto que desea depositar");

        if (verifyNumbers(txtMonto)) {
            deposito = Double.valueOf(txtMonto.getText());
            // Verificar si funciona!!
            cuentaAhorro.depositarDinero(deposito);

            cFiles.escribirArchivoCliente(cliente);
            ControladorEscenas.nuevaEscena(getClass().getResource("/views/operaciones/OperacionesCliente.fxml"));
        }
    }

    /**
     * @param event
     */
    @FXML
    void VolverAction(ActionEvent event) {
        ControladorEscenas.nuevaEscena(getClass().getResource("/views/operaciones/OperacionesCliente.fxml"));
    }

    /**
     * @param event
     */
    @FXML
    void handleKeyNumber(KeyEvent event) {
        try {
            TextField txtField = ((TextField) event.getSource());
            String txt = txtField.getText();

            if (!txt.matches("^[0-9]*$")) {
                txtField.setStyle(" -fx-background-color: red;");
            } else
                txtField.setStyle(" -fx-background-color: white;");

        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

}