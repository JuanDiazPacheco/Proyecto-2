package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.util.Pair;
import utils.ControladorEscenas;
import utils.FileManager.ClientesFiles;

public class InicioViewController implements Initializable {

    @FXML
    private Button btnRegistro;

    @FXML
    private Button btnIngresar;

    private ClientesFiles cFiles;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        cFiles = ClientesFiles.getInstance();
        cFiles.cargarCuentas();
    }

    @FXML
    void handleRegistroAction(ActionEvent event) {
        ControladorEscenas.nuevaEscena(getClass().getResource("/views/nuevos/NuevoClienteView.fxml"));
    }

    @FXML
    void handleIngresarAction(ActionEvent event) {

        // Create the custom dialog.
        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Login Dialog");
        dialog.setHeaderText("Ingrese sus datos para ingresar");

        // Set the icon (must be included in the project).
        ImageView imagen = new ImageView(this.getClass().getResource("/images/login.png").toString());
        imagen.setFitWidth(100);
        imagen.setFitHeight(100);

        dialog.setGraphic(imagen);

        // Set the button types.
        ButtonType loginButtonType = new ButtonType("Login", ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

        // Create the username and password labels and fields.
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField username = new TextField();
        username.setPromptText("Username");
        PasswordField password = new PasswordField();
        password.setPromptText("Password");

        grid.add(new Label("Username:"), 0, 0);
        grid.add(username, 1, 0);
        grid.add(new Label("Password:"), 0, 1);
        grid.add(password, 1, 1);

        // Enable/Disable login button depending on whether a username was entered.
        Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
        loginButton.setDisable(true);

        // Do some validation (using the Java 8 lambda syntax).
        username.textProperty().addListener((observable, oldValue, newValue) -> {
            loginButton.setDisable(newValue.trim().isEmpty());
        });

        dialog.getDialogPane().setContent(grid);
        dialog.show();

        ((Button) loginButton).setOnAction(e -> {
            String numeroCuenta = username.getText();
            String NIP = password.getText();

            if (numeroCuenta.equals("admin") && NIP.equals("admin")) {
                System.out.println("Haciendo login");
                ControladorEscenas.nuevaEscena(getClass().getResource("/views/operaciones/OperacionesAdmin.fxml"));

            } else if (ClientesFiles.mapaPass.containsKey(numeroCuenta) && verificarPass(numeroCuenta, NIP)) {
                // Metodo para cargar OperacionesView
                System.out.println("Haciendo login");

                ControladorEscenas controlador = ControladorEscenas.getInstance();
                controlador.enviarDatos(numeroCuenta);

                ControladorEscenas.nuevaEscena(getClass().getResource("/views/operaciones/DepartamentoView.fxml"));

            } else {

                Alert alert = new Alert(AlertType.ERROR);
                alert.setHeaderText("Un error ha ocurrido");
                alert.setContentText("Verifica que has ingresado bien tus datos.");
                alert.show();

            }
        });

    }

    private boolean verificarPass(String cuenta, String password) {
        return ClientesFiles.mapaPass.get(cuenta).equals(password);
    }

}