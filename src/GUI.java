import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utils.ControladorEscenas;

public class GUI extends Application {
    public static void mainGui(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Scene newScene;
        ControladorEscenas.setStage(stage);

        // newScene = new Scene(producto);
        newScene = new Scene(FXMLLoader.load(getClass().getResource("/views/InicioView.fxml")));

        // newScene.getStylesheets().add(this.getClass().getResource("styles.css").toString());

        stage.setScene(newScene);
        // stage.resizableProperty().set(false);
        stage.show();

    }
}
