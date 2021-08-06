package controllers.nuevos;

import java.net.URL;
import java.time.LocalDate;

import java.util.Random;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyEvent;
import models.perfiles.Cliente;
import models.perfiles.Direccion;
import utils.ControladorEscenas;
import utils.FileManager.ClientesFiles;
import utils.Forms.FormsFields;

public class NuevoClienteController extends FormsFields {

    private ClientesFiles cFiles = ClientesFiles.getInstance();

    @FXML
    private DatePicker dpNacimiento;

    // TextxFields

    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellido;
    @FXML
    private TextField txtColonia;
    @FXML
    private TextField txtEstado;
    @FXML
    private TextField txtCalle;
    @FXML
    private TextField txtCP;
    @FXML
    private TextField txtNumero;
    @FXML
    private TextField txtPassword;

    // Botones

    @FXML
    private Button btnRegresar;
    @FXML
    private Button btnAceptar;

    // Labels

    @FXML
    private Label lblNombre;
    @FXML
    private Label lblApellidos;
    @FXML
    private Label lblFecha;
    @FXML
    private Label lblCalle;
    @FXML
    private Label lblColonia;
    @FXML
    private Label lblNumero;
    @FXML
    private Label lblCP;
    @FXML
    private Label lblEstado;
    @FXML
    private Label lblPass;

    /**
     * @param arg0
     * @param arg1
     */
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        super.initialize(arg0, arg1);

        numbersFieldsList.add(txtCP);
        numbersFieldsList.add(txtNumero);
        numbersFieldsList.add(txtPassword);

        letterFieldsList.add(txtNombre);
        letterFieldsList.add(txtApellido);
        letterFieldsList.add(txtCalle);
        letterFieldsList.add(txtColonia);
        letterFieldsList.add(txtEstado);
    }

    /**
     * @param event
     */
    @FXML
    void handleAceptarAction(ActionEvent event) {

        if (areEmpty()) {
            alert.setContentText("No dejes campos vacios.");
            alert.show();
        } else if (!verifyAllLetters()) {
            alert.setContentText("No introduzcas numeros en los campos de letras.");
            alert.show();
        } else if (!verifyAllNumbers()) {
            alert.setContentText("No introduzcas letras en los campos de numeros.");
            alert.show();
        } else if (!verifyDate()) {
            alert.setContentText("No atendemos a menores de 18, ni mayores de 100.");
            alert.show();
        } else {
            nuevoCliente();
            alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Usuario Creado");
            alert.setHeaderText("Operacion exitosa");
            alert.setContentText("Se ha creado con exito el cliente, regresando.");
            alert.show();
            ControladorEscenas.nuevaEscena(getClass().getResource("/views/InicioView.fxml"));
        }

    }

    /**
     * @return boolean
     */
    // Metodo verificar fecha

    private boolean verifyDate() {
        LocalDate nacimiento = dpNacimiento.getValue();
        LocalDate hoy = LocalDate.now();
        int edad = hoy.getYear() - nacimiento.getYear();
        if (edad > 18 && edad < 100)
            return true;
        else
            return false;
    }

    /**
     * @param event
     */
    // Metodos para verificar campos vacios

    /*
     * private boolean areEmpty() { return isEmpty(txtNombre) | isEmpty(txtApellido)
     * | isEmpty(txtCalle) | isEmpty(txtColonia) | isEmpty(txtCP) |
     * isEmpty(txtEstado) | isEmpty(txtPassword) | isEmpty(txtNumero); }
     */

    @FXML
    void handleRegresarAction(ActionEvent event) {
        ControladorEscenas.nuevaEscena(getClass().getResource("/views/InicioView.fxml"));
    }

    /**
     * @param event
     */
    @FXML
    void handleKeyChar(KeyEvent event) {
        try {
            String txt = ((TextField) event.getSource()).getText();
            Label label = (Label) ((Node) event.getSource()).getParent().getChildrenUnmodifiable().get(1);

            if (!txt.matches("^[a-zA-Z\s]*$")) {
                label.setText("Solo se aceptan letras.");
                label.setVisible(true);
            } else
                label.setVisible(false);

        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param event
     */
    @FXML
    void handleKeyNumber(KeyEvent event) {
        try {
            event.consume();
            String txt = ((TextField) event.getSource()).getText();
            Label label = (Label) ((Node) event.getSource()).getParent().getChildrenUnmodifiable().get(1);

            if (!txt.matches("^[0-9]*$")) {
                label.setVisible(true);
            } else
                label.setVisible(false);

        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    // Metodo para crear un nuevo Cliente, Opcion 1.

    private void nuevoCliente() {
        // Variables del Cliente
        String nombre, apellidos;
        Direccion direccion;
        LocalDate nacimiento;
        // Vairables de la direccion
        String estado, colonia, calle;
        int codigoPostal;
        byte numero;
        // Variables cuenta
        float monto;
        String numeroCuenta;
        String password;

        // Obteniendo datos generales del cliente

        nombre = txtNombre.getText();
        apellidos = txtApellido.getText();
        nacimiento = dpNacimiento.getValue();

        // Creando objeto direccion para la direccion del cliente

        estado = txtEstado.getText();
        colonia = txtColonia.getText();
        calle = txtCalle.getText();
        codigoPostal = Integer.valueOf(txtCP.getText());
        numero = Byte.valueOf(txtNumero.getText());

        direccion = new Direccion(estado, colonia, calle, codigoPostal, numero);

        // Monto inicial cuenta
        monto = 100;

        numeroCuenta = genNumeroCuenta();

        // Creando el objeto cliente
        Cliente cliente = new Cliente(nombre, apellidos, direccion, nacimiento, monto, numeroCuenta);

        // Contraseña
        password = txtPassword.getText();
        cFiles.escribirArchivoClientes(numeroCuenta, password);
        cFiles.escribirArchivoCliente(cliente);
    }

    /**
     * @return String
     */
    private String genNumeroCuenta() {
        long numeroaleatorio = 0;
        String numeroCuenta;
        Random random = new Random();
        do {
            for (int i = 0; i < 16; i++) {
                numeroaleatorio += random.nextInt(10) * Math.pow(10, i);
            }
            // Se crea la String que se devolvera
            numeroCuenta = String.valueOf(numeroaleatorio);
            // Condicion que revisa que el numero de cuenta no este repetido;
        } while (ClientesFiles.numerosCuentas.contains(numeroCuenta));

        // Se añade el numero de cuenta del nuevo cliente al conjunto.
        ClientesFiles.numerosCuentas.add(numeroCuenta);
        return String.valueOf(numeroCuenta);
    }

}