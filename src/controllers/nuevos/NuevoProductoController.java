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
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import models.productos.Producto;
import models.productos.ProductoFactory;
import models.productos.Departamento.Comida.Comida;
import models.productos.Departamento.Electronicos.Electronicos;
import models.productos.Departamento.Ropa.Ropa;
import utils.ControladorEscenas;

import utils.FileManager.ProductosFiles;
import utils.Forms.FormsFields;

public class NuevoProductoController extends FormsFields {

    @FXML
    private GridPane gridPane;

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

    @FXML
    private ComboBox<String> cBSDepartamento;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        super.initialize(arg0, arg1);
        initFileChooser();

        letterFieldsList.add(tFNombre);
        letterFieldsList.add(tFMarca);
        floatsFieldsList.add(tFPrecio);

        pFiles = ProductosFiles.getInstance();
        cBDepartamento.getItems().addAll("Electronicos y Celulares", "Comida y Bebidas", "Ropa y Zapatos", "Deportes");
    }

    @FXML
    void handleDepartamento(ActionEvent event) {
        int index = cBDepartamento.getSelectionModel().getSelectedIndex();
        if (index != -1) {
            cBSDepartamento.getItems().clear();
            if (index != 3) {
                switch (index) {
                    case 0:
                        Electronicos.init();
                        cBSDepartamento.getItems().addAll(Electronicos.getSDepartamentosList());
                        break;
                    case 1:
                        Comida.init();
                        cBSDepartamento.getItems().addAll(Comida.getSDepartamentosList());
                        break;
                    case 2:
                        Ropa.init();
                        cBSDepartamento.getItems().addAll(Ropa.getSDepartamentosList());
                        break;
                }

            }
        }
    }

    @FXML
    void handleCrear(ActionEvent event) {

        int index = cBDepartamento.getSelectionModel().getSelectedIndex();
        if (index != -1) {

            if (areEmpty() | tFImagen.getText().isBlank()) {
                alert.setContentText("No dejes estos campos vacios.");
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
        } else {
            alert.setContentText("Selecciona un departamento.");
            alert.show();
        }

    }

    private void nuevoProducto() {
        // TODO prueba con el que no tiene departamento
        String departamento = cBDepartamento.getSelectionModel().getSelectedItem().toString();
        String sDepartmento = cBSDepartamento.getSelectionModel().getSelectedItem().toString();
        String[] atributos = new String[5];

        atributos[0] = tFNombre.getText();
        atributos[1] = tFPrecio.getText();
        atributos[2] = tFMarca.getText();
        atributos[3] = pFiles.copiarImagen(tFImagen.getText(), departamento);

        if (!sDepartmento.equals(""))
            atributos[4] = sDepartmento;
        else
            atributos[4] = "";

        System.out.println(departamento);

        Producto nuevo = ProductoFactory.nuevoProducto(departamento, atributos);

        pFiles.escribir(nuevo);
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
