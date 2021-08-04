package controllers.nuevos;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import utils.ControladorEscenas;

import utils.FileManager.ProductosFiles;
import utils.Forms.FormsFields;

public class NuevoProductoController extends FormsFields {

    @FXML
    private TextField tFNombre;

    @FXML
    private TextField tFPrecio;

    @FXML
    private TextField tFMarca;

    @FXML
    private TextField tFImagen;

    @FXML
    private ComboBox<String> cBDepartamento;

    private FileChooser fChooser;

    private ProductosFiles pFiles;

    private File fImagen;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        super.initialize(arg0, arg1);
        initFileChooser();

        letterFieldsList.add(tFNombre);
        letterFieldsList.add(tFMarca);
        floatsFieldsList.add(tFPrecio);

        // TODO

        pFiles = ProductosFiles.getInstance();
        cBDepartamento.getItems().addAll("Electronicos", "Comida", "Deportes", "Ropa");
    }

    @FXML
    void handleCrear(ActionEvent event) {

        if (areEmpty()) {
            alert.setContentText("No dejes campos vacios.");
            alert.show();
        } else if (!verifyAllLetters()) {
            alert.setContentText("No introduzcas numeros en los campos de letras.");
            alert.show();
        } else if (!verifyAllFloats()) {
            alert.setContentText("No introduzcas caracteres que no sean digitos en los campos de numeros.");
            alert.show();
        } else {
            nuevoProducto();
            alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Usuario Creado");
            alert.setHeaderText("Operacion exitosa");
            alert.setContentText("Se ha creado con exito el producto, regresando.");
            alert.show();
            ControladorEscenas.nuevaEscena(getClass().getResource("/views/InicioView.fxml"));
        }

    }

    private void nuevoProducto() {
    }

    @FXML
    void handleFile(ActionEvent event) {
        fImagen = fChooser.showOpenDialog(ControladorEscenas.getStage());

        if (fImagen != null) {
            // Manda a llamar al método
            tFImagen.setText(fImagen.getAbsolutePath());
            // verificarSeleccionados();
        }
    }

    @FXML
    void handleVolver(ActionEvent event) {
        ControladorEscenas.nuevaEscena(getClass().getResource("/views/operaciones/OperacionesAdmin.fxml"));
    }

    private void initFileChooser() {
        fChooser = new FileChooser();
        fChooser.setInitialDirectory(new File("."));
        fChooser.setSelectedExtensionFilter(new FileChooser.ExtensionFilter("Imagenes", "*.jpg", "*.png"));
    }

}
