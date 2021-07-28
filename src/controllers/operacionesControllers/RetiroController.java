package controllers.operacionesControllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyEvent;
import models.perfiles.Cliente;
import models.perfiles.cuentas.CuentaAhorro;
import utils.Archivador;
import utils.ControladorEscenas;

public class RetiroController implements Initializable {

    @FXML
    private TextField txtMonto;

    private Archivador archivador;
    private Cliente cliente;
    private ControladorEscenas controlador;
    private CuentaAhorro cuentaAhorro;

    private Alert alert;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        String numeroCuenta;

        // Instancianso objetos esenciales
        archivador = new Archivador();
        controlador = new ControladorEscenas();

        // Instancacias del cliente
        numeroCuenta = (String) controlador.recibirDatos();
        cliente = archivador.cargarCliente(numeroCuenta);
        cuentaAhorro = cliente.getCuentaAhorro();

        alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error Dialog");

    }

    @FXML
    void AceptarAction(ActionEvent event) {
        double retiro;
        System.out.println("Ingrese el monto que desea depositar");
        retiro = Double.valueOf(txtMonto.getText());
        // Verificar si funciona!!
        if (!cuentaAhorro.retirarDinero(retiro, false)) {
            alert.setHeaderText("Ha ocurrido un error.");
            alert.setContentText("Ooops, parece que no tienes fondos suficientes.");

            alert.showAndWait();
        } else {
            archivador.escribirArchivoCliente(cliente);
            ControladorEscenas.nuevaEscena(getClass().getResource("/vistas/OperacionesCliente.fxml"));
        }

    }

    @FXML
    void VolverAction(ActionEvent event) {
        ControladorEscenas.nuevaEscena(getClass().getResource("/vistas/OperacionesCliente.fxml"));
    }

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