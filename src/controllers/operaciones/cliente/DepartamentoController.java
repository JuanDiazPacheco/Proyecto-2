package controllers.operaciones.cliente;

import java.net.URL;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

import components.ItemComponent;
import components.Carousel.CarouselComponent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import javafx.scene.layout.VBox;
import models.productos.Producto;
import models.productos.Departamento.Deportes;
import models.productos.Departamento.Comida.Comida;
import models.productos.Departamento.Electronicos.Electronicos;
import models.productos.Departamento.Ropa.Ropa;
import utils.ControladorEscenas;
import utils.FileManager.ProductosFiles;

public class DepartamentoController implements Initializable {

    @FXML
    private VBox seccionesVBox;

    private List<List<ItemComponent>> lista;

    private ProductosFiles pFiles;

    /**
     * @param arg0
     * @param arg1
     */
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        pFiles = ProductosFiles.getInstance();

        Comida.init();
        Ropa.init();
        Electronicos.init();
        Deportes.init();

        lista = new LinkedList<List<ItemComponent>>();

    }

    /**
     * @param labels
     * @param productos
     */
    // Operaciones Tienda

    private void cargarSecciones(Set<String> labels, List<Producto> productos) {
        lista.clear();
        seccionesVBox.getChildren().clear();

        // Carga y distribuye secciones
        for (String seccion : labels) {
            List<ItemComponent> listSeccion = new LinkedList<ItemComponent>();
            for (Producto producto : productos) {
                if (producto.getSDepartamento() == null || producto.getSDepartamento().equals(seccion)) {
                    listSeccion.add(new ItemComponent(producto));
                }
            }
            lista.add(listSeccion);
        }

        int i = 0;
        for (String seccion : labels) {

            if (lista.get(i).size() != 0) {
                seccionesVBox.getChildren().add(new Label(seccion));
                seccionesVBox.getChildren().add(new CarouselComponent(lista.get(i)));
            }
            i++;
        }

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
    void handleCuentaAction(ActionEvent event) {
        ControladorEscenas.nuevaEscena(getClass().getResource("/views/operaciones/OperacionesCliente.fxml"));
    }

    /**
     * @param event
     */
    // Cargar departamentos

    @FXML
    void handleComidaAction(ActionEvent event) {
        Set<String> sDepaSet = Comida.getSDepartamentosList();
        cargarSecciones(sDepaSet, pFiles.cargar(Comida.getSeccion()));
    }

    /**
     * @param event
     */
    @FXML
    void handleDeportesAction(ActionEvent event) {
        Set<String> sDepaSet = new HashSet<>();
        sDepaSet.add(Deportes.getSeccion());
        cargarSecciones(sDepaSet, pFiles.cargar(Deportes.getSeccion()));
    }

    /**
     * @param event
     */
    @FXML
    void handleElectronicaAction(ActionEvent event) {
        Set<String> sDepaSet = Electronicos.getSDepartamentosList();
        cargarSecciones(sDepaSet, pFiles.cargar(Electronicos.getSeccion()));
    }

    /**
     * @param event
     */
    @FXML
    void handleRopaAction(ActionEvent event) {
        Set<String> sDepaSet = Ropa.getSDepartamentosList();
        cargarSecciones(sDepaSet, pFiles.cargar(Ropa.getSeccion()));
    }

}
