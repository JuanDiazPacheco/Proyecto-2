package utils;

import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.fxml.LoadException;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControladorEscenas {
    private static Stage stage;
    private static Object object;
    private static ControladorEscenas cEscenas;

    private ControladorEscenas() {

    }

    /**
     * @return ControladorEscenas
     */
    public static ControladorEscenas getInstance() {
        if (cEscenas == null)
            cEscenas = new ControladorEscenas();
        return cEscenas;
    }

    /**
     * @param url
     */
    public static void nuevaEscena(URL url) {
        try {
            Scene newScene; // then we create a new scene with our new layout
            newScene = new Scene(FXMLLoader.load(url));
            stage.setScene(newScene);

            stage.show();

        } catch (LoadException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getLocalizedMessage());
            System.out.println(e.getCause());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param stageSent
     */
    public static void setStage(Stage stageSent) {
        stage = stageSent;
    }

    /**
     * @return Stage
     */
    public static Stage getStage() {
        return stage;
    }

    /**
     * @param objectSent
     */
    public void enviarDatos(Object objectSent) {
        if (objectSent != null)
            object = objectSent;
    }

    /**
     * @return Object
     */
    public Object recibirDatos() {
        return object;
    }

    public void clearDatos() {
        object = null;
    }
}
