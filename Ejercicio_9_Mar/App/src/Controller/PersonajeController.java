package Controller;

import Model.Personaje;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class PersonajeController {

    @FXML
    private TextField txtNombre;

    @FXML
    private ComboBox<String> cbRaza;

    @FXML
    private TextField txtPoder;

    @FXML
    private TextField txtPlaneta;

    @FXML
    private TextField txtTecnica;

    @FXML
    private TextField txtEdad;

    @FXML
    private GridPane tablaPersonajes;

    private int filaActual = 1;

    @FXML
    private void initialize() {
        cbRaza.getItems().addAll(
            "Saiyajin",
            "Humano",
            "Namekiano",
            "Androide",
            "Majin",
            "Freezer Race"
        );
    }

    @FXML
    private void agregarPersonaje() {
        String nombre = txtNombre.getText().trim();
        String raza = cbRaza.getValue();
        String poderTexto = txtPoder.getText().trim();
        String planeta = txtPlaneta.getText().trim();
        String tecnica = txtTecnica.getText().trim();
        String edadTexto = txtEdad.getText().trim();

        if (nombre.isEmpty() || raza == null || poderTexto.isEmpty()
            || planeta.isEmpty() || tecnica.isEmpty() || edadTexto.isEmpty()) {
            mostrarError("Todos los campos son obligatorios.");
            return;
        }

        int nivelPoder = 0;
        int edad = 0;

        try {
            nivelPoder = Integer.parseInt(poderTexto);
            edad = Integer.parseInt(edadTexto);
        } catch (NumberFormatException ex) {
            mostrarError("Poder y edad deben ser numeros enteros.");
            return;
        }

        if (nivelPoder <= 0) {
            mostrarError("El nivel de poder debe ser mayor que 0.");
            return;
        }

        if (edad <= 0) {
            mostrarError("La edad debe ser mayor que 0.");
            return;
        }

        Personaje personaje = new Personaje(nombre, raza, nivelPoder, planeta, tecnica, edad);
        tablaPersonajes.add(new Label(personaje.getNombre()), 0, filaActual);
        tablaPersonajes.add(new Label(personaje.getRaza()), 1, filaActual);
        tablaPersonajes.add(new Label(String.valueOf(personaje.getNivelPoder())), 2, filaActual);
        tablaPersonajes.add(new Label(personaje.getPlanetaOrigen()), 3, filaActual);
        tablaPersonajes.add(new Label(personaje.getTecnicaEspecial()), 4, filaActual);
        tablaPersonajes.add(new Label(String.valueOf(personaje.getEdad())), 5, filaActual);
        filaActual++;

        txtNombre.clear();
        cbRaza.getSelectionModel().clearSelection();
        txtPoder.clear();
        txtPlaneta.clear();
        txtTecnica.clear();
        txtEdad.clear();
        txtNombre.requestFocus();
    }

    private void mostrarError(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Error de validacion");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
