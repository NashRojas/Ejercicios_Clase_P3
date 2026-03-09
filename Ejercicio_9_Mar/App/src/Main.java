import Controller.PersonajeController;
import View.PersonajeView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        PersonajeView view = new PersonajeView();
        new PersonajeController(view);

        Scene scene = new Scene(view.getRoot(), 760, 450);
        scene.getStylesheets().add(
            Objects.requireNonNull(getClass().getResource("/View/Style.css")).toExternalForm()
        );
        stage.setTitle("Registro de Personajes Dragon Ball Z");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
