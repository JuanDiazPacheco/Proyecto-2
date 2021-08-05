package components.Carrito;

import java.io.FileInputStream;
import java.io.IOException;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Control;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import utils.StringCurrency;

public class CarritoItem extends HBox {
    ImageView iView;
    Label lblNombre;
    Label lblPrecio;
    Button btnDelete;

    public CarritoItem(String nombre, double precio, String imagen) {
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

        lblNombre = new Label(nombre);
        lblPrecio = new Label(StringCurrency.getMoney(precio));

        initialize();
        this.getChildren().addAll(iView, lblNombre, lblPrecio, btnDelete);
    }

    private void initialize() {
        ImageView iDelete = new ImageView(new Image("/images/Carrito/trash.png"));

        iDelete.fitHeightProperty().set(16);
        iDelete.fitWidthProperty().set(13);

        btnDelete = new Button();

        btnDelete.setGraphic(iDelete);

        addStyles();
    }

    private void addStyles() {
        // Estilos del Hbox
        this.setSpacing(10);
        this.setAlignment(Pos.CENTER);
        this.setPrefSize(Control.USE_COMPUTED_SIZE, Control.USE_COMPUTED_SIZE);

        // Estilos de la imagen
        iView.fitHeightProperty().set(150);
        iView.fitWidthProperty().set(150);

        // Añadiendo las clases
        this.getStyleClass().add("hbox");
        iView.getStyleClass().add("img");
        lblPrecio.getStyleClass().add("lbl-precio");
    }

}
