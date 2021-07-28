import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUI extends Application {
    public static void mainGui(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Scene newScene;

        // newScene = new Scene(producto);
        newScene = new Scene(FXMLLoader.load(getClass().getResource("/views/DepartamentoView.fxml")));
        // newScene.getStylesheets().add(this.getClass().getResource("styles.css").toString());

        stage.setScene(newScene);
        // stage.resizableProperty().set(false);
        stage.show();

    }
}
