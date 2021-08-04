package components;

import java.io.FileInputStream;
import java.io.IOException;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import utils.StringCurrency;

public class ItemComponent extends VBox {
    private ImageView iView;
    private Label lblNombre;
    private Label lblPrecio;
    private Button btnAgregar;

    public ItemComponent(String nombre, double precio, String imagen) {
        // Create instances of the objects

        if (imagen != null) {
            try {
                iView = new ImageView(new Image(new FileInputStream(imagen)));
            } catch (IOException exception) {
                System.out.println("ERROR " + exception.getMessage());
                iView = new ImageView(new Image("/images/compu.jpg"));
            }
        } else
            iView = new ImageView(new Image("/images/compu.jpg"));

        // iView = new ImageView(new Image(new File(imagen)));

        lblNombre = new Label(nombre);
        lblPrecio = new Label(StringCurrency.getMoney(precio));

        initialize();
        this.getChildren().addAll(iView, lblNombre, lblPrecio, btnAgregar);
    }

    private void initialize() {
        btnAgregar = new Button("Agregar");
        addStyles();
    }

    private void addStyles() {
        // Estilos del Vbox
        this.setSpacing(10);
        this.setAlignment(Pos.CENTER);
        this.setPrefSize(Control.USE_COMPUTED_SIZE, Control.USE_COMPUTED_SIZE);

        // Estilos de la imagen
        iView.fitHeightProperty().set(150);
        iView.fitWidthProperty().set(150);

        // Añadiendo las clases
        this.getStyleClass().add("vbox");
        iView.getStyleClass().add("img");
        lblPrecio.getStyleClass().add("lbl-precio");
    }

}