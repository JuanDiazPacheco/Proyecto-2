package controllers;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import components.ItemComponent;
import components.Carousel.CarouselComponent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class DepartamentoController implements Initializable {

    @FXML
    private VBox seccionesVBox;

    private List<ItemComponent> list;
    private List<ItemComponent> list2;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        list = new LinkedList<>();
        list.add(new ItemComponent("Pepsi", 10, null));
        list.add(new ItemComponent("Coca", 10, null));
        list.add(new ItemComponent("Mirinda", 10, null));
        list.add(new ItemComponent("Sprite", 10, null));
        list.add(new ItemComponent("TV", 15000, null));
        list.add(new ItemComponent("Pool", 1000, null));

        list2 = new LinkedList<>();
        list2.add(new ItemComponent("Pepsi", 10, null));
        list2.add(new ItemComponent("Coca", 10, null));
        list2.add(new ItemComponent("Mirinda", 10, null));
        list2.add(new ItemComponent("Sprite", 10, null));
        list2.add(new ItemComponent("TV", 15000, null));
        list2.add(new ItemComponent("Pool", 1000, null));

        seccionesVBox.getChildren().add(new Label("Sub departamento 1"));
        seccionesVBox.getChildren().add(new CarouselComponent(list));
        seccionesVBox.getChildren().add(new Label("Sub departamento 2"));
        seccionesVBox.getChildren().add(new CarouselComponent(list2));

    }

}
