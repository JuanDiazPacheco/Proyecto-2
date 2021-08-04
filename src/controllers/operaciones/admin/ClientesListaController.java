package controllers.operaciones.admin;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

import models.perfiles.Cliente;
import utils.ControladorEscenas;
import utils.FileManager.ClientesFiles;

public class ClientesListaController implements Initializable {

    @FXML
    private TableView<Cliente> clientesTable;

    private TableColumn<Cliente, String> colNombre;
    private TableColumn<Cliente, String> colSaldo;
    private TableColumn<Cliente, String> colDireccion;

    private ClientesFiles cFiles;

    @FXML
    private Button btnRegresar;

    @FXML
    private Button btnVerMas;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cFiles = ClientesFiles.getInstance();
        // clientesTable = new TableView<>();
        colNombre = new TableColumn<Cliente, String>("Nombre");
        colSaldo = new TableColumn<Cliente, String>("Saldo");
        colDireccion = new TableColumn<Cliente, String>("Direccion");

        colNombre.setCellValueFactory(new PropertyValueFactory<Cliente, String>("NombreCompleto"));

        colSaldo.setCellValueFactory(new PropertyValueFactory<Cliente, String>("SaldoAhorro"));

        colDireccion.setCellValueFactory(new PropertyValueFactory<Cliente, String>("Direccion"));

        clientesTable.getColumns().add(colNombre);
        clientesTable.getColumns().add(colSaldo);
        clientesTable.getColumns().add(colDireccion);

        for (String numeroCuenta : ClientesFiles.numerosCuentas) {

            Cliente cliente = cFiles.cargarCliente(numeroCuenta);

            clientesTable.getItems().add(cliente);
        }

    }

    @FXML
    void handleRegresarAction(ActionEvent event) {
        ControladorEscenas.nuevaEscena(getClass().getResource("/views/operaciones/OperacionesAdmin.fxml"));
    }

    @FXML
    void handleVerAction(ActionEvent event) {
        Cliente cliente = clientesTable.getSelectionModel().getSelectedItem();
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setHeaderText("Información del Cliente");
        alert.setContentText(cliente.toString());
        alert.show();
    }

}
