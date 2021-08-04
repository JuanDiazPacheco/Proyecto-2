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
import javafx.scene.input.MouseEvent;
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

    /*
     * private List<ItemComponent> list; private List<ItemComponent> list2;
     */

    private List<List<ItemComponent>> lista;

    private ProductosFiles pFiles;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        pFiles = ProductosFiles.getInstance();

        Comida.init();
        Ropa.init();
        Electronicos.init();
        Deportes.init();

        lista = new LinkedList<List<ItemComponent>>();
        /*
         * list = new LinkedList<>(); list2 = new LinkedList<>();
         */

        /*
         * list.add(new ItemComponent("Pepsi", 10, null)); list.add(new
         * ItemComponent("Coca", 10, null)); list.add(new ItemComponent("Mirinda", 10,
         * null)); list.add(new ItemComponent("Sprite", 10, null)); list.add(new
         * ItemComponent("TV", 15000, null)); list.add(new ItemComponent("Pool", 1000,
         * null));
         * 
         * list2.add(new ItemComponent("Pepsi", 10, null)); list2.add(new
         * ItemComponent("Coca", 10, null)); list2.add(new ItemComponent("Mirinda", 10,
         * null)); list2.add(new ItemComponent("Sprite", 10, null)); list2.add(new
         * ItemComponent("TV", 15000, null)); list2.add(new ItemComponent("Pool", 1000,
         * null));
         */

    }

    // Operaciones Tienda

    private void cargarSecciones(Set<String> labels, List<Producto> productos) {
        // TODO revisar como borrar las listas
        lista.clear();
        seccionesVBox.getChildren().clear();

        // Carga y distribuye secciones
        for (String seccion : labels) {
            List<ItemComponent> listSeccion = new LinkedList<ItemComponent>();
            for (Producto producto : productos) {
                if (producto.getSDepartamento().equals(seccion)) {
                    listSeccion
                            .add(new ItemComponent(producto.getNombre(), producto.getPrecio(), producto.getImagen()));
                }
            }
            lista.add(listSeccion);
        }

        int i = 0;
        for (String seccion : labels) {
            // TODO if la lista de seccion esta vacia no agregar
            seccionesVBox.getChildren().add(new Label(seccion));

            seccionesVBox.getChildren().add(new CarouselComponent(lista.get(i)));
            i++;
        }

        /* seccionesVBox.getChildren().add(new Label(sDepartamento[0])); */
        /* seccionesVBox.getChildren().add(new CarouselComponent(list)); */
        /* seccionesVBox.getChildren().add(new Label(sDepartamento[1])); */
        /* seccionesVBox.getChildren().add(new CarouselComponent(list2)); */
    }

    // TODO crear carrito view, controller y controlCarritoItem

    @FXML
    void handleCarritoAction(MouseEvent event) {

    }

    @FXML
    void handleCuentaAction(ActionEvent event) {
        ControladorEscenas.nuevaEscena(getClass().getResource("/views/operaciones/OperacionesCliente.fxml"));
    }

    // Cargar departamentos

    @FXML
    void handleComidaAction(ActionEvent event) {
        Set<String> sDepaSet = Comida.getSDepartamentosList();
        cargarSecciones(sDepaSet, pFiles.cargar(Comida.getSeccion()));
    }

    @FXML
    void handleDeportesAction(ActionEvent event) {
        Set<String> sDepaSet = new HashSet<>();
        sDepaSet.add(Deportes.getSeccion());
        cargarSecciones(sDepaSet, pFiles.cargar(Deportes.getSeccion()));
    }

    @FXML
    void handleElectronicaAction(ActionEvent event) {
        Set<String> sDepaSet = Electronicos.getSDepartamentosList();
        cargarSecciones(sDepaSet, pFiles.cargar(Electronicos.getSeccion()));
    }

    @FXML
    void handleRopaAction(ActionEvent event) {
        Set<String> sDepaSet = Ropa.getSDepartamentosList();
        cargarSecciones(sDepaSet, pFiles.cargar(Ropa.getSeccion()));
    }

}
