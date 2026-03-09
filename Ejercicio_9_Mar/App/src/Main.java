import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/PersonajeView.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root, 760, 450);
        scene.getStylesheets().add(getClass().getResource("/View/Style.css").toExternalForm());
        stage.setTitle("Registro de Personajes Dragon Ball Z");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
